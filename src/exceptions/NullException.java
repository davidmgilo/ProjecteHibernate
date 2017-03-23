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
public class NullException extends Exception{
    @Override
    public String getMessage() {
        return "Valor no vàlid.";
    }
}
