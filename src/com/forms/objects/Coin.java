package com.forms.objects;

import com.forms.core.CoreObject;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bill Gan
 */
public class Coin extends CoreObject{
    
    public Coin(float x, float y, int id, BufferedImage image){
        super(x, y, id, image);
        this.image = image;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        
    }

}
