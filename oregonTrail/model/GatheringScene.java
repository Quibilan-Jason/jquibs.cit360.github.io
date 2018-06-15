/*

 */
package byui.cit260.oregonTrail.model;
import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author J.R. Basham
 */
public class GatheringScene extends Scene implements Serializable{
    private Scene scene;
    private int plantLifeAmount;

    public GatheringScene() {
        
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public int getPlantLifeAmount() {
        return plantLifeAmount;
    }

    public void setPlantLifeAmount(int plantLifeAmount) {
        this.plantLifeAmount = plantLifeAmount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.scene);
        hash = 17 * hash + this.plantLifeAmount;
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
        final GatheringScene other = (GatheringScene) obj;
        if (this.plantLifeAmount != other.plantLifeAmount) {
            return false;
        }
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GatheringScene{" + "scene=" + scene + ", plantLifeAmount=" + plantLifeAmount + '}';
    }

   
   
}
