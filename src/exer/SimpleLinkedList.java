package exer;

import org.junit.Test;

/**
 * @author bling
 * @create 2022-09-24 14:58
 * 自定义一个单链表，用于显示英雄排名信息
 */
public class SimpleLinkedList {
    HeroNode head;

    public SimpleLinkedList() {
        this.head = new HeroNode();
    }

    /**
     * 遍历链表
     */
    public void list() {
        HeroNode temp = head.next;
        while (true) {
            if (head.next == null) {
                System.out.println("链表为空");
                break;
            }
            System.out.println(temp);
            if (temp.next == null) {
                //遍历到链表最后一个元素
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 添加英雄
     */
    public void add(HeroNode newHero) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                //遍历到链表最后一个元素
                temp.next = newHero;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 按排名添加英雄
     */
    public void addByOrder(HeroNode newHero) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = newHero;
                break;
            }
            if (temp.next.no > newHero.no) {
                newHero.next = temp.next;
                temp.next = newHero;
                break;
            } else if (temp.next.no == newHero.no) {
                System.out.println("排名为%d的英雄已存在，请重新添加！" + newHero.no + "已存在的英雄信息：" + temp.next);
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 修改英雄
     */
    public void update(HeroNode hero) {
        HeroNode temp = head;
        //根据排名no查找到英雄
        while (true) {
            if(temp.next == null) {
                if (temp == head) System.out.println("链表为空,无法修改！");
                else System.out.println("该英雄不存在，无法修改！");
                break;
            }
            if (temp.next.no == hero.no) {
                hero.next = temp.next.next;
                temp.next = hero;
                break;
            }
            temp = temp.next;

        }
    }

    /**
     * 删除英雄
     */
    public void deleteByNo(int no) {
        HeroNode temp = head;
        //根据排名no查找到英雄
        while (true) {

            if(temp.next == null) {
                if (temp == head) System.out.println("链表为空,无法删除！");
                else System.out.println("该英雄不存在，无法删除！");
                break;
            }
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;

        }
    }

    /**
     * 获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
     */
    public int size() {
        HeroNode temp = head;
        int size = 0;
        while (true) {
            if (temp.next == null) {
                break;
            }
            size++;
            temp = temp.next;
        }
        return size;
    }

    /**
     * 查找单链表中的倒数第 k (从1开始)个结点 【新浪面试题】
     * index = size-k+1
     */
    public HeroNode getByLastIndex(int lastIndex) {
//        int size = size();
//        if (size < lastIndex) return null;
        return getByIndex(size()-lastIndex + 1);
    }

    /**
     * 查找第k个节点（从1开始）
     */
    public HeroNode getByIndex(int index) {
        int count = 0;
        int size = size();
        if (index < 1 || index > size) {
            System.out.println("请重新输入索引，范围为：【1-" + size + "】");
            return null;
        }
        HeroNode temp = head;
        while (++count <= index) {
            temp = temp.next;

        }
        return temp;
    }

    /**
     * 单链表反转
     */
    public void reverse() {
        //空链表或只有一个元素
        if (head.next == null || head.next.next == null) return;
        HeroNode temp = new HeroNode();
        HeroNode cur = head.next;
        HeroNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            cur = next;
        }
        head.next = temp.next;
    }

    /**
     * 将单链表逆序打印
     */
    public void printByReverse(HeroNode node) {
        if (node.next != null) {
            printByReverse(node.next);
        }
        System.out.println(node);
    }
    public void printByReverse() {
        printByReverse(head.next);
    }

    /**
     * 合并两个有序的单链表，合并之后的链表依然有序
     */
    public static SimpleLinkedList merge(SimpleLinkedList list1,SimpleLinkedList list2) {
        HeroNode cur = list1.head.next;
        HeroNode another = list2.head.next;
        HeroNode reverseNode = new HeroNode();
        HeroNode next = null;
        while (true) {
            if (cur!=null && another != null) {
                if (cur.no < another.no) {
                    //将小的数加入新链表
                    next = cur.next;
                    cur.next = reverseNode.next;
                    reverseNode.next = cur;
                    cur = next;
                } else {
                    next = another.next;
                    another.next = reverseNode.next;
                    reverseNode.next = another;
                    another = next;
                }
            } else if (cur != null) {
                next = cur.next;
                cur.next = reverseNode.next;
                reverseNode.next = cur;
                cur = next;
            } else if (another != null) {
                next = another.next;
                another.next = reverseNode.next;
                reverseNode.next = another;
                another = next;
            } else break;//遍历完退出循环

        }
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.head.next = reverseNode.next;
        return simpleLinkedList;

    }
}

