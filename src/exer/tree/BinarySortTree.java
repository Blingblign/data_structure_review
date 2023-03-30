package exer.tree;

import com.sun.org.apache.xerces.internal.dom.ParentNode;

/**
 * 二叉排序树
 * @author bling
 * @create 2022-10-06 22:34
 */
public class BinarySortTree {
    private Node2 root;

    public BinarySortTree() {
    }

    public BinarySortTree(Node2 root) {
        this.root = root;
    }
    public Node2 getBinarySortTree(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Node2 node2 = new Node2(arr[i]);
            addNode(node2);
        }
        return root;
    }

    public Node2 getRoot() {
        return root;
    }

    /**
     * 二叉排序树的创建
     */
    public void addNode(Node2 node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (root == null) {
            System.out.println("树为空，无法前序遍历");
        } else root.preOrder();
    }

    /**
     * 中序递归遍历
     */
    public void inOrder() {
        if (root == null) {
            System.out.println("树为空，无法前序遍历");
        } else root.inOrder();
    }

    /**
     *查找需要删除的结点
     * @param value
     * @return
     */
    public Node2 searchNode(int value) {
        if (root == null) return null;
        return root.searchNode(value);
    }

    /**
     * 查找需要删除的结点的父结点
     */
    public Node2 searchParent(int value) {
        if (root == null) return null;
        return root.searchParent(value);
    }

    /**
     * 删除结点
     * 1.叶子结点
     * 2.只有一个子树的结点
     * 3.有两个子树的结点
     */
    public void delNode(int value) {
        if (root == null) return;
        Node2 node = searchNode(value);
        if (node != null) {
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                return;
            }
            Node2 parent = searchParent(value);

                if (node.getLeft() != null && node.getRight() != null) {
                    //要删除的结点有两棵子树，找到左子树结点的最大值或右子树结点的最小值
                    int maxValue = getMaxNodeValue(node.getLeft());
                    delNode(maxValue);
                    node.setData(maxValue);
                } else if (node.getLeft() != null) {
                    //要删除的结点只有左子树
                    if (parent != null) {
                        if (parent.getLeft() != null && parent.getLeft().getData() == value) {
                            parent.setLeft(node.getLeft());
                        } else {
                            parent.setRight(node.getLeft());
                        }
                    } else root = node.getLeft();

                } else if (node.getRight() != null) {
                    //要删除的结点只有右子树
                    if (parent != null) {
                        if (parent.getLeft() != null && parent.getLeft().getData() == value) {
                            parent.setLeft(node.getRight());
                        } else {
                            parent.setRight(node.getRight());
                        }
                    } else root = node.getRight();

                } else {
                    //要删除的结点是叶子节点
                    if (parent != null) {
                        if (parent.getLeft() != null && parent.getLeft().getData() == value) {
                            parent.setLeft(null);
                        } else parent.setRight(null);
                    } else root = null;
                }
        } else System.out.println("未找到要删除的结点");
    }

    /**
     * 找到以node结点为根节点的二叉排序树的结点的最大值,并删除该结点
     */
    public int getMaxNodeValue(Node2 node) {
        Node2 target = node;
        while (target.getRight() != null) {
            target = target.getRight();
        }
        return target.getData();
    }

}
