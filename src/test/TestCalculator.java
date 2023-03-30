package test;

import exer.Calculator;
import org.junit.Test;

import java.util.List;

/**
 * @author bling
 * @create 2022-09-26 9:51
 */
public class TestCalculator {
    @Test
    public void test1() {
        String s = "";
//        System.out.println(s.charAt(0));
        Calculator calculator = new Calculator();
        List infixExpressionList = calculator.toInfixExpressionList("1+((2+3)×4)-5");
        System.out.println("中缀表达式：" + infixExpressionList);
        List suffixExpressionList = calculator.getSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式：" + suffixExpressionList);
    }
    @Test
    public void test2() {
        Calculator calculator = new Calculator();
        String expression = "1+((2+3)*4-6*12+4/3)-5*12+4-5*3/2";
        calculator.cal(expression);
        System.out.println("正确结果为：" + (1+((2+3)*4-6*12+4/3)-5*12+4-5*3/2));
    }
    @Test
    public void test3() {
        final String SYMBOL = "\\+|-|\\*|/|\\(|\\)";
        String s = "--";
        System.out.println(s.matches(SYMBOL));


    }
}
