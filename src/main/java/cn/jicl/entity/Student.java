package cn.jicl.entity;

import lombok.Data;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/23 08:10
 * @Description:
 */
@Data
public class Student {
    private String name;
    private Integer age;

    public void init() {
        System.out.println("初始化...");
    }

    public void destory() {
        System.out.println("销毁...");
    }

}
