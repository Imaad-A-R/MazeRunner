package ca.mcmaster.se2aa4.mazerunner;

public class westToEast implements checkPath {
    @Override
    public String testPath(String[][] maze, int start, String path){
        //set the current position to the left side of the array
        int current_x = 0;

        //direction that the pointer is moving is determined by taking the remainder of 4. 0=East, 1=South, 2=West, 3=North
        int direction = 0;

        //num is used to store numbers in a factorized path
        int num=0;

        //increment through the path that the user provides us
        for (int i=0; i<path.length(); i++){

            //if the user gives us a number, then do the next char in the path that amount of times
            if (path.charAt(i)>='2' && path.charAt(i)<='9' && i+1<path.length()){
                num=path.charAt(i)-48;
                i=i+1;
            }
            else{
                num=1;
            }
            //depending on the current char and direction, check if the next step is a wall or not
            for(int j=0; j<num; j++) {

                //moving forward varies based on direction
                if (path.charAt(i) == 'F') {
                    if ((direction % 4) == 0) {
                        if (maze[start][current_x + 1].equals("#")) {
                            return "incorrect path";
                        } else {
                            current_x++;
                        }
                    } else if (direction % 4 == 1 || direction % 4 == -3) {
                        if (maze[start + 1][current_x].equals("#")) {
                            return "incorrect path";
                        } else {
                            start++;
                        }
                    } else if (Math.abs(direction % 4) == 2) {
                        if (maze[start][current_x - 1].equals("#")) {
                            return "incorrect path";
                        } else {
                            current_x--;
                        }
                    } else if (direction % 4 == 3 || direction % 4 == -1) {
                        if (maze[start - 1][current_x].equals("#")) {
                            return "incorrect path";
                        } else {
                            start--;
                        }
                    }

                //to turn, just increment the directrion value
                } else if (path.charAt(i) == 'R') {
                    direction++;
                } else if (path.charAt(i) == 'L') {
                    direction--;
                } else if (!(path.charAt(i) == ' ')) {
                    return "incorrect path";
                }
            }
        }

        //return result based on the x axis position of the pointer
        if(current_x==(maze[0].length-1)){
            return "correct path";
        }
        return "incorrect path";
    }
}
