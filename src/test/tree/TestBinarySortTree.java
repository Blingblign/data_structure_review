package test.tree;

import exer.tree.BinarySortTree;
import exer.tree.Node2;
import org.junit.Test;

/**
 * @author bling
 * @create 2022-10-06 22:53
 */
public class TestBinarySortTree {
    @Test
    public void test1() {
        BinarySortTree binarySortTree = new BinarySortTree();
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        Node2 root = binarySortTree.getBinarySortTree(arr);
        System.out.println(root);

        binarySortTree.delNode(5);
        binarySortTree.delNode(7);
        binarySortTree.delNode(10);
        binarySortTree.delNode(2);
        binarySortTree.delNode(3);
        binarySortTree.delNode(9);
        binarySortTree.delNode(1);
        binarySortTree.delNode(12);
        binarySortTree.delNode(12);
        System.out.println(binarySortTree.getRoot());
        System.out.println("删除后：");
        binarySortTree.inOrder();

    }
}
