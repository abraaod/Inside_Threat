/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class NullSpecificUser extends Exception{
    
    public NullSpecificUser(String message){
        System.out.println(message);
    }
    
}
