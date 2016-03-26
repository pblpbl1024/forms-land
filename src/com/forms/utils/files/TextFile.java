package com.forms.utils.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Bill Gan
 */
public class TextFile {
    
    private static String line;
    
    public static String readFile(String path){
        BufferedReader file;
        try{
            file = new BufferedReader(new FileReader(path));
        } catch(IOException e){
            e.printStackTrace();
        }
        
        return line;
    }
    
    public static void writeFile(String path, String text){
        try{
            FileWriter file = new FileWriter(path);
            file.write(text);
            file.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
