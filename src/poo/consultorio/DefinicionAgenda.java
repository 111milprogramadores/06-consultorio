/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.consultorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Candelaria
 */
public class DefinicionAgenda {
    private int duracionTurno; //en minutos
    private Date fechaCreacion;
    private Date fechaVigencia;
    private List<DetalleDefinicionAgenda> detalleDefinicion;

    /**
    * Constructor por Defecto.
    */
    public DefinicionAgenda() {
        detalleDefinicion= new ArrayList<>();
    }

    /**
    * Constructor con parámetros, sin incluir atributos referenciales.
     * @param duracionTurno        
     * @param fechaCreacion        
     * @param fechaVigencia          
    */
    public DefinicionAgenda(int duracionTurno, Date fechaCreacion, Date fechaVigencia) {
        this.duracionTurno = duracionTurno;
        this.fechaCreacion = fechaCreacion;
        this.fechaVigencia = fechaVigencia;
        detalleDefinicion= new ArrayList<>();
    }

    /**
    * Constructor con parámetros, con todos los atributos de la clase DefinicionAgenda.
     * @param duracionTurno        
     * @param fechaCreacion        
     * @param fechaVigencia        
     * @param detalleDefinicion        
    */
    public DefinicionAgenda(int duracionTurno, Date fechaCreacion, Date fechaVigencia, List<DetalleDefinicionAgenda> detalleDefinicion) {
        this.duracionTurno = duracionTurno;
        this.fechaCreacion = fechaCreacion;
        this.fechaVigencia = fechaVigencia;
        this.detalleDefinicion = detalleDefinicion;
    }

    public int getDuracionTurno() {
        return duracionTurno;
    }

    public void setDuracionTurno(int duracionTurno) {
        this.duracionTurno = duracionTurno;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public List<DetalleDefinicionAgenda> getDetalleDefinicion() {
        return detalleDefinicion;
    }

    public void setDetalleDefinicion(List<DetalleDefinicionAgenda> detalleDefinicion) {
        this.detalleDefinicion = detalleDefinicion;
    }

    public void agregarDetalle(DetalleDefinicionAgenda detalle) {
        this.detalleDefinicion.add(detalle);
    }

    public DetalleDefinicionAgenda buscarPorDia(int diaDeLaSemana) {
        DetalleDefinicionAgenda retorno = null;
        Iterator<DetalleDefinicionAgenda> iter = detalleDefinicion.iterator();
        
        while (iter.hasNext()) {
            DetalleDefinicionAgenda actual = iter.next();
            
            if (actual.getDiaSemana() == diaDeLaSemana) {
                retorno = actual;
                break;
            }
        }
        
        return retorno;
    }
    
    
}
