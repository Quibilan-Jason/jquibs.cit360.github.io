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

import byui.cit260.oregonTrail.exceptions.RiverSceneControlException;

/**
 *
 * @author Brett Starks, Jason Quibilan, J.R. Basham
 */
public class RiverSceneControl {
  
    public int calculateRiverCrossingProbability(int riverDepth, double currentWeight, double maxWeight) throws RiverSceneControlException {
        double probability;
        int minDepth = 3;
        
        if((riverDepth < 3) || (currentWeight < 0)) {
            throw new RiverSceneControlException("There was an error.");
        }
        if(currentWeight > maxWeight) {
            throw new RiverSceneControlException("You're holding more weight than you're capable of carrying! Get rid of some items and try again.");
        }
        //   Breaking up equation for readability and testing
        double riverCheck = riverDepth - minDepth;
        double weightCheck = maxWeight / currentWeight;
        weightCheck /= 25;
        probability = 100 - (riverCheck / weightCheck);
        
        if(probability < 0) {
            probability = 0;
        }
        
        return (int) probability;
    }
    
    
//    Pseudo Function
//    minDepth = 3, maxWeight = 1000;
//calculateRiverCrossingProbability(int riverDepth, int currentWeight, int maxWeight) return int probability
//  if (riverDepth < 3) || (currentWeight < 0) || (currentWeight > maxWeight): return -1 and exit
//  else 
//        probability = (100 - (riverDepth – minDepth) / ((maxWeight / currentWeight) / 25))
//        if probability < 0 then set probability = 0
//        return probability 
//end

    
}
