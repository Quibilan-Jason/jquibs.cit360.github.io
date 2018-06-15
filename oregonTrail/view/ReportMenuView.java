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

/**
 *
 * @author Brett Starks
 */
class ReportMenuView extends View{

    public ReportMenuView() {
        super("\n"
                + "\n-------------------------------------------------"
                + "\n| Report Menu                                   |"
                + "\n-------------------------------------------------"
                + "\n|L - View all Locations                         |"
                + "\n|C - View all Characters                        |"
                + "\n|I - View all Items                             |"
                + "\n|Q - Return to Previous Menu                    |"
                + "\n-------------------------------------------------");
    }
    
    
    
    @Override
    public boolean doAction(String menuOption) {

        menuOption = menuOption.toUpperCase();

        switch (menuOption) {
            case "L":
                this.displayLocationReport();
                break;
            case "C":
                this.displayCharacterReport();
                break;
            case "I":
                this.displayItemReport();
                break;    
            default:
                ErrorView.display(this.getClass().getName(), 
                        "Error reading input: Invalid response.");
                break;
        }
        return false;
    }

    private void displayLocationReport() {
        ReportLocationView locationReport = new ReportLocationView();
        locationReport.display();
    }
    
    private void displayCharacterReport() {
        ReportCharacterView characterReport = new ReportCharacterView();
        characterReport.display();
    }

    private void displayItemReport() {
        ReportItemView itemReport = new ReportItemView();
        itemReport.display();
    }
    
}
