package com.forms.utils;

import com.forms.utils.files.BufferedImageLoader;
import com.forms.libs.Audio;
import com.forms.libs.Images;
import java.io.IOException;

/**
 *
 * @author Bill Gan
 */
public class ResourceLoader {
    
    private static BufferedImageLoader imageLoader = new BufferedImageLoader();
    
    public static void preLoad(){
        try{
            Images.loading_background = imageLoader.loadImage("loading.png");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void loadImages(){
        
        try{
            Images.title = imageLoader.loadImage("title.png");
            Images.options = imageLoader.loadImage("options.png");
            Images.menu_background = imageLoader.loadImage("menu_background.png");
            Images.spritesheetGrass = imageLoader.loadImage("grass_sheet.png");
            Images.spritesheetp1 = imageLoader.loadImage("p1_spritesheet.png");
            Images.spritesheetp1inverted = imageLoader.loadImage("p1_spritesheet_inverted.png");
            Images.spritesheetMetal = imageLoader.loadImage("metal_sheet.png");
            
            Images.levelOne = imageLoader.loadImage("levels/level1.png");
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public static void loadFonts(){
        Fonts.addFont(new Fonts("FOO.ttf"));
    }
    
    public static void loadSounds(){
        AudioPlayer.addSound(Audio.SOUND_LASER, "Laser.ogg");
        AudioPlayer.addSound(Audio.SOUND_CLICK, "click.ogg");
        AudioPlayer.addSound(Audio.SOUND_JUMP, "jump.ogg");
        
        AudioPlayer.addMusic(Audio.MUSIC_BOBBER_LOOP, "bobber_loop.ogg");
        AudioPlayer.addMusic(Audio.MUSIC_MENU_LOOP, "menu_loop.ogg");
        AudioPlayer.addMusic(Audio.MUSIC_NEW_SPACE_STATION, "new_space_station.ogg");
    }
    
}
