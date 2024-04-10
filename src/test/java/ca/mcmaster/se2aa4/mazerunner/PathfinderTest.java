package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PathfinderTest {
    @Test
    void checkCorrectPath(){
        String [][] maze = {{"#","#","#","#","#","#","#"},
                            {"#"," "," "," ","#","#","#",},
                            {"#"," ","#"," ","#","#","#",},
                            {"#"," ","#"," ","#","#","#",},
                            {"#"," ","#"," "," "," ","#",},
                            {"#"," ","#","#","#"," ","#",},
                            {" "," "," "," "," "," "," ",},
                            {"#","#","#"," ","#"," ","#",},
                            {"#","#","#"," ","#"," ","#",},
                            {"#","#","#"," ","#"," ","#",},
                            {"#","#","#"," ","#"," ","#",},
                            {"#","#","#"," "," "," ","#",},
                            {"#","#","#","#","#","#","#",}};
        Traverser travel = new Traverser();
        KeyPointFinder finder = new KeyPointFinder();
        int start = finder.findStart(maze);
        int end = finder.findEnd(maze);
        FindPath pathfinder = new FastMethod();
        String path = pathfinder.find(maze, start, end);

        assertEquals("FFFFFF", path);

        assertEquals("6F", pathfinder.factorize(path));
    }
}
