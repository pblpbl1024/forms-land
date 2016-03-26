package com.forms.objects;

import com.forms.core.CoreObject;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bill Gan
 */
public class Block extends CoreObject{
    
    public Block(float x, float y, int id, BufferedImage image){
        super(x, y, id, image);
        this.image = image;
        this.setSize(70, 70);
    }
    
    @Override
    public void tick(){
        
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(image, (int) x, (int) y, null);
        super.render(g);
    }
    
}
