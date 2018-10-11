/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit.pkg360;
import java.util.*;
/**
 *
 * @author jgqui
 */
public class Apple implements Runnable {
    String name;
    int time;
    Random r = new Random();
    
    public Apple(String x) {
        name = x;
        time = r.nextInt(999);
    }
    
    public void run() {
        try {
            System.out.printf("%s is sleeping for %d\n", name, time);
            Thread.sleep(time);
            System.out.printf("%s woke up and is done!\n", name);
        } catch(Exception e) {}
    }
}
