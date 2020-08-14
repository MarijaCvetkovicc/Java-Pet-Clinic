/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.species;


import domain.GeneralDomainObject;
import domain.VrstaZivotinje;
import java.util.List;
import so.AbstractGenericOperation;


public class GetAllSpeciesSO extends AbstractGenericOperation{
    List<GeneralDomainObject> list;
    
    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof VrstaZivotinje)) {
            throw new Exception("Invalid entity parameter!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        list = databaseBroker.getAll((VrstaZivotinje) entity);
    }

    public List<GeneralDomainObject> getList() {
        return list;
    }
    
    
}
