package exer.map;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author bling
 * @create 2022-09-28 15:31
 */
public class MyHashMap<K,V> {
    private final int maxsize = 16;
    private Node<K,V>[] elements;
    private int elementCount;

    public MyHashMap() {
    }
    /**
     * 添加
     */
    public void add(V v) {
    }

    /**
     * 添加元素
     */
    public void put(K k, V v) {
        elements = init();
        Node<K,V> temp = new Node<>(k, v);
        //求元素在数组中存放的位置
        int index = hash(k);
        if (elements[index] != null) {
            if (elements[index].key.hashCode() == k.hashCode() && Objects.equals(k,elements[index].key)) {
                elements[index].value = v;
            } else {
                Node<K, V> preNode,next;
                preNode = elements[index];
                while ((next = preNode.next) != null) {
                    if (k.hashCode() == next.key.hashCode() && Objects.equals(k,next.key)) {
                        next.value = v;
                        break;
                    } else {
                        preNode = next;
                    }
                }
                //是否到达链表末尾
                if (next == null) {
                    preNode.next = temp;
                    elementCount++;
                }
            }
        } else {
            elements[index] = temp;
            elementCount++;
        }
    }
    /**
     * 初始化底层数组
     */
    public Node<K, V>[] init() {
        if (elements != null) return  elements;
        @SuppressWarnings({"unchecked"})
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[maxsize];
        return newTable;
    }

    /**
     * 遍历map中所有元素
     */
    public void list() {
        int count = 0;
        for (int i = 0; i < elements.length; i++) {
            if (count > elementCount) break;
            if (elements[i] != null) {
                System.out.println(elements[i].value);
                count++;
                Node<K,V> next = elements[i].next;
                while (next != null) {
                    System.out.println(next.value);
                    count++;
                    next = next.next;
                }
            }
        }
    }

    /**
     * 根据key找到value值
     */
    public V get(K key) {
        int index = hash(key);
        if (elements[index] != null) {
            if (key.hashCode() == elements[index].key.hashCode() && Objects.equals(key,elements[index].key)) {
                return elements[index].value;
            } else {
                Node<K,V> next = elements[index].next;
                while (next != null) {
                    if (key.hashCode() == next.key.hashCode() && Objects.equals(key,next.key)) {
                        return next.value;
                    }
                    next = next.next;
                }
            }
        }
        return null;
    }

    /**
     * 根据key删除value并返回value
     */
    public V remove(K key) {
        int index = hash(key);
        if (elements[index] != null) {
            if (key.hashCode() == elements[index].key.hashCode() && Objects.equals(key,elements[index].key)) {
                V oldValue = elements[index].value;
                elements[index] = elements[index].next;
                return oldValue;
            } else {
                Node<K,V> preNode = elements[index];
                Node<K,V> next;
                while ((next = preNode.next) != null) {
                    if (key.hashCode() == next.key.hashCode() && Objects.equals(key,next.key)) {
                        preNode.next = next.next;
                        return next.value;
                    }
                    preNode = next;
                }
            }
        }
        return null;
    }

    /**
     * 计算元素在数组上的位置
     * @param key
     * @return
     */
    public int hash(K key) {
        if (key instanceof Integer) {
            return (Integer) key % maxsize;
        }
        else return key.hashCode() | (maxsize-1);
    }

    /**
     *
     */
    static class Node<K, V> extends LinkedList<V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K k, V v) {
            this.key = k;
            this.value = v;
        }
        public boolean hasNext() {
            return next != null;
        }
        public Node<K, V> next() {
            return next;
        }

    }
}
