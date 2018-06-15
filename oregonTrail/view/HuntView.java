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
import byui.cit260.oregonTrail.control.CharacterControl;
import byui.cit260.oregonTrail.model.Character;
import byui.cit260.oregonTrail.model.Player;
import byui.cit260.oregonTrail.control.HuntControl;
import byui.cit260.oregonTrail.exceptions.HuntControlException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import oregontrail.OregonTrail;
/**
 *
 * @author J.R. Basham
 */
public class HuntView extends View{
    ArrayList<Character> characters = CharacterControl.createCharacters();
    Character bob = characters.get(0);
    private int charHuntingRank = bob.getSkill(); 
    Random rand = new Random();
    private int wildLifeAmount = rand.nextInt(50) + 1;
    private float charStamina = bob.getStamina(); //Stamina not set in Character Model so hard coding it for testing getStamina()
    private int amountFood;
    private String animalCheck;
      
    public HuntView() {
                   
                super("\n"
                    + "\n-----------------------------------------------------------"
                    + "\n| The success of your Hunt depends on your current        |"
                    + "\n| stamnia and your characters hunting rank. The greater   |"
                    + "\n| the stamnia and the higher the hunting rank             |"
                    + "\n| (1 being the best) the more likely to recover more food.|"
                    + "\n| Animal life must be greater than 10 to hunt.            |"
                    + "\n| Each time you hunt it lowers your characters stamina.   |"
                    + "\n-----------------------------------------------------------"
                    + "\n| Hunt Menu                                               |"
                    + "\n-----------------------------------------------------------"
                    + "\n|H - Hunt                                                 |"
                    + "\n|Q - Go Back                                              |"
                    + "\n-----------------------------------------------------------"); 
                animalCheck =  "The animal life is currently " + wildLifeAmount + ". "
                            + "\n Current stamina is " + charStamina + "."
                            + "\n Your hunting rank is " + charHuntingRank + "." 
                            + "\n Would you like to hunt?";                   
                this.console.println(animalCheck);
    }           
    @Override
    public boolean doAction(String menuOption){      
        
        menuOption = menuOption.toUpperCase();
        
        switch(menuOption) {
            case "H":
        {
            try {
                this.calcHSuccess();
            } catch (HuntControlException rsce) {
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
    private void calcHSuccess() throws HuntControlException {
        HuntControl huntControl = new HuntControl();
        amountFood = huntControl.calcHuntSuccess(charHuntingRank, wildLifeAmount, charStamina);
//        if(amountFood == -1) {
//            
//                System.out.println("\n Your characters hunting skill is not enough to hunt,"
//                                    + "\n Go Back and choose a different Character."
//                                    + "\n Your characters hunting rank is " + charHuntingRank + ".");                 
//        } else if(amountFood == -2) {
//            
//            System.out.println("\n There was not enough food to hunt. "
//                               + "\n Would you like to try again?"
//                               + "\n Below is the new amount present.");
//                wildLifeAmount = rand.nextInt(50) + 1;
//                charStamina = charStamina - .1F;
//                animalCheck =  "The animal life is currently " + wildLifeAmount + ". "
//                            + "\n Current stamina is " + charStamina + "."
//                            + "\n Your characters hunting rank is " + charHuntingRank + "." 
//                            + "\n Would you like to hunt?";                   
//                System.out.println(animalCheck);
//        
//        } else if(amountFood == -3) {
//                System.out.println("\n Your stamnia is to low Go Back to reset."
//                                    + "\n Current stamina is " + charStamina + ".");                 
//        } else {
            
            this.console.println("\n You have recovered " + amountFood +" lbs of food. "
                               + "\n Would you like to hunt again?" );
                wildLifeAmount = rand.nextInt(50) + 1;
                charStamina = charStamina - .1F;
                animalCheck =  "The animal life is currently " + wildLifeAmount + ". "
                            + "\n Current stamina is " + charStamina + "."
                            + "\n Your hunting rank is " + charHuntingRank + "." 
                            + "\n Would you like to hunt?";                   
                this.console.println(animalCheck);
//        }
    }   

}
