/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit;

/**
 *
 * @author jgqui
 */
public class Calculator {

    
    public static int add(int number, int number2) {
        return number + number2;
    }
    
     public static int sub(int number, int number2) {
        return number - number2;
    }
    
     public static int mul(int number, int number2) {
        return number * number2;
    }
     
     public static int div(int number, int number2) {
        if(number2 == 0) {
            throw new IllegalArgumentException("Bruh... Number can not be divided by 0!");
        }
        return number / number2;
    }
}
