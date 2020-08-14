/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.appointment;


import domain.Pregled;
import domain.StavkaPregleda;
import domain.util.GDOStatus;
import so.AbstractGenericOperation;


public class UpdateAppointmentSO extends AbstractGenericOperation {

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Pregled)) {
            throw new Exception("Invalid entity parameter!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        Pregled p = (Pregled) entity;
        databaseBroker.updateRecord(p);
        if (p.getStavke()!= null) {
            for (StavkaPregleda ps : p.getStavke()) {
                switch (ps.getStatus()) {
                    case NEW:
                        System.out.println("Usao sam da zapamti novu stavku");
                        databaseBroker.saveRecord(ps);
                        break;
                    case UPDATED:
                         System.out.println("Usao sam da updateujem  stavku");
                        databaseBroker.updateRecord(ps);
                        break;
                    case DELETED:
                         System.out.println("Usao sam da izbrisem stavku");
                        databaseBroker.deleteRecord(ps);
                        break;
                }
            }
        }
    }

}
