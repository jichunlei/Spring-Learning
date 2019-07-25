package cn.jicl.entity;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/25 18:50
 * @Description:
 */
@Data
@Repository//注入时id默认是类名首字母小写
//@Repository("car111"),也可以自己指定注入id
@Scope(value = "singleton")//默认单例模式
//@Scope(value = "prototype")
public class Car {
    private String name;
    private double price;
}
