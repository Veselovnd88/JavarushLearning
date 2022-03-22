package my.dukeuniversity.shapes.csv;
import edu.duke.*;

import java.io.File;

public class ImageTask {
    public static void task(){
        //testGray();
        //selectAndConvert();

    }

    public static ImageResource makeGray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());

        for (Pixel pixel: outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getRed()+ inPixel.getGreen()+ inPixel.getBlue())/3;
            pixel.setRed(average);
            pixel.setBlue(average);
            pixel.setGreen(average);
        } return outImage;
    }

    public static void selectAndConvert(){
        System.out.println("Select and convert started");
        DirectoryResource dr = new DirectoryResource();
        for (File f:dr.selectedFiles()){
            ImageResource ir = new ImageResource(f);
           ImageResource outIr =  makeGray(ir);
           outIr.draw();

        }
    }


















    public static void testGray() {
        System.out.println("test task Make Gray");
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }


}
