/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author alumne
 */
public class CapitaException extends Exception{

    @Override
    public String getMessage() {
        return "El capità ja està assignat a un vaixell.";
    }
    
}
