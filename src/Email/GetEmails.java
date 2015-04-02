/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import Strategies.HomeStrategy;

/**
 *
 * @author StephenRobert
 */
public class GetEmails implements HomeStrategy {
  

    public String[] GetEmails(){
        String[] EmailAdd = null;
        EmailAdd[0] = "f672707e8cd24a9197cd853b24401335@api.pushalot.com";
        return EmailAdd;
    }
    
}
