package exer.sort;

/**
 * @author bling
 * @create 2022-09-27 11:38
 */
public class QuickSort {
    /**
     * 以数组中间数作为基准值，当遇到基准值时，指针停下，交换指针的值后继续比较
     * @param arr 数组
     * @param left 左边界
     * @param right 有边界
     */
    public static void sort1(int[] arr, int left, int right) {
        if (left > right) return;
        int pivot = arr[(left + right) / 2];
        int l = left;
        int r = right;
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;//找到左边大于等于基准值的数,找到基准值停下
            }
            while (arr[r] > pivot) {
                r -=1;//找到右边小于等于基准值的数
            }
            if (l == r) break;
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //避免两个指针同时遇到了相同的基准值 比如基准值为4，中间为4 3 7 4，
            // 遇到基准值，就让另一边指针继续移动
            if (arr[l] == pivot) {
                r--;
            } else if (arr[r] == pivot) {
                l++;
            }

        }
        //循环结束
        l++;
        r--;
        sort1(arr,left,r);
        sort1(arr,l,right);

    }

    public static void sort2(int[] arr, int begin, int end) {
        if (begin > end) return;
        int pivot = arr[begin];
        int left = begin;
        int right = end;
        int temp = 0;
        while (left != right) {
            //此处一定要让右边先走，两个指针相遇时才能
            while (arr[right] >= pivot && left < right) {
                right--;
            }
            while (arr[left] <= pivot && left < right) {
                left++;
            }

            if (left != right) {
                //交换
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        //相等结束循环，将基准值放在指针位置
        arr[begin] = arr[right];
        arr[right] = pivot;
        sort2(arr,begin,--right);
        sort2(arr,++left,end);
    }
}
