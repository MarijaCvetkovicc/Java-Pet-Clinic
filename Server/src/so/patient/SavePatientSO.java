/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.patient;

import domain.GeneralDomainObject;
import domain.Karton;
import java.util.List;
import so.AbstractGenericOperation;


public class SavePatientSO extends AbstractGenericOperation{

    List<GeneralDomainObject> list;
    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Karton) ) {
            throw new Exception("Invalid entity parameter!");
        }
       list = databaseBroker.getAllComplex((Karton)entity,null);
        for (GeneralDomainObject g : list) {
            Karton k=(Karton) entity;
            if(k.equals(g)){
                System.out.println("Usao sam da je isto");
             throw new Exception("Passport no. already exists!");
            }
        }
       
    }

    @Override
    protected void execute(Object entity) throws Exception {
        databaseBroker.saveRecord((Karton) entity);
    }
    
}
