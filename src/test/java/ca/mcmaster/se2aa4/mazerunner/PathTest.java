package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathTest {
    @Test
    void convertToFactorized(){
        FastMethod fast = new FastMethod();
        String canonical = "FFFFFFFLLRRFR";
        assertEquals("7F 2L 2R F R", fast.factorize(canonical));
    }
}
