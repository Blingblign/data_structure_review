package exer;

import org.junit.Test;
import sun.text.resources.cldr.lag.FormatData_lag;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author bling
 * @create 2022-09-26 8:59
 */
public class Calculator {

    /**
     * 将中缀表达式转换为逆波兰表达式
     * "1+((2+3)×4)-5" =》 中缀的表达式对应的List
     * 即 "1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
     * 将得到的中缀表达式对应的 List => 后缀表达式对应的 List
     * ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] =》 ArrayList [1,2,3,+,4,*,+,5,–]
     */
    public void cal(String expression) {
        List infixExpressionList = toInfixExpressionList(expression);
        List suffixExpressionList = getSuffixExpressionList(infixExpressionList);
        parseSuffixExpressionList(suffixExpressionList);

    }

    /**
     * 解析后缀表达式list
     * [1,2,3,+,4,*,+,5,–]
     */
    public void parseSuffixExpressionList(List<String> suffixExpressionList) {
        Stack<Integer> integerStack = new Stack<>();
        for (String str : suffixExpressionList) {
            if(str.matches("\\d+")) {
                integerStack.push(Integer.parseInt(str));
            } else {
                Integer num1 = integerStack.pop();
                Integer num2 = integerStack.pop();
                int result = calculate(num1, num2, str.charAt(0));
                integerStack.push(result);
            }
        }
        System.out.println(integerStack.peek());
    }

    /**
     * 将中缀表达式转换成后缀表达式
     * [1, +, (, (, 2, +, 3, ), ×, 4, ), -, 5] -->
     * @param infixExpressionList List
     * @return
     */
    public List getSuffixExpressionList(List<String> infixExpressionList) {
        Stack<String> nums = new Stack<>();
        Stack<String> opers = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        for (String str : infixExpressionList) {
            if(str.matches("\\d+")) nums.push(str);
            else if ("(".equals(str) || opers.size() == 0 || "(" .equals(opers.peek()) ) {
                opers.push(str);
            }
            else if (")".equals(str)) {
                //遇到右括号符号栈元素出栈入数栈直到遇到"(",丢弃这一对括号
                do {
                    nums.push(opers.pop());
                } while (!"(" .equals(opers.peek()));
                opers.pop();
            }
            else {
                while (opers.size() != 0 && !"(".equals(opers.peek()) && priority(opers.peek()) >= priority(str)) {
                    nums.push(opers.pop());
                }
                opers.push(str);
            }
        }
        //将符号栈元素依次弹出入数栈，逆序输出数栈，即为逆波兰表达式
        while(opers.size() > 0) {
            nums.push(opers.pop());
        }
        while(nums.size()>0) {
            opers.push(nums.pop());
        }
        while(opers.size() > 0) {
            list.add(opers.pop());
        }

        return list;
    }

    /**
     * 将中缀表达式放到对应的list中
     */
    public List toInfixExpressionList(String expression) {
        int index = 0;
        ArrayList<String> list = new ArrayList<>();
        int length = expression.length();
        String mulNum = "";
        char indexChar;
        while(index < length) {
            indexChar = expression.charAt(index);
            if (indexChar < '0' || indexChar > '9') {
                //非数字
                list.add(indexChar+"");
                index++;
            } else {
                //是数字，检查下一位是否为数字 s.matches("\\d")
                while (index < length && (indexChar = expression.charAt(index)) >= '0' && indexChar <= '9') {
                    mulNum += indexChar;
                    index++;
                }
                list.add(mulNum);
                mulNum = "";
            }
        }
        return list;
    }

    /**
     * 根据操作符进行计算
     * num1,num2分别为出栈的第一个、第二个元素
     */
    public int calculate(int num1, int num2, int oper) {
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
     * 判断是否为操作符
     */
    public boolean isOperate(String oper) {
        return  false;
    }

    /**
     *
     * 判断操作符优先级大小，数字越大，优先级越高
     *
     */
    public int priority(String oper) {
        switch (oper) {
            case "*":
            case "/":
                return 1;
            case "-":
            case "+":
                return 0;

            default:
                throw new RuntimeException("请输入正确的操作符!");
        }
    }
}
