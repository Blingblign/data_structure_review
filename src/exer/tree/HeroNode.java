package exer.tree;

/**
 * @author bling
 * @create 2022-09-29 8:54
 */
public class HeroNode {
    private int id;
    private String name;
    private String nickName;
    private HeroNode left;
    private HeroNode right;
    //标记左、右指针的类型：0表示指向子节点，1表示指向前驱或后继节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public static int count = 0;

    public HeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 1) 如果该非叶子节点 A 只有一个子节点 B，则子节点 B 替代节点 A
     * 2) 如果该非叶子节点 A 有左子节点 B 和右子节点 C，则让左子节点 B 替代节点 A。
     */
    public boolean delete2(int id) {
        if (this.left != null && this.left.getId() == id) {
            if (this.left.left != null) {
                this.left = this.left.left;
            }else {
                this.left = this.left.right;
            }
            return true;
        }
        if (this.right != null && this.right.getId() == id) {
            if (this.right.left != null) {
                this.right = this.right.left;
            }else {
                this.right = this.right.right;
            }
            return true;
        }
        boolean isDeleted = false;
        if (this.left != null) {
            isDeleted= this.left.delete2(id);
        }
        if (isDeleted) {
            return true;
        }
        if (this.right != null) {
            return this.right.delete2(id);
        }
        return false;
    }

    /**
     * 删除节点及其子节点
     */
    public boolean delete(int id) {
        HeroNode parent = this,left,right;
        boolean isDeleted = false;
        if ((left = parent.getLeft()) != null) {
            if (left.getId() == id) {
                parent.setLeft(null);
                return true;
            }
            isDeleted =  left.delete(id);
        }
        if (isDeleted) {
            return true;
        }
        if ((right = parent.getRight()) != null) {
            if (right.getId() == id) {
                parent.setRight(null);
                return true;
            }
            isDeleted = right.delete(id);
        }

        return isDeleted;
    }

    /**
     * 前序遍历
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

    /**
     * 后序遍历
     * @return
     */
    public void postOrder() {
        if (this.getLeft() != null) {
            this.getLeft().postOrder();
        }
        if (this.getRight() != null) {
            this.getRight().postOrder();
        }
        System.out.println(this);

    }

    /**
     * 前序查找
     * @return
     */
    public HeroNode preOrderSearch(int id) {
        count++;
        if (this.getId() == id) {
            System.out.println("前序查找次数为:"+ count);
            return this;
        }
        HeroNode resultNode = null;
        //向左递归查找
        if (this.getLeft() != null) {
            resultNode= this.getLeft().preOrderSearch(id);
        }
        if (resultNode != null) return resultNode;
        //向右递归查找
        if (this.getRight() != null) {
            resultNode = this.getRight().preOrderSearch(id);
        }
        return resultNode;
    }
    /**
     * 中序查找
     * @return
     */
    public HeroNode inOrderSearch(int id) {
        HeroNode resultNode = null;
        //向左递归查找
        if (this.getLeft() != null) {
            resultNode= this.getLeft().inOrderSearch(id);
        }
        if (resultNode != null) return resultNode;
        count++;
        //查询根节点
        if (this.getId() == id) {
            System.out.println("中序查找次数为:"+ count);
            return this;
        }
        //向右递归查找
        if (this.getRight() != null) {
            resultNode = this.getRight().inOrderSearch(id);
        }
        return resultNode;
    }

    /**
     * 后序查找
     * @return
     */
    public HeroNode postOrderSearch(int id) {
        HeroNode resultNode = null;
        //向左递归查找
        if (this.getLeft() != null) {
            resultNode= this.getLeft().postOrderSearch(id);
        }
        if (resultNode != null) return resultNode;
        //向右递归查找
        if (this.getRight() != null) {
            resultNode = this.getRight().postOrderSearch(id);
        }
        if (resultNode != null) return resultNode;
        count++;
        //查询根节点
        if (this.getId() == id) {
            System.out.println("后序查找次数为:"+ count);
            return this;
        }
        return null;
    }






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "id=" + id + ", name='" + name + '\'' + ", nickName='" + nickName + '\'' + '}';
    }


}
