package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;
import java.util.Objects;

public class MazeAnalyzer {

    public MazeAnalyzer() {
    }
    public String arraymaker(String file_name, int length, int width) throws IOException {
        //declare 2d array which will contain maze
        String[][] maze = new String[width][length+1];
        //declare file reading stuff
        FileReader reader = new FileReader(file_name);
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
        //print maze to verify maze was converted successfully. convert nulls to spaces.
        for (int i=0; i < maze.length; i++){
            for (int k=0; k<maze[0].length; k++){
                if (maze[i][k]==null){
                    maze[i][k]=" ";
                }
                System.out.print(maze[i][k]);
            }
            System.out.println();
        }
        //define traverser objects and find start and end indexes
        Traverser travel = new Traverser(maze);
        int start = travel.findStart(maze);
        int end = travel.findEnd(maze);
        return travel.path();
    }
    public String factorize(String canonical){
        return "factor placeholder";
    }
}
