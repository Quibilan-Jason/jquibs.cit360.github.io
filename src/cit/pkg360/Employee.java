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
public class Employee implements Comparable<Employee> {
    
    private int empId;
    private String empName;
    
    public Employee(int empId, String empName) {
        super();
        this.empId = empId;
        this.empName = empName;        
    }
    
    public int getEmpId() {
        return empId;        
    }
    
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    
    public String getEmpName() {
        return empName;
    }
    
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    
    public void display() {
        System.out.println("emp Id :"+getEmpId()+" Emp Name: "+getEmpName());
    }

    @Override
    public int compareTo(Employee emp) {
        
        if(this.empId == emp.getEmpId())
        return 0;
        else if(this.empId > emp.getEmpId())
        return 1;
                
                else return -1;
        
       
    }
    
}
