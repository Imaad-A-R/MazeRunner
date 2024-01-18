package ca.mcmaster.se2aa4.mazerunner;

public class MazeAnalyzer {
    public MazeAnalyzer(String file_name) {
    }
    public String arraymaker(){
        String[][] maze = new String[100][100];
        Traverser travel = new Traverser(maze);
        return travel.path();
    }
    public String factorize(String canonical){
        return "factor placeholder";
    }
}
