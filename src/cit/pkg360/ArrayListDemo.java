/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit.pkg360;
import java.util.*;

/**
 *
 * @author jquibs
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        String[] animals = {"bear", "snake", "eagle", "moose", "cardinal", "dear", "squirrel"};
        List<String> list1 = new ArrayList<>();
        
        //add array items to the list
        for(String x: animals)
            list1.add(x);
        
        String[] birds = {"eagle", "cardinal"};
        List<String> list2 = new ArrayList<>();
        
        //add array items to list
        for(String y: birds)
            list2.add(y);
        
        //print out list1
        for(int i =0;i<list1.size();i++) {
            System.out.printf("%s ", list1.get(i));
        }
        
        editlist(list1,list2);
        System.out.println();
        
        //print out list1 again
        for(int i =0;i<list1.size();i++) {
            System.out.printf("%s ", list1.get(i));
        }    
    }
    
    //create method
    public static void editlist(Collection<String> l1, Collection<String> l2) {
        Iterator<String> it = l1.iterator();
        
        //create loop to stop at end of list
        while(it.hasNext()) {
            if(l2.contains(it.next()))
                it.remove();
        }
    }
}
