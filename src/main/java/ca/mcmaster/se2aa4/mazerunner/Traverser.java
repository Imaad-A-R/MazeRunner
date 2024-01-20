package ca.mcmaster.se2aa4.mazerunner;

public class Traverser {

    public Traverser(String[][] map) {
    }

    public String path(String[][] maze, int start, int end) {
        int current_x = 0;
        String pathing = "";
        int direction = 0;
        /*
        while (current_x!=maze[0].length-1){
            if (maze[start][current_x+1].equals(" ")){
                pathing = pathing+"F";
                current_x++;
            } else if (maze[start][current_x+1].equals("#")) {
                pathing = "We crashed!";
                return pathing;
            }
        }
        */
        while(current_x!=maze[0].length-1){
            if(direction%4==0) {
                if (maze[start + 1][current_x].equals(" ")) {
                    direction++;
                    start++;
                    pathing = pathing + " R F";
                } else if (maze[start][current_x + 1].equals(" ")) {
                    current_x++;
                    pathing = pathing + "F";
                } else if (maze[start - 1][current_x].equals(" ")) {
                    direction--;
                    start--;
                    pathing = pathing + " L F";
                } else {
                    direction += 2;
                    pathing = pathing + " LL ";
                }
            }
            else if(direction%4==1) {
                if (maze[start][current_x - 1].equals(" ")) {
                    direction++;
                    current_x--;
                    pathing = pathing + " R F";
                } else if (maze[start + 1][current_x].equals(" ")) {
                    start++;
                    pathing = pathing + "F";
                } else if (maze[start][current_x + 1].equals(" ")) {
                    direction--;
                    current_x++;
                    pathing = pathing + " L F";
                } else {
                    direction += 2;
                    pathing = pathing + " LL ";
                }
            }
            else if(direction%4==2) {
                if (maze[start - 1][current_x].equals(" ")) {
                    direction++;
                    start--;
                    pathing = pathing + " R F";
                } else if (maze[start][current_x - 1].equals(" ")) {
                    current_x--;
                    pathing = pathing + "F";
                } else if (maze[start + 1][current_x].equals(" ")) {
                    direction--;
                    start++;
                    pathing = pathing + " L F";
                } else {
                    direction += 2;
                    pathing = pathing + " LL ";
                }
            }
            else if(direction%4==3) {
                if (maze[start][current_x + 1].equals(" ")) {
                    direction++;
                    current_x++;
                    pathing = pathing + " R F";
                } else if (maze[start - 1][current_x].equals(" ")) {
                    start--;
                    pathing = pathing + "F";
                } else if (maze[start][current_x - 1].equals(" ")) {
                    direction--;
                    current_x--;
                    pathing = pathing + " L F";
                } else {
                    direction += 2;
                    pathing = pathing + " LL ";
                }
            }
        }
        return pathing;
    }
    public int findEnd(String[][] maze) {
        int end=0;
        for (int i=0; i<maze.length; i++){
            if (maze[i][maze[0].length-1].equals(" ")){
                end = i;
            }
        }
        return end;
    }
    public int findStart(String[][] maze){
        int start=0;
        for (int i=0; i<maze.length; i++){
            if (maze[i][0].equals(" ")){
                start = i;
            }
        }
        return start;
    }
}
