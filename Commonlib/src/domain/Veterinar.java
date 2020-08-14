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
public class Veterinar extends GeneralDomainObject{

    private int sifraVeterinara;
    private String brLicence;
    private String imePrezimeVeterinara;
    private String brTelefona;
    private String korisnickoIme;
    private String lozinka;

    public Veterinar() {
    }

    public Veterinar(int sifraVeterinara, String brLicence, String imePrezimeVeterinara, String brTelefona, String korisnickoIme, String lozinka) {
        this.sifraVeterinara = sifraVeterinara;
        this.brLicence = brLicence;
        this.imePrezimeVeterinara = imePrezimeVeterinara;
        this.brTelefona = brTelefona;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getSifraVeterinara() {
        return sifraVeterinara;
    }

    public String getBrLicence() {
        return brLicence;
    }

    public String getImePrezimeVeterinara() {
        return imePrezimeVeterinara;
    }

    public String getBrTelefona() {
        return brTelefona;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public GDOStatus getStatus() {
        return status;
    }

    public void setSifraVeterinara(int sifraVeterinara) {
        this.sifraVeterinara = sifraVeterinara;
    }

    public void setBrLicence(String brLicence) {
        this.brLicence = brLicence;
    }

    public void setImePrezimeVeterinara(String imePrezimeVeterinara) {
        this.imePrezimeVeterinara = imePrezimeVeterinara;
    }

    public void setBrTelefona(String brTelefona) {
        this.brTelefona = brTelefona;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public void setStatus(GDOStatus status) {
        this.status = status;
    }
    
    
    
    
    @Override
    public String getTableName() {
        return "veterinar";
        
    }

    @Override
    public String getColumnNames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String setAtrValue() {
                return "sifra veterinara=" + sifraVeterinara + ", " + "BrLicence=" + (brLicence == null ? null : "'" + brLicence + "'") + ", " + "Ime i prezime=" + (imePrezimeVeterinara == null ? null : "'" + imePrezimeVeterinara + "'") + ", " + "Br telefona=" + (brTelefona == null ? null : "'" + brTelefona + "'") + ", " + "Korisnicko ime=" + (korisnickoIme == null ? null : "'" + korisnickoIme + "'")+ ", " + "lozinka=" + (lozinka == null ? null : "'" + lozinka + "'");

    }

    @Override
    public String getAtrValue1() {
        return sifraVeterinara + ", " + (brLicence == null ? null : "'" + brLicence + "'") + ", " + (imePrezimeVeterinara == null ? null : "'" + imePrezimeVeterinara + "'") + ", " + (brTelefona == null ? null : "'" + brTelefona + "'") + ", " + (korisnickoIme == null ? null : "'" + korisnickoIme + "'")+", " + (lozinka == null ? null : "'" + lozinka + "'");
    }

    @Override
    public String getAtrValue2() {
       return getAtrValue1();
    }

    @Override
    public String getWhereConditionFind() {
         return "KorisnickoIme = " + "'" + korisnickoIme + "'" + " AND " + "Lozinka = " + "'" + lozinka + "'";
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
        return "";
    }

    @Override
    public String getNameByColumn(int column) {
         String names[] = {"SifraVeterinara", "BrLicence", "ImePrezimeVeterinara", "BrTelefona", "KorisnickoIme","Lozinka"};
        return names[column];
    }

    @Override
    public List<GeneralDomainObject> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GeneralDomainObject getNewRecord(ResultSet rs) throws SQLException {
        return new Veterinar(rs.getInt("SifraVeterinara"), rs.getString("BrLicence"), rs.getString("ImePrezimeVeterinara"), rs.getString("BrTelefona"), rs.getString("KorisnickoIme"), rs.getString("Lozinka"));
    }

    @Override
    public List<GeneralDomainObject> getNewRecords(ResultSet rs) throws SQLException {
          List<GeneralDomainObject> list = new LinkedList<>();
        do{
              int sifraVeterinara = rs.getInt("SifraVeterinara");
            String brLicence = rs.getString("BrLicence");
            String imePrezimeVeterinara = rs.getString("ImePrezimeVeterinara");
            String brTelefona = rs.getString("BrTelefona");
            String korisnickoIme = rs.getString("KorisnickoIme");
            String lozinka = rs.getString("Lozinka");
           Veterinar vet=new Veterinar(sifraVeterinara, brLicence, imePrezimeVeterinara, brTelefona, korisnickoIme, lozinka);
            list.add(vet);
        }while(rs.next());
        return list;
    }

    @Override
    public List<GeneralDomainObject> getList(ResultSet resultSet) throws Exception {
        List<GeneralDomainObject> list = new LinkedList<>();
        while (resultSet.next()) {
            int sifraVeterinara = resultSet.getInt("SifraVeterinara");
            String brLicence = resultSet.getString("BrLicence");
            String imePrezimeVeterinara = resultSet.getString("ImePrezimeVeterinara");
            String brTelefona = resultSet.getString("BrTelefona");
            String korisnickoIme = resultSet.getString("KorisnickoIme");
            String lozinka = resultSet.getString("Lozinka");
           Veterinar vet=new Veterinar(sifraVeterinara, brLicence, imePrezimeVeterinara, brTelefona, korisnickoIme, lozinka);
            list.add(vet);
        }
        return list;
    }

    @Override
    public void createList(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(GeneralDomainObject gdo) {
            if(((Veterinar)gdo).getSifraVeterinara()== sifraVeterinara){
            return true;
        }
        return false;    }

    @Override
    public String toString() {
        return imePrezimeVeterinara; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Veterinar other = (Veterinar) obj;
        if (this.sifraVeterinara != other.sifraVeterinara) {
            return false;
        }
        return true;
    }
    
}
