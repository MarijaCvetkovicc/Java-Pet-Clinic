/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.Karton;
import domain.Pregled;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MSWINDOWS
 */
public class TableModelAppointment extends AbstractTableModel {

    List<Pregled> list;
    String[] header = new String[]{"Date", "Patient", "Diagnosis"};

    public TableModelAppointment(List<Pregled> list) {
        this.list = list;
    }

    
    
    
    @Override
    public int getRowCount() {
          return list.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Pregled appointment = list.get(i);
        switch(i1){
            case 0 : SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
                return sdf.format(appointment.getDatumPregleda());   
            case 1 :     return appointment.getKarton().getImePacijenta()+" "+appointment.getKarton().getBrPasosa();
            case 2 : return appointment.getDijagnoza().getNazivDijagnoze();
            default : return "N/A";
        }
    }

    @Override
    public String getColumnName(int i) {
        return header[i]; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
     public void refresh(List<Pregled> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    public Pregled getAppointment(int rowIndex){
        return list.get(rowIndex);
    }
}
