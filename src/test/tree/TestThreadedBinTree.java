package test.tree;

import exer.tree.HeroNode;
import exer.tree.ThreadedBinaryTree;
import org.junit.Test;

/**
 * @author bling
 * @create 2022-09-29 17:15
 */
public class TestThreadedBinTree {
    @Test
    public void test() {
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        ThreadedBinaryTree tree = new ThreadedBinaryTree(root);
//        tree.inOrderThread();
////        System.out.println(node4.getLeft());
////        System.out.println(node4.getRight());
//        tree.inOrder();
        tree.postOrderThread();
        tree.postOrder();
    }

}
