package exer;

import java.nio.file.FileStore;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author bling
 * @create 2022-09-24 20:45
 */
public class SingleCircleLinkedList {
    HeroNode first;
    HeroNode last;

    /**
     * 添加元素
     */
    public void add(HeroNode newNode) {
        if (first == null) {
            first = newNode;
            last = newNode;
        }else {
            last.next = newNode;
            last = newNode;
        }
        last.next = first;
    }


    /**
     * 遍历
     */
    public void list() {
        HeroNode temp = first;
        while (true) {
            if (first == null) {
                System.out.println("链表为空");
                break;
            }
            System.out.println(temp);
            if (temp.next == first) {
                //遍历到链表最后一个元素
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 约瑟夫问题：n个人，从第k个小孩开始，m=2
     */
    public  void soluteJoSePhu(int m,int n,int k) {
        HeroNode cur = null;
        int count = 0;
        //构造约瑟夫环
        while (count++ < n) {
            if( count == 1) {
                first = new HeroNode(1,"","");
                first.next = first;
                cur = first;
                continue;
            }
            HeroNode heroNode = new HeroNode(count, "", "");
            cur.next= heroNode;
            heroNode.next = first;
            cur = heroNode;
        }
//        cur.next = first;
        //输出约瑟夫环
        list();
        System.out.println("================================");
        //输出出队元素
        count = 1;
        cur =first;//报数起始位置 k=2,
        for (int i = 0; i < k-1; i++) {
            cur = cur.next;
        }
        HeroNode next = null;
        while (cur.next != cur) {
            next = cur.next;
            count++;
            if (count == m) {
                //元素出队，删除元素
                System.out.println(next);
                cur.next = next.next;
                cur = cur.next;
                count = 1;
                continue;
            }
            cur = next;
        }
        System.out.println(cur);

    }

    /**
     * 输出某个元素
     */
//    public void deleteByNo(int no) {
//        HeroNode temp = head;
//        //根据排名no查找到英雄
//        while (true) {
//
//            if(temp.next == null) {
//                if (temp == head) System.out.println("链表为空,无法删除！");
//                else System.out.println("该英雄不存在，无法删除！");
//                break;
//            }
//            if (temp.next.no == no) {
//                temp.next = temp.next.next;
//                break;
//            }
//            temp = temp.next;
//
//        }
//    }
}
