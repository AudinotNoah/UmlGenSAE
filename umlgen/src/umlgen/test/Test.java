package umlgen.test;

import java.util.List;

public abstract class Test {
    private String name;
    private int age;
    private List<String> tags;

    private final static String pourtest = null;

    public Test() {
    }

    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void sayHello() {
        System.out.println("Hello " + name);
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    @Override
    public String toString() {
        return "Test{name='" + name + "', age=" + age + ", tags=" + tags + "}";
    }
}
