package exer.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * 利用kmp算法查找字符串1中是否存在字符串2
 * @author bling
 * @create 2022-10-10 10:16
 */
public class KMPSearch {

    /**
     *
     * @param src
     * @param child
     * @param next
     * @return
     */
    public int kmpSearch(String src,String child, int[] next) {
        int i = 0;
        int j = 0;
        while ( i < src.length() && j < child.length()) {
            //j == -1 表示模式串与主串失配后一致往前回溯，都不满足条件，直接将主串指针后移一位，j指向模式串起点，重新开始寻找
            if (j == -1 || src.charAt(i) == child.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == child.length()) return i - j;
        return -1;
    }

    public int[] getNext(String child) {
        int[] next = new int[child.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < child.length()-1) {
            if (k == -1 || child.charAt(j) == child.charAt(k)) {
                k++;
                j++;
                //优化：abab,若b与主串失配，则模式串回溯到next[3]= 1 该处字符也为b，也不匹配，所以要双层回溯
                if (child.charAt(j) != child.charAt(k))
                    next[j] = k;
                else
                    next[j] = next[k];
            } else
                k = next[k];
        }
        return next;
    }

}
