/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.consultorio;

import java.util.Date;

/**
 *
 * @author Candelaria
 */
public class Consulta {
    private Date horaFin;
    private Date horaInicio;
    private String descripcion;

    /**
    * Constructor por Defecto.
    */
    public Consulta() {
    }

    /**
    * Constructor con parámetros, sin incluir atributos referenciales.
     * @param horaFin        
     * @param horaInicio        
     * @param descripcion        
    */
    
    public Consulta(Date horaFin, Date horaInicio, String descripcion) {
        this.horaFin = horaFin;
        this.horaInicio = horaInicio;
        this.descripcion = descripcion;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
