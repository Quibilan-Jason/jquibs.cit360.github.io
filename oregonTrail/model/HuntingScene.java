/*

 */
package byui.cit260.oregonTrail.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.ArrayList;
/**
 *
 * @author J.R. Basham
 */
public class HuntingScene extends Scene implements Serializable{
    private Scene scene;
    private int wildLifeAmount;
    private ArrayList<Item> item;
    
    public HuntingScene () {
    
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public int getWildLifeAmount() {
        return wildLifeAmount;
    }

    public void setWildLifeAmount(int wildLifeAmount) {
        this.wildLifeAmount = wildLifeAmount;
    }

    public ArrayList<Item> getItem() {
        return item;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.scene);
        hash = 17 * hash + this.wildLifeAmount;
        hash = 17 * hash + Objects.hashCode(this.item);
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
        final HuntingScene other = (HuntingScene) obj;
        if (this.wildLifeAmount != other.wildLifeAmount) {
            return false;
        }
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HuntingScene{" + "scene=" + scene + ", wildLifeAmount=" + wildLifeAmount + ", item=" + item + '}';
    }

    
}
