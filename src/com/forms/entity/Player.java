package com.forms.entity;

import com.forms.Game;
import com.forms.core.CoreObject;
import com.forms.enums.Direction;
import com.forms.gfx.Animation;
import com.forms.handlers.Textures;
import com.forms.objects.Block;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Bill Gan
 */
public class Player extends CoreObject {
    
    private static ArrayList<CoreObject> gameObjects = Game.getInstance().getController().getObjects();
    
    
    private float gravity = 1.2f;
    
    private boolean falling = true;
    private boolean jumping = false;
    private boolean moving = false;
    
    private Animation animeRight;
    private Animation animeLeft;
    
    private Direction direction = Direction.RIGHT;
    
    public Player(float x, float y, int id, Textures tex){
        super(x, y, id, tex);
        this.setSize(66, 92);
        
        animeRight = new Animation(1, tex.player1right);
        animeLeft = new Animation(1, tex.player1left);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        
        fall();
        checkCollision();
        if(moving){
            if(direction == Direction.RIGHT)
                animeRight.runAnimation();
            else if(direction == Direction.LEFT)
                animeLeft.runAnimation();
        }
    }

    @Override
    public void render(Graphics g) {
        if(!moving){
            if(direction == Direction.RIGHT)
                g.drawImage(tex.p1standingright, (int) x, (int) y, null);
            else if(direction == Direction.LEFT)
                g.drawImage(tex.p1standingleft, (int) x, (int) y, null);
        }
        else {
            if(direction == Direction.RIGHT)
                animeRight.drawAnimation(g, x, y);
            else if(direction == Direction.LEFT)
                animeLeft.drawAnimation(g, x, y);
        }
        super.render(g);
    }
    
    private void checkCollision(){
        
        for(CoreObject obj : gameObjects){
            if(obj instanceof Block){
                if(getBottomBounds().intersects(obj.getTopBounds())){
                    velY = 0;
                    y = obj.getY() - height;
                    jumping = false;
                    falling = false;
                } else
                    falling = true;
                if(getTopBounds().intersects(obj.getBottomBounds())){
                    velY = -velY;
                    //fall();
                    y = obj.getY() + obj.getHeight() + 1;
                }
                if(getRightBounds().intersects(obj.getLeftBounds())){
                    velX = 0;
                    x = obj.getX() - width;
                }
                if(getLeftBounds().intersects(obj.getRightBounds())){
                    velX = 0;
                    x = obj.getX() + obj.getWidth();
                }
            }
        }
        
    }
    
    public void fall(){
        if(falling){
            velY += gravity;
            if(velY >= 50)
                velY = 50;
            //jumping = true;
        }
    }
    
    public boolean isJumping(){
        return jumping;
    }

    public void setJumping(boolean jumping){
        this.jumping = jumping;
    }
    
    public boolean isMoving(){
        return moving;
    }
    
    public void setMoving(boolean moving){
        this.moving = moving;
    }
    
    public void setDirection(Direction direction){
        this.direction = direction;
    }
    
    public Direction getDirection(){
        return direction;
    }
    
}
