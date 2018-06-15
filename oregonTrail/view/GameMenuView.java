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

import byui.cit260.oregonTrail.control.MapControl;
import byui.cit260.oregonTrail.exceptions.MapControlException;
import byui.cit260.oregonTrail.model.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brett Starks
 */
public class GameMenuView extends View {
    
    
    
    public GameMenuView() {
               super("\n"
                    + "\n-----------------------------------------------------"
                    + "\n| Game Menu                                         |"
                    + "\n-----------------------------------------------------"
                    + "\n|D - View Date & Day of the Week                    |"
                    + "\n|N - Check Distance Traveled from Missouri          |"
                    + "\n|O - Check Distance Remaining to Oregon             |"
                    + "\n|A - Check the Surrounding Area                     |"
                    + "\n|E - Check for any Events that Occured last Night   |"
                    + "\n|W - View Current Weather                           |"
                    + "\n|S - View Team Status                               |"
                    + "\n|I - View Current Inventory                         |"
                    + "\n|P - Set Team Pace                                  |"
                    + "\n|G - Go to Scene Menu                               |"
                    + "\n|M - View the Map                                   |"
                    + "\n|R - View and Print Reports                         |"
                    + "\n|H - Help Menu                                      |"
                    + "\n|Q - Main Menu                                      |"
                    + "\n-----------------------------------------------------");
    }

    
    @Override
    public boolean doAction(String menuOption) {      
        
        menuOption = menuOption.toUpperCase();
        
        switch(menuOption) {
            case "D":
                this.viewDate();
                break;
            case "N":
                this.checkDistanceFromMissouri();
                break;
            case "O":
                this.checkDistanceToOregon();
                break;
            case "A":
                this.checkSurroundings();
                break;
            case "E":
                this.viewEventLog();
                break;
            case "W":
                this.viewWeather();
                break;
            case "S":
                this.viewTeamStatus();
                break;
            case "I":
                this.displayItemMenu();
                break;
            case "P":
                this.displayPaceMenu();
                break;
            case "G":
                this.displaySceneMenu();
                break;       
            case "R":
                this.displayReportMenu();
                break;
            case "M":        
        {             
            try {
                this.displayMapMenu();
            } catch (MapControlException ex) {
                ErrorView.display(this.getClass().getName(),
                  "Error reading input: " + ex.getMessage());
            }
        }
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

    private void viewDate() {
        this.console.println("\n*** viewDate() called.");
    }

    private void checkDistanceFromMissouri() {
        this.console.println("\n*** checkDistanceFromMissouri() called.");
    }

    private void checkDistanceToOregon() {
        this.console.println("\n*** checkDistanceToOregon() called.");
    }

    private void displayMapMenu() throws MapControlException {
        MapView mapView = new MapView();
        mapView.display();
        
    }
  
    private void viewEventLog() {
        this.console.println("\n*** viewEventLog() called.");
    }

    private void displayPaceMenu() {
       PaceMenuView paceMenu = new PaceMenuView();
       paceMenu.display();
    }

    private void displayItemMenu() {
        ItemMenuView itemMenu = new ItemMenuView();
        itemMenu.display();
    }

    private void viewTeamStatus() {
        this.console.println("\n*** viewTeamStatus() called.");
    }

    private void viewWeather() {
        WeatherView weatherView = new WeatherView();
        weatherView.display();
    }

    private void displaySceneMenu() {
        SceneMenuView sceneMenu = new SceneMenuView();
        sceneMenu.display();
    }
    
    private void checkSurroundings() {
        this.console.println("\n*** checkSurroundings() called.");
    }
    
    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void displayReportMenu() {
        ReportMenuView reportMenu = new ReportMenuView();
        reportMenu.display();
    }
}
