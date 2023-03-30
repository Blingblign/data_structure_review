package exer.tree;

/**
 * 顺序存储二叉树
 * @author bling
 * @create 2022-09-29 12:24
 */
public class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组长度为空，不能使用二叉树遍历...");
        }
        System.out.print(arr[index] + " ");
        if ((2 * index + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        if ((2 * index + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
