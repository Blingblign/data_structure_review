package exer.sort;

/**
 * @author bling
 * @create 2022-09-26 21:06
 */
public class BubbleSort {

    public static void bubbleSort1(int[] arr) {
        int temp ;
        for (int i = 0; i < arr.length-1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void bubbleSort2(int[] arr) {
        int temp ;
        boolean flag = true;//标识变量是否做过交换
        for (int i = 0; i < arr.length-1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;

                }
            }
            if (flag) break;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
