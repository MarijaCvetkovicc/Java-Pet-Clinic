/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.logout;

import controler.Controler;
import domain.Veterinar;
import so.AbstractGenericOperation;


public class LogoutSO extends AbstractGenericOperation{

    @Override
    protected void validate(Object entity) throws Exception {
        if(!(entity instanceof Veterinar))
            throw new Exception("Invalid entity parameter!");
    }

    @Override
    protected void execute(Object entity) throws Exception {
        Controler.getInstance().logOut((Veterinar)entity);
    }
    
}
