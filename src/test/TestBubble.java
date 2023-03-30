package test;

import exer.SimpleLinkedList;
import exer.serach.BinSearch;
import exer.serach.FibonacciSearch;
import exer.serach.InsertSearch;
import exer.sort.*;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author bling
 * @create 2022-09-26 21:11
 */
public class TestBubble {
    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        int[] ints = new int[10000000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int)(Math.random()*100000);
        }
//        BubbleSort.bubbleSort1(ints);
//        ShellSort.sort2(ints);
//        System.out.println(Arrays.toString(ints));
//        QuickSort.sort2(ints,0,ints.length-1);
//        MergeSort.sort(ints,0,ints.length-1,new int[ints.length]);
        RadixSort.sort(ints);
//        System.out.println(Arrays.toString(ints));
        long end = System.currentTimeMillis();
        System.out.println("方法一:"+ (end-start));
//        long start1 = System.currentTimeMillis();
//        BubbleSort.bubbleSort1(new int[]{1,3,5,5,8,7,16,12,15,16,14});
//        long end1 = System.currentTimeMillis();
//        System.out.println("方法二:"+ (end1-start1));

    }
    @Test
    public void test2() {
        SimpleSelectionSort.sort(new int[]{1,3,5,5,8,7,16,12,15,16,14});
        InsertionSort.sort2(new int[]{1,3,5,5,8,7,16,12,15,16,14});
    }

    @Test
    public void test4() {
        int[] ints = {1, 3, 5, 5, 8, 7, 16, 12, 15, 16, 14};
        for (int anInt : ints) {
            anInt = 1;
        }
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test3() {
        ShellSort.sort1(new int[] {8,9,1,7,2,3,5,4,6,0});
        System.out.println("==========================");
        ShellSort.sort2(new int[] {8,9,1,7,2,3,5,4,6,0});
    }

    @Test
    public void test5() {
        int[] ints = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        QuickSort.sort1(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void testMerge() {
        int[] ints = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        MergeSort.sort(ints, 0, ints.length-1, new int[ints.length]);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void testBucket() {
        int[] ints = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        RadixSort.sort(ints);
        System.out.println(Arrays.toString(ints));


    }

    @Test
    public void testBinSearch() {
        int[] ints = {12,12,12,12,12,12,12,12,12};

        BinSearch.search(ints,12,0,ints.length-1);

    }

    @Test
    public void testInsertSearch() {
        int[] ints = {1, 3, 5, 5, 8, 8, 11, 12, 15, 16, 17};
        InsertSearch.search(ints,10,0, ints.length-1);
    }

    @Test
    public void testFibSearch() {
        int[] ints = {-1,3,5,7,9,14,18,23,26,39,43,54,56};

        int index = FibonacciSearch.search(ints, 54);
        System.out.println("索引为：" + index);
    }
}
