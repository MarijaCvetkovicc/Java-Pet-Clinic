/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.appointment;


import domain.GeneralDomainObject;
import domain.Pregled;
import java.util.List;
import so.AbstractGenericOperation;


public class GetAllAppointments extends AbstractGenericOperation{
    List<GeneralDomainObject> list;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Pregled)) {
            throw new Exception("Invalid entity parameter!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        list = databaseBroker.getAllComplex((Pregled)entity,null);
    }

    public List<GeneralDomainObject> getList() {
        return list;
    }
    
    
    
}
