package exer.map;

/**
 * @author bling
 * @create 2022-09-28 15:33
 */
public class Emp {
    private Integer id;
    private String name;
    private String address;

    public Emp(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" + "id=" + id + ", name='" + name + '\'' + ", address='" + address + '\'' + '}';
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
