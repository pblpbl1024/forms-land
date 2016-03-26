package com.forms.libs;

import com.forms.Game;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Bill Gan
 */
public class Reference {
    
    static {
        Properties prop = new Properties();
        InputStream stream = Reference.class.getClassLoader().getResourceAsStream("version.properties");
        
        try{
            prop.load(stream);
            stream.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        VERSION = prop.getProperty("version");
    }
    
    /**
     * The horizontal center of the window
     */
    public static final int CENTER_X = Game.WIDTH / 2;
    /**
     * The vertical center of the window
     */
    public static final int CENTER_Y = Game.HEIGHT / 2;
    /**
     * The base location of the resources folder
     */
    public static final String RESOURCE_LOCATION = "./resources/";
    /**
     * The base location of the sprites folder
     */
    public static final String SPRITE_LOCATION = RESOURCE_LOCATION + "sprites/";
    /**
     * The base location of the fonts folder
     */
    public static final String FONT_LOCATION = RESOURCE_LOCATION + "fonts/";
    /**
     * The base location of the sounds folder
     */
    public static final String SOUND_LOCATION = RESOURCE_LOCATION + "sounds/";
    
    public static final int ALPHA_RGB = BufferedImage.TYPE_INT_ARGB;
    
    public static final String VERSION;
    
}
