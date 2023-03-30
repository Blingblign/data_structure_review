package test.tree;

import exer.tree.ArrBinaryTree;
import org.junit.Test;

/**
 * @author bling
 * @create 2022-09-29 12:29
 */
public class TestArrBinTree {
    @Test
    public void test1() {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.preOrder();
    }
}
