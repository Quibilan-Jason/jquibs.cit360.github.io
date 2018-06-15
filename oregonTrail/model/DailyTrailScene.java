/*
 
 */
package byui.cit260.oregonTrail.model;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author J.R. Basham
 */
public class DailyTrailScene extends Scene implements Serializable {
    
    private Boolean currentPlantPresence;
    private Boolean currentAnimalPresence;
    private Boolean currentHazards;
    private String currentDate;
    private String currentWeather; 
    private Location currentLocation;
    private Scene scene;
    
    public DailyTrailScene() {
    
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Boolean getCurrentPlantPresence() {
        return currentPlantPresence;
    }

    public void setCurrentPlantPresence(Boolean currentPlantPresence) {
        this.currentPlantPresence = currentPlantPresence;
    }

    public Boolean getCurrentAnimalPresence() {
        return currentAnimalPresence;
    }

    public void setCurrentAnimalPresence(Boolean currentAnimalPresence) {
        this.currentAnimalPresence = currentAnimalPresence;
    }

    public Boolean getCurrentHazards() {
        return currentHazards;
    }

    public void setCurrentHazards(Boolean currentHazards) {
        this.currentHazards = currentHazards;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(String currentWeather) {
        this.currentWeather = currentWeather;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.currentPlantPresence);
        hash = 67 * hash + Objects.hashCode(this.currentAnimalPresence);
        hash = 67 * hash + Objects.hashCode(this.currentHazards);
        hash = 67 * hash + Objects.hashCode(this.currentDate);
        hash = 67 * hash + Objects.hashCode(this.currentWeather);
        hash = 67 * hash + Objects.hashCode(this.currentLocation);
        hash = 67 * hash + Objects.hashCode(this.scene);
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
        final DailyTrailScene other = (DailyTrailScene) obj;
        if (!Objects.equals(this.currentDate, other.currentDate)) {
            return false;
        }
        if (!Objects.equals(this.currentWeather, other.currentWeather)) {
            return false;
        }
        if (!Objects.equals(this.currentPlantPresence, other.currentPlantPresence)) {
            return false;
        }
        if (!Objects.equals(this.currentAnimalPresence, other.currentAnimalPresence)) {
            return false;
        }
        if (!Objects.equals(this.currentHazards, other.currentHazards)) {
            return false;
        }
        if (!Objects.equals(this.currentLocation, other.currentLocation)) {
            return false;
        }
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DailyTrailScene{" + "currentPlantPresence=" + currentPlantPresence + ", currentAnimalPresence=" + currentAnimalPresence + ", currentHazards=" + currentHazards + ", currentDate=" + currentDate + ", currentWeather=" + currentWeather + ", currentLocation=" + currentLocation + ", scene=" + scene + '}';
    }

    

    
    
}
