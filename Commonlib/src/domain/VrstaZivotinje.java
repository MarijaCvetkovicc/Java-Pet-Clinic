/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.util.GDOStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author MSWINDOWS
 */
public class VrstaZivotinje extends GeneralDomainObject{

    private int sifraVrste;
    private String nazivVrste;

    public VrstaZivotinje() {
    }

    public VrstaZivotinje(int sifraVrste, String nazivVrste) {
        this.sifraVrste = sifraVrste;
        this.nazivVrste = nazivVrste;
    }

    public int getSifraVrste() {
        return sifraVrste;
    }

    public String getNazivVrste() {
        return nazivVrste;
    }

    public GDOStatus getStatus() {
        return status;
    }

    public void setSifraVrste(int sifraVrste) {
        this.sifraVrste = sifraVrste;
    }

    public void setNazivVrste(String nazivVrste) {
        this.nazivVrste = nazivVrste;
    }

    public void setStatus(GDOStatus status) {
        this.status = status;
    }
    
            
    @Override
    public String getTableName() {
        return "vrstazivotinje";
    }

    @Override
    public String getColumnNames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String setAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAtrValue1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAtrValue2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereConditionFind() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereConditionUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereConditionFindList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoinClauseFind() {
        return "";
    }

    @Override
    public String getJoinClauseUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNameByColumn(int column) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GeneralDomainObject> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GeneralDomainObject getNewRecord(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GeneralDomainObject> getNewRecords(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GeneralDomainObject> getList(ResultSet resultSet) throws Exception {
        List<GeneralDomainObject> list = new LinkedList<>();
        while (resultSet.next()) {
            int sifraVrste = resultSet.getInt("SifraVrste");
            String nazivVrste = resultSet.getString("NazivVrste");
            VrstaZivotinje vrstaZivotinje = new VrstaZivotinje(sifraVrste, nazivVrste);
            list.add(vrstaZivotinje);
        }
        
        return list;    }

    @Override
    public String toString() {
        return nazivVrste; //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public void createList(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(GeneralDomainObject gdo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
