/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.isagil.calculator;

import ort.isagil.calculator.model.*;

/**
 *
 * @author juanpablo.russo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Money primerMoneda = new Money(100, "UY");
        Money segundaMoneda = new Money(1, "USD");
        
        ExchangeRate tipoDeCambio = new ExchangeRate("USD", "UY", 28);
        
        Money resultado = primerMoneda.sumar(segundaMoneda, tipoDeCambio);
        
        System.out.println("Al sumar UY 100 con USD 1 USD el resultado es: " + resultado.toString());
    }
    
}
