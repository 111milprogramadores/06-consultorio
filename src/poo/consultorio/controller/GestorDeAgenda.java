/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.consultorio.controller;

import java.util.List;
import poo.consultorio.Agenda;
import poo.consultorio.Odontologo;
import poo.consultorio.dao.EstadosDao;
import poo.consultorio.dao.OdontologosDao;
import poo.consultorio.service.ServicioGeneracionDeAgenda;
import poo.consultorio.ui.PantallaGenerarAgenda;
import poo.consultorio.ui.PantallaVerAgenda;

/**
 *
 * @author joaquinleonelrobles
 */
public class GestorDeAgenda {
    
    private PantallaGenerarAgenda pantalla;
    private PantallaVerAgenda pantallaVerAgenda;
    
    private final OdontologosDao odontologosDao;
    
    private final ServicioGeneracionDeAgenda servicio;
    
    private Odontologo odontologo;

    public GestorDeAgenda(OdontologosDao odontologosDao, EstadosDao estadosDao) {
        this.odontologosDao = odontologosDao;
        
        this.servicio = new ServicioGeneracionDeAgenda(estadosDao);
    }
    
    public List<Odontologo> obtenerOdontologos () {
        return this.odontologosDao.obtenerTodos();
    }

    public void run() {
        this.pantalla = new PantallaGenerarAgenda(this);
        this.pantalla.setVisible(true);
    }

    public void generarAgenda (Odontologo odontologo, Integer mes, Integer anio) {
        
        // delegamos la funcionalidad de generacion de la agenda a una capa de 
        // servicios, se trata de un objecto instancia de una clase de fabricación
        // pura cuyo propósito es encapsultar lógica de negocio correspondiente a 
        // una funcionalidad más compleja, para facilitar su comprensión
        Agenda agenda = servicio.generarAgenda(odontologo, mes, anio);
        
        // guardamos la referencia al Odontologo seleccionado
        this.odontologo = odontologo;
        
        // mostramos la agenda para solicitar la confirmacion de la agenda generada
        this.pantallaVerAgenda = new PantallaVerAgenda(this, agenda);
        this.pantallaVerAgenda.setVisible(true);
    }
    
    public void confirmarAgenda (Agenda agenda) {
        // agregamos la Agenda al Odontologo seleccionado
        this.odontologo.agregarAgenda(agenda);
        
        // ...y persistimos los cambios en la capa de acceso a datos
        this.odontologosDao.actualizar(odontologo);
        
        // cerramos la pantalla de vista de agenda
        this.pantallaVerAgenda.dispose();
    }
    
}
