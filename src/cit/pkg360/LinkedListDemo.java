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
public class LinkedListDemo {
    public static void main(String[] args) {
        String[] fruits = {"apples", "bananas", "mangos", "oranges"};
        List<String> list1 = new LinkedList<String>();
        
        //add array items to the list
        for(String x : fruits)
            list1.add(x);
        
        String[] veggies = {"carrots", "celery", "onions"};
        List<String> list2 = new LinkedList<String>();
        
        //add array items to list
        for(String y : veggies)
            list2.add(y);
        
        //combine list1 and list2
        list1.addAll(list2);
        
        //create methods
        printMe(list1);
        removeStuff(list1, 2,5);
        printMe(list1);
        reverseMe(list1);
        
    }
    
    //printMe method
    private static void printMe(List<String> l) {
        for(String temp : l)
            System.out.printf("%s ", temp);
        System.out.println();
    }
    
    //removeStuff method
    private static void removeStuff(List<String> l, int from, int to) {
        l.subList(from, to).clear();
    }
    
    //reverseMe method
    private static void reverseMe(List<String> l) {
        ListIterator<String> it = l.listIterator(l.size());
        while(it.hasPrevious())
            System.out.printf("%s ", it.previous());
    }
}
