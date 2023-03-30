package test.algorithm;

import exer.algorithm.KMPSearch;
import org.junit.Test;
import sun.plugin2.message.OverlayWindowMoveMessage;

/**
 * @author bling
 * @create 2022-10-10 10:46
 */
public class TestKMP {
    @Test
    public void test() {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = " ";
        KMPSearch kmpSearch = new KMPSearch();
        int[] next = kmpSearch.getNext(str2);
        int index = kmpSearch.kmpSearch(str1, str2, next);
        System.out.println(str1.indexOf(str2));
        System.out.println(index);
    }
}
