package cn.jicl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/30 21:59
 * @Description: TODO
 */
@Repository
public class EmpDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int update(String name, int id) {
        String sql="UPDATE emp SET empname=? WHERE id=?";
        int update = jdbcTemplate.update(sql, name, id);
        System.out.println("更新数据条数:"+update);
        return update;
    }
}
