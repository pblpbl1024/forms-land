package com.forms.utils;

import com.forms.input.MouseInput;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


/**
 *
 * @author Bill Gan
 */
public class Button extends Rectangle {
    
    private String text;
    private static boolean toggled = false;
    
    public Button(int x, int y, int width, int height){
        super(x, y, width, height);
    }
    
    public Button setText(String text){
        this.text = text;
        return this;
    }
    
    public void drawButton(Graphics g, int offset){
        int xx = x + offset;
        int yy = y + 38;
        if(MouseInput.MOUSE.intersects(this) && MouseInput.MOUSE != null){
            g.setColor(new Color(255, 165, 0));
        } else
            g.setColor(Color.BLACK);
        
        if(!MouseInput.pressed && MouseInput.MOUSE.intersects(this))
            g.drawRect(x, y, width, height);
        else if(MouseInput.pressed && MouseInput.MOUSE.intersects(this))
            g.fillRect(x, y, width, height);
        else
            g.drawRect(x, y, width, height);
        
        g.setColor(Color.BLACK);
        g.drawString(text, xx, yy);
    }
    
    public void toggle(){
        if(!toggled)
            toggled = true;
        else
            toggled = false;
    }
    
    public boolean isToggled(){
        return toggled;
    }
    
}
