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

/**
 *
 * @author MSWINDOWS
 */
public class GetAllPatientsSO extends AbstractGenericOperation{

     List<GeneralDomainObject> list;
    @Override
    protected void validate(Object entity) throws Exception {
       if (!(entity instanceof Karton)) {
            throw new Exception("Invalid entity parameter!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
           list = databaseBroker.getAllComplex((Karton)entity,null);
    }
    
      public List<GeneralDomainObject> getList() {
        return list;
    }
}
