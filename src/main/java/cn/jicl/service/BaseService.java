package cn.jicl.service;

import cn.jicl.dao.BaseDao;
import cn.jicl.dao.CarDao;
import cn.jicl.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/27 15:25
 * @Description: TODO
 */
public class BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;

    public void add(T t) {
        baseDao.add(t);
    }
}
