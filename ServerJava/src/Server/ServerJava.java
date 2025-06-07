/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.Frame;

/**
 *
 * @author Farhan
 */
public class ServerJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServerFrame frame=new ServerFrame(); 
        frame.setTitle("SERVER");
        frame.setBounds(100, 10, 320, 320);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        
        
        
    }
    
}
