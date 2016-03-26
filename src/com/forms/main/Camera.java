package com.forms.main;

import com.forms.Game;
import com.forms.core.CoreObject;
import com.forms.entity.Player;
import com.forms.libs.Identities;

/**
 *
 * @author Bill Gan
 */
public class Camera {
    
    private float x, y;
    private Player player;
    
    public Camera(float x, float y){
        this.x = x;
        this.y = y;
        for(CoreObject obj : Game.getInstance().getController().getObjects())
            if(obj.getId() == Identities.PLAYER)
                player = (Player) obj;
    }
    
    public void tick(){
        x += ((-player.getX() + Game.WIDTH / 2) - x) * 0.0275f;
    }
    
    public float getX(){
        return x;
    }
    
    public float getY(){
        return y;
    }

}
