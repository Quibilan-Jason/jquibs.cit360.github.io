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

import byui.cit260.oregonTrail.model.Party;
import byui.cit260.oregonTrail.model.Character;
import byui.cit260.oregonTrail.model.Ox;
import java.util.ArrayList;

/**
 *
 * @author Brett Starks
 */
public class PartyControl {
    
    public int getPartyHealth(Party party) {
        double avgCharHealth = 0;
        ArrayList<Character> charInParty = new ArrayList<>();
        charInParty = party.getCharactersInParty();
        for(int i=0; i < charInParty.size(); i++) {
            avgCharHealth += charInParty.get(i).getCurrentHealth();
        }
        avgCharHealth /= charInParty.size();
        
//        avgCharHealth = Math.round(avgCharHealth);
        
        return (int) avgCharHealth;
    }
    
    public int getOxHealth(Party party) {
        double avgOxHealth = 0;
        ArrayList<Ox> oxInParty = new ArrayList<>();
        oxInParty = party.getOxInParty();
        for(int i=0; i < oxInParty.size(); i++) {
            avgOxHealth += oxInParty.get(i).getCurrentHealth();
        }
        avgOxHealth /= oxInParty.size();
        
//        avgOxHealth = Math.round(avgOxHealth);
        
        return (int) avgOxHealth;
    }
    
}
