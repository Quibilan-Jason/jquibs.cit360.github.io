/*
 * Copyright (C) 2017 J.R. Basham
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
package byui.cit260.oregonTrail.view;

import java.io.PrintWriter;
import oregontrail.OregonTrail;

/**
 *
 * @author J.R. Basham
 */
public class ErrorView {
    
    // Create a class variable for the errorFile and assign to outFile
    private static final PrintWriter errorFile = OregonTrail.getOutFile();
    private static final PrintWriter logFile = OregonTrail.getLogFile();
    
    // Create a function to display error message
    public static void display(String className, String errorMessage) {
	errorFile.println(
		"---------------------------------------------"
	      + "\n- ERROR - " + errorMessage
              + "\n-------------------------------------------");
        // log error
        logFile.println(className + " - " + errorMessage);
        logFile.flush();
    }
}
