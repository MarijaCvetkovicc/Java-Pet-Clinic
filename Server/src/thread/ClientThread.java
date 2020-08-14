/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controler.Controler;

import domain.GeneralDomainObject;
import domain.Karton;
import domain.Pregled;
import domain.Veterinar;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;


public class ClientThread extends Thread {

    private Socket socket;  
    private Veterinar vet;
    boolean active;

    public ClientThread(Socket socket) {
        this.socket = socket;
        active = true;
    }

    @Override
    public void run() {
        try {
            handleRequest();
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void handleRequest() throws IOException, ClassNotFoundException {
        while (active) {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Request request = (Request) in.readObject();
            Response response = new Response();
            
            try{
                int operation = request.getOperation();
                
                switch(operation){
                    case Operation.OPERATION_LOGIN:
                        Veterinar loginVet = (Veterinar) request.getData();
                        Veterinar vet = Controler.getInstance().logIn(loginVet);                        
                        response.setStatus(ResponseStatus.OK);
                        response.setData(vet);     
                        this.vet = vet;
                        Controler.getInstance().addClient(this);
                        break;
                   case Operation.OPERATION_GET_ALL_SPECIES:
                        List<GeneralDomainObject> species = Controler.getInstance().getAllSpecies();
                        response.setStatus(ResponseStatus.OK);
                        response.setData(species); 
                        break;
                   case Operation.OPERATION_GET_ALL_PATIENTS://-???
                        List<GeneralDomainObject> allPatients = Controler.getInstance().getAllPatients();
                        response.setStatus(ResponseStatus.OK);
                        response.setData(allPatients); 
                        break;
                    case Operation.OPERATION_SEARCH_PATIENTS:
                        Karton searechedPatient = (Karton) request.getData();                        
                        List<GeneralDomainObject> patients = Controler.getInstance().searchPatients(searechedPatient);
                        response.setStatus(ResponseStatus.OK);
                        response.setData(patients); 
                        break;
                         
                    case Operation.OPERATION_SAVE_PATIENT:
                        Karton savedPatient = (Karton) request.getData();   
                        Controler.getInstance().savePatient(savedPatient);
                        response.setStatus(ResponseStatus.OK);                        
                        break;
                        
                    case Operation.OPERATION_UPDATE_PATIENT:
                        Karton updatedPatient = (Karton) request.getData();   
                        Controler.getInstance().updatePatient(updatedPatient);
                        response.setStatus(ResponseStatus.OK);                        
                        break;
                        
                    case Operation.OPERATION_DELETE_PATIENT:
                        Karton deletedPatient = (Karton) request.getData();   
                        Controler.getInstance().deletePatient(deletedPatient);
                        response.setStatus(ResponseStatus.OK);                        
                        break;
                        
                    case Operation.OPERATION_GET_ALL_DIAGNOSIS:
                        List<GeneralDomainObject> diagnosis = Controler.getInstance().getAllDiagnosis();
                        response.setStatus(ResponseStatus.OK);
                        response.setData(diagnosis); 
                        break;
                        
                    case Operation.OPERATION_GET_ALL_SERVICES:
                        List<GeneralDomainObject> services = Controler.getInstance().getAllServices();
                        response.setStatus(ResponseStatus.OK);
                        response.setData(services); 
                        break;
                        
                    case Operation.OPERATION_SAVE_APPOINTMENT:
                        Pregled savedAppointment = (Pregled) request.getData();   
                        Controler.getInstance().saveAppointment(savedAppointment);
                        response.setStatus(ResponseStatus.OK);                        
                        break;
                    case Operation.OPERATION_SEARCH_APPOINTMENTS:
                        Pregled searchedAppointments = (Pregled) request.getData();                        
                        List<GeneralDomainObject> appointments = Controler.getInstance().searchAppointments(searchedAppointments);
                        response.setStatus(ResponseStatus.OK);
                        response.setData(appointments); 
                        break;
                    case Operation.OPERATION_UPDATE_APPOINTMENT:
                        Pregled updatedAppointment = (Pregled) request.getData();   
                        Controler.getInstance().updateAppointment(updatedAppointment);
                        response.setStatus(ResponseStatus.OK);                        
                        break;
                    case Operation.OPERATION_GET_ALL_APPOINTMENTS://----?
                        List<GeneralDomainObject> petAppointments = Controler.getInstance().getAllAppointments();
                        response.setStatus(ResponseStatus.OK);
                        response.setData(petAppointments); 
                        break;
                    case Operation.OPERATION_LOGOUT:
                        Veterinar loggedOutVet = (Veterinar) request.getData();
                        Controler.getInstance().logOut(loggedOutVet);                        
                        response.setStatus(ResponseStatus.OK);  
                        Controler.getInstance().removeClient(this);
                        sendResponse(response);
                        stopClient();
                        break;
                }
            
            }catch(Exception e){
                e.printStackTrace();
                response.setError(e);
                response.setStatus(ResponseStatus.ERROR);
            }
            
            sendResponse(response);
        }
    }

    public void sendResponse(Response response) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(response);        
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
        final ClientThread other = (ClientThread) obj;
        if (!Objects.equals(this.vet, other.vet)) {
            return false;
        }
        return true;
    }

    public Veterinar getVet() {
        return vet;
    }
    
    public void stopClient() {
        try {
            active = false;
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
