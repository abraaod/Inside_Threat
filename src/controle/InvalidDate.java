/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author henriquedavid
 */
public class InvalidDate extends Exception{
    
    public InvalidDate(){
        System.err.println("Data inválida!");
    }
    
}
