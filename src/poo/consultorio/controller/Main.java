/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.consultorio.controller;

import java.util.Calendar;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import poo.consultorio.DefinicionAgenda;
import poo.consultorio.DetalleDefinicionAgenda;
import poo.consultorio.Estado;
import poo.consultorio.Odontologo;
import poo.consultorio.TipoDoc;
import poo.consultorio.dao.EstadosDao;
import poo.consultorio.dao.EstadosDaoHibernateImpl;
import poo.consultorio.dao.EstadosDaoImpl;
import poo.consultorio.dao.OdontologosDao;
import poo.consultorio.dao.OdontologosDaoHibernateImpl;
import poo.consultorio.dao.OdontologosDaoImpl;

/**
 *
 * @author Candelaria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        
        // A SessionFactory is set up once for an application!
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure("resources/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
			.build();
	try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	}
	catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
            
            throw e;
	}
        
        // creamos los objetos de DAO
        OdontologosDao odontologosDao = new OdontologosDaoHibernateImpl(sessionFactory);
        EstadosDao estadosDao = new EstadosDaoHibernateImpl(sessionFactory);
        
        // iniciamos el caso de uso
        new GestorDeAgenda(odontologosDao, estadosDao).run();
    }
    
}
