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

import byui.cit260.oregonTrail.exceptions.MapControlException;
import byui.cit260.oregonTrail.model.Location;
import byui.cit260.oregonTrail.model.Map;
import byui.cit260.oregonTrail.model.Pace;
import byui.cit260.oregonTrail.model.Scene;

/**
 *
 * @author Brett Starks
 */
public class MapControl {
    
    
    private static Location[] createLocations() {
        
        Location[] locations = new Location[22];
        locations[0] = new Location(0, 2000, "Independence", "town", "Independence, MO");
        locations[1] = new Location(80, 1920, "Kansas River Crossing", "river", "The Kansas River");
        locations[2] = new Location(140, 1860, "Granada Station", "town", "Granada Station");
        locations[3] = new Location(240, 1760, "Big Blue River Crossing", "river", "Big Blue River");
        locations[4] = new Location(270, 1730, "Rock Creek Station", "town", "Rock Creek Station");
        locations[5] = new Location(340, 1660, "Fort Kearney", "fort", "Fort Kearney");
        locations[6] = new Location(490, 1510, "Platte River Crossing", "river", "Platte River");
        locations[7] = new Location(580, 1420, "Chimney Rock", "landmark", "Chimney Rock");
        locations[8] = new Location(600, 1400, "Scotts Bluff", "town", "Scotts Bluff");
        locations[9] = new Location(650, 1350, "Fort Laramie", "fort", "Fort Laramie");
        locations[10] = new Location(750, 1250, "Fort Caspar", "fort", "Fort Caspar");
        locations[11] = new Location(810, 1190, "Independence Rock", "landmark", "Indpendence Rock");
        locations[12] = new Location(910, 1090, "South Pass", "landmark", "South Pass");
        locations[13] = new Location(1050, 950, "Bear River Crossing", "river", "Bear River");
        locations[14] = new Location(1100, 900, "Soda Springs", "landmark", "Soda Springs");
        locations[15] = new Location(1150, 850, "Fort Hall", "fort", "Fort Hall");
        locations[16] = new Location(1250, 750, "Snake River Crossing", "river", "Snake River");
        locations[17] = new Location(1600, 400, "Fort Boise", "fort", "Fort Boise");
        locations[18] = new Location(1700, 300, "Blue Mountains", "landmark", "Blue Mountains");
        locations[19] = new Location(1800, 200, "Whitman Mission", "city", "Whitman Mission");
        locations[20] = new Location(1900, 100, "The Dalles", "landmark", "The Dalles");
        locations[21] = new Location(2000, 0, "Oregon City", "city", "Oregon City, OR");
        return locations;
    }  
    
    private static Scene[] createScenes(){
        Scene[] scenes = new Scene[5];
        scenes[0] = new Scene("DailyTrailScene");
        scenes[1] = new Scene("TownScene");
        scenes[2] = new Scene("RiverScene");
        scenes[3] = new Scene("FortScene");
        return scenes;
    }
    
    private static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[] locations = map.getLocations();
        locations[0].setScene(scenes[1]);
        locations[1].setScene(scenes[2]);
        locations[2].setScene(scenes[1]);
        locations[3].setScene(scenes[2]);
        locations[4].setScene(scenes[1]);
        locations[5].setScene(scenes[3]);
        locations[6].setScene(scenes[2]);
        locations[7].setScene(scenes[0]);
        locations[8].setScene(scenes[1]);
        locations[9].setScene(scenes[3]);
        locations[10].setScene(scenes[3]);
        locations[11].setScene(scenes[0]);
        locations[12].setScene(scenes[0]);
        locations[13].setScene(scenes[2]);
        locations[14].setScene(scenes[0]);
        locations[15].setScene(scenes[3]);
        locations[16].setScene(scenes[2]);
        locations[17].setScene(scenes[3]);
        locations[18].setScene(scenes[0]);
        locations[19].setScene(scenes[1]);
        locations[20].setScene(scenes[0]);
        locations[21].setScene(scenes[1]);
    }
    
    public static Map createMap() {
        
        Map map = new Map();
        
        Location[] locations = createLocations();
        map.setNoOfLocations(locations.length);
        map.setLocations(locations);
        
        Scene[] scenes = createScenes();
        assignScenesToLocations(map, scenes);
        
        return map;
    }
    
    
    public int calculateDailyMiles(int avgCharHealth, int avgOxHealth, int currentWeight, int maxWeight, Pace pace) throws MapControlException {
        double miles = 20;
        double currentPace;
            
        if(pace == null) {
            currentPace = 0;
        } else {
            currentPace = pace.getValue();
        }
        
        if((avgCharHealth <= 0) || (avgCharHealth > 100) || (avgOxHealth <= 0) || (avgOxHealth > 100) || (currentWeight < 0) || (currentWeight > maxWeight) || ((currentPace != 0.5) && (currentPace != 1.0) && (currentPace != 1.5))) {
            throw new MapControlException("You cannot move.... "
                                        + "Your wagon is too heavy for Oxen to pull, "
                                        + "Your Ox might be dead, "
                                        + "or unfortunately You are dead... ");
        } else {
            miles *= currentPace;
//            Separating the equation a bit to make it more readable.
            double healthCheck = ((avgCharHealth + avgOxHealth) / 2 ) * .01;
//            double weightCheck = ((maxWeight - currentWeight) / maxWeight) / 2;
            double weightCheck = maxWeight - currentWeight;
            weightCheck = weightCheck / maxWeight;
            miles *= (healthCheck + weightCheck) / 2;

//              Original equation
//              miles = (miles * currentPace) * (((((avgCharHealth + avgOxHealth) / 2)  * .01) +  ((maxWeight - currentWeight) / maxWeight)) / 2);
            miles = Math.round(miles);
        }
        
        return (int) miles;
    }
    

}
