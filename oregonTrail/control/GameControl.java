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

import byui.cit260.oregonTrail.exceptions.GameControlException;
import byui.cit260.oregonTrail.exceptions.ItemControlException;
import byui.cit260.oregonTrail.model.Character;
import byui.cit260.oregonTrail.model.Map;
import byui.cit260.oregonTrail.model.Game;
import byui.cit260.oregonTrail.model.Item;
import byui.cit260.oregonTrail.model.Pace;
import byui.cit260.oregonTrail.model.Party;
import byui.cit260.oregonTrail.model.Player;
import byui.cit260.oregonTrail.model.Weather;
import byui.cit260.oregonTrail.view.CharacterView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import oregontrail.OregonTrail;

/**
 *
 * @author Brett Starks, Jason Quibilan, JR Basham
 */
public class GameControl {

    public static Player createPlayer(String playersName) {
        if(playersName == null) return null;
        
        Player player = new Player();
        player.setName(playersName);
        
        Party party = new Party();
        
        OregonTrail.setPlayer(player);
        player.setParty(party);
        
        //Setting current and max weight statically until we implement functionality. --Brett
        player.getParty().setCurrentWeight(200);
        player.getParty().setMaxWeight(1000);
        
        return player;
    }
    
    //generate weather here temporarily until DailyTrailControl has been created.
    public static Weather currentWeather = WeatherControl.generateWeather();
    
    //Create Item List -- should be empty at New Game, but will add items here temporarily for testing.
    public static ArrayList<Item> currentInventory;

    public GameControl() throws ItemControlException {
        this.currentInventory = ItemControl.addInventoryItems();
    }
    
    public static Pace currentPace = PaceControl.setPace(Pace.Average);

    public static int createNewGame(Player player) throws GameControlException {
        if(player == null) {
            throw new GameControlException("Error - Cannot create new game");
        }
        
        Game game = new Game();
        game.setPlayer(player);
        OregonTrail.setCurrentGame(game);
        Map map = MapControl.createMap();
        game.setMap(map);

        ArrayList<Character> characters = CharacterControl.createCharacters();
        game.setCharacters(characters);
        CharacterView characterView = new CharacterView();
        characterView.display();
        
        return 1;
    }
    
    public static void saveGame(Game currentGame, String filePath) throws GameControlException {
        
        try(FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(currentGame);
        } catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
        
    }
    
    public static void loadGame(String filePath) throws GameControlException{
        Game game = null;
        
        try(FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject();
        } catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
        
        OregonTrail.setCurrentGame(game);
        
    }
    
}
