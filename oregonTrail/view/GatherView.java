/*
 * Copyright (C) 2017 J.R. Basham
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
import byui.cit260.oregonTrail.control.GatherControl;
import byui.cit260.oregonTrail.exceptions.GatherControlException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import oregontrail.OregonTrail;
/**
 *
 * @author J.R. Basham
 */
public class GatherView extends View {
    private int charGatherRank = 2; //Skill not set in Character Model so hard coding it for testing getSkill()
    Random rand = new Random();
    private int plantLifeAmount = rand.nextInt(200) + 1;
    private float charStamina = .6F; //Stamina not set in Character Model so hard coding it for testing getStamina()
    private int amountFood;
    private String plantCheck;
      
    public GatherView() {
                   
                super("\n"
                    + "\n-----------------------------------------------------------"
                    + "\n| The success of your Gather depends on your current      |"
                    + "\n| stamnia and your characters gather rank. The greater    |"
                    + "\n| the stamnia and the higher the Gather rank              |"
                    + "\n| (1 being the best) the more likely to recover more food.|"
                    + "\n| Plant life must be greater than 10 to gather.           |"
                    + "\n| Each time you gather it lowers your characters stamina. |"
                    + "\n-----------------------------------------------------------"
                    + "\n| Gather Menu                                             |"
                    + "\n-----------------------------------------------------------"
                    + "\n|G - Gather                                               |"
                    + "\n|Q - Go Back                                              |"
                    + "\n-----------------------------------------------------------"); 
                plantCheck =  "The plant life is currently " + plantLifeAmount + ". "
                            + "\n Current stamina is " + charStamina + "."
                            + "\n Your gather rank is " + charGatherRank + "." 
                            + "\n Would you like to gather?";                   
                this.console.println(plantCheck);
    }           
    @Override
    public boolean doAction(String menuOption){      
        
        menuOption = menuOption.toUpperCase();
        
        switch(menuOption) {
            case "G":
        {
            try {
                this.calcGSuccess();
            } catch (GatherControlException rsce) {
                ErrorView.display(this.getClass().getName(),
                  "Error reading input: " + rsce.getMessage());
            }
        }
                break;
            default:
                this.console.println("*** Invalid selection. Try again ***");
                break;
        }
        return false;
    }
//    private void timesToGather(){
//        
//    
//    }
    private void calcGSuccess() throws GatherControlException {
        GatherControl gathControl = new GatherControl();
        amountFood = gathControl.calcGathSuccess(charGatherRank, plantLifeAmount, charStamina);
//        if(amountFood == -1) {
//            
//                System.out.println("\n Your characters gathering skill is not enough to gather,"
//                                    + "\n Go Back and choose a different Character."
//                                    + "\n Your characters gathering rank is " + charGatherRank + ".");                 
//        } else if(amountFood == -2) {
//            
//            System.out.println("\n There was not enough plant life to gather. "
//                               + "\n Would you like to try again?"
//                               + "\n Below is the new amount present.");
//                plantLifeAmount = rand.nextInt(50) + 1;
//                charStamina = charStamina - .1F;
//                plantCheck =  "The plant life is currently " + plantLifeAmount + ". "
//                            + "\n Current stamina is " + charStamina + "."
//                            + "\n Your characters gathering rank is " + charGatherRank + "." 
//                            + "\n Would you like to gather?";                   
//                System.out.println(plantCheck);
//        
//        } else if(amountFood == -3) {
//                System.out.println("\n Your stamnia is to low Go Back to reset."
//                                    + "\n Current stamina is " + charStamina + ".");                 
//        } else {
            
            this.console.println("\n You have recovered " + amountFood +" lbs of food. "
                               + "\n Would you like to gather again?" );
                plantLifeAmount = rand.nextInt(50) + 1;
                charStamina = charStamina - .1F;
                plantCheck =  "The plant life is currently " + plantLifeAmount + ". "
                            + "\n Current stamina is " + charStamina + "."
                            + "\n Your gathering rank is " + charGatherRank + "." 
                            + "\n Would you like to gather?";                   
                this.console.println(plantCheck);
//        }
    } 
}
