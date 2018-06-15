/*
 * Copyright (C) 2017 Brett Starks
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

/**
 *
 * @author Brett Starks
 */
public enum Weather {
    
    Sunny("Sunny", "Not a cloud in the sky. This should be a good day for travel."),
    Rain("Rain", "There's a light rain that is causing a bit of mud on the trail. The distance we travel today will be affected a little."),
    Rainstorm("Rainstorm", "It\'s raining somethin' fierce. The distance we travel today will be greatly affected."),
    Snow("Snow", "It\'s cold! A light frost has covered the trail. The distance we travel today will be affected a little."),
    Blizzard("Blizzard", "There is so much snow that our nostrils are frozen shut. The distance we travel today will be greatly affected."),
    Fog("Fog", "There is a heavy fog over the trail. The distance we travel today will be affected a little.");
    
    private final String name;
    private final String desc;

    Weather(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName(){
        return name;
    }

    public String getDesc(){
        return desc;
    }
    
}
