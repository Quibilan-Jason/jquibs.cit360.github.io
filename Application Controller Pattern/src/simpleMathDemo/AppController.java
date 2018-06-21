package simpleMathDemo;

import java.util.HashMap;

public class AppController {
    
    private static final HashMap<String, doMath> hashMapOfCommands = new HashMap<>();

    public AppController() {
    }
    
    static {
        hashMapOfCommands.put("+", new Add());
        hashMapOfCommands.put("/", new Div());
        hashMapOfCommands.put("*", new Mul());
        hashMapOfCommands.put("^", new Exp());
        hashMapOfCommands.put("-", new Sub());
    }
    
    public void handleCommand( Integer num1, String command, Integer num2) {
        
        doMath handler = hashMapOfCommands.get(command);
        
        handler.execute(num1, num2);
        
    }
}
