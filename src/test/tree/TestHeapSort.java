package test.tree;

import exer.sort.HeapSort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author bling
 * @create 2022-09-30 9:22
 */
public class TestHeapSort {
    @Test
    public void test() {
        int arr[] = {1,4,3,8,12,6,3,9,24,16};
        HeapSort heapSort = new HeapSort(arr);
        heapSort.sort();
        System.out.println(Arrays.toString(arr));
    }
}
