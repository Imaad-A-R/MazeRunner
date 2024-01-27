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

            //POINTING EAST
            if(direction%4==0) {

                //depending on the current position, the possible paths are checked in this order
                //1.turn right, 2.move forward, or 3.turn left
                //direction value is incremented if a turn is made, and the x/y value is incremented on the movement
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

            //POINTING SOUTH
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

            //POINTING WEST
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

            //POINTING NORTH
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

        //return the factorized path
        return factorize(pathing);
    }

    //algorithm to convert the canonical form to the factorized form
    @Override
    public String factorize(String canonical){
        String factored = "";
        int total = 1;
        //look at the first element
        char current = canonical.charAt(0);

        //compare the last element with the for loop one, increasing a count and printing only when they don't match
        for (int i=1; i<canonical.length(); i++){
            if (canonical.charAt(i)==current){
                total++;

                //these if statements are purely for the case where we are on the last element
                if (i==canonical.length()-1){
                    factored = factored+" "+total+canonical.charAt(i);
                }
            }
            else if(canonical.charAt(i)!=current && total>=2){
                factored = factored+" "+total+current;
                total=1;
                if (i==canonical.length()-1){
                    factored = factored+" "+canonical.charAt(i);
                }
            }
            else{
                factored=factored+" "+current;
                if (i==canonical.length()-1){
                    factored = factored+" "+canonical.charAt(i);
                }
            }
            current = canonical.charAt(i);
        }
        return factored.substring(1);
    }
}
