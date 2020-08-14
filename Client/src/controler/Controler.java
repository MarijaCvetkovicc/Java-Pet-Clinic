/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import communication.Communication;
import domain.Dijagnoza;
import domain.Karton;
import domain.Pregled;
import domain.StavkaPregleda;

import domain.Veterinar;
import domain.VrstaUsluge;
import domain.VrstaZivotinje;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

public class Controler {

    private static Controler instance;

    private Controler() {

    }

    public static Controler getInstance() {
        if (instance == null) {
            instance = new Controler();
        }
        return instance;
    }

    public Veterinar logIn(String username, String password) throws Exception {
        Veterinar vet = new Veterinar();
        vet.setKorisnickoIme(username);
        vet.setLozinka(password);
        Request request = new Request(Operation.OPERATION_LOGIN, vet);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (Veterinar) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

     public void logOut(Veterinar v) throws IOException, ClassNotFoundException, Exception {        
        Request request = new Request(Operation.OPERATION_LOGOUT, v);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();        
        Exception ex = (Exception) response.getError();
        if(response.getStatus() == ResponseStatus.ERROR)
            throw ex;
    }
    
   public List<VrstaZivotinje> getAllSpecies() throws IOException, ClassNotFoundException{
       Request request=new Request();
        request.setOperation(Operation.OPERATION_GET_ALL_SPECIES);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        return (List<VrstaZivotinje>) response.getData();

   }
    public List<Dijagnoza> getAllDiagnosis() throws IOException, ClassNotFoundException {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_GET_ALL_DIAGNOSIS);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        return (List<Dijagnoza>) response.getData();
    }

    public List<VrstaUsluge> getAllServices() throws IOException, ClassNotFoundException {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_GET_ALL_SERVICES);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        return (List<VrstaUsluge>) response.getData();
    }
   
   public List<Karton> getAllPatients() throws IOException, ClassNotFoundException {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_GET_ALL_PATIENTS);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        return (List<Karton>) response.getData();
    }
   
   //Patients
       public List<Karton> getSearchedPatients(String patName) throws IOException, ClassNotFoundException, Exception {
        Karton patient = new Karton();
        patient.setImePacijenta(patName);
       
        Request request = new Request(Operation.OPERATION_SEARCH_PATIENTS, patient);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (LinkedList<Karton>) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public void savePatient(Karton patient) throws IOException, ClassNotFoundException, Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_SAVE_PATIENT);
        request.setData(patient);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return;
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public void updatePatient(Karton patient) throws IOException, ClassNotFoundException, Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_UPDATE_PATIENT);
        request.setData(patient);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return;
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public void deletePatient(Karton patient) throws IOException, ClassNotFoundException, Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_DELETE_PATIENT);
        request.setData(patient);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return;
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }
    public void saveAppointment(Pregled appointment) throws IOException, ClassNotFoundException, Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_SAVE_APPOINTMENT);
        request.setData(appointment);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return;
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public List<Pregled> getSearchedAppointments(String Patname) throws IOException, ClassNotFoundException, Exception {
        Pregled appointment = new Pregled();
        Karton patient = new Karton();
        patient.setImePacijenta(Patname);
       
        appointment.setKarton(patient);
        Request request = new Request(Operation.OPERATION_SEARCH_APPOINTMENTS, appointment);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (LinkedList<Pregled>) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    

    public void updateAppointment(Pregled a, List<StavkaPregleda> updatedItems) throws IOException, ClassNotFoundException, Exception {
       
        a.setStavke(updatedItems);
        Request request = new Request();
        request.setOperation(Operation.OPERATION_UPDATE_APPOINTMENT);
        request.setData(a);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return;
        }
        Exception ex = (Exception) response.getError();
        throw ex;


    }

   
    public List<Pregled> getAllAppointments() throws IOException, ClassNotFoundException, Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_GET_ALL_APPOINTMENTS);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (List<Pregled>)response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

}
