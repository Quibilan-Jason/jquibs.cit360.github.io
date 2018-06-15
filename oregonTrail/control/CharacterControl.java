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
package byui.cit260.oregonTrail.control;

import byui.cit260.oregonTrail.exceptions.CharacterControlException;
import byui.cit260.oregonTrail.model.Character;
import java.util.ArrayList;

/**
 *
 * @author Brett Starks
 */
public class CharacterControl {

    public static ArrayList<Character> createCharacters() {
        ArrayList<Character> characters = new ArrayList<Character>();
        Character bob = new Character("Bob", "B", "He's Bob", 8, "Healthy", 100, 100, 1F, 100);
        characters.add(bob);
        Character joe = new Character("Joe", "J","Joe is sickly", 4, "Healthy", 100, 100, 1F, 50);
        characters.add(joe);
        Character cindy = new Character("Cindy", "C", "Hi my name is Cindy!", 10, "Healthy", 100, 100, 1F, 4000);
        characters.add(cindy);
        Character ergon = new Character("Ergon IV", "E", "Distinguished Ergon the Banker", 0, "Healthy", 100, 100, 1F, 1000);
        characters.add(ergon);
        Character mitch = new Character("Mitch", "M", "He's Mitch", 8, "Healthy", 100, 100, 1F, 100);
        characters.add(mitch);
        return characters;
    }

    public int calcHealthDraw(int currentHealth, int stamina, int amountOfFood, int weather, int pace) throws CharacterControlException {
        
        int dailyHealthDraw = 0;
        int x = 0;
        int y = 0;
        int healthDraw = 0;
        int extraHealthDraw = 0;
        
        if ((currentHealth < 0) || (stamina < 0) || (amountOfFood < 0) || (weather < 0 || weather > 2) || (pace < 0 || pace > 2)) {
            throw new CharacterControlException("Your Dead.");
        }
        
         x = (currentHealth + stamina + amountOfFood);
         y = (weather + pace);
        
        if ((x <= 300) && (x >= 280)) {
            healthDraw = 5;
        }  else if ((x <= 279) && (x >= 250)) {
            healthDraw = 10;
        }  else if ((x <= 249) && (x >= 210)) {
            healthDraw = 15;
        }  else if ((x <= 209) && (x >= 150)) {
            healthDraw = 20;
        }  else if ((x <= 149) && (x >= 0)) {
            healthDraw = 25;
        }        
        
        if (y == 0) {
            extraHealthDraw = 0;
        }  else if (y == 1) {
            extraHealthDraw = 2;
        }  else if (y == 2) {
            extraHealthDraw = 5;
        }  else if (y == 3) {
            extraHealthDraw = 8;
        }  else if (y == 4) {
            extraHealthDraw = 10;
        }     
        
           dailyHealthDraw = (healthDraw + extraHealthDraw);        
            return dailyHealthDraw;
    } 
    
    public static void restCalc(int numDays) throws CharacterControlException {
        int amountFood = 100; // Making static inputs for testing
        int charHealth = 20; // Making static inputs for testing
        int maxHealth = 100; // Making static inputs for testing
        
        if (amountFood < 0 || charHealth < 0 || charHealth > maxHealth ) {
           throw new CharacterControlException("There was an error.");
        }
        if ((amountFood - 10 * numDays) < 0){
           throw new CharacterControlException("Your out of Food");
        }
        amountFood -= 10 * numDays;
        if (charHealth < maxHealth) {
            charHealth += 10 * numDays;
        }
    }
}        
            
            
        
    
             
       
        
            