package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;

public class MazeAnalyzer {

    public MazeAnalyzer() {
    }
    public String arraymaker(String file_name, int length, int width) throws IOException {
        //declare 2d array which will contain maze
        String[][] maze = new String[width][length+1];
        //declare file reading stuff
        System.out.println(file_name);
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
        //print maze to verify maze was converted successfully
        for (int i=0; i < maze.length; i++){
            for (int k=0; k<maze[0].length; k++){
                System.out.print(maze[i][k]);
            }
            System.out.println();
        }
        Traverser travel = new Traverser(maze);
        return travel.path();
    }
    public String factorize(String canonical){
        return "factor placeholder";
    }
}
