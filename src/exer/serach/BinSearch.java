package exer.serach;

/**
 * @author bling
 * @create 2022-09-27 21:35
 */
public class BinSearch {
    public static void search(int[] arr, int num, int begin, int end) {
        if (begin > end) {
            System.out.println("找不到元素");
            return;
        }
        int mid = (begin + end) / 2;
        if (arr[mid] == num) {
            System.out.println("找到元素，索引为：" + mid);
            System.out.println("元素有：");
            System.out.print( arr[mid] + " ");
            int left = mid,right = mid;

            while(left > 0) {
                if(arr[--left] == num) System.out.print(arr[mid]  + " ");
            }
            while (right < arr.length-1) {
                 if(arr[++right] ==num) System.out.print(arr[mid]  + " ");
            }
        }
        else if (arr[mid] < num) {
            search(arr,num,mid + 1,end);
        } else search(arr,num,begin,mid-1);

    }
}
