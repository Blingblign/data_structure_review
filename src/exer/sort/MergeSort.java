package exer.sort;

/**
 * 归并排序：
 * 1.使用递归将数组细分：左递归，右递归
 * 2.合并：比较左右两个子序列依次将较小值放入临时数组中
 * 3.从临时数组将结果回原数组
 * @author bling
 * @create 2022-09-27 16:27
 */
public class MergeSort {
    public static void sort(int[] arr, int begin, int end, int[] temp) {
        if (begin >= end) return;
        int mid = (begin + end) / 2;
        //向左递归
        sort(arr, begin, mid, temp);
        //向右递归
        sort(arr,mid + 1, end, temp);
        //归并
        merge(arr, begin, end, temp);
    }

    /**
     * 将左右两个有序序列合并成一个有序序列
     */
    public static void merge(int[] arr, int begin, int end, int[] temp) {
        int i = begin;
        int mid = (begin + end) / 2;
        int index = 0;//临时数组索引
        int j = mid + 1;
        //遍历左右两个有序序列将其合并成一个
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[index++] =arr[i++];
            } else temp[index++] =arr[j++];
        }
        //将未遍历完的序列放入临时数组中
        while (i <= mid) {
            temp[index++] =arr[i++];
        }
        while (j <= end) {
            temp[index++] =arr[j++];
        }
        //将临时数组排序好的结果返回给原数组
        index = 0;
        while (begin <= end) {
            arr[begin++] =temp[index++];
        }
    }
}
