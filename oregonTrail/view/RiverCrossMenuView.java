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

import byui.cit260.oregonTrail.control.RiverSceneControl;
import byui.cit260.oregonTrail.exceptions.RiverSceneControlException;
import java.util.Random;
import oregontrail.OregonTrail;

/**
 *
 * @author Brett Starks
 */
class RiverCrossMenuView extends View{

    
    private String riverDesc;
    Random random = new Random();
    private int riverDepth = random.nextInt(12 - 3 + 1) + 3;
    private double currentWeight = OregonTrail.getPlayer().getParty().getCurrentWeight();
    private double maxWeight = OregonTrail.getPlayer().getParty().getMaxWeight();
    private int probability;
    private String menu;
    
    
    // Adding this because I think I'm supposed to reference my riverCrossingProbability() function without making it static.
    RiverSceneControl riverSceneControl = new RiverSceneControl();
    
    public RiverCrossMenuView(){
    }
    
    @Override
    public void display() {
        boolean done = false;
        
        try {
            this.probability = riverSceneControl.calculateRiverCrossingProbability(riverDepth, currentWeight, maxWeight);
        } catch(RiverSceneControlException rsce) {
                    ErrorView.display(this.getClass().getName(),
                  "Error reading input: " + rsce.getMessage());
        }
        
        this.riverDesc =  "\n"
                        + "\n The river is currently " + riverDepth + " feet. The odds of crossing with your current load are "
                        + this.probability + "%.";
        
        this.menu =   "\n"
                    + "\n-----------------------------------------------------"
                    + "\n| River Cross Menu                                  |"
                    + "\n-----------------------------------------------------"
                    + "\n|D - Drop Supplies                                  |"
                    + "\n|C - Cross the River                                |"
                    + "\n|Q - Go Back                                        |"
                    + "\n-----------------------------------------------------";
        
        this.displayMessage = this.riverDesc + this.menu;

        do {
            String value = this.getInput();
            if(value.toUpperCase().equals("Q")) return;
            
            done = this.doAction(value);
            
            
        } while(!done);
    }

    
    @Override
    public boolean doAction(String menuOption) {      
        
        menuOption = menuOption.toUpperCase();
        
        switch(menuOption) {
            case "D":
                this.dropSupplies();
                break;
            case "C":
                return this.riverCrossCheckView(riverDepth, probability);
            default:
                this.console.println("*** Invalid selection. Try again ***");
                break;
        }
        return false;
    }

    private void dropSupplies() {
        this.console.println("\n*** dropSupplies() called. ***");
    }

    // Making this a boolean so that we can return whether a successful crossing occurred (true), or if the player canceled (false)
    // If true, successful crossing will return user back to Scene Menu. If false, player will go back to River Crossing Menu.
    private boolean riverCrossCheckView(int riverDepth, int probability) {
        RiverCrossCheckView riverCrossCheck = new RiverCrossCheckView();
        return riverCrossCheck.displayCheck(riverDepth, probability);
    }

}
