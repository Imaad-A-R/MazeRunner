package ca.mcmaster.se2aa4.mazerunner.configuration;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import java.io.*;

public class Configure {
    private static final Logger logger = LogManager.getLogger();
    public ProgramGuide createConfig(String[] args) throws ParseException, IOException {
        Options options = new Options();
        options.addOption("i", true, "Input argument for map");
        options.addOption("p", true, "Test a specific path");
        options.addOption("method", true, "Algorithm for finding path");
        options.addOption("baseline", true, "Algorithm to check as baseline");
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
        return new ProgramGuide(cmd.getOptionValue("i", "examples/straight.maz.txt"), cmd.getOptionValue("p", "null"), cmd.getOptionValue("method", "fast"), length, width, cmd.getOptionValue("baseline", "null"));
    }
}
