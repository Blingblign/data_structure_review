package exer.recursion;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Stack;

/**八皇后问题
 * 任意两个皇后不能同一行，同一列，同一斜线
 * 用一维数组输出所有的排列组合
 * @author bling
 * @create 2022-09-26 15:58
 */
public class EightQueen {
    int maxsize = 8;
    int[] arr = new int[maxsize];
    Stack<Integer> stack = new Stack<>();
    public static int count = 0;
    /**
     * 根据第一个皇后的位置，得到其他皇后的位置
     */
    public boolean getArrange(int location1,int i) {
//        System.out.println("+++++++++++++++++++++++++++++");
        if (i >= maxsize-1) {
            count++;
            show();
            System.out.println();
            return true;
        }
        //location1表示前一个皇后的位置，location2表示后一个皇后的位置
        int sub = 0;
        int location2 = 0;
//        do {
//            location2 = (int)(Math.random() * 8);
//            sub = location1 - location2;
//        } while (sub == 0 || sub ==-1 || sub == 1);
//        getArrange(location2);
        for (int j = 0; j < maxsize; j++ ) {
            arr[i] = location1;
            arr[i+1] = j;
            sub = arr[i] - arr[i+1];
            if (sub == 0 || sub == -1 || sub == 1) {

            } else {
                getArrange(arr[i + 1], i + 1);
            }
        }
        return false;
    }
    public void show() {
//        while (stack.size() > 0) {
//            System.out.print(stack.pop() + "  ");
//        }
//        System.out.println(count);
//        System.out.println(count);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }

    /**
     * 放置第n个皇后（start from 0）
     */
    public void placeQueen(int n) {
        if (n == 8) {
            count++;
            show();
            System.out.println();
            return;
        }
        for (int i = 0; i < maxsize; i++) {
            arr[n] = i;
            //判断位置是否冲突
            if (judge(n)) {
                placeQueen(n+1);
            }
        }

    }

    /**
     * 判断位置是否冲突
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //不能位于同一列或对角线
            if (arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])) return false;
        }
        return true;
    }

}
