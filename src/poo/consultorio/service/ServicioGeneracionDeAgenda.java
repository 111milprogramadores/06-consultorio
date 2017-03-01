/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.consultorio.service;

import java.util.Calendar;
import poo.consultorio.Agenda;
import poo.consultorio.DefinicionAgenda;
import poo.consultorio.DetalleDefinicionAgenda;
import poo.consultorio.Estado;
import poo.consultorio.Odontologo;
import poo.consultorio.Turno;
import poo.consultorio.dao.EstadosDao;

/**
 *
 * @author joaquinleonelrobles
 */
public class ServicioGeneracionDeAgenda {
    
    private final EstadosDao estadosDao;

    public ServicioGeneracionDeAgenda(EstadosDao estadosDao) {
        this.estadosDao = estadosDao;
    }
    
    public Agenda generarAgenda (Odontologo odontologo, Integer mes, Integer anio) {
        // el mes de la clase Calendar es basado en 0: Enero
        System.out.println("Generando Agenda para " + odontologo + ": " + mes + "/" + anio);
        
        // obtenemos el estado "Disponible" para los nuevos turnos
        Estado disponible = estadosDao.buscarPorNombre("Disponible");
        
        // obtenemos la definicion de agenda del odontologo
        DefinicionAgenda def = odontologo.getDefinicionAgenda();
        
        // iniciamos el calendario en el 1ero del mes a generar
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, mes);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.YEAR, anio);
        
        // creamos un calendario para el fin de la agenda
        Calendar finAgenda = (Calendar) cal.clone();
        finAgenda.add(Calendar.MONTH, 1);
        
        // inicializamos la Agenda para el Odontologo en este periodo
        Agenda agenda = new Agenda(finAgenda.getTime(), cal.getTime());
        
        // mientras sigamos trabajando en el mes a generar
        while (cal.get(Calendar.MONTH) == mes) {
            
            // solo generamos agenda para los dias de semana
            if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                
                // obtenemos el detalle de definicion de agenda para el dia de hoy
                DetalleDefinicionAgenda detalle = def.buscarPorDia(cal.get(Calendar.DAY_OF_WEEK));
                
                // creamos un calendario auxiliar para la hora de inicio
                Calendar inicio = Calendar.getInstance();
                inicio.setTime(detalle.getHoraInicio());
                inicio.set(Calendar.SECOND, 0);
                
                // seteamos la hora de inicio de la jornada
                cal.set(Calendar.HOUR_OF_DAY, inicio.get(Calendar.HOUR_OF_DAY));
                cal.set(Calendar.MINUTE, inicio.get(Calendar.MINUTE));
                cal.set(Calendar.SECOND, inicio.get(Calendar.SECOND));
                
                // creamos un calendario auxiliar para la hora de fin
                Calendar finJornada = Calendar.getInstance();
                finJornada.setTime(detalle.getHoraFin());
                finJornada.set(Calendar.SECOND, 0);
                
                // copiamos los datos del dia
                finJornada.set(Calendar.MONTH, cal.get(Calendar.MONTH));
                finJornada.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
                finJornada.set(Calendar.YEAR, cal.get(Calendar.YEAR));
                
                // creamos un calendario auxiliar para el inicio y fin del intervalo
                Calendar inicioIntervalo = Calendar.getInstance();
                inicioIntervalo.setTime(detalle.getHoraInicioIntervalo());
                inicioIntervalo.set(Calendar.MONTH, cal.get(Calendar.MONTH));
                inicioIntervalo.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
                inicioIntervalo.set(Calendar.YEAR, cal.get(Calendar.YEAR));
                inicioIntervalo.set(Calendar.SECOND, cal.get(Calendar.SECOND));
                
                Calendar finIntervalo = (Calendar) inicioIntervalo.clone();
                finIntervalo.add(Calendar.MINUTE, detalle.getDuracionIntervalo());
                
                // calculamos el horario de fin del turno actual
                Calendar finTurno = (Calendar) cal.clone();
                finTurno.add(Calendar.MINUTE, def.getDuracionTurno());

                // mientras no se acabe la jornada
                while (finTurno.before(finJornada)) {
                    
                    // solo si no estamos en el intervalo
                    // usamos compareTo() en vez de before() y after() para considerar
                    // los casos extremos
                    if (finTurno.compareTo(inicioIntervalo) <= 0 || cal.compareTo(finIntervalo) >= 0) {
                        
                        // creamos un espacio disponible para la hora actual
                        Turno turno = new Turno(cal.getTime(), disponible);
                        
                        // agregamos el turno disponible al odontolog
                        agenda.agregarTurno(turno);
                    }
                    
                    // incrementamos la hora actual
                    cal.add(Calendar.MINUTE, def.getDuracionTurno());
                    finTurno.add(Calendar.MINUTE, def.getDuracionTurno());
                }
            }
            
            // pasamos al dia siguiente
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        
        return agenda;
    }
    
}
