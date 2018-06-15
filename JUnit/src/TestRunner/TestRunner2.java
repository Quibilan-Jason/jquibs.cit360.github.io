/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestRunner;


import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


/**
 *
 * @author jgqui
 */
public class TestRunner2 {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(TestAssertions.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
   }

    private static class TestAssertions {

        public TestAssertions() {
        }
    }
} 