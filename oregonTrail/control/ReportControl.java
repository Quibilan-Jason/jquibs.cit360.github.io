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

import byui.cit260.oregonTrail.exceptions.ReportControlException;
import byui.cit260.oregonTrail.model.Location;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import byui.cit260.oregonTrail.model.Character;
import byui.cit260.oregonTrail.model.Item;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author Brett Starks
 */
public class ReportControl {

    public static void saveLocationReport(Location[] locations, String filePath) throws ReportControlException {
        try(PrintWriter output = new PrintWriter(filePath)) {
            output.println("\n\n                   Location Report                  ");
            output.printf("%n%-25s%-20s%-15s", "Name", "Location Type", "Dist. to Oregon");
            output.printf("%n%-25s%-20s%-15s", "---------------", "---------------", "---------------");
            for(Location location : locations) {
                output.printf("%n%-25s%-20s%-15s", location.getDesc(), location.getSceneType(), location.getDistanceToOregon() + " miles");
            }
            output.println("\n\n");
        } catch(Exception e) {
            throw new ReportControlException(e.getMessage());
        }
    }
    
     public static void  saveCharacterReport(ArrayList<Character> characters, String outputLocation) throws ReportControlException {
        //Create Buffered Reader object for input file
        try (PrintWriter out = new PrintWriter(outputLocation)) {

        //print title and column headings
        out.println("\n\n                          Character Report                                    ");
        out.printf("%n%-20s%-30s%20s","Name"      , "Description",                  "Starting Currency ");
        out.printf("%n%-20s%-30s%20s","----------", "----------------------------", "------------------");

        //print the description, quanity and price of each item
        for (Character character : characters) {
         out.printf("%n%-20s%-30s%7s", character.getName()
				, character.getDescription()
				, "$" + character.getStartingCurrency());
        }
        out.println("\n\n");
        } catch(Exception e) {
            throw new ReportControlException(e.getMessage());
        }
           
    }
     
    public static void saveItemReport(ArrayList<Item> items, String filePath) throws ReportControlException {
        
        try (PrintWriter out = new PrintWriter(filePath)) {
        
        out.println("\n\n                          Item Report                                          ");
        out.printf("%n%-20s%-52s%20s","Name"      , "Description",                                 "Cost");
        out.printf("%n%-20s%-66s%20s","-----------", "----------------------------", "------------------");    
        
        for (Item item : items) {
         out.printf("%n%-20s%-68s%-7s", item.getName()
				, item.getDescription()
				, "$" + item.getCost());
        }
        out.println("\n\n");
        } catch(Exception e) {
            throw new ReportControlException(e.getMessage());
        }
           
    }
        
 }
     
     
     
    // Not sure how to get this to work.
//    public static void readLocationReport(String filePath) throws ReportControlException {
//
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath + ".txt"))) {
//            String str;
//            while((str = br.readLine()) !=null ) {
//                this.console.println(str);
//            }
//        } catch(Exception e) {
//            throw new ReportControlException(e.getMessage());
//        }
//    }

    
    
    
    

