package com.forms.gfx;

import com.forms.Game;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Bill Gan
 */
public class Renderer {
    
    public void renderBackground(Graphics g){
        switch(Game.state){
            case MENU:
                Game.getInstance().getMenu().render(g);
                break;
            case GAME:
                break;
            case OPTIONS:
                Game.getInstance().getOptions().render(g);
                break;
            case PAUSE:
                break;
            case LOADING:
                break;
            default:
                g.setColor(Color.RED);
                g.drawString("UNKNOWN GAMESTATE", 150, 150);
                break;
            
        }
    }
    
    public void renderForeground(Graphics g){
        switch(Game.state){
            case MENU:
                break;
            case GAME:
                Game.getInstance().getController().render(g);
                break;
            case OPTIONS:
                break;
            case PAUSE:
                break;
            case LOADING:
                break;
            default:
                g.setColor(Color.RED);
                g.drawString("UNKNOWN GAMESTATE", 150, 150);
                break;   
        }
    }
    
}  

