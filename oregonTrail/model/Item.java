/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.model;

/**
 *
 * @author J.R. Basham, Jason Quibilan, Brett Starks
 */
public enum Item {
    
    Oxen("Oxen", "Strong and powerful beast that can pull wagons up to 1000 lbs.", 1000, 40),
    WagonSmall("WagonSmall", "Small wagon that can carry minimal amount of supplies.", 200, 200),
    WagonMedium("WagonMedium", "Medium wagon that can carry an average amount of supplies.", 400, 400),
    WagonLarge("WagonLarge", "Large wagon that can carry a maximum amount of supplies.", 600, 600),
    Food("Food", "Delicious consumables for nourishment. Comes in 5 lb increments", 5, 1),
    Ammo("Ammo", "Bullets for hunting or protection. Comes in boxes of 20 bullets.", 5, 2),
    Wheel("Wheel", "Spare wheels, just in case.", 40, 10);
   
    private final String name;
    private final String description;
    private final int weight;
    private final int cost;

    Item(String name, String description, int weight, int cost) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.cost = cost;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }
    
    public int getCost() {
        return cost;
    }
    
    

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", description=" + description + ", weight=" + weight + ", cost=" + cost + '}';
    }
    
}
