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
public class Turno {
    private Date fechaHora;
    private Estado estado;
    private Consulta consulta;
    private Paciente paciente;

    /**
    * Constructor por Defecto.
    */
    public Turno() {
    }

    /**
    * Constructor con parámetros, con todos los atributos de la clase Turno.
     * @param fechaHora            
     * @param estado            
     * @param consulta            
     * @param paciente            
    */
    public Turno(Date fechaHora, Estado estado, Consulta consulta, Paciente paciente) {
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.consulta = consulta;
        this.paciente = paciente;
    }

    public Turno(Date fechaHora, Estado estado) {
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
}
