import edu.duke.*;
import java.io.*;
/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrayScaleConverter {
    
    public ImageResource makeGray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            
            int avg = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;
            pixel.setRed(avg);
            pixel.setGreen(avg);
            pixel.setBlue(avg);
        }
        return outImage;
    }
    
    public ImageResource makeInverted(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            
            pixel.setRed(255 - inPixel.getRed());
            pixel.setBlue(255 - inPixel.getBlue());
            pixel.setGreen(255 - inPixel.getGreen());
        }
        return outImage;
    }
    
    public void testImagesGray(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            ImageResource ir = new ImageResource(f);
            /*ImageResource grayIR = makeGray(ir);
            String fname = ir.getFileName();
            String newName = "grayVersion-" + fname;
            grayIR.setFileName(newName);
            grayIR.save();*/
            
            ImageResource invertedIR = makeInverted(ir);
            String fname = ir.getFileName();
            String newName = "inverted-" + fname;
            invertedIR.setFileName(newName);
            invertedIR.save();
        }
    }
}
