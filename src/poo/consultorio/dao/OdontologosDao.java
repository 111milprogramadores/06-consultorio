/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.consultorio.dao;

import java.util.List;
import poo.consultorio.Odontologo;

/**
 *
 * @author joaquinleonelrobles
 */
public interface OdontologosDao {
    
    public void guardar (Odontologo odontologo);
    public List<Odontologo> obtenerTodos ();

    public void actualizar(Odontologo odontologo);
    
}
