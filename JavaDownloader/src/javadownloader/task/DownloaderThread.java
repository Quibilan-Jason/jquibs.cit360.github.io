/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javadownloader.task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author jgqui
 */
public class DownloaderThread extends Thread {
    
    private static final int TIMEOUT = 5000;
    private static final int BLOCK_SIZE = 1024;
    
    private DownloadListener listener;
    private String url;
    
    public DownloaderThread(DownloadListener listener, String url) {
        this.listener = listener;
        this.url = url;
    }
    
     @Override
    public void run() {
        
        try {            
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setReadTimeout(TIMEOUT);
            connection.connect();
            
            String fileName = new java.io.File(url).getName();
            
            File fileToSave = new File(fileName);
            
            String filePath = this.listener.showSaveDialog(fileToSave);
            
            if(filePath == null) {
                this.listener.onDownloadFailed("Sorry Brah! you didn't pick proper directory");
                return;
            }
                        
            FileOutputStream out = new FileOutputStream(new File(filePath));
            
            int fileSize = connection.getContentLength();
            
            System.out.println("Brah, File Size = " + fileSize);
            
            double total = 0.0;
            
            this.listener.onDownloadStart();
            
            InputStream input = connection.getInputStream();            
            
            byte buffer[] = new byte[BLOCK_SIZE];
            int length = -1;
            
            while((length = input.read(buffer, 0, BLOCK_SIZE)) != -1) {
                total = total + length;
                out.write(buffer, 0, length);
                this.listener.onDownloadProgress("Bruddah, so far you downloaded " + length, (int) ((total / fileSize) * 100));
            }     
            
            input.close();
            out.close();
            this.listener.onDownloadComplete();
            
        } catch (Exception e) {
            this.listener.onDownloadFailed(e.getMessage());
        }
    }
    
    public interface DownloadListener {
        
        void onDownloadStart();

        void onDownloadProgress(String description, int value);
        
        void onDownloadComplete();
        
        void onDownloadFailed(String errorMsg);

        String showSaveDialog(File fileToSave);
    }    
}
