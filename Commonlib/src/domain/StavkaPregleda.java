/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.util.GDOStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MSWINDOWS
 */
public class StavkaPregleda  extends GeneralDomainObject{

    private int sifraPregleda;
    private int redniBroj;
    private double cena;
    private VrstaUsluge usluga;

    public StavkaPregleda() {
    }

    public StavkaPregleda(int sifraPregleda, int redniBroj, double cena, VrstaUsluge usluga) {
        this.sifraPregleda = sifraPregleda;
        this.redniBroj = redniBroj;
        this.cena = cena;
        this.usluga = usluga;
    }

    public int getSifraPregleda() {
        return sifraPregleda;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public double getCena() {
        return cena;
    }

    public VrstaUsluge getUsluga() {
        return usluga;
    }

    public GDOStatus getStatus() {
        return status;
    }

    public void setSifraPregleda(int sifraPregleda) {
        this.sifraPregleda = sifraPregleda;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setUsluga(VrstaUsluge usluga) {
        this.usluga = usluga;
    }

    public void setStatus(GDOStatus status) {
        this.status = status;
    }
    
    
    @Override
    public String getTableName() {
        return " stavkapregleda ";
    }

    @Override
    public String getColumnNames() {
          return " (SifraPregleda, RedniBroj, Cena,SifraUsluge) ";
    }

    @Override
    public String setAtrValue() {
        return "SifraPregleda="+sifraPregleda+", "
                + "RedniBroj = " + redniBroj + ", "
                + "Cena = " + cena
                + "SifraUsluge = " + usluga.getSifraUsluge();
    }

    @Override
    public String getAtrValue1() {
        return sifraPregleda+","+ redniBroj+", " +cena+ ", " + usluga.getSifraUsluge();
    }

    @Override
    public String getAtrValue2() {
        return   redniBroj+", " +cena+ ", " + usluga.getSifraUsluge();

    }

    @Override
    public String getWhereConditionFind() {
        return " sp.SifraPregleda";
    }

    @Override
    public String getWhereConditionUpdate() {
         return " SifraPregleda = " + sifraPregleda + " AND " + "RedniBroj = " + redniBroj;
    }

    @Override
    public String getWhereConditionFindList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoinClauseFind() {
        return " sp JOIN vrstaUsluge vu ON sp.SifraUsluge=vu.SifraUsluge";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createList(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StavkaPregleda other = (StavkaPregleda) obj;
        if (this.sifraPregleda != other.sifraPregleda) {
            return false;
        }
        if (this.redniBroj != other.redniBroj) {
            return false;
        }
        return true;
    }

    
    @Override
    public boolean equals(GeneralDomainObject gdo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
