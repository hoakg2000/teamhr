//package com.tma.teamhr.DAO;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//public abstract class AbstractJpaDAO< T >  {
//
//    private Class< T > clazz;
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    public final void setClazz( Class< T > clazzToSet ){
//        this.clazz = clazzToSet;
//    }
//
//    public T findOne( int id ){
//        return entityManager.findByName( clazz, id );
//    }
//    public List< T > findAll(){
//        return entityManager.createQuery( "from " + clazz.getName() )
//                .getResultList();
//    }
//
//    public void create( T entity ){
//        entityManager.persist( entity );
//    }
//
//    public T update( T entity ){
//        return entityManager.merge( entity );
//    }
//
//    public void delete( T entity ){
//        entityManager.remove( entity );
//    }
//    public void deleteById( int entityId ){
//        T entity = findOne( entityId );
//        delete( entity );
//    }
//}