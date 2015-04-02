/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author StephenRobert
 */
public class CheckLogin {
    public CheckLogin(){
        boolean inout =false;
        inout = CheckIt();
    
}

    public boolean CheckIt() {
        frame();
        
        return false;
        
        
    }

    public void frame() {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel p = new JPanel();
        JButton b1 = new JButton("Action Listener");
        
        p.add(b1);
        f.add(p);
    }
    
    
}
