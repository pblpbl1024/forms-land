package com.forms.core;

import com.forms.handlers.Textures;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bill Gan
 */
public abstract class CoreObject {
    
    protected float x, y, velX, velY;
    
    protected int id;
    
    protected int width;
    protected int height;
    
    protected Textures tex;
    protected BufferedImage image;
    
    public CoreObject(float x, float y, int id, Textures tex){
        this.x = x;
        this.y = y;
        this.id = id;
        this.tex = tex;
    }
    
    public CoreObject(float x, float y, int id, BufferedImage image){
        this.x = x;
        this.y = y;
        this.id = id;
        this.image = image;
    }
    
    public abstract void tick();
    
    public void render(Graphics g){
        //Debugging collision
        /*
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
        g2d.draw(getTopBounds());
        g2d.draw(getBottomBounds());
        g2d.draw(getRightBounds());
        g2d.draw(getLeftBounds());
        */
    }
    
    public Rectangle getTopBounds(){
        return new Rectangle((int) x, (int) y, width, 12);
    }
    
    public Rectangle getBottomBounds(){
        return new Rectangle((int) x, (int) y + (height - 12), width, 12);
    }
    
    public Rectangle getRightBounds(){
        return new Rectangle((int) x + (width - 6), (int) y, 6, height);
    }
    
    public Rectangle getLeftBounds(){
        return new Rectangle((int) x, (int) y, 6, height);
    }
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public int getId() {
        return id;
    }
    
    public int getWidth(){
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }
    
    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }
    
}
