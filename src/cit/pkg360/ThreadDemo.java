/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit.pkg360;

/**
 *
 * @author jquibs
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Apple("one"));
        Thread t2 = new Thread(new Apple("two"));
        Thread t3 = new Thread(new Apple("three"));
        Thread t4= new Thread(new Apple("four"));
        Thread t5 = new Thread(new Apple("five"));
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
