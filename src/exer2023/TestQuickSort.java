package exer2023;

import java.util.Arrays;

/**
 * @author bling
 * @create 2023-03-30 22:26
 */
public class TestQuickSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,16,18,3,7,55,23,7,28};
        int[] arr2 = {1,5,16,18,23,28};
        quickSort1(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 单边循环
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort1(int[] arr,int left, int right) {
        int i,j;
        i = j = left;
        for (; j < right; j++) {
            if (arr[j] < arr[right]) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }

    }

    /**
     * 双边排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort2(int[] arr,int left, int right) {

    }

}
