package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.graph.BackTracker;
import ca.mcmaster.se2aa4.mazerunner.graph.Coordinates;

import java.util.LinkedList;
import java.util.Queue;

public class FastMethod implements FindPath {
    public Queue<Coordinates> coordQueue;
    public Coordinates [][] pathTracker;
    public boolean [][] marked;
    FastMethod(){
        coordQueue = new LinkedList<>();
    }
    public String find(String[][] maze, int start, int end){
        boolean reachedEnd = false;
        pathTracker = new Coordinates[maze.length][maze[0].length];
        marked = new boolean[maze.length][maze[0].length];
        pathTracker [start][1] = new Coordinates(start, 0);
        coordQueue.add(new Coordinates(start, 1));
        marked [start][1] = true;
        marked [start][0] = true;


        while (!reachedEnd && !coordQueue.isEmpty()){
            Coordinates currentCoords = coordQueue.remove();
            checkNodeBelow(currentCoords, maze);
            checkNodeAbove(currentCoords, maze);
            checkNodeLeft(currentCoords, maze);
            checkNodeRight(currentCoords, maze);
            reachedEnd = currentCoords.x+1==maze[0].length-1 && currentCoords.y==end;
        }
        BackTracker pathDeterminer = new BackTracker();
        return factorize(pathDeterminer.calculateSteps(pathTracker, end));
    }

    private void checkNodeLeft(Coordinates currentCoords, String[][] maze) {
        if (maze[currentCoords.y][currentCoords.x-1].equals(" ") && !marked[currentCoords.y][currentCoords.x-1]){
            pathTracker [currentCoords.y][currentCoords.x-1] = new Coordinates(currentCoords.y, currentCoords.x);
            marked [currentCoords.y][currentCoords.x-1] = true;
            coordQueue.add(new Coordinates(currentCoords.y, currentCoords.x-1));
        }
    }

    private void checkNodeRight(Coordinates currentCoords, String[][] maze) {
        if (maze[currentCoords.y][currentCoords.x+1].equals(" ") && !marked[currentCoords.y][currentCoords.x+1]){
            pathTracker [currentCoords.y][currentCoords.x+1] = new Coordinates(currentCoords.y, currentCoords.x);
            marked [currentCoords.y][currentCoords.x+1] = true;
            coordQueue.add(new Coordinates(currentCoords.y, currentCoords.x+1));
        }
    }

    private void checkNodeAbove(Coordinates currentCoords, String[][] maze) {
        if (maze[currentCoords.y-1][currentCoords.x].equals(" ") && !marked[currentCoords.y-1][currentCoords.x]){
            pathTracker [currentCoords.y-1][currentCoords.x] = new Coordinates(currentCoords.y, currentCoords.x);
            marked [currentCoords.y-1][currentCoords.x] = true;
            coordQueue.add(new Coordinates(currentCoords.y-1, currentCoords.x));
        }
    }

    private void checkNodeBelow(Coordinates currentCoords, String [][] maze) {
        if (maze[currentCoords.y+1][currentCoords.x].equals(" ") && !marked[currentCoords.y+1][currentCoords.x]){
            pathTracker [currentCoords.y+1][currentCoords.x] = new Coordinates(currentCoords.y, currentCoords.x);
            marked [currentCoords.y+1][currentCoords.x] = true;
            coordQueue.add(new Coordinates(currentCoords.y+1, currentCoords.x));
        }
    }
}
