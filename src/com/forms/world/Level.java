package com.forms.world;

import com.forms.handlers.Controller;
import com.forms.Game;
import com.forms.core.CoreObject;
import com.forms.entity.Player;
import com.forms.handlers.Textures;
import com.forms.libs.Identities;
import com.forms.libs.Images;
import com.forms.objects.Block;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bill Gan
 */
public class Level {
    
    private BufferedImage image;
    private Controller controller = Game.getInstance().getController();
    private Textures tex = Game.getInstance().getTextureHandler();
    
    public Level(int levelNumber){
        switch(levelNumber){
            case 1:
                image = Images.levelOne;
                break;
            default:
                break;
        }
    }
    
    public void loadLevel(){
        int w = image.getWidth();
        int h = image.getHeight();
        
        for(int x = 0; x < w; x++){
            for(int y = 0; y < h; y++){
                int pixel = image.getRGB(x, y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                
                if(red == 255 && green == 255 && blue == 0)
                    addPlayer((float)x, (float)y, red, green, blue);
                    //controller.addObject(new Player(x * 70, y * 70, Identities.PLAYER, tex));
                else if(red == 255 && green == 255 && blue == 255){
                    addBlock(x, y, Identities.BLOCK_GRASS_UNCURVED, tex.blockgrassUnCurved);
                }
                else {
                    if(red == 76 && green == 255 && blue == 0)
                        addBlock(x, y, Identities.BLOCK_GRASS_LEFT, tex.blockgrassLeft);
                    if(red == 0 && green == 38 && blue == 255)
                        addBlock(x, y, Identities.BLOCK_GRASS_RIGHT, tex.blockgrassRight);
                    if(red == 0 && green == 255 && blue == 255)
                        addBlock(x, y, Identities.BLOCK_GRASS, tex.blockgrass);
                    if(red == 255 && green == 0 && blue == 0)
                        addBlock(x, y, Identities.BLOCK_METAL, tex.blockmetal);
                }
            }
        }
    }
    
    private void addBlock(int x, int y, int id, BufferedImage texture){
        controller.addObject(new Block(x * 70, y * 70, id, texture));
    }
    
    private void addPlayer(float x, float y, int red, int green, int blue){
        Player player = null;
        for(CoreObject obj : controller.getObjects())
            if(obj.getId() == Identities.PLAYER)
                player = (Player) obj;
            player.setX(x * 70);
            player.setY(y * 70);
    }
    
}
