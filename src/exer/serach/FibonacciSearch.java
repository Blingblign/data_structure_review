package exer.serach;

import java.util.Arrays;

/**
 * @author bling
 * @create 2022-09-28 11:46
 */
public class FibonacciSearch {
    private static int[] fib;
    static int maxsize = 20;

    public static int search(int[] arr, int target) {
        //获取斐波那契数列
        getFioSequence();
        System.out.println(Arrays.toString(fib));
        int low = 0;
        int high = arr.length-1;
        int k = 0;
        //将数组元素个数对应的斐波那契数列的某个值
        while (high > fib[k]-1) k++;
        //数组复制，大于arr长度的部分默认为0
        int[] temp = Arrays.copyOf(arr, fib[k]);
        //将临时数组大于arr长度的元素赋值为arr数组最后一个元素的值
        for (int i = arr.length; i < temp.length; i++) {
            temp[i] = arr[arr.length-1];
        }
        while (low <= high) {
            if (k == 0) {
                if (arr[low] == target) {
                    return low;
                } else break;
            }
            //将temp按照黄金分割点分割为两部分，比较
            int mid = low + fib[k-1] -1;
            System.out.println(temp[mid]);
            if (target < temp[mid]) {
                high = mid -1;
                k--;
            } else if (target > temp[mid]) {
                low = mid +1;
                k -= 2;
            } else {
                if (mid <= arr.length-1) return mid;
                //得到的是补全的值
                else return arr.length-1;
            }

        }

        return -1;
    }

    /**
     * 构建斐波那契数列
     */
    public static void getFioSequence() {
        fib = new int[maxsize];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < maxsize; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
    }
}
