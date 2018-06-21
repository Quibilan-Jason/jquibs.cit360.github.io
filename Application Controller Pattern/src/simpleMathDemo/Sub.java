package simpleMathDemo;

public class Sub implements doMath {
    
    public void execute(Integer num1, Integer num2) {
        Integer sum = num1 - num2;
        System.out.println(sum);
    }
    
}