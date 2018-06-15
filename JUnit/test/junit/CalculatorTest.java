/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 *
 * @author jgqui
 */
public class CalculatorTest {
    
    @BeforeClass
   public static void beforeClass() {
      System.out.println("in before class");
   }

   //execute only once, in the end
   @AfterClass
   public static void  afterClass() {
      System.out.println("in after class");
   }

   //execute for each test, before executing test
   @Before
   public void before() {
      System.out.println("in before");
   }
	
   //execute for each test, after executing test
   @After
   public void after() {
      System.out.println("in after");
   }
	
   //test case 1
   @Test
   public void testCase1() {
      System.out.println("in test case 1");
   }

   //test case 2
   @Test
   public void testCase2() {
      System.out.println("in test case 2");
   }
    
    @Test
    public void CalculatorTest() {
        assertEquals("error in add()", 3, Calculator.add(1, 2));
        assertEquals("error in add()", -3, Calculator.add(-1, -2));
        assertEquals("error in sub()", 5, Calculator.sub(9, 4));
        assertEquals("error in sub()", -1, Calculator.sub(-3, -2));
        assertEquals("error in mul()", 12, Calculator.mul(6, 2));
        assertEquals("error in mul()", -16, Calculator.mul(4, -4));
        assertEquals("error in div()", 4, Calculator.div(8, 2));
        assertEquals("error in div()", 8, Calculator.div(16,0 ));
                
    }    
}
