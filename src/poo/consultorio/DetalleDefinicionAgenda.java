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
public class DetalleDefinicionAgenda {
    private int diaSemana;
    private int duracionIntervalo; //minutos
    private Date horaFin;
    private Date horaInicio;
    private Date horaInicioIntervalo;

    /**
    * Constructor por Defecto.
    */
    public DetalleDefinicionAgenda() {
    }

    /**
    * Constructor con parámetros.
     * @param diaSemana     
     * @param duracionIntervalo     
     * @param horaFin     
     * @param horaInicio     
    */
    public DetalleDefinicionAgenda(int diaSemana, int duracionIntervalo, Date horaFin, Date horaInicio, Date horaInicioIntervalo) {
        this.diaSemana = diaSemana;
        this.duracionIntervalo = duracionIntervalo;
        this.horaFin = horaFin;
        this.horaInicio = horaInicio;
        this.horaInicioIntervalo = horaInicioIntervalo;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getDuracionIntervalo() {
        return duracionIntervalo;
    }

    public void setDuracionIntervalo(int duracionIntervalo) {
        this.duracionIntervalo = duracionIntervalo;
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

    public Date getHoraInicioIntervalo() {
        return horaInicioIntervalo;
    }

    public void setHoraInicioIntervalo(Date horaInicioIntervalo) {
        this.horaInicioIntervalo = horaInicioIntervalo;
    }
    
    
}
