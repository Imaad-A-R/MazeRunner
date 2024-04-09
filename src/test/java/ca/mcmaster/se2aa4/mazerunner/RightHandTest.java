package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class RightHandTest {
    @Test
    void checkSlowPath(){

        String [][] maze = {{"#","#","#","#","#","#","#"},
                            {"#","#","#","#","#","#","#",},
                            {"#","#","#","#","#","#","#",},
                            {"#","#","#","#","#","#","#",},
                            {"#","#","#","#","#","#","#",},
                            {"#","#","#","#","#","#","#",},
                            {" "," "," "," "," "," "," ",},
                            {"#","#"," ","#","#","#","#",},
                            {"#","#"," ","#","#","#","#",},
                            {"#","#"," ","#","#","#","#",},
                            {"#","#","#","#","#","#","#",},
                            {"#","#","#","#","#","#","#",},
                            {"#","#","#","#","#","#","#",}};
        Traverser travel = new Traverser();
        int start = travel.findStart(maze);
        int end = travel.findEnd(maze);
        FindPath pathfinder = new RightHand();
        String path = pathfinder.find(maze, start, end);

        assertEquals("FFRFFFLLFFFRFFFF", path);
        assertNotEquals("FFFFFF", path);
        assertEquals("2F R 3F 2L 3F R 4F", pathfinder.factorize(path));
    }
}
