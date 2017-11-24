/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.criterion.Projections;
import Util.HibernateUtil;

/**
 *
 * @author Johanna
 */
public class GenericDaoImpl<T, E extends Serializable> implements GenericDao<T, E>  {

     private final Class<T> clazz;
    protected Session session;
    protected Transaction tx;

    /**
     *
     */
    @SuppressWarnings("unchecked")
    
    public GenericDaoImpl() {
        this.clazz = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass())
                            .getActualTypeArguments()[0];
        
        this.session = HibernateUtil.getSessionFactory().openSession();
        ThreadLocalSessionContext.bind(session);
    }
    
    public E create(T entity) {
        E id;
        try {
            startOperation();
            id = (E) session.save(entity);
            tx.commit();
        } catch (HibernateException e) {
            id = null;
            tx.rollback();
            throw e;
        }
        
        return  id;
    }
    
    public void delete(T entity) {
        try {
            startOperation();
            session.delete(entity);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw e;
        }  
        
    }
    
    @SuppressWarnings("unchecked")
    public void update(T entity) {
        try {
            startOperation();
            session.merge(entity);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw e;
        } 
        
    }
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        List <T> list;
        try {
            startOperation();
            list = session.createCriteria(clazz).list();
        } catch (HibernateException e) {
            list = null ;
            throw e;
        } 
        
        
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findList(int pageNo, int pageSize) {
        List <T> list;
        try {
            startOperation();
            list = session.createCriteria(clazz)
                          .setFirstResult((pageNo - 1) * pageSize)
                          .setMaxResults(pageSize)
                          .list();
        } catch (HibernateException e) {
            list = null ;
            throw e;
        }  
                
        return list;
    }
    public int getCountOfAll() {
        Long count;
        try {
            startOperation();
            count = (Long) HibernateUtil.getSession()
                                           .createCriteria(clazz)
                                           .setProjection(Projections.rowCount())
                                           .uniqueResult();
        } catch (HibernateException e) {
            count = null;
            throw e;
        } 
        
        
        
        if (null == count) {
            return 0;
        } else {
            return count.intValue();
        }
    }
    
    @SuppressWarnings("unchecked")
    public T findById(Serializable id) {
        T obj;
        try {
            startOperation();
            obj = (T) session.get(clazz, id);
        } catch (HibernateException e) {
            obj = null;
            throw e;
        }    
        
        
        return  obj;
    }
    
     public void closeS() {
         session.close();
     }
    

    protected void startOperation() throws HibernateException {
        
        if(session == null){
           session = HibernateUtil.getSession();
        }
          
        if(tx == null ){            
           tx = session.beginTransaction();
        }else
            
          if(!tx.isActive()){
             tx = session.beginTransaction();
          }

    }
}