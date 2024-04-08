package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.configuration.ProgramGuide;

import java.io.*;

public class MazeAnalyzer {


    public String arraymaker(ProgramGuide guideInfo) throws IOException {
        //declare 2d array which will contain maze
        String[][] maze = new String[guideInfo.maze_width][guideInfo.maze_length+1];

        //declare file reading stuff
        FileReader reader = new FileReader(guideInfo.file_name);
        BufferedReader bufread = new BufferedReader(reader);
        String line;
        int j=0;

        //convert file contents to a 2d array
        while((line = bufread.readLine())!=null){
            for (int i=0; i<line.length(); i++){
                maze [j][i] = String.valueOf(line.charAt(i));
            }
            j++;
        }
        //convert nulls in the array to spaces.
        for (int i=0; i < maze.length; i++){
            for (int k=0; k<maze[0].length; k++){
                if (maze[i][k]==null){
                    maze[i][k]=" ";
                }
            }
        }

        //define traverser objects and find start index
        Traverser travel = new Traverser();
        int start = travel.findStart(maze);

        //call into the traverser method
        return travel.checkMaze(maze, start, guideInfo.test_path, guideInfo.method, guideInfo.baseline);
    }
}
