/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcessPacketInfo;

import Email.EmailIt;
import LogIn.LogIn;
import java.util.HashMap;
import MySQL.GetDeviceInfo;
import Strategies.HomeStrategy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import Output.OutputManager;

/**
 *
 * @author StephenRobert
 */
public class ProcessPacket implements HomeStrategy {

    private GetDeviceInfo GetDeviceInfo;
    private getLogInDetails getLogInDetails;
    private boolean user1;
    private boolean user2;
    private boolean user3;

    private Connection Connect;
    private Statement statement;
    private ResultSet result;
    private HashMap< Integer, Integer> LogInInformation = new HashMap< Integer, Integer>();
    private LogIn LogIn;

    public ProcessPacket(int packet) {
        
        try {
            new OutputManager(packet);
        } catch (MessagingException ex) {
            Logger.getLogger(ProcessPacket.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        
        
    }


   
}
