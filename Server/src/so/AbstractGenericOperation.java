/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import database.DatabaseBroker;
import database.IDatabaseBroker;
import database.connection.DatabaseConnection;


public abstract class AbstractGenericOperation {
    protected IDatabaseBroker databaseBroker;

    public AbstractGenericOperation() {
        this.databaseBroker = new DatabaseBroker();
    }

    public final void templateExecute(Object entity) throws Exception {
        try {
            startTransaction();
            validate(entity);
            
            execute(entity);
            commitTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransaction();
            throw ex;
        }
    }

    protected abstract void validate(Object entity) throws Exception;

    protected abstract void execute(Object entity) throws Exception;

    private void startTransaction() throws Exception {        
        databaseBroker.startTransaction();
    }

    private void commitTransaction() throws Exception {        
        databaseBroker.commitTransaction();
    }

    private void rollbackTransaction() throws Exception {       
        databaseBroker.rollbackTransaction();
    }
}
//DatabaseConnection.getInstance().getConnection().setAutoCommit(false);
//DatabaseConnection.getInstance().commit();
 //DatabaseConnection.getInstance().rollback();