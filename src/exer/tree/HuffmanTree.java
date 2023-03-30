package exer.tree;

import org.junit.runner.notification.StoppedByUserException;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bling
 * @create 2022-09-30 9:52
 */
public class HuffmanTree {
    private Node root;
    private final Map<Byte,String> huffmanCodes = new HashMap<>();
    private int lastByteLength;

    public void decode(String s, Map<String,Byte> map) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        int start = 0;
        while (index++ < s.length()) {
            if (map.get(s.substring(start,index)) != null) {
                stringBuilder.append(s, start, index);
                start = index;
            }
        }
    }

    public Node getHuffmanTree(byte[] bytes) {
//        String str = "I like learning Java forever ! 我永远喜欢学习爪哇";
//        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        //map用于存放各个byte和它出现的次数
        HashMap<Byte, Integer> byteMap = new HashMap<>();
        //list用于存放生成的node结点
        ArrayList<Node> nodes = new ArrayList<>();
        //统计byte出现的次数，构造Node结点
        for (byte b : bytes) {
            byteMap.merge(b, 1, Integer::sum);
        }
        for (Map.Entry<Byte, Integer> entry : byteMap.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            nodes.add(node);
        }
        //构造huffman树
        while (nodes.size() > 1) {
            //使用集合工具类的自然排序方法，集合元素必须实现comparable接口
            Collections.sort(nodes);
            //取出最小的两个结点作为子节点，生成新的根节点并放入集合中
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.getWeight() + rightNode.getWeight(), leftNode, rightNode);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
//        root = nodes.get(0);
        return nodes.get(0);
    }
    public void getHuffmanEncodeTable() {
        getHuffmanEncodeTable(root,"",new StringBuilder());
    }


    /**
     * 构造Huffman编码表，规定左边路径为0，右边路径为1
     * @param node Node
     * @param code 当前结点到父节点路径
     * @param stringBuilder 当前结点的父结点的编码
     */
    public void getHuffmanEncodeTable(Node node, String code, StringBuilder stringBuilder) {
        if (node != null) {
            StringBuilder builder = new StringBuilder(stringBuilder);
            builder.append(code);
            //当前结点为非叶子节点
            if (node.getData() == null) {
                //向左递归
                getHuffmanEncodeTable(node.getLeft(),"0", builder);
                //向右递归
                getHuffmanEncodeTable(node.getRight(),"1", builder);
            } else {
                //当前节点为叶子节点
                huffmanCodes.put(node.getData(), builder.toString());
            }
        }
    }

    /**
     * 按huffman编码压缩文本
     * @param bytes 需要被压缩的字节数组
     */
    public byte[] huffmanZip(byte[] bytes) {
        Node root = getHuffmanTree(bytes);
        setRoot(root);
        getHuffmanEncodeTable();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            //得到"1000101001..."
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println("编码后的字符串长度位：" + stringBuilder.length());
        //将字符串变成byte数组，数组的第一个字节用于存放不完整位的位数
        //
        int count = (stringBuilder.length()+7)/8;
        int leftCount = stringBuilder.length() % 8;
        bytes = new byte[count+1];
        bytes[0] = (byte)leftCount;
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            String substring;
            if (i + 8 <= stringBuilder.length()) {
                substring = stringBuilder.substring(i, i + 8);
            } else {
                substring = stringBuilder.substring(i);
            }
            int intValue = Integer.parseInt(substring, 2);
            bytes[i/8+1] = (byte)intValue;
        }
        return bytes;
    }

    /**
     * 解码
     * @param bytes 用huffman编码编码后的字节数组
     */
    public byte[] decode(byte[] bytes,Map<Byte,String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        //先把字节数组用字符串拼接
        for (int i = 1; i < bytes.length; i++) {

            int temp = bytes[i];
            temp |= 256;
            String s = Integer.toBinaryString(temp);
            String substring;
            if (i == bytes.length-1 && bytes[0] != 0) {
                substring = s.substring(s.length() - bytes[0]);
            } else {
                substring = s.substring(s.length() - 8);
            }
            stringBuilder.append(substring);
        }
        HashMap<String, Byte> huffmanDecodes = new HashMap<>();
        ArrayList<Byte> byteList = new ArrayList<>();
        //将字符串按编码转成字节
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            huffmanDecodes.put(entry.getValue(),entry.getKey());
        }
        int start = 0;
        int end = 0;
        while (++end <= stringBuilder.length()) {
            String substring = stringBuilder.substring(start, end);
            Byte b = huffmanDecodes.get(substring);
            if (b != null) {
                byteList.add(b);
                start = end;
            }

        }
        bytes = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            bytes[i] = byteList.get(i);
        }
        return bytes;
    }

    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历
     */
    public void preOrder(Node root) {
        System.out.println(root);
        if (root.getLeft() != null) {
            preOrder(root.getLeft());
        }
        if (root.getRight() != null) {
            preOrder(root.getRight());
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Map<Byte, String> getHuffmanCodes() {
        return huffmanCodes;
    }
}
