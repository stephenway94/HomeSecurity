/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcessPacketInfo;
import Email.EmailIt;
import Strategies.HomeStrategy;
import MySQL.GetDeviceInfo;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author StephenRobert
 */
public class ProcessDevice implements HomeStrategy {
    private GetDeviceInfo GetDeviceInfo;
    //private EmailIt Email;

    public ProcessDevice(int IntPacket) {
        GetDeviceInfo getinfo = new GetDeviceInfo();
        System.out.println("this will update the device info");
        HashMap<Integer, String> deviceInfo = new HashMap<Integer, String>();
        
        deviceInfo = getinfo.MakeConnection();
        System.out.println("device info is " + deviceInfo.entrySet());
        Retrieve(deviceInfo, IntPacket);
    }

    private void Retrieve(HashMap<Integer, String> deviceInfo, int IntPacket) {
        //this.Email = new EmailIt();
        //EmailIt email = new EmailIt();
        String tmp = deviceInfo.get(IntPacket);
        try {
            new EmailIt(tmp);
        } catch (MessagingException ex) {
            Logger.getLogger(ProcessDevice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
   
    
}
