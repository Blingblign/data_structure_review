package test.algorithm;

import exer.algorithm.HanoiTower;
import org.junit.Test;

/**
 * @author bling
 * @create 2022-10-09 11:01
 */
public class TestHanoiTower {
    @Test
    public void test() {
        HanoiTower.hanoiTower(5,'A','B','C');
        System.out.println(HanoiTower.count);
    }
}
