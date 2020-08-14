/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import database.DatabaseBroker;
import domain.Dijagnoza;

import domain.GeneralDomainObject;
import domain.Karton;
import domain.Pregled;
import domain.Veterinar;
import domain.VrstaUsluge;
import domain.VrstaZivotinje;
import java.util.ArrayList;
import java.util.List;
import so.AbstractGenericOperation;
import so.appointment.GetAllAppointments;
import so.appointment.SaveAppointmentSO;
import so.appointment.SearchAppointmentsSO;
import so.appointment.UpdateAppointmentSO;
import so.diagnosis.GetAllDiagnosisSO;
import so.species.GetAllSpeciesSO;
import so.login.LoginSO;
import so.patient.SavePatientSO;
import so.patient.DeletePatientSO;
import so.patient.GetAllPatientsSO;
import so.patient.SearchPatientsSO;
import so.patient.UpdatePatientSO;
import so.service.GetAllServicesSO;
import thread.ClientThread;
import thread.ServerThread;
import util.SettingsLoader;


public class Controler {

    private static Controler instance;
    private DatabaseBroker dbb;
    private ServerThread server;
    private List<ClientThread> clients;

    private Controler() {
        clients = new ArrayList<>();
    }

    public static Controler getInstance() {
        if (instance == null) {
            instance = new Controler();
        }
        return instance;
    }

    public void addClient(ClientThread client) throws Exception {
        if (!clients.contains(client)) {
            clients.add(client);
        } else {
            throw new Exception("This vet is already  logged in");
        }

    }

    public void setProperties(String port, String url, String user, String password) {
        SettingsLoader.getInstance().setProperties(port, url, user, password);
        dbb = new DatabaseBroker();
    }

    public Veterinar logIn(Veterinar dataVet) throws Exception {
        AbstractGenericOperation so = new LoginSO();
        so.templateExecute(dataVet);
        return ((LoginSO) so).getVet();
    }

    public List<GeneralDomainObject> getAllSpecies() throws Exception {
        AbstractGenericOperation so = new GetAllSpeciesSO();
        so.templateExecute(new VrstaZivotinje());
        return ((GetAllSpeciesSO) so).getList();
    }

    public List<GeneralDomainObject> searchPatients(Karton dataPatient) throws Exception {
        AbstractGenericOperation so = new SearchPatientsSO();
        so.templateExecute(dataPatient);
        return ((SearchPatientsSO) so).getList();
    }

    public void savePatient(Karton data) throws Exception {
        AbstractGenericOperation so = new SavePatientSO();
        so.templateExecute(data);
    }

    public void updatePatient(Karton data) throws Exception {
        AbstractGenericOperation so = new UpdatePatientSO();
        so.templateExecute(data);
    }

    public void deletePatient(Karton data) throws Exception {
        AbstractGenericOperation so = new DeletePatientSO();
        so.templateExecute(data);
    }

    public List<GeneralDomainObject> getAllDiagnosis() throws Exception {
        AbstractGenericOperation so = new GetAllDiagnosisSO();
        so.templateExecute(new Dijagnoza());
        return ((GetAllDiagnosisSO) so).getList();
    }

     public List<GeneralDomainObject> getAllPatients() throws Exception {
        AbstractGenericOperation so = new GetAllPatientsSO();
        so.templateExecute(new Karton());
        return ((GetAllPatientsSO) so).getList();
    }
    public List<GeneralDomainObject> getAllServices() throws Exception {
        AbstractGenericOperation so = new GetAllServicesSO();
        so.templateExecute(new VrstaUsluge());
        return ((GetAllServicesSO) so).getList();
    }

    public List<GeneralDomainObject> getAllAppointments() throws Exception {
        AbstractGenericOperation so = new GetAllAppointments();
        so.templateExecute(new Pregled());
        return ((GetAllAppointments) so).getList();
    }
    public void saveAppointment(Pregled data) throws Exception {
        AbstractGenericOperation so = new SaveAppointmentSO();
        so.templateExecute(data);
    }

    public void startServer() {
        server = new ServerThread();
        server.start();
    }

    public void stopServer() {
        for (ClientThread ct : clients) {
            ct.stopClient();
        }
        server.stopServer();
    }

 public List<GeneralDomainObject> searchAppointments(Pregled app) throws Exception {
        AbstractGenericOperation so = new SearchAppointmentsSO();
        so.templateExecute(app);
        return ((SearchAppointmentsSO) so).getList();

    }
 
    public void updateAppointment(Pregled appointmentToUpdate) throws Exception {
        AbstractGenericOperation updateAppointment = new UpdateAppointmentSO();
        updateAppointment.templateExecute(appointmentToUpdate);
    }

    public void logOut(Veterinar vet) throws Exception {
        for (ClientThread ct : clients) {
            if (ct.getVet().equals(vet)) {

                return;
            }
        }
        throw new Exception("Log out failed!");
    }

    public void removeClient(ClientThread ct) {
        clients.remove(ct);
    }
/*
    public List<GeneralDomainObject> findScheduledAppointments() throws Exception {
        AbstractGenericOperation so = new GetAllAppointments();
        so.templateExecute(new Pregled());
        List<GeneralDomainObject> list = ((GetAllAppointments) so).getList();
        for(GeneralDomainObject gdo : list){
            Pregled a = (Pregled)gdo;
            if(a.getAppointmentStatus() != AppointmentStatus.SCHEDULED){
                list.remove(a);
            }
        }
        return list;

    }
*/
}
