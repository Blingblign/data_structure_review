package test.tree;

import exer.tree.AVLTree;
import exer.tree.Node3;
import org.junit.Test;

/**
 * @author bling
 * @create 2022-10-08 17:10
 */
public class TestAVLTree {
    @Test
    public void test() {
        AVLTree avlTree = new AVLTree();
        int[] nums = {3, 2, 1, 4, 5, 6, 7, 10, 9, 8};
        Node3 root = avlTree.buildTree(nums);
//        avlTree.delete(root,4);
//        avlTree.delete(root,6);
//        avlTree.inOrder();
        avlTree.bfs();

    }
}
