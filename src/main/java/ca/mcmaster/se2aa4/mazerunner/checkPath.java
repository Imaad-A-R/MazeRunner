package ca.mcmaster.se2aa4.mazerunner;

//inferface which is used as a template for algorithms that can check if a user given path is valid.
public interface checkPath {
    String testPath(String[][] maze, int start, String path);
}
