package test;

import org.junit.Test;

/**
 * @author bling
 * @create 2023-02-09 18:39
 */
public class RegExp {
    @Test
    public void testReg() {
        String phone = "13024111112";
        boolean matches = phone.matches("^1[3-9]\\d{9}$");
        System.out.println(matches);
    }
    @Test
    public void testJson() {

    }
}
