/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.GeneralDomainObject;
import java.util.List;


public interface IDatabaseBroker {
    public List<GeneralDomainObject> findRecords(GeneralDomainObject gdo, GeneralDomainObject gdo1) throws Exception;
    public List<GeneralDomainObject> getAll(GeneralDomainObject gdo) throws Exception;
    public List<GeneralDomainObject> getAllComplex(GeneralDomainObject gdo, GeneralDomainObject gdo1) throws Exception;
    public void saveRecord(GeneralDomainObject gdo) throws Exception;
    public void saveComplexRecord(GeneralDomainObject gdo) throws Exception;
    public void updateRecord(GeneralDomainObject gdo) throws Exception;
    public void deleteRecord(GeneralDomainObject gdo) throws Exception;
    public void startTransaction();
    public void commitTransaction();
    public void rollbackTransaction();
    
}
