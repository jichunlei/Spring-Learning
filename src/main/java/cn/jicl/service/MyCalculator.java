package cn.jicl.service;

import org.springframework.stereotype.Service;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/28 09:54
 * @Description: 菲接口实现类
 */
@Service
public class MyCalculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        return a / b;
    }
}
