/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.consultorio;

/**
 *
 * @author Candelaria
 */
public class TipoDoc {
    private String nombre;
    private String abreviatura;

    /**
    * Constructor por Defecto.
    */
    public TipoDoc() {
    }

    /**
    * Constructor con parametros.
     * @param nombre
     * @param abreviatura
    */
    public TipoDoc(String nombre, String abreviatura) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    
    
}
