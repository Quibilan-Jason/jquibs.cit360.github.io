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

import byui.cit260.oregonTrail.model.Location;
import java.util.Scanner;
import oregontrail.OregonTrail;

/**
 *
 * @author Brett Starks
 */
public class MapView extends View {
    
    Location[] locations = OregonTrail.getCurrentGame().getMap().getLocations();
    
    public MapView(){
        super();
    }
    
    @Override
    public void display() {
        this.displayMessage = "\n\tTHE MAP\n";
        
        for(Location location : locations) {
            this.displayMessage += "\n---------------------------------------------------------------"
                                 + "\n| " + location.getName() + " (" + location.getSceneType() + ")"   
                                 + "\n|  Distance to Oregon: \t" + location.getDistanceToOregon();
        }
       
        this.displayMessage += "\n---------------------------------------------------------------";
        this.displayMessage += "\n\n\nPress any key to return.";
        
        this.console.println("\n" + this.displayMessage);
        this.getInput();
    }
    
    @Override
    public String getInput() {
        String value = "";
        try {
            //        Scanner keyboard = new Scanner(System.in);
            value = this.keyboard.readLine();
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(),
                  "Error reading input: " + e.getMessage());
            return null;
        }
        return value;
    }

    @Override
    public boolean doAction(String value) {
        return true;
    }
    
}
