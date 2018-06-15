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
package byui.cit260.oregonTrail.control;

import byui.cit260.oregonTrail.model.Weather;
import java.util.Random;

/**
 *
 * @author Brett Starks
 */
public class WeatherControl {
    
    public WeatherControl() {
        
    }
    
    static Weather generateWeather() {
        
        Weather currentWeather;
        Random rand = new Random();
        int x = rand.nextInt(10);
        
        if(x > 8){
            currentWeather = Weather.Rain;
        } else if(x == 7){
            currentWeather = Weather.Rainstorm;
        } else if(x == 6){
            currentWeather = Weather.Fog;
        } else if(x == 5){ 
            currentWeather = Weather.Snow;
        } else {
            currentWeather = Weather.Sunny;
        }
        
        return currentWeather;
    }
    
}
