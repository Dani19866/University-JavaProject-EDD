/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.utils;

import javax.swing.JFrame;
import user.User;

/**
 *
 * @author Daniel
 */
public class NodeGUI extends JFrame {
    public User user;
    
    public NodeGUI(User user){
        this.user = user;
    }
}
