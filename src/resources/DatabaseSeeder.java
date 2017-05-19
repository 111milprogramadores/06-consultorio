/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.util.ArrayList;
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
import poo.consultorio.dao.OdontologosDao;
import poo.consultorio.dao.OdontologosDaoHibernateImpl;

/**
 *
 * @author joaquinleonelrobles
 */
public class DatabaseSeeder {
    
    public static void main (String[] args) {
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
        
        Calendar hoy = Calendar.getInstance();
        
        // creamos los tipos de doc
        TipoDoc dni = new TipoDoc("Documento Nacional de Identidad", "DNI");
        
        // creamos la fecha de nacimiento de ariel
        Calendar calAriel = Calendar.getInstance();
        calAriel.set(Calendar.YEAR, 1980);
        calAriel.set(Calendar.MONTH, 11);
        calAriel.set(Calendar.DAY_OF_MONTH, 4);
        
        // creamos los odontologos
        Odontologo ariel = new Odontologo("Loza", "Av San Martín 1889", "Ariel", calAriel.getTime(), 30123123, 1234, dni);
        
        // creamos la definicion de agenda de ariel loza
        Calendar vigenteHasta = Calendar.getInstance();
        vigenteHasta.add(Calendar.MONTH, 3);
        
        DefinicionAgenda definicionAgendaAriel = new DefinicionAgenda(30, hoy.getTime(), vigenteHasta.getTime());
        
        // creamos el detalle de definicion por dia de la semana
        Calendar inicioDia = Calendar.getInstance();
        inicioDia.set(Calendar.HOUR_OF_DAY, 8);
        inicioDia.set(Calendar.MINUTE, 0);
        inicioDia.set(Calendar.SECOND, 0);
        
        Calendar finDia = Calendar.getInstance();
        finDia.set(Calendar.HOUR_OF_DAY, 18);
        finDia.set(Calendar.MINUTE, 0);
        finDia.set(Calendar.SECOND, 0);
        
        Calendar inicioIntervalo = Calendar.getInstance();
        inicioIntervalo.set(Calendar.HOUR_OF_DAY, 12);
        inicioIntervalo.set(Calendar.MINUTE, 0);
        inicioIntervalo.set(Calendar.SECOND, 0);
        
        // para cada dia de la semana
        DetalleDefinicionAgenda lunes     = new DetalleDefinicionAgenda(Calendar.MONDAY, 60, finDia.getTime(), inicioDia.getTime(), inicioIntervalo.getTime());
        DetalleDefinicionAgenda martes    = new DetalleDefinicionAgenda(Calendar.TUESDAY, 60, finDia.getTime(), inicioDia.getTime(), inicioIntervalo.getTime());
        DetalleDefinicionAgenda miercoles = new DetalleDefinicionAgenda(Calendar.WEDNESDAY, 60, finDia.getTime(), inicioDia.getTime(), inicioIntervalo.getTime());
        DetalleDefinicionAgenda jueves    = new DetalleDefinicionAgenda(Calendar.THURSDAY, 60, finDia.getTime(), inicioDia.getTime(), inicioIntervalo.getTime());
        DetalleDefinicionAgenda viernes   = new DetalleDefinicionAgenda(Calendar.FRIDAY, 60, finDia.getTime(), inicioDia.getTime(), inicioIntervalo.getTime());
        
        // ...los agregamos a la definicion
        definicionAgendaAriel.agregarDetalle (lunes);
        definicionAgendaAriel.agregarDetalle (martes);
        definicionAgendaAriel.agregarDetalle (miercoles);
        definicionAgendaAriel.agregarDetalle (jueves);
        definicionAgendaAriel.agregarDetalle (viernes);
        
        ArrayList<DefinicionAgenda> definiciones = new ArrayList<>();
        definiciones.add(definicionAgendaAriel);
        
        // ...y se la asignamos a ariel
        ariel.setDefinicionesAgenda(definiciones);
        
        // creamos el DAO para guardarlos
        OdontologosDao odontologosDao = new OdontologosDaoHibernateImpl(sessionFactory);
        odontologosDao.guardar(ariel);
        
        // creamos el estado "Disponible" para los Turnos
        Estado disponible = new Estado("Disponible", "Disponible para reservar");
        
        // y creamos el DAO para guardarlo
        EstadosDao estadosDao = new EstadosDaoHibernateImpl(sessionFactory);
        estadosDao.guardar(disponible);
        
        System.out.println("Objetos para pruebas inicializados correctamente...");
    }
}
