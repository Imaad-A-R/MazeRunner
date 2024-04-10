package ca.mcmaster.se2aa4.mazerunner;

import java.text.DecimalFormat;

public class Traverser {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private final KeyPointFinder finder = new KeyPointFinder();

    public String checkMaze(String[][] maze, String test_path, String method, String baseline) {


        //first create our objects for path finding and get start and end
        FindPath pathfinder;
        int end = finder.findEnd(maze);
        int start = finder.findStart(maze);

        try {
            //first check if path to test
            if (!test_path.equals("null")){
                return testAPath(maze, start, end, test_path);
            }
            //then check for baseline
            else if (!baseline.equals("null")){
                return baselineComparison(maze, start, method, baseline);
            }


            //if there is no path to test, no baseline and we are using righthand
            if (method.equals("righthand")) {
                pathfinder = new RightHand();
                String path = pathfinder.find(maze, start, end);
                return pathfinder.factorize(path);
            //if there is no path to test, no baseline, and we are using fast
            } else if (method.equals("fast")) {
                pathfinder = new FastMethod();
                String path = pathfinder.find(maze, start, end);
                return pathfinder.factorize(path);
            }
            else{
                throw new IllegalArgumentException("Enter a valid method {fast, righthand}");
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
        String normalPath = firstMethod.find(maze, start, finder.findEnd(maze));
        System.out.println("Time for method: "+df.format((System.currentTimeMillis()-startTime)));

        startTime = System.currentTimeMillis();
        String baselinePath = secondMethod.find(maze, start, finder.findEnd(maze));
        System.out.println("Time for baseline: "+df.format((System.currentTimeMillis()-startTime)));

        return "Speedup: "+ df.format((double) baselinePath.length() / normalPath.length());
    }

    private String testAPath(String [][] maze, int start, int end, String test_path){
        CheckPath firstChecker = new WestToEast();
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

}
