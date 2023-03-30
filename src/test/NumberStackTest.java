package test;

import exer.NumberStack;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.ObjectProperty;
import org.junit.Test;

/**
 * @author bling
 * @create 2022-09-25 16:43
 */
public class NumberStackTest {
    @Test
    public void test2() {
        calculate2("132*14-13/3+12*12/14-13+5+9-11*13");
        System.out.println("=====正确结果为："+ (132*14-13/3+12*12/14-13+5+9-11*13));
    }

    /**
     * 计算表达式的值 String expression = "72*2+12-(3+5/2)-(1+5)"的值
     */
//    public void calculate(String expression) {
//        //创建数栈、符号栈
//        NumberStack<Integer> numberStack = new NumberStack<>();
//        NumberStack<Character> operateStack = new NumberStack<>();
//        //解析表达式:1.判断是否为操作符;
//        // 2.判断操作符的优先级大小(数字越大优先级越高);
//        // 当前操作符优先级<=栈顶元素优先级时-->符号栈、数栈弹出元素进行计算，
//        // 3.解析操作符，调用对应的方法进行计算将计算结果入数栈，当前操作符入符号栈
//        //4.解析完表达式，弹出栈中元素进行计算-->操作栈空，数栈只有一个元素，返回数栈栈顶元素
//        int index = 0;
//        int num1 = 0;
//        int num2 = 0;
//        int oper = 0;
//        String mulNum = "";//标识一个多位数
//        label:while (index < expression.length()) {
//            char indexChar = expression.substring(index, index + 1).charAt(0);
//            while (! isOperate(indexChar)) {
//
//                //不是运算符，检查索引后一个位置1.先判断索引是否为最后一个元素 2.是否为字符，以此类推
//                mulNum += indexChar;
//                if (index == expression.length()-1) {
//                    //将尾部元素入栈，结束方法
//                    numberStack.push(Integer.parseInt(mulNum));
//                    break label;
//                }
//                index++;
//                indexChar = expression.substring(index, index + 1).charAt(0);
//            }
//            //入数栈
//            numberStack.push(Integer.parseInt(mulNum));
//            mulNum = "";
//
//            //当前字符是运算符，判断符号栈中是否有元素
//            while (operateStack.peek() != null && priority(indexChar) <= priority(operateStack.peek())) {
//                //有元素,判断优先级
//                    //当前运算符优先级<= 栈中元素优先级-->出栈计算
//                    num1 = numberStack.pop();
//                    num2 = numberStack.pop();
//                    oper = operateStack.pop();
//                    int result = cal(num1, num2, oper);
//                    //将计算结果入栈
//                    numberStack.push(result);
//            }
//            //没有元素或里面元素优先级更小则直接入栈
//            operateStack.push(indexChar);
//            index++;
//
//        }
//        //计算栈中剩余元素
//        while (operateStack.peek() != null) {
//            num1 = numberStack.pop();
//            num2 = numberStack.pop();
//            oper = operateStack.pop();
//            int result = cal(num1, num2, oper);
//            //将计算结果入栈
//            numberStack.push(result);
//        }
//        System.out.println("表达式 "+ expression +" 结果为："+ numberStack.peek());
//    }
    public void calculate2(String expression) {
        //创建数栈、符号栈
        NumberStack<Integer> numberStack = new NumberStack<>();
        NumberStack<Character> operateStack = new NumberStack<>();
        //解析表达式:1.判断是否为操作符;
        // 2.判断操作符的优先级大小(数字越大优先级越高);
        // 当前操作符优先级<=栈顶元素优先级且栈顶不为'('时-->符号栈、数栈弹出元素进行计算，
        // 3.解析操作符，调用对应的方法进行计算将计算结果入数栈，当前操作符入符号栈
        //4.解析完表达式，弹出栈中元素进行计算-->操作栈空，数栈只有一个元素，返回数栈栈顶元素
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        String mulNum = "";//标识一个多位数
        label:while (index < expression.length()) {
            char indexChar = expression.substring(index, index + 1).charAt(0);
            while (! isOperate(indexChar)) {

                //不是运算符，检查索引后一个位置1.先判断索引是否为最后一个元素 2.是否为字符，以此类推
                mulNum += indexChar;
                if (index == expression.length()-1) {
                    //将尾部元素入栈，结束方法
                    numberStack.push(Integer.parseInt(mulNum));
                    break label;
                }
                index++;
                indexChar = expression.substring(index, index + 1).charAt(0);
            }
            //入数栈
            numberStack.push(Integer.parseInt(mulNum));
            mulNum = "";

            //当前字符是运算符，判断符号栈中是否有元素

            while ('(' !=indexChar && operateStack.peek() != null  && priority(indexChar) <= priority(operateStack.peek())) {
                //有元素,判断优先级
                //当前运算符优先级<= 栈中元素优先级-->出栈计算
                num1 = numberStack.pop();
                num2 = numberStack.pop();
                oper = operateStack.pop();
                int result = cal(num1, num2, oper);
                //将计算结果入栈
                numberStack.push(result);
            }
            //没有元素或里面元素优先级更小则直接入栈
            operateStack.push(indexChar);
            index++;

        }
        //计算栈中剩余元素
        while (operateStack.peek() != null) {
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            oper = operateStack.pop();
            int result = cal(num1, num2, oper);
            //将计算结果入栈
            numberStack.push(result);
        }
        System.out.println("表达式 "+ expression +" 结果为："+ numberStack.peek());
    }

    /**
     * 判断是否为操作符
     */
    public boolean isOperate(char oper) {
        return  oper == '*' || oper == '/' || oper == '+' || oper == '-' || oper == '(' || oper == ')';
    }

    /**
     * 根据操作符进行计算
     * num1,num2分别为出栈的第一个、第二个元素
     */
    public int cal(int num1, int num2, int oper) {
        switch (oper) {
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
            case '-':
                return num2 - num1;
            case '+':
                return num1 + num2;
            default:
                throw new RuntimeException("请输入正确的操作符!");
        }
    }

    /**
     * 判断操作符优先级大小，数字越大，优先级越高
     */
    public int priority(int oper) {
        switch (oper) {
            case '(':
                return 2;
            case '*':
            case '/':
                return 1;
            case '-':
            case '+':
                return 0;
            case ')':
                return -1;
            default:
                throw new RuntimeException("请输入正确的操作符!");
        }
    }


    @Test
    public void test1() {
        int i1 = 67;
        char c1 = (char)i1;
        System.out.println(67 == c1);
        System.out.println(c1);
        NumberStack<Integer> numberStack = new NumberStack(5);
//        System.out.println(numberStack.isEmpty());
//        numberStack.pop();
//        numberStack.peek();
        numberStack.push(1);
        numberStack.push(2);
        numberStack.push(2);
        numberStack.push(4);
        numberStack.push(4);
        numberStack.push(4);
        System.out.println(numberStack.size());
        System.out.println(numberStack.pop());
        System.out.println(numberStack.pop());
        System.out.println(numberStack.pop());
        System.out.println(numberStack.pop());
        System.out.println(numberStack.size());



    }
}
