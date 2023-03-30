package exer.tree;

/**
 * @author bling
 * @create 2022-09-30 20:57
 */
public class Node implements Comparable<Node> {
    private Byte data;
    private int weight;
    private Node left;
    private Node right;

    public Node(Byte data, int weight, Node left, Node right) {
        this.data = data;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    public Node(int weight) {
        this.weight = weight;
    }

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", weight=" + weight + '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
