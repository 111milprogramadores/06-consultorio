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
public class Odontologo {
    private String apellido;
    private String domicilio;
    private String nombre;
    private Date fechaNacimiento;    
    private int nroDocumento;
    private int nroMatricula;
    private DefinicionAgenda definicionAgenda;
    private List<Agenda> agendas;
    private TipoDoc tipoDoc;
    
    /**
    * Constructor por Defecto.
    */
    public Odontologo() {
        this.agendas = new ArrayList<>();
    }

    /**
    * Constructor con parámetros, sin incluir atributos referenciales.
     * @param apellido            
     * @param domicilio            
     * @param nombre            
     * @param fechaNacimiento            
     * @param nroDocumento            
     * @param nroMatricula            
     * @param tipoDoc            
    */
    public Odontologo(String apellido, String domicilio, String nombre, Date fechaNacimiento, int nroDocumento, int nroMatricula, TipoDoc tipoDoc) {
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nroDocumento = nroDocumento;
        this.nroMatricula = nroMatricula;
        this.tipoDoc = tipoDoc;
        
        this.agendas = new ArrayList<>();
    }

    /**
    * Constructor con parámetros, con todos los atributos de la clase Odontologo.
     * @param apellido            
     * @param domicilio            
     * @param nombre            
     * @param fechaNacimiento            
     * @param nroDocumento            
     * @param nroMatricula            
     * @param definicionAgenda            
     * @param agenda            
    */
    public Odontologo(String apellido, String domicilio, String nombre, Date fechaNacimiento, int nroDocumento, int nroMatricula, DefinicionAgenda definicionAgenda, List<Agenda> agenda) {
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nroDocumento = nroDocumento;
        this.nroMatricula = nroMatricula;
        this.definicionAgenda = definicionAgenda;
        this.agendas = agenda;
    }
    
    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public int getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(int nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public DefinicionAgenda getDefinicionAgenda() {
        return definicionAgenda;
    }

    public void setDefinicionAgenda(DefinicionAgenda definicionAgenda) {
        this.definicionAgenda = definicionAgenda;
    }

    public List<Agenda> getAgenda() {
        return agendas;
    }

    public void setAgenda(List<Agenda> agenda) {
        this.agendas = agenda;
    }

    public TipoDoc getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDoc tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public void agregarAgenda(Agenda agenda) {
        this.agendas.add(agenda);
    }

    @Override
    public String toString() {
        return this.apellido + ", " + this.nombre;
    }
    
}
