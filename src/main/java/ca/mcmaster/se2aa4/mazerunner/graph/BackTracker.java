package ca.mcmaster.se2aa4.mazerunner.graph;

public class BackTracker {
    enum Direction{
        N,
        S,
        E,
        W
    }
    public String path;
    private Direction currentDirection = Direction.E;
    public String calculateSteps(Coordinates[][] pathTracker, int end) {
        Coordinates prevNode = pathTracker[end][pathTracker[0].length-1];
        Coordinates currentNode = pathTracker[end][pathTracker[0].length-2];
        path = "F";
        while(prevNode.x!=0){
            switch (currentDirection){
                case E:
                    path = determinePathEast(currentNode, prevNode) + path;
                    break;
                case W:
                    path = determinePathWest(currentNode, prevNode) + path;
                    break;
                case N:
                    path = determinePathNorth(currentNode, prevNode) + path;
                    break;
                case S:
                    path = determinePathSouth(currentNode, prevNode) + path;
                    break;
            }
            prevNode = currentNode;
            currentNode = pathTracker[currentNode.y][currentNode.x];
        }
        return path;
    }

    private String determinePathSouth(Coordinates currentNode, Coordinates prevNode) {
        if (currentNode.y == prevNode.y-1){
            return "F";
        }
        else if (currentNode.x == prevNode.x-1){
            currentDirection = Direction.E;
            return "FR";
        }
        else{
            currentDirection = Direction.W;
            return "FL";
        }
    }

    private String determinePathNorth(Coordinates currentNode, Coordinates prevNode) {
        if (currentNode.y == prevNode.y+1){
            return "F";
        }
        else if (currentNode.x == prevNode.x+1){
            currentDirection = Direction.W;
            return "FR";
        }
        else{
            currentDirection = Direction.E;
            return "FL";
        }
    }

    private String determinePathWest(Coordinates currentNode, Coordinates prevNode) {
        if (currentNode.x == prevNode.x+1){
            return "F";
        }
        else if (currentNode.y == prevNode.y-1){
            currentDirection = Direction.S;
            return "FR";
        }
        else{
            currentDirection = Direction.N;
            return "FL";
        }
    }

    private String determinePathEast(Coordinates currentNode, Coordinates prevNode) {
        if (currentNode.x == prevNode.x-1){
            return "F";
        }
        else if (currentNode.y == prevNode.y+1){
            currentDirection = Direction.N;
            return "FR";
        }
        else{
            currentDirection = Direction.S;
            return "FL";
        }
    }


}
