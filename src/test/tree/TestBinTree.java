package test.tree;

import exer.tree.BinTree;
import exer.tree.HeroNode;
import org.junit.Test;

/**
 * @author bling
 * @create 2022-09-29 9:36
 */
public class TestBinTree {
    @Test
    public void testBinTree() {
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        BinTree binTree = new BinTree();
        binTree.setRoot(root);
        System.out.println("前序遍历：");
        binTree.preOrder();
        System.out.println("=============================");
//        System.out.println("中序遍历：");
//        binTree.inOrder();
//        System.out.println("=============================");
//        System.out.println("后序遍历：");
//        binTree.postOrder();
//        System.out.println("=============================");
//
//        System.out.println("前序查找：");
//        binTree.preOrderSearch(5);
//        System.out.println("=============================");
//        HeroNode.count = 0;
//
//        System.out.println("中序查找：");
//        binTree.inOrderSearch(5);
//        System.out.println("=============================");
//        HeroNode.count = 0;
//
//        System.out.println("后序查找：");
//        binTree.postOrderSearch(5);
//        System.out.println("=============================");

//        System.out.println("删除节点及其子节点：");
//        boolean delete = binTree.delete(5);
//        System.out.println("是否删除：" + delete);
//        System.out.println("前序遍历：");
//        binTree.preOrder();
//        System.out.println("=============================");

        System.out.println("删除节点，用子节点替代删除节点：");
        boolean delete2 = binTree.delete2(4);
        System.out.println("是否删除：" + delete2);
        System.out.println("前序遍历：");
        binTree.preOrder();
        System.out.println("=============================");

    }

    @Test
    public void test2() {
        System.err.println("你好");
    }
}
