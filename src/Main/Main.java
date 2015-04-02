/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;


/**
 *
 * @author StephenRobert
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MessagingException, SQLException {
        
        try {
            // TODO code application logic here
            new Manager();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
}