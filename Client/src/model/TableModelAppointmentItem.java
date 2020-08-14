/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.StavkaPregleda;
import domain.VrstaUsluge;
import domain.util.GDOStatus;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import session.Session;
import usecase.UseCase;

/**
 *
 * @author MSWINDOWS
 */
public class TableModelAppointmentItem extends AbstractTableModel{

     List<StavkaPregleda> itemsAfterUpdate;
    List<StavkaPregleda> itemsBeforeUpdate;
    List<StavkaPregleda> items;
    String[] header={"No.","Cena","Service"};

    public TableModelAppointmentItem(List<StavkaPregleda> items) {
        this.items = items;
    }
    
    
    @Override
    public int getRowCount() {
       return items.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        StavkaPregleda item = items.get(i);
        
        switch (i1) {
            case 0:
                return item.getRedniBroj();
            case 1:
                return item.getCena();
            case 2:
                return item.getUsluga().getNazivUsluge();
            
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int i) {
        return header[i]; //To change body of generated methods, choose Tools | Templates.
    }
    private void setOrderNumbers() {
        int no = 0;
        for (StavkaPregleda ai : items) {
            no++;
            ai.setRedniBroj(no);
        }
     
    }

    public List<StavkaPregleda> getItems() {
        return items;
    }

    public void remove(int row) {
        StavkaPregleda item=items.get(row);
         update(item);
        items.remove(item);
       
        setOrderNumbers();
        fireTableDataChanged();
    }

    public void addItem(VrstaUsluge service,Double price) {
        StavkaPregleda item=new StavkaPregleda();
        item.setUsluga(service);
        item.setCena(price);
        
         update(item);
        items.add(item);
       setOrderNumbers();
        fireTableDataChanged();
    }

    public double getTotalPrice() {
        double bill=0.0;
        for (StavkaPregleda item : items) {
            bill+=item.getCena();
        }
        return bill;
    }

    public void removeALL() {
        items.removeAll(items);
        fireTableDataChanged();
    }

    public void setItems() {
        //
    }

    public List<StavkaPregleda> getItemsAfterUpdate() {
        return itemsAfterUpdate;
    }

    public List<StavkaPregleda> getItemsBeforeUpdate() {
        return itemsBeforeUpdate;
    }

    public void setItemsAfterUpdate() {
        itemsAfterUpdate = new ArrayList<>();
        setItemsBeforeUpdate();
    }
  public void setItemsBeforeUpdate() {
        itemsBeforeUpdate = new ArrayList<>();
        for (StavkaPregleda ai : items) {
            StavkaPregleda ai1 = new StavkaPregleda();
            ai1.setRedniBroj(ai.getRedniBroj());
            ai1.setCena(ai.getCena());
            VrstaUsluge s = new VrstaUsluge(ai.getUsluga().getSifraUsluge(), ai.getUsluga().getNazivUsluge() );
            ai1.setUsluga(s);
            ai1.setStatus(GDOStatus.DEFAULT);
            itemsBeforeUpdate.add(ai1);
        }

    }
    
       private void update(StavkaPregleda item) {
        if (Session.getInstance().getCurrentUseCase() == UseCase.UC_NEW_APPOINTMENT) {
            return;
        }
        if (!itemsAfterUpdate.contains(item)) {
            if(itemsBeforeUpdate.contains(item)){
             item.setStatus(GDOStatus.DELETED);
            
            }else{
              
             item.setStatus(GDOStatus.NEW);
              
            }
             System.out.println("Nova stavka ili ibrisana ima status"+item.getStatus());
            itemsAfterUpdate.add(item);
        }
    }
}
