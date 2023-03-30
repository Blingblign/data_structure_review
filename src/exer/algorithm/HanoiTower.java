package exer.algorithm;

/**
 * 分治法
 * @author bling
 * @create 2022-10-09 10:17
 */
public class HanoiTower {
    public static int count = 0;

    /**
     * 使用分治算法解决汉诺塔问题
     * @param nums 需要移动的圆盘数
     * @param a 起始柱a
     * @param b 中间柱b
     * @param c 最后柱c
     */
    public static void hanoiTower(int nums, char a, char b, char c) {
        if (nums == 1) {
            System.out.println("第1个盘从" + a +" -> " + c );
            count ++;
        }
        else {
            //圆盘分为两部分：最下面一个盘和上面所有盘
            //先把上面所有盘从a -> b
            hanoiTower(nums-1,a,c,b);
            //再把最下面盘从a -> c
            System.out.println("第"+nums+"个盘从" + a +" -> " + c );
            count ++;
            //最后把上面所有盘从b -> c
            hanoiTower(nums-1,b,a,c);
        }
    }
}
