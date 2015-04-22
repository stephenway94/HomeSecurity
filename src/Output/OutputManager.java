/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Output;

import Strategies.HomeStrategy;
import Main.GetContent;
import javax.mail.MessagingException;



/**
 *
 * @author StephenRobert
 */
public class OutputManager implements HomeStrategy {
     public GetEmail Getemail = new GetEmail();
     public GetContent getContent = new GetContent();

    public OutputManager(int packet) throws MessagingException {
     
        String[] email = Getemail.GetEmail();
        String content = getContent.GetContent(packet);
        System.out.println("Description of the id is: " + content);
        System.out.println("email would be sent here");
        new UpdateFeed(content);
        
        //new EmailIt(email,content);
        //new SendUDP();
        System.out.println("UDP message would be sent here");
        
        
        
        
        
     
    }
    
}
