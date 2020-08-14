/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frm.appointment;


import controler.Controler;
import domain.Dijagnoza;
import domain.Karton;
import domain.Pregled;
import domain.StavkaPregleda;
import domain.VrstaUsluge;
import form.FrmMain;
import frm.patient.FrmSearch;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.TableModelAppointmentItem;
import session.Session;
import usecase.UseCase;

/**
 *
 * @author MSWINDOWS
 */
public class FormAppointment extends javax.swing.JDialog {

    /**
     * Creates new form FormAppointment
     */
    Object parent;
    public FormAppointment(FrmSearch parent, boolean modal) {
        super(parent, modal);
        initComponents();
        populateForm();
        this.parent=parent;
    }
 public FormAppointment(FrmMain parent, boolean modal) {
        super(parent, modal);
        initComponents();
        populateForm();
        this.parent=parent;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmbService = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPatient = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbDiagnosis = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtBill = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Appointment items"));

        jLabel5.setText("Service:");

        cmbService.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel6.setText("Price:");

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblItems);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrice))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbService, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemove))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Appointment"));

        lblID.setText("ID:");

        txtID.setEnabled(false);

        jLabel2.setText("Patient:");

        txtPatient.setEnabled(false);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel3.setText("Diagnosis:");

        cmbDiagnosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Date:");

        txtBill.setEnabled(false);

        jLabel7.setText("Bill(Total amount to pay):");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("d MMM yyyy hh:mm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtBill, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblID)
                        .addGap(34, 34, 34)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDiagnosis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(46, 46, 46)
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       VrstaUsluge service=(VrstaUsluge) cmbService.getSelectedItem();
        if(txtPrice.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "Please enter the price");
        return;
        }
        double price=Double.parseDouble(txtPrice.getText());
        
        if(price<0){
        JOptionPane.showMessageDialog(this, "Price has to be positive number");
        return;
        }
        TableModelAppointmentItem tma=(TableModelAppointmentItem) tblItems.getModel();
            tma.addItem(service,price);
        txtBill.setText(tma.getTotalPrice()+"");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
       int row=tblItems.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "You have to select item which you want to remove!");
        }else{
            TableModelAppointmentItem tma=(TableModelAppointmentItem) tblItems.getModel();
            tma.remove(row);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       FrmSearch searchPatient=new FrmSearch(this, true);
        searchPatient.setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(txtPatient.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "Set patient field");
        return;
        
        }
        if(validaate()){
            
            try {
                Pregled appointment =createNewAppointment();
                System.out.println("Predled koji se upisuje u bazu je:"+appointment.getKarton().getImePacijenta()
                        +" "+appointment.getDijagnoza());
                Controler.getInstance().saveAppointment(appointment);
                int response = JOptionPane.showConfirmDialog(null, "Appointment successfully saved! Do you want to create another appointment?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    resetTxtFileds();
                } else {
                    this.dispose();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormAppointment.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(FormAppointment.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(this, "Appointment is not saved");
        return;
            }
            }else{
         JOptionPane.showMessageDialog(this, "List of items is empty! Please enter new items");
        return;
        
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       Session.getInstance().setCurrentUseCase(UseCase.UC_EDIT_APPOINTMENT);
        TableModelAppointmentItem tma=(TableModelAppointmentItem) tblItems.getModel();
        tma.setItemsAfterUpdate();
         txtBill.setText(tma.getTotalPrice()+"");
         
       cmbService.setEnabled(true);
       cmbDiagnosis.setEnabled(true);
       btnAdd.setVisible(true);
       btnRemove.setVisible(true);
       txtPrice.setVisible(true);
        btnEdit.setVisible(false);
        btnUpdate.setVisible(true);
        btnSave.setVisible(false);
       
       

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         if(txtPatient.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "Set patient field");
        return;
        
        }  if(validaate()){
            
            try {
                Pregled appointment =createNewAppointment();
                System.out.println("DAtum na pregledu je:"+appointment.getDatumPregleda());
               ArrayList<StavkaPregleda> items = (ArrayList<StavkaPregleda>) ((TableModelAppointmentItem) (tblItems.getModel())).getItemsAfterUpdate();
                
                for (StavkaPregleda item : items) {
                    item.setSifraPregleda(appointment.getSifraPregeda());
                    System.out.println("Stavke koje ubacujem:"+item.getSifraPregleda()+","+item.getRedniBroj()+","+item.getStatus());
                }
                    Controler.getInstance().updateAppointment(appointment, items);
                    JOptionPane.showMessageDialog(null, "Appointment is successfully updated!");
                    ((FrmSearch) parent).dispose();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormAppointment.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(FormAppointment.class.getName()).log(Level.SEVERE, null, ex);
            }
                }  else {
                JOptionPane.showMessageDialog(null, "Please enter all required fields!");
            }
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
      
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormAppointment dialog = new FormAppointment((FrmMain) new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Object> cmbDiagnosis;
    private javax.swing.JComboBox<Object> cmbService;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tblItems;
    private javax.swing.JTextField txtBill;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPatient;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
    public void setPatient(Karton patient) {
       txtPatient.setText(patient.getSifraKartona() +" "+patient.getBrPasosa()+" "+patient.getImePacijenta());
       Session.getInstance().setUseCaseParams(patient);
    }

      private void populateForm() {
       tblItems.setModel(new TableModelAppointmentItem(new LinkedList<>()));
       setScreenLocation();
       populateCmbDiagnosis();
       populatecmbService();
       switch(Session.getInstance().getCurrentUseCase()){
           case UseCase.UC_SEARCH_APPOINTMENT :
               txtID.setVisible(true);
               lblID.setVisible(true);
              
               btnEdit.setVisible(true);
               cmbDiagnosis.setEnabled(false);
               cmbService.setEnabled(false);
                btnSave.setVisible(false);
                 btnAdd.setVisible(false);
                 btnRemove.setVisible(false);
                btnEdit.setVisible(true);
                 btnUpdate.setVisible(false);
                 btnCancel.setVisible(true);
                 
                txtPrice.setVisible(false);
               
               setAppointment();
             break;
           case  UseCase.UC_EDIT_APPOINTMENT:
              txtID.setVisible(true);
               lblID.setVisible(true);
              
               btnEdit.setVisible(true);
               cmbDiagnosis.setEnabled(false);
               cmbService.setEnabled(false);
                btnSave.setVisible(false);
                 btnAdd.setVisible(false);
                 btnRemove.setVisible(false);
                btnEdit.setVisible(true);
                 btnUpdate.setVisible(false);
                 btnCancel.setVisible(true);
                 
                txtPrice.setVisible(false);
               
               setAppointment();
             break;
           case UseCase.UC_NEW_APPOINTMENT:
                txtID.setVisible(false);
               lblID.setVisible(false);
              
               btnSearch.setVisible(true);
                cmbDiagnosis.setEnabled(true);
               cmbService.setEnabled(true);
               txtPrice.setVisible(true);
                btnSave.setVisible(true);
                 btnAdd.setVisible(true);
                 btnRemove.setVisible(true);
                btnEdit.setVisible(false);
                 btnUpdate.setVisible(false);
                 btnCancel.setVisible(true);
                  
              
               break;
               
       
       }
       
    }
        private void setAppointment() {
        Pregled appointment=(Pregled) Session.getInstance().getUseCaseParams();
        txtID.setText(appointment.getSifraPregeda()+"");
        txtPatient.setText(appointment.getKarton().getSifraKartona() +" "+appointment.getKarton().getBrPasosa()+" "+appointment.getKarton().getImePacijenta());
        Date date=appointment.getDatumPregleda();
         
        jDateChooser1.setDate(date);
        for (StavkaPregleda ai : appointment.getStavke()) {
            System.out.println(ai.getUsluga().getNazivUsluge());
        }
        tblItems.setModel(new TableModelAppointmentItem(appointment.getStavke()));
        btnSearch.setVisible(false);
        
       cmbDiagnosis.setSelectedItem(appointment.getDijagnoza());
      
    }
    private void setScreenLocation() {
        setLocationRelativeTo(null);
    }
    
     private void populateCmbDiagnosis() {
        try {
            cmbDiagnosis.removeAllItems();
            List<Dijagnoza> list=Controler.getInstance().getAllDiagnosis();
            for (Dijagnoza d : list) {
                cmbDiagnosis.addItem(d);
            }
                    
            } catch (IOException ex) {
            Logger.getLogger(FormAppointment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void populatecmbService() {
        try {
            cmbService.removeAllItems();
           List<VrstaUsluge> list=Controler.getInstance().getAllServices();
           for (VrstaUsluge s : list) {
           cmbService.addItem(s);
            }
                    
            } catch (IOException ex) {
            Logger.getLogger(FormAppointment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void resetTxtFileds() {
        txtBill.setText("");
        txtPatient.setText("");
        cmbDiagnosis.setSelectedItem(0);
        cmbService.setSelectedItem(0);
        jDateChooser1.setDate(new Date());
        TableModelAppointmentItem tma=(TableModelAppointmentItem) tblItems.getModel();
        tma.removeALL();
    }
     
     private Pregled createNewAppointment() {
        Pregled appointement=new Pregled();
        appointement.setDijagnoza((Dijagnoza) cmbDiagnosis.getSelectedItem());
        appointement.setDatumPregleda(jDateChooser1.getDate());
         System.out.println("Datum unesen je:"+jDateChooser1.getDate());
         
        if (Session.getInstance().getCurrentUseCase() == UseCase.UC_NEW_APPOINTMENT) {
            appointement.setKarton((Karton) Session.getInstance().getUseCaseParams());
        } else {
            appointement.setKarton(new Karton(Integer.parseInt(txtPatient.getText().split(" ")[0]) , txtPatient.getText().split(" ")[1],null, txtPatient.getText().split(" ")[2], null, null, null));
            appointement.setSifraPregeda(((Pregled) (Session.getInstance().getUseCaseParams())).getSifraPregeda());
        }
        TableModelAppointmentItem tai=(TableModelAppointmentItem) tblItems.getModel();
       appointement.setStavke(tai.getItems());
         System.out.println("Pregled:"+appointement.getSifraPregeda()+","+appointement.getKarton().getImePacijenta());
        
        
        return appointement;
    }
     
     private boolean validaate() {

        TableModelAppointmentItem tai=(TableModelAppointmentItem) tblItems.getModel();
        boolean approve=true;
        if(tai.getItems().isEmpty()){
            System.out.println("Lista stavki je prazna");
            approve=false;
        }
       
       return approve; 
    }

   
     
     
}
