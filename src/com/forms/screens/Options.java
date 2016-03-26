package com.forms.screens;

import com.forms.libs.Images;
import com.forms.libs.Reference;
import com.forms.utils.Button;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Bill Gan
 */
public class Options {
    
    public Button back;
    public Button showfps;
    public Button showhitbox;
    
    public Options(){
        
        int fillerY = 250;
        
        back = new Button(50, 112, 200, 50).setText("Back");
        showfps = new Button(200, fillerY, 250, 50).setText("Show FPS");
        showhitbox = new Button(200, fillerY += 60, 250, 50).setText("Hitboxes: OFF");
        
    }
    
    public void drawButton(Graphics g, Rectangle rect, String text, int offset){
        Font foo = new Font("Foo", Font.PLAIN, 32);
        g.setFont(foo);
        
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
        g.drawString(text, rect.x + offset, rect.y + 38);
    }
    
    public void render(Graphics g){
        g.drawImage(Images.menu_background, 0, 0, null);
        g.drawImage(Images.options, 340, 80, null);
        
        Font foo = new Font("Foo", Font.PLAIN, 32);
        g.setFont(foo);

        back.drawButton(g, 67);
        showfps.drawButton(g, 48);
        showhitbox.drawButton(g, 6);
    }

}
