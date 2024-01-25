package ca.mcmaster.se2aa4.mazerunner;

public class westToEast implements checkPath {
    @Override
    public String testPath(String[][] maze, int start, String path){
        int current_x = 0;
        int direction = 0;
        int num=0;

        for (int i=0; i<path.length(); i++){
            if (path.charAt(i)>='2' && path.charAt(i)<='9' && i+1<path.length()){
                num=path.charAt(i)-48;
                i=i+1;
            }
            else{
                num=1;
            }
            for(int j=0; j<num; j++) {
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
                } else if (path.charAt(i) == 'R') {
                    direction++;
                } else if (path.charAt(i) == 'L') {
                    direction--;
                } else if (!(path.charAt(i) == ' ')) {
                    return "incorrect path";
                }
            }
        }

        if(current_x==(maze[0].length-1)){
            return "correct path";
        }
        return "incorrect path";
    }
}
