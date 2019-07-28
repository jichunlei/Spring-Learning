package cn.jicl.dao;

import cn.jicl.entity.Plane;
import org.springframework.stereotype.Repository;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/27 15:23
 * @Description: TODO
 */
@Repository
public class PlaneDao extends BaseDao<Plane> {
    @Override
    public Plane get() {
        return new Plane();
    }

    @Override
    public void add(Plane plane) {
        System.out.println("生产飞机...");
    }
}
