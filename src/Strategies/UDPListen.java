/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;

//import ListenerManager.Listen;
import ListenerManager.ListenManager;
import ListenerManager.UpdateDetails;
import ProcessPacketInfo.ProcessPacket;
import ProcessPacketInfo.getLogInDetails;
import Main.GetDetails;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author StephenRobert
 */
public class UDPListen implements HomeStrategy {

    private getLogInDetails getLogInDetails;

    public ListenManager listen = new ListenManager();
    public GetDetails getIt = new GetDetails();
    

    public UDPListen() throws IOException, SQLException {
        getLogInDetails getLogIn = new getLogInDetails();
        HashMap<Integer, Integer> check = new HashMap<Integer, Integer>();
        int ids[] = new int[3];
        ids[0] = 1101;
        ids[1] = 1102;
        ids[2] = 1103;
        
        while (true) {
            boolean device = false;

            check.clear();
            check = getIt.GetDetails();
            String manager = "Launched from UDP Listen";
            int id = listen.ListenerManager(manager);
            for (int i = 0; i < ids.length; i++) {
                if (id == ids[i]) {
                    new UpdateDetails(check, id);
                    device = true;
                   return;

                }

            }
            if(check.containsValue(1) == false){
                if(device == false){
                new ProcessPacket(id);
            }
            }
            
        }
    }
}
