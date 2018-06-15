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
public class StoreScene extends Scene implements Serializable {
    private Scene scene;
    private FortScene fortScene;
    private TownScene townScene;
    private ArrayList<Item> itemList;
    
    
    public StoreScene() {
       
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public FortScene getFortScene() {
        return fortScene;
    }

    public void setFortScene(FortScene fortScene) {
        this.fortScene = fortScene;
    }

    public TownScene getTownScene() {
        return townScene;
    }

    public void setTownScene(TownScene townScene) {
        this.townScene = townScene;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.scene);
        hash = 37 * hash + Objects.hashCode(this.fortScene);
        hash = 37 * hash + Objects.hashCode(this.townScene);
        hash = 37 * hash + Objects.hashCode(this.itemList);
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
        final StoreScene other = (StoreScene) obj;
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        if (!Objects.equals(this.fortScene, other.fortScene)) {
            return false;
        }
        if (!Objects.equals(this.townScene, other.townScene)) {
            return false;
        }
        if (!Objects.equals(this.itemList, other.itemList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StoreScene{" + "scene=" + scene + ", fortScene=" + fortScene + ", townScene=" + townScene + ", itemList=" + itemList + '}';
    }

}