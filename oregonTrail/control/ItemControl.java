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

import byui.cit260.oregonTrail.exceptions.ItemControlException;
import byui.cit260.oregonTrail.model.Item;
import java.util.ArrayList;

/**
 *
 * @author Brett Starks
 */
public class ItemControl {
    
    public static ArrayList<Item> addInventoryItems() throws ItemControlException {
        ArrayList<Item> inventory = new ArrayList<>();
        inventory.add(Item.Oxen);
        inventory.add(Item.Food);
        //inventory.add(Item.Food);
        //inventory.add(Item.Food);
        inventory.add(Item.Ammo);
        inventory.add(Item.Wheel);
        inventory.add(Item.WagonLarge);
        inventory.add(Item.WagonMedium);
        inventory.add(Item.WagonSmall);
        

        
        inventory = sortInventory(inventory);
        
        return inventory;
    }

    private static ArrayList<Item> sortInventory(ArrayList<Item> inventory) throws ItemControlException {
        
        if(inventory.size() < 0) {
            throw new ItemControlException("There was an error with your inventory!");
        }
        
        if(inventory.size() < 1) {
            return inventory;
        } else if(inventory.size() < 2) {
            return inventory;
        }
        
        for(int i=0; i < inventory.size(); i++) {
            for(int j=i+1; j < inventory.size(); j++) {
                if(inventory.get(i).getName().compareTo(inventory.get(j).getName()) > 0 ) {
                    Item temp = inventory.get(i);
                    inventory.set(i, inventory.get(j));
                    inventory.set(j, temp);
                }
            }
        }
        
        return inventory;
    }
    
    
}
