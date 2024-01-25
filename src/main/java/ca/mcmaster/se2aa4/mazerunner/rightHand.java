package ca.mcmaster.se2aa4.mazerunner;

public class rightHand implements findPath {

    //this is the exploration implemented using the dumb right hand rule
    @Override
    public String find(String[][] maze, int start){
        int current_x = 0;
        String pathing = "";
        int direction = 0;

        //keep running the loop until we reach the other side of the maze, indicating we finished it
        while(current_x!=maze[0].length-1){

            //direction that the pointer is moving is determined by taking the remainder of 4. 0=East, 1=South, 2=West, 3=North.
            if(direction%4==0) {

                //depending on the current position, turn right, move forward, or turn left by incrementing diff values depending on direction
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
}
