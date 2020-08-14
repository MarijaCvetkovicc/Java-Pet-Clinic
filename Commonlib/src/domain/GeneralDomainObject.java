/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.util.GDOStatus;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author NEDA
 */
public abstract class GeneralDomainObject implements Serializable{
    GDOStatus status = GDOStatus.DEFAULT;

    public GDOStatus getStatus() {
        return status;
    }

    public void setStatus(GDOStatus status) {
        this.status = status;
    }
    
    
    public abstract String getTableName();
    public abstract String getColumnNames();
    public abstract String setAtrValue();
    public abstract String getAtrValue1();
    public abstract String getAtrValue2();
    public abstract String getWhereConditionFind();
    public abstract String getWhereConditionUpdate();
    public abstract String getWhereConditionFindList();
    public abstract String getJoinClauseFind();
    public abstract String getJoinClauseUpdate();
    public abstract String getNameByColumn(int column);
    public abstract List<GeneralDomainObject> getList();
    public abstract GeneralDomainObject getNewRecord(ResultSet rs) throws SQLException;
    public abstract List<GeneralDomainObject> getNewRecords(ResultSet rs) throws SQLException;
    public abstract List<GeneralDomainObject> getList(ResultSet resultSet) throws Exception;
    public abstract void createList(ResultSet rs) throws Exception;
    public abstract boolean equals(GeneralDomainObject gdo);
}
