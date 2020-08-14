/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.Karton;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MSWINDOWS
 */
public class TableModelPatient extends AbstractTableModel {

    List<Karton> patients = new LinkedList<>();
    String[] header = new String[]{"Passport No", "Name and surname of owner", "Pet name","Telephone number","Spacies","Vet"};

    public TableModelPatient(List<Karton> patients) {
        this.patients = patients;
    }   
    
    @Override
    public int getRowCount() {
     if(patients==null){
         return 0;
         
     }  
     return patients.size();
    }

    @Override
    public int getColumnCount() {
      return  header.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
         Karton patient = patients.get(i);
        switch(i1){
            case 0:
                return patient.getBrPasosa();
            case 1:
                return patient.getImePrezimeVlasnika();
            case 2:
                return patient.getImePacijenta();
             case 3:
                return patient.getBrTelefonaVlasnika();
            case 4:
                return patient.getVrstaZivotinje().getNazivVrste();
             case 5:
                return patient.getVeterinar().getImePrezimeVeterinara();
            default:
                return "N/A";
        }        
    }

    @Override
    public String getColumnName(int i) {
        return header[i]; //To change body of generated methods, choose Tools | Templates.
    }

    public List<Karton> getAllPatients() {
        return patients;
    }
    
      public Karton getPatient(int rowIndex){
        return patients.get(rowIndex);
    }
    
    public void refresh(){
    fireTableDataChanged();
    
    }
     public void refresh(List<Karton> patients){
        this.patients = patients;
        fireTableDataChanged();
    }
    
}
