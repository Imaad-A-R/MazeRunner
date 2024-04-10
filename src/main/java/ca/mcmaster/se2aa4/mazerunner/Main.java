package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;

import ca.mcmaster.se2aa4.mazerunner.configuration.Configure;
import ca.mcmaster.se2aa4.mazerunner.configuration.ProgramGuide;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    //main method which calls other methods and handles exceptions
    public static void main(String[] args) throws ParseException {
        try {
            Configure config = new Configure();
            ProgramGuide guideInfo = config.createConfig(args);
            MazeAnalyzer mazeAnalyzer = new MazeAnalyzer();
            String pathing = mazeAnalyzer.arraymaker(guideInfo);
            System.out.println(pathing);
        } catch(ParseException | IOException e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("** End of MazeRunner");
    }
}
