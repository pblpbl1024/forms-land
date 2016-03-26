package com.forms.input;

import com.forms.Game;
import com.forms.enums.GameState;
import com.forms.libs.Audio;
import com.forms.screens.Menu;
import com.forms.screens.Options;
import com.forms.utils.AudioPlayer;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Bill Gan
 */
public class MouseInput extends MouseAdapter {
    
    public static boolean pressed = false;
    
    public static int MOUSE_X, MOUSE_Y;
    public static Rectangle MOUSE = new Rectangle(1, 1, 1, 1);
    
    private Menu menu = Game.getInstance().getMenu();
    private Options options = Game.getInstance().getOptions();

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouse = e.getButton();
        Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);
        
        if(mouse == MouseEvent.BUTTON1){
            
            switch(Game.state){
                case MENU:
                    if(rect.intersects(menu.play)){
                        AudioPlayer.playSound(Audio.SOUND_LASER, 1f, 4f);
                        Game.getInstance().levelOne.loadLevel();
                        Game.state = GameState.GAME;
                    } else if(rect.intersects(menu.options)){
                        AudioPlayer.playSound(Audio.SOUND_LASER, 1f, 4f);
                        Game.state = GameState.OPTIONS;
                    }
                    break;
                case GAME:
                    break;
                case OPTIONS:
                    if(rect.intersects(options.back)){
                        AudioPlayer.playSound(Audio.SOUND_LASER, 1f, 4f);
                        Game.state = GameState.MENU;
                    } else if(rect.intersects(options.showfps)){
                        AudioPlayer.playSound(Audio.SOUND_LASER, 1f, 4f);
                        options.showfps.toggle();
                        if(options.showfps.isToggled())
                            options.showfps.setText("Hide FPS");
                        else
                            options.showfps.setText("Show FPS");
                    }
                    break;
                case PAUSE:
                    break;
                default:
                    break;
                    
            }
        } 
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = true;
        MOUSE = new Rectangle(e.getX(), e.getY(), 1, 1);
        if(Game.state == GameState.MENU){
            if(MOUSE.intersects(menu.quit)){
                AudioPlayer.playSound(Audio.SOUND_LASER, 1f, 4f);
            }
        }
        
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        pressed = false;
        MOUSE = new Rectangle(e.getX(), e.getY(), 1, 1);
        if(Game.state == GameState.MENU){
            if(MOUSE.intersects(menu.quit)){
                Game.exit();
            }
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        MOUSE_X = e.getX();
        MOUSE_Y = e.getY();
        
        MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
        
        switch(Game.state){
            case GAME:
                break;
            case MENU:
                if ((MOUSE.intersects(menu.play)
                        || MOUSE.intersects(menu.options)
                        || MOUSE.intersects(menu.quit))
                        && !AudioPlayer.hasPlayedHover) {
                    
                    AudioPlayer.playSound(Audio.SOUND_CLICK, 1f, 1.2f);
                    AudioPlayer.hasPlayedHover = true;
                    
                }else if(!(MOUSE.intersects(menu.play)
                        || MOUSE.intersects(menu.options)
                        || MOUSE.intersects(menu.quit))
                        && AudioPlayer.hasPlayedHover){
                    
                    AudioPlayer.hasPlayedHover = false;
                }
                break;
            case OPTIONS:
                if((MOUSE.intersects(options.back)
                        || MOUSE.intersects(options.showfps)
                        || MOUSE.intersects(options.showhitbox))
                        && !AudioPlayer.hasPlayedHover) {
                    
                    AudioPlayer.playSound(Audio.SOUND_CLICK, 1f, 1.2f);
                    AudioPlayer.hasPlayedHover = true;
                    
                }else if(!(MOUSE.intersects(options.back)
                        || MOUSE.intersects(options.showfps)
                        || MOUSE.intersects(options.showhitbox))
                    && AudioPlayer.hasPlayedHover){
                    
                    AudioPlayer.hasPlayedHover = false;
                }
                break;
            case PAUSE:
                break;
        }
    }
    
}      
