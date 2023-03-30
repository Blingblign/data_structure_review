package exer.algorithm;

/**
 * @author bling
 * @create 2022-10-09 9:33
 */
public class BinarySearch {
    /**
     * 有序数组arr
     * 二分查找非递归
     * @param arr
     * @return
     */
    public static int search(int[] arr,int value) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left+right)/2;
            if (value == arr[mid]) return mid;
            if (value < arr[mid]) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        throw new RuntimeException("值"+value+ "不存在");
    }
}
