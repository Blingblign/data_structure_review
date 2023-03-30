package exer.serach;

/**
 * 插值查找
 * @author bling
 * @create 2022-09-28 11:28
 */
public class InsertSearch {
    public static int search(int[] arr, int target, int begin, int end) {
        if (begin > end || target < arr[begin] || target > arr[end]) return -1;
        if (arr[begin] == arr[end]) return target == arr[begin] ? 1 : 0;
        int mid = begin + (target-arr[begin])/(arr[end]-arr[begin])*(end-begin);
        if (target > arr[mid]) {
            begin =mid + 1;
            return search(arr,target,begin,end);
        } else if (target < arr[mid]) {
            end = mid - 1;
            return search(arr,target,begin,end);
        } else {
            System.out.println("存在该值，索引为：" + mid);
            return mid;
        }
    }
}
