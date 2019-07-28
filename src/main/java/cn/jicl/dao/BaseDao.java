package cn.jicl.dao;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/27 15:16
 * @Description: TODO
 */
public abstract class BaseDao<T> {
    public abstract T get();

    public abstract void add(T t);
}
