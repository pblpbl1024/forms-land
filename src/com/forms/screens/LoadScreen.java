package com.forms.screens;

import com.forms.Game;
import com.forms.libs.Images;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Bill Gan
 */
public class LoadScreen {
    
    private static int width = 540;
    private static int numResources = 10;
    private static int loadAdd = width / numResources;
    private static int loadStatus = 0;
    
    private static String msg = "Loading Sprites...";
    
    public static void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.drawImage(Images.loading_background, 0, 0, null);
        g.setColor(Color.black);
        g.drawRect(49, 399, width, 51); // draws the outline of the bar
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString(msg, 51, 395);
        g.setColor(new Color(176, 226, 255));
        g.fillRect(50, 400, loadStatus, 50); // fills in the bar as the resources are loaded
    }
    
    public static void loadMore(){
        loadStatus += loadAdd;
    }
    
    public static void setMessage(String msg){
        LoadScreen.msg = msg;
    }

}
