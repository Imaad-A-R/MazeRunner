package ca.mcmaster.se2aa4.mazerunner;

//interface that serves as a blueprint on ways to check that a path is correct for a maze
public interface findPath {
    String find(String[][] maze, int start);
}
