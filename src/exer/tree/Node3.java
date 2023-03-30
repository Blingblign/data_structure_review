package exer.tree;

/**
 * @author bling
 * @create 2022-10-08 14:47
 */
public class Node3 {
    int value;
    int height;
    Node3 left;
    Node3 right;

    public Node3(int value) {
        this.value = value;
        this.height = 1;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node3 getLeft() {
        return left;
    }

    public void setLeft(Node3 left) {
        this.left = left;
    }

    public Node3 getRight() {
        return right;
    }

    public void setRight(Node3 right) {
        this.right = right;
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

    @Override
    public String toString() {
        return "Node3{" + "value=" + value + ", height=" + height + '}';
    }
}
