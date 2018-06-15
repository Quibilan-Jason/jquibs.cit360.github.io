/*
 *
 */
package byui.cit260.oregonTrail.model;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author J.R. Basham
 */
public class FortScene extends Scene implements Serializable{
    private Scene scene;
    private StoreScene storeScene;
    
    public FortScene() {
        
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public StoreScene getStoreScene() {
        return storeScene;
    }

    public void setStoreScene(StoreScene storeScene) {
        this.storeScene = storeScene;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.scene);
        hash = 71 * hash + Objects.hashCode(this.storeScene);
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
        final FortScene other = (FortScene) obj;
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        if (!Objects.equals(this.storeScene, other.storeScene)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FortScene{" + "scene=" + scene + ", storeScene=" + storeScene + '}';
    }

  

    
     
}
