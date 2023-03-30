package test.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author bling
 * @create 2022-10-29 11:07
 */
public class Unknown {
    /**
     * 测试list集合、stream流对空数据的处理
     */
    @Test
    public void testStream() {
        ArrayList<String> list = new ArrayList<>();
        String s = null;
        list.add(s);
        list.add("aa");
        list.add("bb");
        System.out.println("集合的大小为："+list.size());
        System.out.println(list.get(0) == null);
        list.stream().collect(Collectors.toList());
        for (String s1 : list) {
            System.out.println(".."+s1);
        }
    }
    @Test
    public void testByteToInteger() {
        String s = "1011";
        Integer decode = Integer.valueOf(s, 2);
        int anInt = Integer.parseInt(s, 2);
        System.out.println("anInt:"+anInt);
        System.out.println("decode:"+decode);
        Integer d2 = decode | 2<<8;
        System.out.println("d2:"+Integer.toBinaryString(d2));
        String s1 = Integer.toBinaryString(decode);
        System.out.println("Integer->BinaryString:"+s1);

    }

    /**
     * foreach是否是迭代器模式
     */
    @Test
    public void testForeach() {
        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person("zz",12));
        list.add(new Person("cc",15));

        //list.forEach(item->{
        //    item.setName("dd");
        //});
        for (Person person : list) {
            person = new Person("mm",13);
        }
        System.out.println(list);

    }
}
class Person {
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
