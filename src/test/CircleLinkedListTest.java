package test;

import exer.HeroNode;
import exer.SingleCircleLinkedList;
import org.junit.Test;

/**
 * @author bling
 * @create 2022-09-24 21:02
 */
public class CircleLinkedListTest {
    @Test
    public void test() {
        SingleCircleLinkedList linkedList = new SingleCircleLinkedList();
        linkedList.add(new HeroNode(1,"林冲","豹子头"));
        linkedList.add(new HeroNode(2,"卢俊义","水麒麟"));
        linkedList.add(new HeroNode(3,"公孙胜","入云龙"));
        linkedList.add(new HeroNode(4,"吴用","智多星"));
        //        linkedList.list();
        //        System.out.println("==========================");
        linkedList.add(new HeroNode(5,"宋江","呼保义"));
        linkedList.add(new HeroNode(6,"宋江","呼保义"));
        linkedList.add(new HeroNode(7,"秦明","霹雳火"));
        linkedList.add(new HeroNode(8,"呼延灼","双鞭"));
        linkedList.list();

    }

    @Test
    public void testJoSePhu() {
        SingleCircleLinkedList linkedList = new SingleCircleLinkedList();
        linkedList.soluteJoSePhu(2,5,1);
    }
}
