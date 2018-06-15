/*
 * Copyright (C) 2017 jgqui
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package byui.cit260.oregonTrail.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import oregontrail.OregonTrail;

/**
 *
 * @author jgqui
 */
public abstract class View implements ViewInterface {
    
    protected String displayMessage;
    protected final BufferedReader keyboard = OregonTrail.getInFile();
    protected final PrintWriter console = OregonTrail.getOutFile();
    
    public View() {
        
    }
    public View(String message) {
        this.displayMessage = message;
    }
    
    @Override
    public void display() {
        boolean done = false;
        
        do {
            String value = this.getInput();
            if(value.toUpperCase().equals("Q")) return;
            
            done = this.doAction(value);
            
            
        } while(!done);
    }
    
    @Override
    public String getInput() {
//        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        try {
        while(!valid) {
            this.console.println("\n" + this.displayMessage);
            
            value = this.keyboard.readLine();
            value = value.trim();
            
            if(value.length() <1) {
                ErrorView.display(this.getClass().getName(),
	          "\nInvalid value: value cannot be blank.");
                continue;
            }
            break;
        }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(),
                  "Error reading input: " + e.getMessage());
            return null;
        }
        return value;
    }
}
