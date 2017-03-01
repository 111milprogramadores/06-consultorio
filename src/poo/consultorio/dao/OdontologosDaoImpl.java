/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.consultorio.dao;

import java.util.ArrayList;
import java.util.List;
import poo.consultorio.Odontologo;

/**
 *
 * @author joaquinleonelrobles
 */
public class OdontologosDaoImpl implements OdontologosDao {
    
    private final List<Odontologo> odontologos;

    public OdontologosDaoImpl() {
        this.odontologos = new ArrayList<>();
    }

    @Override
    public void guardar(Odontologo odontologo) {
        this.odontologos.add(odontologo);
    }

    @Override
    public List<Odontologo> obtenerTodos() {
        return this.odontologos;
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        // al tratarse de una implementación en memoria no es necesario
        // implementar este método, los cambios se guardan por la referencia
        // del objeto a su espacio de memoria
    }
    
}
