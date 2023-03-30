package test;

import exer.HeroNode;
import exer.SimpleLinkedList;
import org.junit.Test;

/**
 * @author bling
 * @create 2022-09-24 16:12
 */
public class LinkedListTest {
    @Test
    public void test() {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        linkedList.add(new HeroNode(1,"林冲","豹子头"));
        linkedList.add(new HeroNode(4,"卢俊义","水麒麟"));
        linkedList.add(new HeroNode(5,"公孙胜","入云龙"));
        linkedList.add(new HeroNode(8,"吴用","智多星"));
//        linkedList.list();
//        System.out.println("==========================");
        linkedList.addByOrder(new HeroNode(9,"宋江","呼保义"));
        linkedList.addByOrder(new HeroNode(14,"宋江","呼保义"));
        linkedList.addByOrder(new HeroNode(18,"秦明","霹雳火"));
        linkedList.addByOrder(new HeroNode(21,"呼延灼","双鞭"));
//        linkedList.list();
//        System.out.println("==========================");
//
//        linkedList.update(new HeroNode(3,"王熙凤","丹凤眼"));
//        linkedList.list();
//        System.out.println("==========================");
////        linkedList.deleteByNo(4);
////        linkedList.deleteByNo(5);
////        linkedList.deleteByNo(6);
//
//        linkedList.list();
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.getByIndex(8));
//        System.out.println(linkedList.getByLastIndex(8));
//        linkedList.reverse();
//        linkedList.list();
//        System.out.println("逆序打印======================");
//        linkedList.printByReverse();
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.add(new HeroNode(3,"林冲","豹子头"));
        simpleLinkedList.add(new HeroNode(6,"卢俊义","水麒麟"));
        simpleLinkedList.add(new HeroNode(9,"公孙胜","入云龙"));
        simpleLinkedList.add(new HeroNode(12,"吴用","智多星"));
        simpleLinkedList.addByOrder(new HeroNode(14,"宋江","呼保义"));
        simpleLinkedList.addByOrder(new HeroNode(16,"宋江","呼保义"));
        simpleLinkedList.addByOrder(new HeroNode(21,"秦明","霹雳火"));
        simpleLinkedList.addByOrder(new HeroNode(25,"呼延灼","双鞭"));
        SimpleLinkedList merge = SimpleLinkedList.merge(linkedList, simpleLinkedList);
        merge.reverse();
        merge.list();


    }
}
