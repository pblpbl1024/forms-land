package com.forms.input;

import com.forms.Game;
import com.forms.core.CoreObject;
import com.forms.entity.Player;
import com.forms.enums.Direction;
import com.forms.libs.Audio;
import com.forms.libs.Identities;
import com.forms.utils.AudioPlayer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 *
 * @author Bill Gan
 */
public class KeyInput extends KeyAdapter {
    
    private Player player;
    
    private boolean[] keyDown = new boolean[2];
    
    public KeyInput(){
        for(CoreObject obj : Game.getInstance().getController().getObjects()){
            if(obj.getId() == Identities.PLAYER)
                player = (Player) obj;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch(Game.state){
            case MENU:
                break;
            case GAME:
                // set player jumping power
                if(key == KeyEvent.VK_I && !player.isJumping()){
                    AudioPlayer.playSound(Audio.SOUND_JUMP);
                    player.setVelY(-20);
                    player.setJumping(true);
                }
                if(key == KeyEvent.VK_A){
                    player.setVelX(-8);
                    player.setMoving(true);
                    player.setDirection(Direction.LEFT);
                    keyDown[0] = true;
                }
                if(key == KeyEvent.VK_D){
                    player.setVelX(8);
                    player.setMoving(true);
                    player.setDirection(Direction.RIGHT);
                    keyDown[1] = true;
                }
                break;
            case OPTIONS:
                break;
            case PAUSE:
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch(Game.state){
            case MENU:
                break;
            case GAME:
                if(key == KeyEvent.VK_A){
                    keyDown[0] = false;
                    player.setMoving(false);
                }
                if(key == KeyEvent.VK_D){
                    keyDown[1] = false;
                    player.setMoving(false);
                }
                
                if(keyDown[0] && !keyDown[1])
                    player.setVelX(-5);
                if(!keyDown[0] && keyDown[1])
                    player.setVelX(5);
                if(!keyDown[0] && !keyDown[1]){
                    player.setVelX(0);
                }
                break;
            case OPTIONS:
                break;
            case PAUSE:
                break;
            default:
                break;
        }
    }
    
}
