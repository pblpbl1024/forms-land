package com.forms.utils.files;

import com.forms.libs.Reference;
import com.forms.screens.LoadScreen;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Bill Gan
 */
public class BufferedImageLoader {
    
    private BufferedImage image;
    
    public BufferedImage loadImage(String imagePath) throws IOException{
        //LoadScreen.setMessage("Loading textures from " + Reference.SPRITE_LOCATION);
        //System.out.println(imagePath);
        image = ImageIO.read(new File(Reference.SPRITE_LOCATION + imagePath));
        return image;
    }
    
}
