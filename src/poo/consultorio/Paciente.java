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
public class Paciente {
    private String apellido;
    private String domicilio;
    private Date fechaNacimiento;
    private String nombre;
    private int nroDocumento;
    private int nroPaciente;
    private Odontologo odontologCabecera;
    private List<Consulta> consultas;

    /**
    * Constructor por Defecto.
    */
    public Paciente() {
        consultas= new ArrayList<>();
    }

    /**
    * Constructor con parámetros, sin incluir atributos referenciales.
     * @param apellido            
     * @param domicilio            
     * @param fechaNacimiento            
     * @param nombre            
     * @param nroDocumento            
     * @param nroPaciente            
    */
    public Paciente(String apellido, String domicilio, Date fechaNacimiento, String nombre, int nroDocumento, int nroPaciente) {
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.nroDocumento = nroDocumento;
        this.nroPaciente = nroPaciente;
        consultas = new ArrayList<>();
    }

    /**
    * Constructor con parámetros, con todos los atributos de la clase Paciente.
     * @param apellido            
     * @param domicilio            
     * @param fechaNacimiento            
     * @param nombre            
     * @param nroDocumento            
     * @param nroPaciente            
     * @param odontologCabecera            
     * @param consultas            
    */
    public Paciente(String apellido, String domicilio, Date fechaNacimiento, String nombre, int nroDocumento, int nroPaciente, Odontologo odontologCabecera, List<Consulta> consultas) {
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.nroDocumento = nroDocumento;
        this.nroPaciente = nroPaciente;
        this.odontologCabecera = odontologCabecera;
        this.consultas = consultas;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public int getNroPaciente() {
        return nroPaciente;
    }

    public void setNroPaciente(int nroPaciente) {
        this.nroPaciente = nroPaciente;
    }

    public Odontologo getOdontologCabecera() {
        return odontologCabecera;
    }

    public void setOdontologCabecera(Odontologo odontologCabecera) {
        this.odontologCabecera = odontologCabecera;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
 
}
