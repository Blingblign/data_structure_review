package exer2023;

/**
 * 二分查找：给定一个排序数组和待查找数m,返回数组中值等于m的下标，没有则返回-1；
 * @author bling
 * @create 2023-03-27 15:49
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE -1;
        int b = 2;
        int c = a + b;
        System.out.println( c);
        int[] arr = {1, 5, 7, 13, 13, 26, 27, 37};
        int m = 39;
        int i1 = binarySearch(arr, m);
        int i2 = binarySearchRecursively(arr, 0,arr.length-1,m);
        System.out.println("i1 = " + i1 + ",i2 = " + i2);
    }
    //循环
    public static int binarySearch(int[] arr, int m) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;//存在整数溢出的情况，mid = low + (high-low)/2
            if (arr[mid] == m) {
                return mid;
            } else if (arr[mid] < m) {
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return -1;
    }

    //递归
    public static int binarySearchRecursively(int[] arr, int left, int right, int m) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (arr[mid] == m) return mid;
        else if (arr[mid] < m) return binarySearchRecursively(arr, mid + 1, right, m);
        else return binarySearchRecursively(arr, left, mid - 1, m);

    }
}
