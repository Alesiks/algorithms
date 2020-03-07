package by.bsu.mmf.algo.graphtheory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ConnectedCellInAGridTest {


    @Test
    public void test() {
        int[][] grid = {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0},
        };

        int actual = ConnectedCellInAGrid.maxRegion(grid);
        assertEquals(5, actual);

    }

}
