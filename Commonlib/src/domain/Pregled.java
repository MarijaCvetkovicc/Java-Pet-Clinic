/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


import domain.util.GDOStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSWINDOWS
 */
public class Pregled extends GeneralDomainObject{

    private int sifraPregeda;
    private Date datumPregleda;
    private Karton karton;
    private Dijagnoza dijagnoza;
     private List<StavkaPregleda> stavke;
     //private AppointmentStatus appointmentStatus;
     
    public Pregled() {
        stavke=new LinkedList<>();
       // appointmentStatus = AppointmentStatus.SCHEDULED;
    }

    public Pregled(int sifraPregeda, Date datumPregleda, Karton karton, Dijagnoza dijagnoza, List<StavkaPregleda> stavke) {
        this.sifraPregeda = sifraPregeda;
        this.datumPregleda = datumPregleda;
        this.karton = karton;
        this.dijagnoza = dijagnoza;
        this.stavke = stavke;
    }

    public int getSifraPregeda() {
        return sifraPregeda;
    }

    public void setSifraPregeda(int sifraPregeda) {
        this.sifraPregeda = sifraPregeda;
    }

    public Date getDatumPregleda() {
        return datumPregleda;
    }

    public void setDatumPregleda(Date datumPregleda) {
        this.datumPregleda = datumPregleda;
    }

    public Karton getKarton() {
        return karton;
    }

    public void setKarton(Karton karton) {
        this.karton = karton;
    }

    public Dijagnoza getDijagnoza() {
        return dijagnoza;
    }

    public void setDijagnoza(Dijagnoza dijagnoza) {
        this.dijagnoza = dijagnoza;
    }

    public List<StavkaPregleda> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaPregleda> stavke) {
        this.stavke = stavke;
    }

    public GDOStatus getStatus() {
        return status;
    }

    public void setStatus(GDOStatus status) {
        this.status = status;
    }
/*    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }
 public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
  */  
    
   
            
    @Override
    public String getTableName() {
        return "pregled";
        
    }

    @Override
    public String getColumnNames() {
        return " (DatumPregleda, SifraKartona, SifraDijagnoze) ";//status?
    }

    @Override
    public String setAtrValue() {
            java.sql.Timestamp sqlDate = new java.sql.Timestamp(datumPregleda.getTime());
        return "DatumPregleda = " + "'" + sqlDate + "'" + ", "
                + "SifraKartona = " + karton.getSifraKartona()+ ", "
                + "SifraDijagnoze = " + dijagnoza.getSifraDijagnoze();
              //  + ", "+ "Status = " + (appointmentStatus == null ? null : "'" + appointmentStatus + "'");
    }

    @Override
    public String getAtrValue1() {
             java.sql.Timestamp sqlDate = new java.sql.Timestamp(datumPregleda.getTime());
        return "(" + "'" + sqlDate + "'" + ", "
                
               
                + karton.getSifraKartona()+ ", "
                 + (dijagnoza.getSifraDijagnoze())+ ")";
               // + ", " + (appointmentStatus == null ? null : "'" + appointmentStatus + "'") + ")";
    }

    @Override
    public String getAtrValue2() {
        return getAtrValue1();
    }

    @Override
    public String getWhereConditionFind() {
        return " k.ImePacijenta = " + "'" + karton.getImePacijenta() + "'";
    }

    @Override
    public String getWhereConditionUpdate() {
        return "SifraPregleda="+sifraPregeda;
    }

    @Override
    public String getWhereConditionFindList() {
        return sifraPregeda +"";
    }

    @Override
    public String getJoinClauseFind() {
         return " p JOIN karton k ON (p.SifraKartona = k.SifraKartona)" +
                " JOIN dijagnoza d ON p.SifraDijagnoze = d.SifraDijagnoze JOIN vrstazivotinje z ON k.SifraVrste = z.SifraVrste JOIN veterinar v ON k.SifraVeterinara = v.SifraVeterinara";
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
         List<GeneralDomainObject> list = new LinkedList<>();
        for (StavkaPregleda s : stavke) {
            list.add((GeneralDomainObject) s);
        }
        return list;
    }

    @Override
    public GeneralDomainObject getNewRecord(ResultSet rs) throws SQLException {
        Pregled p = new Pregled();
        p.setSifraPregeda(rs.getInt("p.SifraPregleda"));
        Date d = rs.getTimestamp("p.DatumPregleda");

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm");
        try {
            p.setDatumPregleda(sdf.parse(d.toString()));
            System.out.println(sdf.parse(d.toString()));
        } catch (ParseException ex) {
            Logger.getLogger(Pregled.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       Karton k = new Karton(rs.getInt("k.SifraKartona"), rs.getString("k.BrPasosa"), rs.getString("k.ImePrezimeVlasnika"), rs.getString("k.ImePacijenta"), rs.getString("k.BrojTelefonaVlasnika"), new VrstaZivotinje(rs.getInt("z.SifraVrste"), rs.getString("z.NazivVrste")), 
                    new Veterinar(rs.getInt("v.SifraVeterinara"), rs.getString("v.BrLicence"), rs.getString("v.ImePrezimeVeterinara"),  rs.getString("v.BrTelefona"),  rs.getString("v.KorisnickoIme"),  rs.getString("v.Lozinka")));
       p.setKarton(k);
        p.setDijagnoza(new Dijagnoza(rs.getInt("d.SifraDijagnoze"), rs.getString("d.NazivDijagnoze")));
        return p;
    }

    @Override
    public List<GeneralDomainObject> getNewRecords(ResultSet rs) throws SQLException {
  List<GeneralDomainObject> list = new LinkedList<>();
        do {
           Pregled p = new Pregled();
            p.setSifraPregeda(rs.getInt("p.SifraPregleda"));
             Date d = rs.getTimestamp("p.DatumPregleda");
            
            p.setDatumPregleda(d);
           
           Karton k = new Karton(rs.getInt("k.SifraKartona"), rs.getString("k.BrPasosa"), rs.getString("k.ImePrezimeVlasnika"), rs.getString("k.ImePacijenta"), rs.getString("k.BrTelefonaVlasnika"), new VrstaZivotinje(rs.getInt("z.SifraVrste"), rs.getString("z.NazivVrste")), 
                    new Veterinar(rs.getInt("v.SifraVeterinara"), rs.getString("v.BrLicence"), rs.getString("v.ImePrezimeVeterinara"),  rs.getString("v.BrTelefona"),  rs.getString("v.KorisnickoIme"),  rs.getString("v.Lozinka")));
       p.setKarton(k);
        p.setDijagnoza(new Dijagnoza(rs.getInt("d.SifraDijagnoze"), rs.getString("d.NazivDijagnoze")));
            list.add(p);
        } while (rs.next());
        return list;    }

    @Override
    public List<GeneralDomainObject> getList(ResultSet rs) throws Exception {
         List<GeneralDomainObject> list = new ArrayList<>();
          while (rs.next()) {
            Pregled p = new Pregled();
            p.setSifraPregeda(rs.getInt("SifraPregleda"));
            Date d = rs.getTimestamp("DatumPregleda");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                p.setDatumPregleda(sdf.parse(d.toString()));
            } catch (ParseException ex) {
                Logger.getLogger(Pregled.class.getName()).log(Level.SEVERE, null, ex);
            }
          list.add(p);
        }
        return list;
    }

    @Override
    public void createList(ResultSet rs) throws Exception {
        //List<AppointmentItem> list = new LinkedList<>();
        List<StavkaPregleda> lista = new ArrayList<>();
        while (rs.next()) {
            StavkaPregleda sp = new StavkaPregleda();
            sp.setRedniBroj(rs.getInt("sp.RedniBroj"));
            sp.setCena(rs.getDouble("sp.Cena"));
            sp.setUsluga(new VrstaUsluge(rs.getInt("vu.SifraUsluge"), rs.getString("vu.NazivUsluge")));
            lista.add(sp);
        }
        stavke = lista;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Pregled other = (Pregled) obj;
        if (this.sifraPregeda != other.sifraPregeda) {
            return false;
        }
        return true;
    }

    
    @Override
    public boolean equals(GeneralDomainObject gdo) {
  Pregled p = (Pregled) gdo;
        return this.sifraPregeda == p.getSifraPregeda();    }
    
}
