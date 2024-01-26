package ca.mcmaster.se2aa4.mazerunner;

//interface that serves as a blueprint for algorithms that generate a valid path for a maze
public interface findPath {
    String find(String[][] maze, int start);

    String factorize(String canonical);
}
