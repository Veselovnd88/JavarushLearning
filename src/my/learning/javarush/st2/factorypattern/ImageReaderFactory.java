package my.learning.javarush.st2.factorypattern;

import my.learning.javarush.st2.factorypattern.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes img){
            ImageReader i = null;
            if (img ==ImageTypes.BMP){
                i = new BmpReader();
            }
            else if(img ==ImageTypes.JPG){
                i = new JpgReader();
            }
            else if(img == ImageTypes.PNG){
                i = new PngReader();
            }
            else {throw new IllegalArgumentException();}
            return i;

    }
}
