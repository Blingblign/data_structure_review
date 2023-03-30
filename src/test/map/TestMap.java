package test.map;

import exer.map.Emp;
import exer.map.MyHashMap;
import org.junit.Test;

/**
 * @author bling
 * @create 2022-09-28 21:22
 */
public class TestMap {

    @Test
    public void testMap() {
        MyHashMap<Integer, Emp> map = new MyHashMap<>();
        Emp emp1 = new Emp(1, "小明");
        Emp emp2 = new Emp(2, "小李");
        Emp emp3 = new Emp(3, "小黄");
        Emp emp4 = new Emp(4, "小刘");
        Emp emp5 = new Emp(19, "小🐎");
        Emp emp6 = new Emp(17, "小🐂");
        map.put(emp1.getId(),emp1);
        map.put(emp2.getId(),emp2);
        map.put(emp3.getId(),emp3);
        map.put(emp4.getId(),emp4);
        map.put(emp5.getId(),emp5);
        map.put(emp6.getId(),emp6);
        Emp emp = map.get(19);
//        System.out.println(emp);
        Emp remove = map.remove(19);
        Emp remove1 = map.remove(4);
        System.out.println("移除的元素为"+remove);
        System.out.println("移除的元素为"+remove1);
        map.list();

    }
}
