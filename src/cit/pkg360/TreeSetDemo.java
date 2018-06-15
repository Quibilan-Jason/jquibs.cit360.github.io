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
public class TreeSetDemo {    
    public static void main(String[] args) {
        
        Set <Employee> empset = new TreeSet<Employee>();
        
        Employee emp1 = new Employee(124, "Fred");
        Employee emp2 = new Employee(188, "Daphne");
        Employee emp3 = new Employee(102, "Velma");
        Employee emp4 = new Employee(153, "Shaggy");
        Employee emp5 = new Employee(174, "Scooby");
        
        empset.add(emp1);
        empset.add(emp2);
        empset.add(emp3);
        empset.add(emp4);
        empset.add(emp5);
        
        for(Employee emp: empset)
            emp.display();
        
    }
    
}
