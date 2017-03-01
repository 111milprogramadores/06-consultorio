/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.consultorio.controller;

import java.util.Calendar;
import poo.consultorio.DefinicionAgenda;
import poo.consultorio.DetalleDefinicionAgenda;
import poo.consultorio.Estado;
import poo.consultorio.Odontologo;
import poo.consultorio.TipoDoc;
import poo.consultorio.dao.EstadosDao;
import poo.consultorio.dao.EstadosDaoImpl;
import poo.consultorio.dao.OdontologosDao;
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
        
        // ...y se la asignamos a ariel
        ariel.setDefinicionAgenda(definicionAgendaAriel);
        
        // creamos el DAO para guardarlos
        OdontologosDao odontologosDao = new OdontologosDaoImpl();
        odontologosDao.guardar(ariel);
        
        // creamos el estado "Disponible" para los Turnos
        Estado disponible = new Estado("Disponible", "Disponible para reservar");
        
        // y creamos el DAO para guardarlo
        EstadosDao estadosDao = new EstadosDaoImpl();
        estadosDao.guardar(disponible);
        
        // iniciamos el caso de uso
        new GestorDeAgenda(odontologosDao, estadosDao).run();
    }
    
}
