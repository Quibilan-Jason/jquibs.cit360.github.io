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

import java.util.Scanner;

/**
 *
 * @author Brett Starks, Jason Quibilan, JR Basham
 */
public class HelpMenuView extends View {

    public HelpMenuView() {
        super("\n"
                + "\n-------------------------------------------------"
                + "\n| Help Menu                                     |"
                + "\n-------------------------------------------------"
                + "\n|G - Game objective                             |"
                + "\n|H - How to move                                |"
                + "\n|T - Tips                                       |"
                + "\n|Q - Return to previous menu                    |"
                + "\n-------------------------------------------------");
    }

    @Override
    public boolean doAction(String menuOption) {

        menuOption = menuOption.toUpperCase();

        switch (menuOption) {
            case "G":
                this.console.println(StartProgramView.getIntroText());
                break;
            case "H":
                this.console.println("Use the options in the Game Menu and Daily Trail Menu to move forward, visit towns, hunt, or gather.");
                break;
            case "T":
                this.console.println("If you want an easier time, choose a banker! If you want a challenge, choose a freeloader!");
                break;
            default:
                this.console.println("*** Invalid selection. Try again ***");
                break;
        }
        return false;
    }

}
