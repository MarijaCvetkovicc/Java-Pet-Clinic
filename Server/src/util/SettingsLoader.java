/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SettingsLoader {
    private static SettingsLoader instance;
    private Properties properties;

    private SettingsLoader() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("settings.properties"));
        } catch (IOException ex) {
            Logger.getLogger(SettingsLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static SettingsLoader getInstance(){
        if(instance == null)
            instance = new SettingsLoader();
        return instance;
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key, "n/a");        
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public void setProperties(String port, String url, String user, String password) {
        OutputStream output = null;
        try {
            output = new FileOutputStream("settings.properties");
            
            
            System.out.println(url);
            properties.setProperty("port", port);
            properties.setProperty("url", url);
            properties.setProperty("user", user);
            properties.setProperty("password", password);
            
            properties.store(output, null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SettingsLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SettingsLoader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(SettingsLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
