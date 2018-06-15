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

import byui.cit260.oregonTrail.control.GameControl;
import byui.cit260.oregonTrail.control.ReportControl;
import oregontrail.OregonTrail;

/**
 *
 * @author Brett Starks
 */
class ReportLocationView extends View{

    public ReportLocationView() {
        super(    "\n-------------------------------------------------"
                + "\n| Locations Report                              |"
                + "\n-------------------------------------------------"
                + "\n|V - View Report Only                           |"
                + "\n|S - View & Save Locations Report to a File     |"
                + "\n|Q - Return to Previous Menu                    |"
                + "\n-------------------------------------------------");
    }
    
    
    
    @Override
    public boolean doAction(String menuOption) {

        menuOption = menuOption.toUpperCase();

        switch (menuOption) {
            case "V":
                this.viewReport();
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

    private void viewReport() {
        ReportLocationFormat formatReport = new ReportLocationFormat();
        formatReport.display();
    }

    private void saveReport() {
       this.console.println("\n\nCreate a name to save the file:");
       
        this.displayMessage = "";
        
        String filePath = this.getInput();
        
        try {
            ReportControl.saveLocationReport(OregonTrail.getCurrentGame().getMap().getLocations(), filePath + ".txt");
            this.console.println("\n\nReport successfully saved.");
        } catch(Exception ex) {
            ErrorView.display("ReportLocationView", ex.getMessage());
        }
        
        this.displayMessage = "\n-------------------------------------------------"
                            + "\n| Locations Report                              |"
                            + "\n-------------------------------------------------"
                            + "\n|V - View Report Only                           |"
                            + "\n|S - View & Save Locations Report to a File     |"
                            + "\n|Q - Return to Previous Menu                    |"
                            + "\n-------------------------------------------------";
        
        ReportLocationFormat formatReport = new ReportLocationFormat();
        formatReport.display();
        
    }
    
}
