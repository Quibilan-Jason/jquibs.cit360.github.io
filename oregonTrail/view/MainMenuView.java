/*
 * Copyright (C) 2017 Brett Starks
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

import byui.cit260.oregonTrail.control.GameControl;
import byui.cit260.oregonTrail.exceptions.GameControlException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import oregontrail.OregonTrail;

/**
 *
 * @author Brett Starks, Jason Quibilan, JR Basham
 */
public class MainMenuView extends View {
    
    
    
    public MainMenuView() {
              super("\n"
                    + "\n-------------------------------------------------"
                    + "\n| Main Menu                                     |"
                    + "\n-------------------------------------------------"
                    + "\n|N - New Game                                   |"
                    + "\n|S - Save Game                                  |"
                    + "\n|L - Load Game                                  |"
                    + "\n|H - Help Menu                                  |"
                    + "\n|Q - Quit Game                                  |"
                    + "\n-------------------------------------------------");
    }

    
    @Override
    public boolean doAction(String value) {      
        
        value = value.toUpperCase();
        
        switch(value) {
            case "N":
        {
            try {
                this.startGame();
            } catch (GameControlException ex) {
                 ErrorView.display(this.getClass().getName(),
                  "Error reading input: " + ex.getMessage());
            }
        }
                break;
            case "S":
                this.saveGame();
                break;
            case "L":
                this.loadGame();
                break;
            case "H":
                this.displayHelpMenu();
                break;
            default:
                this.console.println("*** Invalid selection. Try again ***");
                break;
        }
        return false;
    }

    private void startGame() throws GameControlException {
        int returnValue = GameControl.createNewGame(OregonTrail.getPlayer());
        

    }

    private void saveGame() {
        this.console.println("\n\nCreate a name to save the file:");
        
        this.displayMessage = "";
        
        String filePath = this.getInput();
        
        try {
            GameControl.saveGame(OregonTrail.getCurrentGame(), filePath);
            this.console.println("Game successfully saved.");
        } catch(Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        
        this.displayMessage = "\n"
                            + "\n-------------------------------------------------"
                            + "\n| Main Menu                                     |"
                            + "\n-------------------------------------------------"
                            + "\n|N - New Game                                   |"
                            + "\n|S - Save Game                                  |"
                            + "\n|L - Load Game                                  |"
                            + "\n|H - Help Menu                                  |"
                            + "\n|Q - Quit Game                                  |"
                            + "\n-------------------------------------------------";
        
    }

    private void loadGame() {
        this.console.println("\n\nEnter the name of the file you want to load:");
        
        String filePath = this.getInput();
        
        try {
            GameControl.loadGame(filePath);
            this.console.println("Game successfully loaded.");
        } catch(Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
        
    }

    private void displayHelpMenu() {
       HelpMenuView helpMenu = new HelpMenuView();
       helpMenu.display();
    }
    
}
