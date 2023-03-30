package exer;

/**
 * @author bling
 * @create 2022-09-24 16:32
 */
public class HeroNode {
    int no;
    String name;
    String nickName;
    HeroNode next;

    public HeroNode() {
    }

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + ", nickName='" + nickName + '\'' + '}';
    }
}
