package cn.jicl.bean;

import cn.jicl.service.Calculator;
import cn.jicl.service.MyCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/28 10:22
 * @Description: AOP测试类
 */
@ContextConfiguration(locations = "classpath:config/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * @Description: 使用JdbcTemplate操作数据库
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/28 10:42
     **/
    @Test
    public void test01() {
        String sql="UPDATE emp SET empname=? WHERE id=?";
        int update = jdbcTemplate.update(sql, "王五", 1);
        System.out.println("更新数据条数:"+update);
    }
}
