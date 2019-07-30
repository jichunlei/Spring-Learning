package cn.jicl.bean;

import cn.jicl.dao.EmpDao;
import cn.jicl.service.Calculator;
import cn.jicl.service.EmpService;
import cn.jicl.service.MyCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/28 10:22
 * @Description: AOP测试类
 */
@ContextConfiguration(locations = "classpath:config/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcTest {

    @Autowired
    EmpService empService;

    /**
     * @Description: 使用JdbcTemplate操作数据库
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/28 10:42
     **/
    @Test
    public void test01() throws FileNotFoundException {
        empService.updateName("咸子磊",1,"咸子磊",2);
    }
}
