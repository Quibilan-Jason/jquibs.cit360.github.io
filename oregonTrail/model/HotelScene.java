/*

 */
package byui.cit260.oregonTrail.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author J.R. Basham
 */
public class HotelScene extends Scene implements Serializable{
    private Scene scene;
    private ArrayList<Character> character;
    private TownScene townScene;
    public HotelScene () {
    
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ArrayList<Character> getCharacter() {
        return character;
    }

    public void setCharacter(ArrayList<Character> character) {
        this.character = character;
    }

    public TownScene getTownScene() {
        return townScene;
    }

    public void setTownScene(TownScene townScene) {
        this.townScene = townScene;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.scene);
        hash = 47 * hash + Objects.hashCode(this.character);
        hash = 47 * hash + Objects.hashCode(this.townScene);
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
        final HotelScene other = (HotelScene) obj;
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        if (!Objects.equals(this.character, other.character)) {
            return false;
        }
        if (!Objects.equals(this.townScene, other.townScene)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HotelScene{" + "scene=" + scene + ", character=" + character + ", townScene=" + townScene + '}';
    }

    
}
