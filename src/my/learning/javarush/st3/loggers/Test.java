package my.learning.javarush.st3.loggers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    public void check(String srt){
        try{
        logger.debug(srt+" передана");}
        catch (Exception e){
            logger.error("Error");
        }

    }

}
