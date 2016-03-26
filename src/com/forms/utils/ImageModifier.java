package com.forms.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bill Gan
 */
public class ImageModifier {
    
    public static BufferedImage resizeImage(BufferedImage originalImage, int type, float x, float y, int initialWidth, int initialHeight, double scale){
        initialWidth *= scale;
        initialHeight *= scale;
        BufferedImage resizedImage = new BufferedImage(initialWidth, initialHeight, type);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, (int)x, (int) y, initialWidth, initialHeight, null);
        g2d.dispose();
        return resizedImage;
    }

}
