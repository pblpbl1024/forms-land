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
public class Menu {
    
    public Button play, options, quit;
    
    public Menu(){
        
        int fillerY = 300;
        
        play = new Button(Reference.CENTER_X - 100, fillerY, 200, 50).setText("Play");
        options = new Button(Reference.CENTER_X - 100, fillerY += 60, 200, 50).setText("Options");
        quit = new Button(Reference.CENTER_X - 100, fillerY += 60, 200, 50).setText("Quit");
    }
    
    public void drawButton(Graphics g, Rectangle rect, String text, int offset){
        Font foo = new Font("Foo", Font.PLAIN, 32);
        g.setFont(foo);
        
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
        g.drawString(text, rect.x + offset, rect.y + 38);
    }
    
    public void render(Graphics g) {
        //render background for menu
        g.drawImage(Images.menu_background, 0, 0, null);
        
        //setting menu background colour
        //g.setColor(new Color(176, 226, 255));
        //g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.drawImage(Images.title, 175, 70, null);
        
        Font foo = new Font("Foo", Font.PLAIN, 32);
        g.setFont(foo);
        
        play.drawButton(g, 67);
        options.drawButton(g, 40);
        quit.drawButton(g, 67);
    }
    
}
