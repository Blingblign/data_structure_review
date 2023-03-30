package test.algorithm;

import exer.algorithm.BinarySearch;
import org.junit.Test;

/**
 * @author bling
 * @create 2022-10-09 9:41
 */
public class TestBinarySearch {

    @Test
    public void test1() {
        int[] arr = {1,3,6,7,7,9,13,16};
        int val = BinarySearch.search(arr, 17);
        System.out.println(val);
    }
}
