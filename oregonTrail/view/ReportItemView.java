/*
 * Copyright (C) 2017 jgqui
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
import byui.cit260.oregonTrail.control.ItemControl;
import byui.cit260.oregonTrail.control.ReportControl;
import byui.cit260.oregonTrail.exceptions.ItemControlException;
import byui.cit260.oregonTrail.model.Item;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JQ
 */
public class ReportItemView extends View {

    
    
    public ReportItemView() {
        super(    "\n-------------------------------------------------"
                + "\n| Items Report                                  |"
                + "\n-------------------------------------------------"
                + "\n|V - View Report                                |"
                + "\n|S - Save Items Report to a File                |"
                + "\n|Q - Return to Previous Menu                    |"
                + "\n-------------------------------------------------");
    }
    
    @Override
    public boolean doAction(String menuOption) {

        menuOption = menuOption.toUpperCase();

        switch (menuOption) {
            case "V":
        {
            try {
                this.printItemReport();
            } catch (ItemControlException ex) {
                Logger.getLogger(ReportItemView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "S":
        {
            try {
                this.saveReport();
            } catch (ItemControlException ex) {
                Logger.getLogger(ReportItemView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            default:
                ErrorView.display(this.getClass().getName(), 
                        "Error reading input: Invalid response.");
                break;
        }
        return false;
    }

    /**
     *
     */
    public void  printItemReport() throws ItemControlException{
        
        //ArrayList<byui.cit260.oregonTrail.model.Character> characters = CharacterControl.createCharacters();
        ArrayList<byui.cit260.oregonTrail.model.Item> items;
        items = ItemControl.addInventoryItems();
        
        try {

        //print title and column headings
        this.console.println("\n\n                          Item Report                                          ");
        this.console.printf("%n%-20s%-52s%20s","Name"      , "Description",                                 "Cost");
        this.console.printf("%n%-20s%-66s%20s","-----------", "----------------------------", "------------------");
            

        //print the name, description and starting currency of each item
        //for (byui.cit260.oregonTrail.model.Character character : characters) {
        //this.console.printf("%n%-20s%-30s%7s", character.getName()
	//			, character.getDescription()
	//			, "$" + character.getStartingCurrency());
        //}
        
        for (byui.cit260.oregonTrail.model.Item item : items) {
         this.console.printf("%n%-20s%-68s%-7s", item.getName()
				, item.getDescription()
				, "$" + item.getCost());
        }

        this.console.println("\n "
                            + "\nReport printed successfully.");
        } catch (Exception e) {
                ErrorView.display(this.getClass().getName(),
                  "Error printing Item Report: " + e.getMessage());
        }
    }
    private void saveReport() throws ItemControlException {
        //ArrayList<byui.cit260.oregonTrail.model.Character> characters = CharacterControl.createCharacters();
        
        ArrayList<byui.cit260.oregonTrail.model.Item> items;
        items = ItemControl.addInventoryItems();
        
        this.console.println("\n\nCreate a name to save the Report to file:");
        
        String filePath = this.getInput();
        
        try {
            ReportControl.saveItemReport(items, filePath);
            this.console.println("Item Report successfully saved.");
        } catch(Exception e) {
                ErrorView.display(this.getClass().getName(),
                "Error saving Item Report: " + e.getMessage());
        }
    }
}
