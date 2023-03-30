package exer2023;

import java.util.Arrays;

/**
 * @author bling
 * @create 2023-03-30 17:01
 */
public class TestInsertSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,16,18,3,7,55,23,7,28};
        int[] arr2 = {1,5,16,18,23,28};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            for ( ; j > 0 ; j--) {
                if (temp < arr[j - 1]) {
                    //前一个元素后移
                    arr[j] = arr[j-1];
                } else
                    break;
            }
            arr[j] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }
}
