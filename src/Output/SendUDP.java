/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Output;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author StephenRobert
 * based on this example https://systembash.com/a-simple-java-udp-server-and-udp-client/
 */
public class SendUDP {
    public SendUDP(){
        try {
            DatagramSocket send = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("192.168.0.12");
            byte[] Data = new byte[1024];
            String tmp = "5555";
            Data = tmp.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(Data, Data.length, IPAddress, 9876);
            send.send(sendPacket);
            send.close();
            System.out.println("Sent UDP");
        
        } catch (Exception ex) {
            System.out.println("error in SendUDP");
        }
    }
    
}
