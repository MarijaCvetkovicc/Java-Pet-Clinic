/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.appointment;

import domain.Pregled;
import so.AbstractGenericOperation;


public class SaveAppointmentSO extends AbstractGenericOperation{

    @Override
    protected void validate(Object entity) throws Exception {
         if (!(entity instanceof Pregled)) {
            throw new Exception("Invalid entity parameter!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        databaseBroker.saveComplexRecord((Pregled) entity);
    }
    
    
}
