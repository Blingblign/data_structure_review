package exer2023;

import java.util.Arrays;

/**
 * @author bling
 * @create 2023-03-30 16:13
 */
public class TestSelectSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,16,18,3,7,55,23,7,28};
        int[] arr2 = {1,5,16,18,23,28};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            int tempIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[tempIndex]) {
                    tempIndex = j;
                }
            }
            if (tempIndex == i) continue;
            //交换
            int temp = arr[i];
            arr[i] = arr[tempIndex];
            arr[tempIndex] = temp;
        }
    }
}
