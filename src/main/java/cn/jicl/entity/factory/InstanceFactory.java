package cn.jicl.entity.factory;

import cn.jicl.entity.Person;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/24 08:46
 * @Description: 静态工厂类
 */
public class InstanceFactory {

    public Person getInstance(String name, Integer age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        return person;
    }
}
