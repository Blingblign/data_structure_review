package test.tree;

import exer.tree.HuffmanTree;
import exer.tree.Node;
import org.junit.Test;
import sun.nio.cs.ext.ISO2022_CN;

import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

/**
 * @author bling
 * @create 2022-09-30 10:36
 */
public class TestHuffmanTree {
    @Test
    public void test2() {
        HuffmanTree huffmanTree = new HuffmanTree();
        String s = "i like like like java do you like a java";
        String str = "I like learning Java啊哈啊啊啊 forever ! 我永远喜欢学习爪哇🐂🐎🐂🐎🐂🐎🐂🐎";
        byte[] bytes = str.getBytes();
        System.out.println("压缩前字节数：" + bytes.length);

        byte[] encodeBytes = huffmanTree.huffmanZip(bytes);
        System.out.println("压缩后字节数：" + encodeBytes.length);

        Map<Byte, String> huffmanCodes = huffmanTree.getHuffmanCodes();
        byte[] decodeBytes = huffmanTree.decode(encodeBytes, huffmanCodes);

        String s1 = new String(decodeBytes);
        System.out.println("解压后的文本：" + s1);

    }
    @Test
    public void test() {
        char c = 255;
        byte b = (byte)c;
        int i = c;
        System.out.println(i);
        System.out.println(b);
        byte b1 = 1;
        int i1 = b1 & 0xff;
        System.out.println(Integer.toBinaryString(i1));

//        System.out.println("--------------");
//        String s = Integer.toUnsignedString(b1, 2);
//        System.out.println(s);  System.out.println(i1);

    }
    @Test
    public void test1() throws UnsupportedEncodingException {
        String s = "🐎zxc";
        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        int temp = bytes[0];
        temp |= 256;
        String s2 = Integer.toBinaryString(temp);
        System.out.println(s2.substring(s2.length()-8));
        System.out.println(bytes.length);
        String s1 = new String(bytes, 0, bytes.length, StandardCharsets.US_ASCII);
        System.out.println(s1);
    }
    @Test
    public void test3() {
        String s = "1010";
        int anInt = Integer.parseInt(s, 2);
        System.out.println(anInt);
        System.out.println(Integer.toString(-23, 2));
        System.out.println(Integer.toBinaryString(23));
    }

}
