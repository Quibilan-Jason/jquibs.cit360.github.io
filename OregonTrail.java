/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrail;

import byui.cit260.oregonTrail.model.Player;
import byui.cit260.oregonTrail.model.Game;
import byui.cit260.oregonTrail.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;




/**
 *
 * @author J.R. Basham, Jason Quibilan, Brett Starks
 */
public class OregonTrail {
    
    private static Game currentGame = null;
    private static Player player = null;
    //NEW CODE WK12
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        OregonTrail.logFile = logFile;
    }
    
    
    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        OregonTrail.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        OregonTrail.inFile = inFile;
    }
    // END NEW CODE WK12
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        OregonTrail.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        OregonTrail.player = player;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        StartProgramView startProgramView = new StartProgramView();
//        try {
//            startProgramView.display();
//        } catch(Throwable te){
//            System.out.println(te.getMessage());
//            te.printStackTrace();
//            startProgramView.display();
//        }
    
    try {
	// open character stream files for the end user input and output
	OregonTrail.inFile = new BufferedReader(new InputStreamReader(System.in));
	
	OregonTrail.outFile = new PrintWriter(System.out, true);
        
        // open log file
        String filePath = "logfile.txt";
        OregonTrail.logFile = new PrintWriter(filePath);
        
	// create StartProgramView and start the program
	StartProgramView startProgramView = new StartProgramView();
	startProgramView.display();
	return;
	
        } catch (Throwable e) {
	System.out.println("Exception: " + e.toString() +
			   "\nCause: " + e.getCause() +
			   "\nMessage: " + e.getMessage());
	e.printStackTrace();;
        } finally {
        try {
            if (OregonTrail.inFile !=null)
                OregonTrail.inFile.close();
            
            if (OregonTrail.outFile !=null)   
                OregonTrail.outFile.close();
            
            if(OregonTrail.logFile != null)
               OregonTrail.logFile.close();
        } catch (IOException ex) {
            System.out.println("Error closing files");
            return;
        }
	
        }
    
    }
    
}
