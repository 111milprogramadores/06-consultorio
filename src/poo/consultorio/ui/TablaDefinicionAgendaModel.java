/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.consultorio.ui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import poo.consultorio.DetalleDefinicionAgenda;

/**
 *
 * @author joaquinleonelrobles
 */
public class TablaDefinicionAgendaModel extends AbstractTableModel {
    
    private static final String[] COLUMNAS = { "Día", "Inicio", "Fin", "Inicio Intervalo", "Duración Intervalo" };
    
    private final SimpleDateFormat sdfHora;
    private final SimpleDateFormat sdfDia;
    
    private List<DetalleDefinicionAgenda> detalle;

    public TablaDefinicionAgendaModel() {
        super();
        
        this.detalle = new ArrayList<>();
        this.sdfHora = new SimpleDateFormat("HH:mm");
        this.sdfDia = new SimpleDateFormat("EEEE");
    }

    @Override
    public int getRowCount() {
        return this.detalle.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNAS[column];
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Object retorno = null;
        DetalleDefinicionAgenda dd = detalle.get(fila);
        
        // según la columna deseada obtenemos el valor a mostrar
        switch (columna) {
            case 0:
                // obtenemos una instancia del calendario
                Calendar cal = Calendar.getInstance();
                
                // creamos una fecha con el dia de la semana correspondiente
                cal.set(Calendar.DAY_OF_WEEK, dd.getDiaSemana());
                
                // devolvemos la representacion en texto del dia
                retorno = sdfDia.format(cal.getTime());
                
                break;
            case 1:
                retorno = sdfHora.format(dd.getHoraInicio());
                break;
            case 2:
                retorno = sdfHora.format(dd.getHoraFin());
                break;
            case 3:
                retorno = sdfHora.format(dd.getHoraInicioIntervalo());
                break;
            case 4:
                retorno = dd.getDuracionIntervalo();
                break;
        }
        
        return retorno;
    }

    public void setDetalle(List<DetalleDefinicionAgenda> detalle) {
        this.detalle = detalle;
    }
    
}
