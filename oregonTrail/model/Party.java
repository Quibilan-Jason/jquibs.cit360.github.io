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
package byui.cit260.oregonTrail.model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Brett Starks
 */
public class Party implements Serializable{
    
    private ArrayList<Character> charactersInParty = new ArrayList<>();
    private ArrayList<Item> partyInventory = new ArrayList<>();
    private ArrayList<Ox> oxInParty = new ArrayList<>();
    private String currentPace = "Slow";
    private int currentMoney;
    private boolean brokenWagon = false;
    private int holdableAmount;
    private Player player;
    private int currentWeight;
    private int maxWeight;

    public Party() {
    }

    public ArrayList<Character> getCharactersInParty() {
        return charactersInParty;
    }

    public void addCharacter(Character newCharacter) {
        charactersInParty.add(newCharacter);
    }

    public void setCharactersInParty(ArrayList<Character> charactersInParty) {
        this.charactersInParty = charactersInParty;
    }
    
    public void removeCharacter(Character deadCharacter) {
        charactersInParty.remove(deadCharacter);
    }

    public ArrayList<Item> getPartyInventory() {
        return partyInventory;
    }

    public void addItem(Item newItem) {
        partyInventory.add(newItem);
    }
    
    public void removeItem(Item usedItem) {
        partyInventory.remove(usedItem);
    }

    public ArrayList<Ox> getOxInParty() {
        return oxInParty;
    }
    
    public void addOx(Ox newOx) {
        oxInParty.add(newOx);
    }
    
    public void removeOx(Ox deadOx) {
        oxInParty.remove(deadOx);
    }

    public String getCurrentPace() {
        return currentPace;
    }

    public void setCurrentPace(String currentPace) {
        this.currentPace = currentPace;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public boolean isBrokenWagon() {
        return brokenWagon;
    }

    public void setBrokenWagon(boolean brokenWagon) {
        this.brokenWagon = brokenWagon;
    }

    public int getHoldableAmount() {
        return holdableAmount;
    }

    public void setHoldableAmount(int holdableAmount) {
        this.holdableAmount = holdableAmount;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.charactersInParty);
        hash = 41 * hash + Objects.hashCode(this.partyInventory);
        hash = 41 * hash + Objects.hashCode(this.oxInParty);
        hash = 41 * hash + Objects.hashCode(this.currentPace);
        hash = 41 * hash + this.currentMoney;
        hash = 41 * hash + (this.brokenWagon ? 1 : 0);
        hash = 41 * hash + this.holdableAmount;
        hash = 41 * hash + Objects.hashCode(this.player);
        hash = 41 * hash + this.currentWeight;
        hash = 41 * hash + this.maxWeight;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Party other = (Party) obj;
        if (this.currentMoney != other.currentMoney) {
            return false;
        }
        if (this.brokenWagon != other.brokenWagon) {
            return false;
        }
        if (this.holdableAmount != other.holdableAmount) {
            return false;
        }
        if (!Objects.equals(this.currentPace, other.currentPace)) {
            return false;
        }
        if (!Objects.equals(this.charactersInParty, other.charactersInParty)) {
            return false;
        }
        if (!Objects.equals(this.partyInventory, other.partyInventory)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Party{" + "charactersInParty=" + charactersInParty + ", partyInventory=" + partyInventory + ", currentPace=" + currentPace + ", currentMoney=" + currentMoney + ", brokenWagon=" + brokenWagon + ", holdableAmount=" + holdableAmount + '}';
    }
    
    

   

    
    
    
    
}
