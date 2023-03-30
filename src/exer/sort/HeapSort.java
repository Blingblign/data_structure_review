package exer.sort;

/**
 * 堆排序:现将数组（二叉树）构造成一个大顶堆，再将最大元素“下沉”,与最后一个元素交换
 * 重新调整堆结构，使之成为一个大顶堆，得到次大元素，依次类推，得到一个有序序列。
 * {4，6，8，5，9}
 * @author bling
 * @create 2022-09-29 20:39
 */
public class HeapSort {
    int[] arr;

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        //从最后一个非叶子节点往前将所有以非叶子节点为根节点的树都构造成大顶堆
        for (int i = arr.length/2 -1; i >=0 ; i--) {
            sort(arr,i, arr.length);
        }
        for (int j = arr.length-1; j > 0; j--) {
            //将最大元素“下沉”
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            //重新构造大顶堆
            sort(arr,0,j);
        }
    }

    /**
     * 从下至上构建大顶堆
     * 前提：i 的左子树和右子树均已为大顶堆
     * @param arr   需排序数组
     * @param i     第i个非叶子节点
     * @param length 数组长度
     */
    public void sort(int[] arr,int i, int length) {
        for (int k = 2*i + 1; k < length; k = 2*i + 1) {
            int temp = arr[i];
            //让k指向i的子节点的较大值
            if (k+1 < length && arr[k] < arr[k+1]) {
                k++;
            }
            if (arr[k] > arr[i]) {
                arr[i] = arr[k];
                arr[k] = temp;
                i = k;
            } else break;
        }

    }

}
