package cn.jicl.entity;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/22 08:37
 * @Description:
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Person {
    private String name = "小明";

    private Integer age;

    private Student student;

    private List<Object> list;

    private Map<String, Object> map;

    private Properties properties;

    public Person() {
        System.out.println("无参构造器...");
    }

    public Person(String name, Integer age) {
        System.out.println("有参构造器...");
        this.name = name;
        this.age = age;
    }
}
