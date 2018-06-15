/*
 * Copyright (C) 2017 jgqui
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
package byui.cit260.oregonTrail.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jgqui
 */
public class Location implements Serializable {
    private int mileMarker;
    private int distanceToOregon;      
    private String name;
    private String sceneType;
    private String desc;
    private Scene scene;
    
    // Constructors
    public Location() {
    }

    public Location(int mileMarker, int distanceToOregon) {
        this.mileMarker = mileMarker;
        this.distanceToOregon = distanceToOregon;
    }

    public Location(int mileMarker, int distanceToOregon, String name, String sceneType, String desc) {
        this.mileMarker = mileMarker;
        this.distanceToOregon = distanceToOregon;
        this.name = name;
        this.sceneType = sceneType;
        this.desc = desc;
    }
    

    // Getters and Setters
    public int getmileMarker() {
        return mileMarker;
    }

    public void setmileMarker(int mileMarker) {
        this.mileMarker = mileMarker;
    }

    public int getDistanceToOregon() {
        return distanceToOregon;
    }

    public void setDistanceToOregon(int distanceToOregon) {
        this.distanceToOregon = distanceToOregon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSceneType() {
        return sceneType;
    }

    public void setsceneType(String sceneType) {
        this.sceneType = sceneType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.mileMarker;
        hash = 71 * hash + this.distanceToOregon;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.sceneType);
        hash = 71 * hash + Objects.hashCode(this.desc);
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
        final Location other = (Location) obj;
        if (this.mileMarker != other.mileMarker) {
            return false;
        }
        if (this.distanceToOregon != other.distanceToOregon) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.sceneType, other.sceneType)) {
            return false;
        }
        if (!Objects.equals(this.desc, other.desc)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "mileMarker=" + mileMarker + ", distanceToOregon=" + distanceToOregon + ", name=" + name + ", sceneType=" + sceneType + ", desc=" + desc + '}';
    }

    
}
