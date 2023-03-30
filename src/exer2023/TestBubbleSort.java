package exer2023;

import java.util.Arrays;

/**
 * @author bling
 * @create 2023-03-27 16:38
 */
public class TestBubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,16,18,3,7,55,23,7,28};
        int[] arr2 = {1,5,16,18,23,28};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] bubbleSort(int[] arr) {
        //循环次数
        for (int i = 0; i < arr.length - 1; i++) {
            //2.设置boolean变量，看是否发生了交换
            boolean swapped = false;
            //每次循环比较次数
            //1.减少比较次数
            for (int j = 0; j < arr.length - 1- i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + i + "轮循环");
            if (!swapped) {
                return arr;
            }
        }
        return arr;
    }
    //3.进一步减少比较次数：记录每次循环最后一次交换的索引值
    public static int[] bubbleSort2(int[] arr) {
        int n = arr.length - 1;
        while (true) {
            System.out.println("第轮循环");
            int last = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    last = j;
                }
            }
            n = last;
            if (n == 0) break;
        }
        return arr;
    }

}
