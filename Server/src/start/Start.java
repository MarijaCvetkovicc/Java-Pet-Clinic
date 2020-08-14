/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import form.FrmServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import thread.ClientThread;


public class Start {
    private boolean active = true;
    
    public void startServer() throws IOException{
        new FrmServer().setVisible(true);
//        ServerSocket ss = new ServerSocket(9000);
//        while(active){
//            Socket socket = ss.accept();
//            ClientThread clientThread = new ClientThread(socket);
//            clientThread.start();
//        }
        
    }
    public static void main(String[] args) throws IOException {
        //new Start().startServer();
        new FrmServer().setVisible(true);
    }
}
