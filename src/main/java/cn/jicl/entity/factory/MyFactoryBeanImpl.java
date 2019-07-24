package cn.jicl.entity.factory;

import cn.jicl.entity.Student;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/24 19:31
 * @Description:
 */
public class MyFactoryBeanImpl implements FactoryBean<Student> {
    /**
     * @Description: 创建对象
     * @return: cn.jicl.entity.Student
     * @auther: xianzilei
     * @date: 2019/7/24 19:31
     **/
    public Student getObject() throws Exception {
        Student student = new Student();
        student.setName("xianzilei");
        student.setAge(10);
        return student;
    }

    /**
     * @Description: 获取对象类型
     * @return: java.lang.Class<?>
     * @auther: xianzilei
     * @date: 2019/7/24 19:33
     **/
    public Class<?> getObjectType() {
        return Student.class;
    }

    /**
     * @Description: 是否是单例模式
     * @return: boolean
     * @auther: xianzilei
     * @date: 2019/7/24 19:37
     **/
    public boolean isSingleton() {
        return false;
    }
}
