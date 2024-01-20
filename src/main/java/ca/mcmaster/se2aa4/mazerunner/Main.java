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
            MazeAnalyzer maze = new MazeAnalyzer();
            String pathing = maze.arraymaker(config.file_name(), config.maze_length(), config.maze_width());
            String factorize = maze.factorize(pathing);
            if (pathing.equals("We crashed!")){
                System.out.println("The maze was not a straight maze, so we crashed into a wall (Traversal coming soon!)");
            }
            else{
                System.out.println("Starting from the entry point on the left, the path to solve the maze is: "+pathing);
            }
        } catch(ParseException | IOException e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("** End of MazeRunner");
    }


    private record Configure(String file_name, String test_path, int maze_length, int maze_width){
        Configure{
            if (!(file_name.endsWith(".maz.txt"))){
                throw new IllegalArgumentException("Please enter a valid file");
            }
            else if (maze_length>1000 || maze_width>1000){
                throw new IllegalArgumentException("Maze is too large");
            }
        }

    }
    private static Configure configuring(String []args) throws IOException, ParseException {
        Options options = new Options();
        options.addOption("i", true, "Input argument for map");
        options.addOption("p", true, "Test a specific path");
        CommandLineParser parser = new DefaultParser();
        logger.info("** Starting Maze Runner");
        CommandLine cmd = parser.parse(options, args);
        logger.info("**** Reading the maze from file " + cmd.getOptionValue("i", "examples/straight.maz.txt"));
        BufferedReader reader = new BufferedReader(new FileReader(cmd.getOptionValue("i", "examples/straight.maz.txt")));
        String line;
        int length=0, width=0;
        while ((line = reader.readLine()) != null) {
            for (int idx = 0; idx < line.length(); idx++) {
                length = idx;
            }
            width++;
        }
        return new Configure(cmd.getOptionValue("i", "examples/straight.maz.txt"), cmd.getOptionValue("p", "null"), length, width);
    }
}
