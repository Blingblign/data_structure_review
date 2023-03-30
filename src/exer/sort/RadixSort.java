package exer.sort;

/**
 * 基数排序:
 * 先求数组中元素的最高位数
 * 按照个位、十位、百位...依次排入桶中，然后从桶中取出元素放回原数组，一直到最高位
 * @author bling
 * @create 2022-09-27 20:31
 */
public class RadixSort {
    public static void sort(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        int digit = (max + "").length();//最大位数
        //十个桶，每个桶容量设置为数组arr最大长度
        int[][] bucket = new int[10][arr.length];
        //记录每个桶中元素个数
        int[] bucketSizes = new int[arr.length];
        //按位依次放入桶中，再从桶中取出
        for (int i = 0,n = 1; i < digit; i++,n *= 10) {
            //放入桶中
            for (int j = 0; j < arr.length; j++) {
                int remain = arr[j] / n % 10;
                bucket[remain][bucketSizes[remain]++] = arr[j];
            }
            //从桶中取出
            int index = 0;//数组索引
            for (int j = 0; j < bucket.length; j++) {
                for (int k = 0; k < bucketSizes[j]; k++) {
                    arr[index++] = bucket[j][k];
                }
                //标记桶中元素清零
                bucketSizes[j] = 0;
            }


        }
    }
}
