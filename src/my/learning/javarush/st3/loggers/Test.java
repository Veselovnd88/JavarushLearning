package my.learning.javarush.st3.loggers;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    //файл проперти должен быть в папке src
    // добавил зависимости через Maven
    //org.slf4j:slf4j-log4j12
    //org.slf4j:slf4j-api

    public void check(String srt){
        try{
        logger.trace(srt+" передана");}
        catch (Exception e){
            logger.error("Error");
        }

    }

}
