package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws ParseException {
        try {
            Configure config = configuring(args);
            MazeAnalyzer maze = new MazeAnalyzer(config.file_name());
            String pathing = maze.arraymaker();
            String factorize = maze.factorize(pathing);
            System.out.println(pathing);
            System.out.println(factorize);
        } catch(ParseException | IOException e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }


    private record Configure(String file_name){
        Configure{
            if (!(file_name.endsWith(".maz.txt"))){
                throw new IllegalArgumentException("Please enter a valid file");
            }
        }
    }
    private static Configure configuring(String []args) throws IOException, ParseException {
        Options options = new Options();
        options.addOption("i", true, "Input argument for map");
        CommandLineParser parser = new DefaultParser();
        logger.info("** Starting Maze Runner");
        CommandLine cmd = parser.parse(options, args);
        logger.info("**** Reading the maze from file " + cmd.getOptionValue("i", "examples/straight.maz.txt"));
        BufferedReader reader = new BufferedReader(new FileReader(cmd.getOptionValue("i", "examples/straight.maz.txt")));
        String line;
        while ((line = reader.readLine()) != null) {
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    logger.info("WALL ");
                } else if (line.charAt(idx) == ' ') {
                    logger.info("PASS ");
                }
            }
            logger.info(System.lineSeparator());
        }
        return new Configure(cmd.getOptionValue("i", "examples/straight.maz.txt"));
    }
}
