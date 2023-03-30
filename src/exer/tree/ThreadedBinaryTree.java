package exer.tree;

import java.util.Stack;

/**
 * 线索化二叉树
 * 将二叉树节点的空指针域指向该节点按某种遍历方式得到的前驱和后继节点
 * 前序线索化、中序线索化、后序线索化
 * @author bling
 * @create 2022-09-29 15:15
 */
public class ThreadedBinaryTree{
    private HeroNode root;
    private HeroNode pre;

    public ThreadedBinaryTree(HeroNode root) {
        this.root = root;
    }

    /**
     * 遍历中序线索化二叉树（非递归）
     */
    public void inOrder() {
        HeroNode node = root;
        while (node != null) {
            //先找到线索化二叉树起始节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            //找到后继节点
            while (node.getRightType() == 1) {
                System.out.println(node.getRight());
                node = node.getRight();
            }
            //去右子树里重新找下个起点，直到node的右子节点为空
            node = node.getRight();
        }

    }
    public void inOrderThread() {
        inOrderThread(root);
    }

    /**
     * 中序线索化
     */
    public void inOrderThread(HeroNode node) {
        if (node == null) return;
        //左子树中序线索化
        inOrderThread(node.getLeft());
        //根节点中序线索化
        if (node.getLeft() == null) {
            //left指向前驱节点
            node.setLeftType(1);
            node.setLeft(pre);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        //右子树中序线索化
        inOrderThread(node.getRight());

    }
    /**
     * 遍历后序线索化二叉树（非递归）
     */
    public void postOrder() {
        HeroNode node = root;
        Stack<HeroNode> nodeStack = new Stack<>();
        while (node != null) {
            //先找到线索化二叉树起始节点
            while (node.getLeftType() == 0) {
                nodeStack.push(node);
                node = node.getLeft();
            }
            System.out.println(node);
            //找到后继节点
            while (node.getRightType() == 1) {
                System.out.println(node.getRight());
                node = node.getRight();
            }
            if (node == nodeStack.peek()) {
                while (nodeStack.size() != 0) {
                    System.out.println(nodeStack.pop());
                }
                if (node == root) return;
            }
            //去右子树里重新找下个起点，直到node的右子节点为空
            node = node.getRight();
            if (node != null) nodeStack.push(node);
        }

    }

    /**
     *
     */
    public void postOrderThread() {
        postOrderThread(root);
    }


    /**
     * 后序线索化
     */
    public void postOrderThread(HeroNode node) {
        if (node == null) return;
        //左子树后序线索化
        postOrderThread(node.getLeft());
        //右子树后序线索化
        postOrderThread(node.getRight());
        //根节点后序线索化
        if (node.getLeft() == null) {
            //left指向前驱节点
            node.setLeftType(1);
            node.setLeft(pre);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

    }
}
