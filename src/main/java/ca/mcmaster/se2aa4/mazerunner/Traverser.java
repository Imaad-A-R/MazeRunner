package ca.mcmaster.se2aa4.mazerunner;

public class Traverser {

    public Traverser(String[][] map) {
    }

    public String findPath(String[][] maze, int start) {
        int current_x = 0;
        String pathing = "";
        int direction = 0;
        while(current_x!=maze[0].length-1){
            if(direction%4==0) {
                if (maze[start + 1][current_x].equals(" ")) {
                    direction++;
                    start++;
                    pathing = pathing + "RF";
                } else if (maze[start][current_x + 1].equals(" ")) {
                    current_x++;
                    pathing = pathing + "F";
                } else if (maze[start - 1][current_x].equals(" ")) {
                    direction--;
                    start--;
                    pathing = pathing + "LF";
                } else {
                    direction += 2;
                    pathing = pathing + "LL";
                }
            }
            else if(direction%4==1) {
                if (maze[start][current_x - 1].equals(" ")) {
                    direction++;
                    current_x--;
                    pathing = pathing + "RF";
                } else if (maze[start + 1][current_x].equals(" ")) {
                    start++;
                    pathing = pathing + "F";
                } else if (maze[start][current_x + 1].equals(" ")) {
                    direction--;
                    current_x++;
                    pathing = pathing + "LF";
                } else {
                    direction += 2;
                    pathing = pathing + "LL";
                }
            }
            else if(direction%4==2) {
                if (maze[start - 1][current_x].equals(" ")) {
                    direction++;
                    start--;
                    pathing = pathing + "RF";
                } else if (maze[start][current_x - 1].equals(" ")) {
                    current_x--;
                    pathing = pathing + "F";
                } else if (maze[start + 1][current_x].equals(" ")) {
                    direction--;
                    start++;
                    pathing = pathing + "LF";
                } else {
                    direction += 2;
                    pathing = pathing + "LL";
                }
            }
            else if(direction%4==3) {
                if (maze[start][current_x + 1].equals(" ")) {
                    direction++;
                    current_x++;
                    pathing = pathing + "RF";
                } else if (maze[start - 1][current_x].equals(" ")) {
                    start--;
                    pathing = pathing + "F";
                } else if (maze[start][current_x - 1].equals(" ")) {
                    direction--;
                    current_x--;
                    pathing = pathing + "LF";
                } else {
                    direction += 2;
                    pathing = pathing + "LL";
                }
            }
        }
        return pathing;
    }

    //method which will determine if a path is correct or not
    public String testPath(String[][] maze, int start, String path){
        int current_x = 0;
        int direction = 0;

        for (int i=0; i<path.length(); i++){
            if (path.charAt(i)=='F'){
                if ((direction%4)==0){
                    if (maze[start][current_x+1].equals("#")){
                        return "incorrect path";
                    }
                    else{
                        current_x++;
                    }
                }
                else if(direction%4==1 || direction%4==-3){
                    if (maze[start+1][current_x].equals("#")){
                        return "incorrect path";
                    }
                    else{
                        start++;
                    }
                }
                else if(Math.abs(direction%4)==2){
                    if (maze[start][current_x-1].equals("#")){
                        return "incorrect path";
                    }
                    else{
                        current_x--;
                    }
                }
                else if(direction%4==3 || direction%4==-1){
                    if (maze[start-1][current_x].equals("#")){
                        return "incorrect path";
                    }
                    else{
                        start--;
                    }
                }
            }
            else if(path.charAt(i)=='R'){
                direction++;
            }
            else if(path.charAt(i)=='L'){
                direction--;
            }
            else if (!(path.charAt(i)==' ')){
                return "incorrect path";
            }
        }

        if(current_x==(maze[0].length-1)){
            return "correct path";
        }
        return "incorrect path";
    }
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
}
