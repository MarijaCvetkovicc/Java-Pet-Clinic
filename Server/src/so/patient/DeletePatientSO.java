/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.patient;

import domain.GeneralDomainObject;
import domain.Karton;
import domain.Pregled;
import java.util.List;
import so.AbstractGenericOperation;


public class DeletePatientSO extends AbstractGenericOperation{

    List<GeneralDomainObject> list;
    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Karton)) {
            throw new Exception("Invalid entity parameter!");
        }
        list = databaseBroker.getAllComplex(new Pregled(),null);
        for (GeneralDomainObject g : list) {
            Pregled p=(Pregled) g;
            Karton k=(Karton) entity;
            if(p.getKarton().getSifraKartona()==k.getSifraKartona()){
                throw new Exception("You can not delete patient with appointments");
            }
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        databaseBroker.deleteRecord((Karton) entity);
    }
    
}
