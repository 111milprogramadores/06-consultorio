/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.consultorio.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.consultorio.Estado;

/**
 *
 * @author joaquinleonelrobles
 */
public class EstadosDaoHibernateImpl implements EstadosDao {
    
    private SessionFactory sessionFactory;

    public EstadosDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Estado estado) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(estado);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Estado buscarPorNombre(String nombre) {
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Estado> query = builder.createQuery(Estado.class);
        Root<Estado> root = query.from(Estado.class);
        query.select(root);
        query.where(builder.equal(root.get("nombre"), nombre));
        
        Estado estado = session.createQuery(query).uniqueResult();
        
        session.close();
        
        return estado;
    }
    
}
