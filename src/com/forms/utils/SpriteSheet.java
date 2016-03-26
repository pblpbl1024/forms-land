package com.forms.utils;

import java.awt.image.BufferedImage;

/**
 *
 * @author Bill Gan
 */
public class SpriteSheet {
    
    private BufferedImage image;
    private int width;
    private int height;
    
    public SpriteSheet(BufferedImage image, int size){
        this.image = image;
        this.width = size;
        this.height = size;
    }
    
    public SpriteSheet(BufferedImage image, int width, int height){
        this.image = image;
        this.width = width;
        this.height = height;
    }
    
    public BufferedImage getSprite(int col, int row){
        return image.getSubimage((col * width) - width, (row * height) - height, width, height);
    }
    
}
