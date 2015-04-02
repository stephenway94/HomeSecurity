/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListenerManager;

import Strategies.HomeStrategy;
import java.io.IOException;

/**
 *
 * @author StephenRobert
 */
public class ListenManager implements HomeStrategy {
    private Listen Listen;
    public int ListenerManager;
    public int ListenerManager(String host) throws IOException{
         this.Listen = new Listen();
        int tmp;
        tmp = Listen.Listen(host);
        
        return tmp;
    }
    
}
