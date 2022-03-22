package my.dukeuniversity.shapes.csv;
import edu.duke.*;

import java.io.File;

public class BatchInversions {
    public static void task(){
        selectAndInverse();
    }

    public static ImageResource makeInvert(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());

        for (Pixel pixel: outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            pixel.setRed(255-inPixel.getRed());
            pixel.setBlue(255 - inPixel.getBlue());
            pixel.setGreen(255 - inPixel.getGreen());
        } return outImage;
    }


    public static void selectAndInverse(){
        System.out.println("Select and inverse task started");
        DirectoryResource dr = new DirectoryResource();
        for (File f :dr.selectedFiles()){

            ImageResource inIr = new ImageResource(f);
            String fname = inIr.getFileName();
            String nname = "inverted-"+ fname;
            ImageResource out = makeInvert(inIr);
            out.setFileName(nname);
            out.draw();
            out.save();
        }
    }

}
