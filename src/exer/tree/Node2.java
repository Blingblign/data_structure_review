package exer.tree;

/**
 * @author bling
 * @create 2022-10-06 22:50
 */
public class Node2 {
    private int data;
    private Node2 left;
    private Node2 right;

    public Node2(int data) {
        this.data = data;
    }
    /**
     * 添加二叉排序树的结点
     * @return
     */
    public void addNode(Node2 node) {
        if (node == null) return;
        if (node.getData() < this.getData()) {
            if (this.getLeft() == null) {
                this.setLeft(node);
            } else {
                this.getLeft().addNode(node);
            }
        } else {
            if (this.getRight() == null) {
                this.setRight(node);
            } else {
                this.getRight().addNode(node);
            }
        }

    }

    /**
     * 查找需要删除的结点
     */
    public Node2 searchNode(int value) {
        if (value == this.getData()) return this;
        if (value < this.getData()) {
            if (this.getLeft() == null) return null;
            return this.getLeft().searchNode(value);
        }
        if (this.getRight() == null) return null;
        return this.getRight().searchNode(value);
    }

    /**
     * 查找需要删除的结点的父结点
     */
    public Node2 searchParent(int value) {
        if ((this.getLeft() != null && this.getLeft().getData() == value) || (this.getRight() != null && this.getRight().getData() == value)) {
            return this;
        }
        if (value < this.getData() && this.getLeft() != null) {
            return this.getLeft().searchParent(value);
        } else if (this.getRight() != null) {
            return this.getRight().searchParent(value);
        }
        return null;
    }

    /**
     * 删除结点
     */
    public void delNode(Node2 node) {
        if (this.getLeft() != null && node.getData() == this.getLeft().getData()) {
            if (node.getLeft() != null && node.getRight() != null) {

            } else if (node.getLeft() != null) {
                //只有一个子树的结点
                this.setLeft(node.getLeft());
            } else if (node.getRight() != null){
                this.setRight(node.getRight());
            } else {
                //叶子结点直接删除
                this.setLeft(null);
            }
        } else if (this.getRight() != null && node.getData() == this.getRight().getData()) {

        } else {
            
        }
    }

    /**
     * 前序遍历
     * @return
     */
    public void preOrder() {
        System.out.println(this);
        if (this.getLeft() != null) {
            this.getLeft().preOrder();
        }
        if (this.getRight() != null) {
            this.getRight().preOrder();
        }
    }

    /**
     * 中序遍历
     * @return
     */
    public void inOrder() {
        if (this.getLeft() != null) {
            this.getLeft().inOrder();
        }
        System.out.println(this);
        if (this.getRight() != null) {
            this.getRight().inOrder();
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node2 getLeft() {
        return left;
    }

    public void setLeft(Node2 left) {
        this.left = left;
    }

    public Node2 getRight() {
        return right;
    }

    public void setRight(Node2 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node2{" + "data=" + data + '}';
    }
}
