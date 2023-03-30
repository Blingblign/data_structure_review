package test;

import exer.recursion.EightQueen;
import exer.recursion.Maze;
import org.junit.Test;
import sun.security.util.AuthResources_it;

/**
 * @author bling
 * @create 2022-09-26 15:33
 */
public class TestRecursion {
    @Test
    public void test1() {
        Maze maze = new Maze();
        maze.getMaze();
        maze.show();
        maze.setWay(1,1);
        System.out.println("=======================");
        maze.show();
    }
    @Test
    public void test2() {
        EightQueen eightQueen = new EightQueen();
        eightQueen.placeQueen(0);
        System.out.println(eightQueen.count);
        eightQueen.show();
    }

}
