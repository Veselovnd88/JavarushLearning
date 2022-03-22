package my.dukeuniversity.shapes.csv;
import edu.duke.*;

import java.io.File;

public class ImageSaver {

    public void doSave(){
        DirectoryResource dr = new DirectoryResource();
        for (File f :dr.selectedFiles()){
            ImageResource inIr = new ImageResource(f);
            String fname = inIr.getFileName();
            String nname = "copy-"+ fname;
            inIr.setFileName(nname);
            inIr.draw();
            inIr.save();
        }
    }

}
