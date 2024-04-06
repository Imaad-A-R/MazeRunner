package ca.mcmaster.se2aa4.mazerunner;

public class Traverser {

    public String checkMaze(String[][] maze, int start, String test_path, String method) {

        //first create our objects which will be used to evaluate the business logic
        FindPath pathfinder;
        CheckPath firstChecker = new WestToEast();
        int end = findEnd(maze);

        try {
            //if there is no path to test then find a path for the user
            if (test_path.equals("null") && method.equals("righthand")) {
                pathfinder = new RightHand();
                return pathfinder.find(maze, start, end);
            } else if (test_path.equals("null") && method.equals("fast")) {
                pathfinder = new FastMethod();
                return pathfinder.find(maze,start, end);
            }
            //if there is a path to test then check that path
            else {
                //check west to east and see if user path works
                String answer = firstChecker.testPath(maze, start, test_path);

                //if user path doesn't work west to east then check east to west
                if (answer.equals("incorrect path")) {
                    CheckPath secondChecker = new EastToWest();
                    return secondChecker.testPath(maze, end, test_path);
                } else {
                    return firstChecker.testPath(maze, start, test_path);
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            return "/!\\ An error has occured /!\\";
        }
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

    //method which determines end of the maze. This is used later for checking an east to west solution provided by the user.
    private int findEnd(String[][] maze){
        int end=0;
        for (int i=0; i<maze.length; i++){
            if (maze[i][maze[0].length-1].equals(" ")){
                end = i;
            }
        }
        return end;
    }

}
