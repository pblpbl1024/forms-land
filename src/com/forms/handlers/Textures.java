package com.forms.handlers;

import com.forms.libs.Images;
import com.forms.utils.SpriteSheet;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bill Gan
 */
public class Textures {
    private SpriteSheet sheetGrass;
    private SpriteSheet p1rightsheet;
    private SpriteSheet p1leftsheet;
    private SpriteSheet sheetMetal;
    
    //public BufferedImage player1;
    public BufferedImage p1standingright;
    public BufferedImage p1standingleft;
    
    public BufferedImage player1right[] = new BufferedImage[4];
    public BufferedImage player1left[] = new BufferedImage[4];
    
    /*
    Game object images
    */
    public BufferedImage blockgrass;
    public BufferedImage blockgrassLeft;
    public BufferedImage blockgrassMid;
    public BufferedImage blockgrassRight;
    public BufferedImage blockgrassUnCurved;
    public BufferedImage blockdirt;
    
    public BufferedImage blockmetal;
    public BufferedImage blockmetalUnCurved;
    
    public Textures(){
        sheetGrass = new SpriteSheet(Images.spritesheetGrass, 70);
        p1rightsheet = new SpriteSheet(Images.spritesheetp1, 66, 92);
        p1leftsheet = new SpriteSheet(Images.spritesheetp1inverted, 66, 92);
        sheetMetal = new SpriteSheet(Images.spritesheetMetal, 70, 70);
        
        initTextures();
    }
    
    private void initTextures(){
        blockgrass = sheetGrass.getSprite(5, 6);
        blockgrassLeft = sheetGrass.getSprite(5, 5);
        blockgrassMid = sheetGrass.getSprite(5, 4);
        blockgrassRight = sheetGrass.getSprite(5, 3);
        blockgrassUnCurved = sheetGrass.getSprite(5, 4);
        blockdirt = sheetGrass.getSprite(1, 6);
        
        blockmetal = sheetMetal.getSprite(3, 6);
        blockmetalUnCurved = sheetMetal.getSprite(1, 1);
        
        p1standingright = p1rightsheet.getSprite(1, 1);
        p1standingleft = p1leftsheet.getSprite(3, 1);
        
        player1right[0] = p1rightsheet.getSprite(2, 1);
        player1right[1] = p1rightsheet.getSprite(3, 1);
        player1right[2] = p1rightsheet.getSprite(1, 2);
        player1right[3] = p1rightsheet.getSprite(2, 2);
        
        player1left[0] = p1leftsheet.getSprite(2, 1);
        player1left[1] = p1leftsheet.getSprite(1, 1);
        player1left[2] = p1leftsheet.getSprite(3, 2);
        player1left[3] = p1leftsheet.getSprite(2, 2);
        
    }
    
}
