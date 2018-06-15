/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.ArrayList;
/**
 *
 * @author J.R. Basham, Jason Quibilan, Brett Starks
 */
public class Player implements Serializable{
    
    // class instance variables
    private String name;
    private String skill;
    private int startingCurrency = 0;
    private ArrayList<Game> games = new ArrayList<Game>();
    private ArrayList<Character> character = new ArrayList<Character>();
    private Party party;
    private Pace pace;

    public Player() {
    }

    public ArrayList<Character> getCharacter() {
        return character;
    }

    public void setCharacter(ArrayList<Character> character) {
        this.character = character;
    }

     public void addCharacter(Character newCharacter) {
        character.add(newCharacter);
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getStartingCurrency() {
        return startingCurrency;
    }

    public void setStartingCurrency(int startingCurrency) {
        this.startingCurrency = startingCurrency;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Pace getPace() {
        return pace;
    }

    public void setPace(Pace pace) {
        this.pace = pace;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.skill);
        hash = 47 * hash + this.startingCurrency;
        hash = 47 * hash + Objects.hashCode(this.games);
        hash = 47 * hash + Objects.hashCode(this.character);
        hash = 47 * hash + Objects.hashCode(this.party);
        hash = 47 * hash + Objects.hashCode(this.pace);
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
        final Player other = (Player) obj;
        if (this.startingCurrency != other.startingCurrency) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.skill, other.skill)) {
            return false;
        }
        if (!Objects.equals(this.games, other.games)) {
            return false;
        }
        if (!Objects.equals(this.character, other.character)) {
            return false;
        }
        if (!Objects.equals(this.party, other.party)) {
            return false;
        }
        if (this.pace != other.pace) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", skill=" + skill + ", startingCurrency=" + startingCurrency + ", games=" + games + ", character=" + character + ", party=" + party + ", pace=" + pace + '}';
    }
    
    

    
}
