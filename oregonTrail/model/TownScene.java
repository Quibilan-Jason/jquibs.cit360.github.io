/*

 */
package byui.cit260.oregonTrail.model;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author J.R. Basham
 */
public class TownScene extends Scene implements Serializable{
    private Scene scene;
    private HotelScene hotelScene;
    private StoreScene storeScene;
    
    public TownScene (){
    
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public HotelScene getHotelScene() {
        return hotelScene;
    }

    public void setHotelScene(HotelScene hotelScene) {
        this.hotelScene = hotelScene;
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
        hash = 83 * hash + Objects.hashCode(this.scene);
        hash = 83 * hash + Objects.hashCode(this.hotelScene);
        hash = 83 * hash + Objects.hashCode(this.storeScene);
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
        final TownScene other = (TownScene) obj;
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        if (!Objects.equals(this.hotelScene, other.hotelScene)) {
            return false;
        }
        if (!Objects.equals(this.storeScene, other.storeScene)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TownScene{" + "scene=" + scene + ", hotelScene=" + hotelScene + ", storeScene=" + storeScene + '}';
    }

   
    
}
