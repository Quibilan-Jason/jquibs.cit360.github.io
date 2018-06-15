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

import byui.cit260.oregonTrail.exceptions.RiverSceneControlException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brett Starks
 */
class SceneMenuView extends View{

    
    
    public SceneMenuView() {
        super("\n"
                    + "\n-----------------------------------------------------"
                    + "\n| Daily Trail Menu                                  |"
                    + "\n-----------------------------------------------------"
                    + "\n|T - Visit Town (If Town is Present)                |"
                    + "\n|F - Visit Fort (If Fort is Present)                |"
                    + "\n|S - Visit Store (If Store is Present)              |"
                    + "\n|C - Cross River (If River is Present)              |"
                    + "\n|R - Rest for a Day                                 |"
                    + "\n|H - Go Hunting                                     |"
                    + "\n|G - Gather Edible Plants                           |"
                    + "\n|Q - Go to Game Menu                                |"
                    + "\n-----------------------------------------------------");
    }

    
    @Override
    public boolean doAction(String menuOption) {      
        
        menuOption = menuOption.toUpperCase();
        
        switch(menuOption) {
            case "T":
                this.displayTownMenu();
                break;
            case "F":
                this.displayFortMenu();
                break;
            case "S":
                this.displayStoreMenu();
            case "C":
        {
            try {
                this.displayRiverCrossMenu();
            } catch (RiverSceneControlException ex) {
                ErrorView.display(this.getClass().getName(),
                  "Error reading input: " + ex.getMessage());
            }
        }
                break;
            case "R":
                this.restAction();
                break;
            case "H":
                this.displayHuntMenu();
                break;
            case "G":
                this.displayGatherMenu();
                break;
            default:
                this.console.println("*** Invalid selection. Try again ***");
                break;
        }
        return false;
    }

    private void displayTownMenu() {
        this.console.println("\n*** displayTownMenu() called. ***");
    }

    private void displayFortMenu() {
        this.console.println("\n*** displayFortMenu() called. ***");
    }

    private void displayRiverCrossMenu() throws RiverSceneControlException {
        RiverCrossMenuView riverCrossMenu = new RiverCrossMenuView();
        riverCrossMenu.display();
    }

    private void restAction() {
        RestView restMenu = new RestView();
        restMenu.display();
    }

    private void displayHuntMenu() {
        HuntView huntMenu = new HuntView();
        huntMenu.display();
    }

    private void displayGatherMenu() {
        GatherView gatherMenu = new GatherView();
        gatherMenu.display();
    }
    private void displayStoreMenu() {
        StoreMenuView storeMenu = new StoreMenuView();
        storeMenu.display();
    }
    
}
