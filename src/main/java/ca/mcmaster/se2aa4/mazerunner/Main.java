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
            MazeAnalyzer maze = new MazeAnalyzer();
            String pathing = maze.arraymaker(guideInfo);
            System.out.println(pathing);
        } catch(ParseException | IOException e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("** End of MazeRunner");
    }

    /*
    //configure record and method to configure command line arguments away from main method
    private record Configure(String file_name, String test_path, int maze_length, int maze_width){
        Configure{
            if (!(file_name.endsWith(".txt"))){
                throw new IllegalArgumentException("Please enter a valid file");
            }
            if(test_path.isEmpty()){
                throw new IllegalArgumentException("Please enter a valid path");
            }
        }

    }
    private static Configure configuring(String []args) throws IOException, ParseException {
        //create new command line options i and p
        Options options = new Options();
        options.addOption("i", true, "Input argument for map");
        options.addOption("p", true, "Test a specific path");
        options.addOption("method", true, "Algorithm for finding path");
        CommandLineParser parser = new DefaultParser();

        logger.info("** Starting Maze Runner");
        CommandLine cmd = parser.parse(options, args);
        logger.info("**** Reading maze from file " + cmd.getOptionValue("i", "examples/straight.maz.txt"));
        BufferedReader reader = new BufferedReader(new FileReader(cmd.getOptionValue("i", "examples/straight.maz.txt")));


        //determine length and width while reading through the maze
        String line;
        int length=0, width=0;
        while ((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                length = i;
            }
            width++;
        }
        //return configuration
        return new Configure(cmd.getOptionValue("i", "examples/straight.maz.txt"), cmd.getOptionValue("p", "null"), length, width);
    }

     */
}
