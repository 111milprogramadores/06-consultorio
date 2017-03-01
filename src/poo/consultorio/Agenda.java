/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.consultorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Candelaria
 */
public class Agenda {
    private Date fechaFin;
    private Date fechaInicio;
    private List<Turno> turnos;

    /**
    * Constructor por Defecto.
    */
    public Agenda() {
        this.turnos = new ArrayList<>();
    }

    /**
    * Constructor con parámetros, sin incluir atributos referenciales.
     * @param fechaFin           
     * @param fechaInicio       
    */
    public Agenda(Date fechaFin, Date fechaInicio) {
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        
        this.turnos = new ArrayList<>();
    }
    
    /**
    * Constructor con parámetros, con todos los atributos de la clase Agenda.
     * @param fechaFin           
     * @param fechaInicio           
     * @param turnos           
    */
    public Agenda(Date fechaFin, Date fechaInicio, List<Turno> turnos) {
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.turnos = turnos;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
    
    public void agregarTurno (Turno turno) {
        this.turnos.add(turno);
    }

}
