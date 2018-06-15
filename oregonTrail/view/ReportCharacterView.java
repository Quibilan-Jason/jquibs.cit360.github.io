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
import byui.cit260.oregonTrail.control.ReportControl;
import java.util.ArrayList;


/**
 *
 * @author J.R. Basham
 */
class ReportCharacterView extends View {

    public ReportCharacterView() {
            super("\n-------------------------------------------------"
                + "\n| Characters Report                             |"
                + "\n-------------------------------------------------"
                + "\n|V - View Report                                |"
                + "\n|S - Save Characters Report to a File           |"
                + "\n|Q - Return to Previous Menu                    |"
                + "\n-------------------------------------------------");
    }
    
    @Override
    public boolean doAction(String menuOption) {
        
        menuOption = menuOption.toUpperCase();

        switch (menuOption) {
            case "V":
                this.printCharacterReport();
                break;
            case "S":
                this.saveReport();
                break;
            default:
                ErrorView.display(this.getClass().getName(), 
                        "Error reading input: Invalid response.");
                break;
        }
        return false;
    }

    public void  printCharacterReport(){
        
        ArrayList<Character> characters = CharacterControl.createCharacters();
       
        try {

        //print title and column headings
        this.console.println("\n\n                          Character Report                                    ");
        this.console.printf("%n%-20s%-30s%20s","Name"      , "Description",                  "Starting Currency ");
        this.console.printf("%n%-20s%-30s%20s","----------", "----------------------------", "------------------");

        //print the name, description and starting currency of each item
        for (Character character : characters) {
         this.console.printf("%n%-20s%-30s%7s", character.getName()
				, character.getDescription()
				, "$" + character.getStartingCurrency());
        }
        this.console.println("\n "
                            + "\nReport printed successfully.");
        } catch (Exception e) {
                ErrorView.display(this.getClass().getName(),
                  "Error printing Character Report: " + e.getMessage());
        }
    }
    private void saveReport() {
        ArrayList<Character> characters = CharacterControl.createCharacters();
        
        this.console.println("\n\nCreate a name to save the Report to file:");
        
        String filePath = this.getInput();
        
        try {
            ReportControl.saveCharacterReport(characters, filePath);
            this.console.println("Character Report successfully saved.");
        } catch(Exception e) {
                ErrorView.display(this.getClass().getName(),
                "Error saving Character Report: " + e.getMessage());
        }
    }

    
}
