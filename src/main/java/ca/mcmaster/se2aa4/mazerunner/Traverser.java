package ca.mcmaster.se2aa4.mazerunner;

import java.text.DecimalFormat;

public class Traverser {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public String checkMaze(String[][] maze, int start, String test_path, String method, String baseline) {
        //first create our objects which will be used to evaluate the business logic
        FindPath pathfinder;
        CheckPath firstChecker = new WestToEast();
        int end = findEnd(maze);

        try {
            //if there is no path to test then find a path for the user
            if (test_path.equals("null") && method.equals("righthand") && baseline.equals("null")) {
                pathfinder = new RightHand();
                String path = pathfinder.find(maze, start, end);
                return pathfinder.factorize(path);
            } else if (test_path.equals("null") && method.equals("fast") && baseline.equals("null")) {
                pathfinder = new FastMethod();
                String path = pathfinder.find(maze, start, end);
                return pathfinder.factorize(path);
            }
            else if (test_path.equals("null")){
                return baselineComparison(maze, start, method, baseline);
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

    private String baselineComparison(String[][] maze, int start, String method, String baseline) {

        FindPath firstMethod;
        FindPath secondMethod;
        if (method.equals("righthand")){
            firstMethod = new RightHand();
        }
        else{
            firstMethod = new FastMethod();
        }
        if (baseline.equals("righthand")){
            secondMethod = new RightHand();
        }
        else{
            secondMethod = new FastMethod();
        }

        double startTime = System.currentTimeMillis();
        String normalPath = firstMethod.find(maze, start, findEnd(maze));
        System.out.println("Time for method: "+df.format((System.currentTimeMillis()-startTime)));

        startTime = System.currentTimeMillis();
        String baselinePath = secondMethod.find(maze, start, findEnd(maze));
        System.out.println("Time for baseline: "+df.format((System.currentTimeMillis()-startTime)));

        return "Speedup: "+ df.format((double) baselinePath.length() / normalPath.length());
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
