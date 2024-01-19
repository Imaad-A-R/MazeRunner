package ca.mcmaster.se2aa4.mazerunner;

public class Traverser {

    public Traverser(String[][] map) {
    }

    public String path() {
        return "placeholder";
    }
    public int findEnd(String[][] maze) {
        int end=0;
        for (int i=0; i<maze.length; i++){
            if (maze[i][maze[0].length-1]==" "){
                end = i;
            }
        }
        return end;
    }
    public int findStart(String[][] maze){
        int start=0;
        for (int i=0; i<maze.length; i++){
            if (maze[i][0]==" "){
                start = i;
            }
        }
        return start;
    }
}
