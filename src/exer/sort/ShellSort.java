package exer.sort;

import java.util.Arrays;

/**
 * 希尔排序，又叫缩小增量排序，主要有两种排序方式：
 * 交换法和移位法
 * @author bling
 * @create 2022-09-27 9:53
 */
public class ShellSort {

    /**
     * 采用交换法进行希尔排序
     * @param arr
     */
    public static void sort1(int[] arr) {
        int count = 0;
        //外层循环缩小增量
        for (int gap = arr.length/2; gap > 0; gap /= 2) {
            //将按照增量（步长）获得的分组进行排序：将一个数据采用交换的方式倒着比较插入一个有序队列，类似于冒泡排序的第一步
            for (int i = gap; i < arr.length; i++) {
                for (int j = i-gap; j >= 0 ; j -= gap) {
                    if (arr[j] > arr[j+gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                    else break;//因为前面的元素都是有序的，若前一个元素<=当前元素，则整个序列都是有序的
                }
            }

//            System.out.println("第"+ ++count +"轮排序的结果：" + Arrays.toString(arr));
        }
    }

    /**
     * 移位法
     */
    public static void sort2(int[] arr) {
        int count = 0;
        //外层循环缩小增量
        for (int gap = arr.length/2; gap > 0; gap /= 2) {
            //将按照增量（步长）获得的分组进行排序：将一个数据采用交换的方式倒着比较插入一个有序队列，类似于冒泡排序的第一步
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;
                if (arr[j-gap] > arr[j]) {
                    while (j-gap >=0 && arr[j-gap] > temp) {
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
//            System.out.println("第"+ ++count +"轮排序的结果：" + Arrays.toString(arr));

        }
    }
}
