/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListenerManager;

import ProcessPacketInfo.ProcessPacket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author StephenRobert
 */
public class Listen {
    private int PACKETSIZE = 4;
    public int Listen(String Host) throws IOException{
   
        
    
        
            int port = 9999;
            
            // Construct the socket
            DatagramSocket socket = new DatagramSocket(port);

            System.out.println(Host);

         
                // Create a packet
                DatagramPacket packet = new DatagramPacket(new byte[PACKETSIZE], PACKETSIZE);

                // Receive a packet (blocking)
                socket.receive(packet);

                String stringpacket = new String(packet.getData());
         

                int IntPacket = Integer.parseInt(stringpacket);
                System.out.println("IntPacket is " + IntPacket);
                socket.close();

             return IntPacket;
                }
            
        
 
    
}