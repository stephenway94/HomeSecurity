/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import ListenerManager.ListenManager;
import ListenerManager.UpdateDetails;
import Strategies.UDPListen;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author StephenRobert
 */
public class Manager {

    public ListenManager listen = new ListenManager();
    public GetDetails getIt = new GetDetails();
    public HashMap<Integer, Integer> details = new HashMap<Integer, Integer>();

    public Manager() throws IOException, SQLException {
        int ids[] = new int[4];
        ids[0] = 1101;
        ids[1] = 1102;
        ids[2] = 1103;
        while(true){
        GetLogIn();
        if(details.isEmpty() == true){
            System.out.println("server unavailable");
        }
        if(details.containsValue(1) == true){
             int id = GetInteger();
        for (int i = 0; i < ids.length; i++) {
            if (id == ids[i]) {
                new UpdateDetails(details, id);

            }
        }
        }
        else{
             new UDPListen(); //this is the main thread that receives device packets
    
        }
        }

        }

    public void GetLogIn() {
        try {
            details.clear();
            details = getIt.GetDetails();
            System.out.println("details contains " + details.entrySet());
            

                
            
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int GetInteger() throws IOException {
        String listener = "Listener launched from manager";
        int idpacket = listen.ListenerManager(listener);
        return idpacket;
    }



    }

