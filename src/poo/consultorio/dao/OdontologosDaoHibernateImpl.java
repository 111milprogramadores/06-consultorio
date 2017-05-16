/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.consultorio.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.consultorio.Odontologo;

/**
 *
 * @author joaquinleonelrobles
 */
public class OdontologosDaoHibernateImpl implements OdontologosDao {
    
    private SessionFactory sessionFactory;

    public OdontologosDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Odontologo odontologo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(odontologo);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Odontologo> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Odontologo> retorno = session.createQuery("from Odontologo").list();
        session.close();
        
        return retorno;
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(odontologo);
        session.getTransaction().commit();
        session.close();
    }
    
}
