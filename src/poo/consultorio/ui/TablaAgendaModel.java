/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.consultorio.ui;

import java.text.SimpleDateFormat;
import javax.swing.table.AbstractTableModel;
import poo.consultorio.Agenda;
import poo.consultorio.Turno;

/**
 *
 * @author joaquinleonelrobles
 */
public class TablaAgendaModel extends AbstractTableModel {
    
    private static final String[] COLUMNAS = { "Fecha", "Hora", "Estado", "Consulta", "Paciente" };
    
    private final SimpleDateFormat sdfHora;
    private final SimpleDateFormat sdfDia;
    
    private Agenda agenda;

    public TablaAgendaModel(Agenda agenda) {
        super();
        
        this.agenda = agenda;
        this.sdfHora = new SimpleDateFormat("HH:mm");
        this.sdfDia = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public int getRowCount() {
        return this.agenda.getTurnos().size();
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
        Turno turno = agenda.getTurnos().get(fila);
        
        // según la columna deseada obtenemos el valor a mostrar
        switch (columna) {
            case 0:
                retorno = sdfDia.format(turno.getFechaHora());
                
                break;
            case 1:
                retorno = sdfHora.format(turno.getFechaHora());
                break;
            case 2:
                retorno = turno.getEstado();
                break;
            case 3:
                retorno = turno.getConsulta();
                break;
            case 4:
                retorno = turno.getPaciente();
                break;
        }
        
        return retorno;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
    
}
