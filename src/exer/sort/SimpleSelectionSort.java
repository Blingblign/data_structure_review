package exer.sort;

import java.util.Arrays;

/**
 * @author bling
 * @create 2022-09-26 21:30
 */
public class SimpleSelectionSort {

    public static void sort(int[] arr) {
        int min;
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;

                }
            }
            //交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }
        System.out.println(Arrays.toString(arr));

    }
}
