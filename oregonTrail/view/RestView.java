/*
 * Copyright (C) 2017

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
import byui.cit260.oregonTrail.exceptions.CharacterControlException;

/**
 *
 * @author J.R. Basham, Brett Starks, Jason Q
 */
public class RestView extends View {

    public RestView() {
        super("How many days do you want to rest?");
    }

    @Override
    public boolean doAction(String numOfDays) {
        int numDays;
        try {
            numDays = Integer.parseInt(numOfDays);
            try {
                CharacterControl.restCalc(numDays);
                this.console.println("You rested " + numDays + " days.");
                return true;
            } catch (CharacterControlException ce) {
                 ErrorView.display(this.getClass().getName(),
                  "Error reading input: " + ce.getMessage());
            }
        } catch (NumberFormatException nf) {
             ErrorView.display(this.getClass().getName(),
                  "You must enter a invalid number. Press Q to go back." + nf.getMessage());
        }
        return false;
    }

}
