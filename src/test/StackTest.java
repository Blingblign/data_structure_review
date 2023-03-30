package test;

import com.sun.istack.internal.NotNull;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.junit.Test;

import javax.naming.spi.ResolveResult;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author bling
 * @create 2022-09-24 23:57
 */
public class StackTest {
    @Test
    public void test3() {
        char c= (char)49;
        System.out.println(c);
    }
    @Test
    public void test1() {

        System.out.println(Integer.parseInt('5' + ""));
        char c1 = '1';
        String s23 = "1";
        int i1 = c1;
        System.out.println(i1);
        String expression = "73*2*2-5+1-5+3-4/2";
        Stack<Integer> integerStack = new Stack<>();//数栈
        Stack<Character> characterStack = new Stack<>();//符号栈
        //解析表达式
        String[] intStrs = expression.split("\\d+");
        int[] nums = new int[intStrs.length];
        for (int i = 0; i < intStrs.length; i++) {
            nums[i] = Integer.parseInt(intStrs[i]);
        }
        String[] charStrs = expression.split("[\\*\\-\\+\\/]");
        char[] chars = new char[charStrs.length];
        for (int i = 0; i < charStrs.length; i++) {
            chars[i] = charStrs[i].charAt(0);
        }
        while (true) {
            if (characterStack.peek() == null) {
                characterStack.push(chars[0]);
            }
        }
    }
    @Test
    public void test2() {
//        Stack stack = new Stack();
//        stack.push(1);
//        stack.push(2);
//        Object index = stack.pop();
        int[] maxRightArr = getMaxRightArr2(new int[]{2, 6, 3, 8, 10, 9});
        System.out.println(Arrays.toString(maxRightArr));
    }

    /**
     * 数组元素随机无序的，要求打印出所有元素右边第一个大于该元素的值
     * 示例：
     * 给定数组：[2,6,3,8,10,9]
     * 返回数组：[6,8,8,10,-1,-1]
     * @param arr
     * @return
     */
    public int[] getMaxRightArr(int[] arr) {
        int[] resources = new int[arr.length];
        Stack<Object> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && (int)stack.peek() < arr[i]) {
                stack.pop();
                resources[count++] = arr[i];

            }
            stack.push(arr[i]);
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            resources[count++] = -1;
        }
        return resources;

    }

    public int[] getMaxRightArr2(@NotNull int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        int[] resources = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (! stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                Integer index = stack.pop();
                resources[index] = arr[i];

            }
            stack.push(arr[i]);
        }
        while (! stack.isEmpty()) {
            resources[stack.pop()] = -1;
        }
        return resources;

    }

}
