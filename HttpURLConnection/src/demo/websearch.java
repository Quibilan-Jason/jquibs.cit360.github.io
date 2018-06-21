package demo;

import java.io.*;    
import java.net.*;  

/**
 *
 * @author jgqui
 */

public class websearch {    


    public static void main(String[] args) throws MalformedURLException, IOException {
        
        //creates the object and then stores the data we need to access a web page
        String url = "http://www.google.com/search";
        URL webpage = new URL(url);
        
        //Open the URL connection
        try {
        HttpURLConnection connect = (HttpURLConnection) webpage.openConnection();
        
        //create a new bufferedreader 
        BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
        
        int status = connect.getResponseCode();
        System.out.println("Brah, da response code is: " + status);
        
        //read and print out lines
        String page;              
        while((page = in.readLine()) != null) {
            System.out.println(page);
        }
        
        //close the bufferedreader
        in.close();
        connect.disconnect();
        } catch (MalformedURLException e) {
            System.out.println(url + ": Brah, check if URL is correct.");
        } catch (UnknownHostException e) {
            System.out.println(url + " Brah, no results, no network connection or bad URL path.");
        }
    }
    
}
