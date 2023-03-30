package exer.tree;

import java.util.List;

/**
 * @author bling
 * @create 2022-09-29 8:54
 */
public class BinTree {
    protected HeroNode root;

    public BinTree() {
    }

    public BinTree(HeroNode root) {
        this.root = root;
    }

    public void add(List<HeroNode> list) {

    }

    /**
     * 将数组转换成二叉树
     */
    public static <T> BinTree fromArrToBinTree(T[] arr) {
        return null;
    }


    /**
     * 删除节点及其子节点
     * 如果是叶子节点，则直接删除；如果不是，则删除该子树
     */
    public boolean delete(int id) {
        if (root != null) {
            if (root .getId() == id) {
                root = null;
                return true;
            }
            else return root.delete(id);
        }
        return false;
    }

    /**
     * 1) 如果该非叶子节点 A 只有一个子节点 B，则子节点 B 替代节点 A
     * 2) 如果该非叶子节点 A 有左子节点 B 和右子节点 C，则让左子节点 B 替代节点 A。
     * @param id
     * @return
     */
    public boolean delete2(int id) {
        if (root != null) {
            if (root.getId() == id) {
                if (root.getLeft() != null) {
                        root = root.getLeft();
                } else {
                    root = root.getRight();
                }
                return true;
            }
            return root.delete2(id);
        }
        return false;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        if (root != null) {
            root.inOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (root != null) {
            root.postOrder();
        }
    }

    /**
     * 前序查找
     */
    public HeroNode preOrderSearch(int id) {
        if (root != null) {
            root.preOrderSearch(id);
        }
        return null;
    }

    /**
     * 中序查找
     * @return HeroNode
     */
    public HeroNode inOrderSearch(int id) {
        if (root != null) {
            root.inOrderSearch(id);
        }
        return null;
    }

    /**
     * 后序查找
     * @return
     */
    public HeroNode postOrderSearch(int id) {
        if (root != null) {
            root.postOrderSearch(id);
        }
        return null;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public HeroNode getRoot() {
        return root;
    }
}
