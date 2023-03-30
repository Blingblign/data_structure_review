package exer.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bling
 * @create 2022-10-08 11:49
 */
public class AVLTree {
    private Node3 root;

    /**
     * 创建AVL树
     */
    public Node3 buildTree(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            root = insert(root,arr[i]);
        }
        return root;
    }


    /**
     * 求以node为根节点的树的高度
     */
    public int getHeight(Node3 root) {
        return  root == null ? 0 : Math.max(root.left == null ? 0 : root.left.height,root.right == null ? 0 : root.right.height) + 1;
    }

    /**
     * 单旋转LL
     */
    public Node3 rightRotate(Node3 root) {
        Node3 newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.height = getHeight(root);
        newRoot.height = getHeight(newRoot);
        return newRoot;
    }

    /**
     * 单旋转RR
     */
    public Node3 leftRotate(Node3 root) {
        Node3 newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.height = getHeight(root);
        newRoot.height = getHeight(newRoot);
        return newRoot;
    }

    /**
     * 双旋转LR
     * 先左旋再右旋
     */
    public Node3 leftRightRotate(Node3 root) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    /**
     * 双旋转RL
     * 先右旋再左旋
     */
    public Node3 rightLeftRotate(Node3 root) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

    /**
     * 向AVL树中添加元素
     * @param root
     * @param value
     * @return
     */
    public Node3 insert(Node3 root,int value) {
        if (root == null)
            return new Node3(value);
        if (value < root.value) {
            //向左子树上添加
            root.left = insert(root.left,value);
            if (getHeight(root.left) - getHeight(root.right) > 1) {
                if (value < root.left.value)
                    //LL,右旋转
                    return rightRotate(root);
                else
                    //LR,双旋转
                    return leftRightRotate(root);
            }
        } else {
            //向右子树上添加
            root.right = insert(root.right,value);
            if (getHeight(root.right) - getHeight(root.left) > 1) {
                if (value < root.right.value)
                    //RL,双旋转
                    return rightLeftRotate(root);
                else
                    //RR,左旋转
                    return leftRotate(root);
            }
        }
        root.height = getHeight(root);
        return root;
    }

    /**
     * 删除AVL树中的元素
     */
    public Node3 delete(Node3 root, int value) {
        if (root == null) {
            System.out.println("未找到要删除的结点，删除失败！");
            return null;
        }
        if (value == root.value) {
            if (root.left != null && root.right != null) {
                //要删除的结点有两棵子树，则在高度更大的子树上进行删除
                if (getHeight(root.left) > getHeight(root.right)) {
                    //删除左子树上值最大的结点，并将结点值赋给根节点
                    int maxValue = findMax(root.left).value;
                    root.value = maxValue;
                    root.left = delete(root.left,maxValue);
                } else {
                    //删除右子树上值最小的结点，并将结点值赋给根节点
                    int minValue = findMin(root.right).value;
                    root.value = minValue;
                    root.right = delete(root.right,minValue);
                }
            } else {
                //叶子结点或只有一个子树的结点
                root = (root.left != null ? root.left : root.right);
            }
        } else if (value < root.value) {
            //要删除的结点位于左子树上
            root.left = delete(root.left,value);
            //判断是否满足平衡条件
            if (getHeight(root.right) - getHeight(root.left) > 1) {
                if (getHeight(root.right.left) > getHeight(root.right.right)) {
                    //RL 双旋转
                    return rightLeftRotate(root);
                } else
                    //RR
                    return leftRotate(root);
            }
        } else {
            //要删除的结点位于右子树上
            root.right = delete(root.right,value);
            //判断是否满足平衡条件
            if (getHeight(root.left) - getHeight(root.right) > 1) {
                if (getHeight(root.left.right) > getHeight(root.left.left)) {
                    //LR 双旋转
                    return leftRightRotate(root);
                } else
                    //LL
                    return rightRotate(root);
            }
        }
        if (root != null)
            root.height = getHeight(root);
        return root;
    }

    /**
     * 找到结点值最大的结点
     */
    public Node3 findMax(Node3 root) {
        if (root == null)
            return null;
        if (root.right == null) {
            return root;
        }
        return findMax(root.right);
    }

    /**
     * 找到结点值最小的结点
     */
    public Node3 findMin(Node3 root) {
        if (root == null)
            return null;
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        root.inOrder();

    }

    /**
     * 广度优先遍历bfs
     */
    public void bfs() {
        Queue<Node3> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //移除队列头元素
            Node3 node = queue.remove();
            System.out.println(node);
            //头元素的子结点加入队列
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }


}
