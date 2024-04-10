package ca.mcmaster.se2aa4.mazerunner;

public class KeyPointFinder {
    //method which determines the start of the maze
    public int findStart(String[][] maze){
        int start=0;
        for (int i=0; i<maze.length; i++){
            if (maze[i][0].equals(" ")){
                start = i;
            }
        }
        return start;
    }

    //method which determines end of the maze
    public int findEnd(String[][] maze){
        int end=0;
        for (int i=0; i<maze.length; i++){
            if (maze[i][maze[0].length-1].equals(" ")){
                end = i;
            }
        }
        return end;
    }
}
