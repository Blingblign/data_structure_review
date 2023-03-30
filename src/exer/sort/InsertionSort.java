package exer.sort;

import com.sun.org.apache.bcel.internal.generic.IfInstruction;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 插入排序
 * @author bling
 * @create 2022-09-26 22:06
 */
public class InsertionSort {

    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for ( j= i-1; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j+1] = arr[j];
                }else break;
            }
            arr[j+1] = temp;

        }
        System.out.println(Arrays.toString(arr));
    }
    public static void sort2(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int index = i-1;
            while (index >= 0 && temp < arr[index]) {
                arr[index+1] = arr[index];
                index--;
            }


            arr[index+1] = temp;

        }
        System.out.println(Arrays.toString(arr));
    }

}
