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
import java.util.Objects;

/**
 *
 * @author MSWINDOWS
 */
public class Karton extends GeneralDomainObject{

    private int sifraKartona;
    private String brPasosa;
    private String imePrezimeVlasnika;
    private String imePacijenta;
    private String brTelefonaVlasnika;
    private VrstaZivotinje vrstaZivotinje;
    private Veterinar veterinar;

    public Karton() {
    }

    public Karton(int sifraKartona, String brPasosa, String imePrezimeVlasnika, String imePacijenta, String brTelefonaVlasnika, VrstaZivotinje vrstaZivotinje, Veterinar veterinar) {
        this.sifraKartona = sifraKartona;
        this.brPasosa = brPasosa;
        this.imePrezimeVlasnika = imePrezimeVlasnika;
        this.imePacijenta = imePacijenta;
        this.brTelefonaVlasnika = brTelefonaVlasnika;
        this.vrstaZivotinje = vrstaZivotinje;
        this.veterinar = veterinar;
    }

     public Karton( String brPasosa, String imePrezimeVlasnika, String imePacijenta, String brTelefonaVlasnika, VrstaZivotinje vrstaZivotinje, Veterinar veterinar) {
        
        this.brPasosa = brPasosa;
        this.imePrezimeVlasnika = imePrezimeVlasnika;
        this.imePacijenta = imePacijenta;
        this.brTelefonaVlasnika = brTelefonaVlasnika;
        this.vrstaZivotinje = vrstaZivotinje;
        this.veterinar = veterinar;
    }
    public int getSifraKartona() {
        return sifraKartona;
    }

    public String getBrPasosa() {
        return brPasosa;
    }

    public String getImePrezimeVlasnika() {
        return imePrezimeVlasnika;
    }

    public String getImePacijenta() {
        return imePacijenta;
    }

    public String getBrTelefonaVlasnika() {
        return brTelefonaVlasnika;
    }

    public VrstaZivotinje getVrstaZivotinje() {
        return vrstaZivotinje;
    }

    public Veterinar getVeterinar() {
        return veterinar;
    }

    public GDOStatus getStatus() {
        return status;
    }

    public void setSifraKartona(int sifraKartona) {
        this.sifraKartona = sifraKartona;
    }

    public void setBrPasosa(String brPasosa) {
        this.brPasosa = brPasosa;
    }

    public void setImePrezimeVlasnika(String imePrezimeVlasnika) {
        this.imePrezimeVlasnika = imePrezimeVlasnika;
    }

    public void setImePacijenta(String imePacijenta) {
        this.imePacijenta = imePacijenta;
    }

    public void setBrTelefonaVlasnika(String brTelefonaVlasnika) {
        this.brTelefonaVlasnika = brTelefonaVlasnika;
    }

    public void setVrstaZivotinje(VrstaZivotinje vrstaZivotinje) {
        this.vrstaZivotinje = vrstaZivotinje;
    }

    public void setVeterinar(Veterinar veterinar) {
        this.veterinar = veterinar;
    }

    public void setStatus(GDOStatus status) {
        this.status = status;
    }
    
            
    @Override
    public String getTableName() {
        return "karton";
    }

    @Override
    public String getColumnNames() {
        return " ( SifraKartona, BrPasosa,ImePrezimeVlasnika,ImePacijenta,BrTelefonaVlasnika,SifraVeterinara,SifraVrste)";
    }
    
    @Override
    public String setAtrValue() {
        return  "BrPasosa = " + (brPasosa == null ? null : "'" + brPasosa + "'") + ", "
                + "ImePrezimeVlasnika = " + (imePrezimeVlasnika == null ? null : "'" + imePrezimeVlasnika + "'") + ", "
               
                + "ImePacijenta = " + (imePacijenta == null ? null : "'" + imePacijenta + "'") + ", "
                + "BrTelefonaVlasnika = " + (brTelefonaVlasnika == null ? null : "'" + brTelefonaVlasnika + "'") + ", "
                + "SifraVeterinara = " + veterinar.getSifraVeterinara()+ ", "
                + "SifraVrste = " + vrstaZivotinje.getSifraVrste() ;
  
    }

    @Override
    public String getAtrValue1() {
         return sifraKartona+","
                +(brPasosa == null ? null : "'" + brPasosa + "'") + ", "
                + (imePrezimeVlasnika == null ? null : "'" + imePrezimeVlasnika + "'") + ", "
               
                + (imePacijenta == null ? null : "'" + imePacijenta + "'") + ", "
                + (brTelefonaVlasnika == null ? null : "'" + brTelefonaVlasnika + "'") + ", "
                +  veterinar.getSifraVeterinara()+ ", "
                + vrstaZivotinje.getSifraVrste() ;
  
       
  
    }

    @Override
    public String getAtrValue2() {
        return 
                (brPasosa == null ? null : "'" + brPasosa + "'") + ", "
                + (imePrezimeVlasnika == null ? null : "'" + imePrezimeVlasnika + "'") + ", "
               
                + (imePacijenta == null ? null : "'" + imePacijenta + "'") + ", "
                + (brTelefonaVlasnika == null ? null : "'" + brTelefonaVlasnika + "'") + ", "
                +  veterinar.getSifraVeterinara()+ ", "
                + vrstaZivotinje.getSifraVrste() ;
    }

    @Override
    public String getWhereConditionFind() {
        
         return " k.ImePacijenta = " + "'" + imePacijenta + "'";
    }

    @Override
    public String getWhereConditionUpdate() {
        return "SifraKartona = " + "'" + sifraKartona + "'";
    }

    @Override
    public String getWhereConditionFindList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoinClauseFind() {
        return " k JOIN veterinar v ON k.SifraVeterinara=v.SifraVeterinara JOIN vrstazivotinje z ON k.SifraVrste=z.SifraVrste";
    }

    @Override
    public String toString() {
        return imePacijenta+" " +vrstaZivotinje.getNazivVrste()+" "+imePrezimeVlasnika+" "+brTelefonaVlasnika+" "+veterinar.getImePrezimeVeterinara(); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public String getJoinClauseUpdate() {
        return "";
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
         Karton k=new Karton();
        k.setSifraKartona(rs.getInt("k.SifraKartona"));
        k.setBrPasosa(rs.getString("k.BrPasosa"));
        k.setImePrezimeVlasnika(rs.getString("k.ImePrezimeVlasnika"));
        k.setImePacijenta(rs.getString("k.ImePacijenta"));
        k.setBrTelefonaVlasnika(rs.getString("k.BrTelefonaVlasnika"));
        k.setVeterinar(new Veterinar(rs.getInt("v.SifraVeterinara"), rs.getString("v.BrLicence"), rs.getString("v.ImePrezimeVeterinara"), rs.getString("v.BrTelefona"), rs.getString("v.KorisnickoIme"), rs.getString("v.Lozinka")));
        k.setVrstaZivotinje(new VrstaZivotinje(rs.getInt("z.SifraVrste"), rs.getString("z.NazivVrste")));
        return k;
    }

    @Override
    public List<GeneralDomainObject> getNewRecords(ResultSet rs) throws SQLException {
        List<GeneralDomainObject> list=new LinkedList<>();
        do{
            Karton k=new Karton();
        k.setSifraKartona(rs.getInt("k.SifraKartona"));
        k.setBrPasosa(rs.getString("k.BrPasosa"));
        k.setImePrezimeVlasnika(rs.getString("k.ImePrezimeVlasnika"));
        k.setImePacijenta(rs.getString("k.ImePacijenta"));
        k.setBrTelefonaVlasnika(rs.getString("k.BrTelefonaVlasnika"));
        k.setVeterinar(new Veterinar(rs.getInt("v.SifraVeterinara"), rs.getString("v.BrLicence"), rs.getString("v.ImePrezimeVeterinara"), rs.getString("v.BrTelefona"), rs.getString("v.KorisnickoIme"), rs.getString("v.Lozinka")));
        k.setVrstaZivotinje(new VrstaZivotinje(rs.getInt("z.SifraVrste"), rs.getString("z.NazivVrste")));
       list.add(k);
            
        }while(rs.next());
        
        return list;
    }

    @Override
    public List<GeneralDomainObject> getList(ResultSet resultSet) throws Exception {
        List<GeneralDomainObject> list=new LinkedList<>();
        while(resultSet.next()){
           int sifraKartona= resultSet.getInt("SifraKartona");
           String brPasosa=resultSet.getString("BrPasosa");
           String imePrezimeVlasnika=resultSet.getString("ImePrezimeVlasnika");
           String imePacijenta=resultSet.getString("ImePacijenta");
           String brTelefonaVlasnika=resultSet.getString("BrTelefonaVlasnika");
           
        Karton karton=new Karton(sifraKartona, brPasosa, imePrezimeVlasnika, imePacijenta, brTelefonaVlasnika, null, null);
        list.add(karton);
        }
        return  list;
    }

    @Override
    public void createList(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public boolean equals(GeneralDomainObject obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Karton other = (Karton) obj;
        if (!Objects.equals(this.brPasosa, other.brPasosa)) {
            return false;
        }
        return true;
    }
    
    
}
