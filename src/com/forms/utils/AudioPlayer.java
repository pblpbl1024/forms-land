package com.forms.utils;

import com.forms.libs.Reference;
import com.forms.screens.LoadScreen;
import java.util.HashMap;
import java.util.Map;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 *
 * @author Bill Gan
 */
public class AudioPlayer {
    
    private static Map<String, Sound> soundMap = new HashMap<String, Sound>();
    
    private static Map<String, Music> musicMap = new HashMap<String, Music>();
    
    public static boolean hasPlayedHover = false;
    
    public static void addSound(String key, String path){
        //LoadScreen.setMessage("Loading sounds from " + Reference.SOUND_LOCATION);
        try {
            soundMap.put(key, new Sound(Reference.SOUND_LOCATION + path));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
    
    public static void addMusic(String key, String path){
        //LoadScreen.setMessage("Loading music from " + Reference.SOUND_LOCATION);
        try {
            musicMap.put(key, new Music(Reference.SOUND_LOCATION + path));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
    
    public static Sound getSound(String key){
        return soundMap.get(key);
    }
    
    public static Music getMusic(String key){
        return musicMap.get(key);
    }
    
    public static void playSound(String key){
        soundMap.get(key).play(1f, 0.4f);
    }
    
    public static void playSound(String key, float pitch, float volume){
        soundMap.get(key).play(pitch, volume);
    }
    
    public static void playMusic(String key){
        musicMap.get(key).loop(1f, 0.2f);
    }
    
    public static void playMusic(String key, float pitch, float volume){
        musicMap.get(key).loop(pitch, volume);
    }
    
}
