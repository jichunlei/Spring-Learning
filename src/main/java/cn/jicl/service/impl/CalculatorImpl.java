package cn.jicl.service.impl;

import cn.jicl.service.Calculator;
import org.springframework.stereotype.Service;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/28 09:54
 * @Description: 接口实现类
 */
@Service
public class CalculatorImpl implements Calculator {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double sub(double a, double b) {
        return a - b;
    }

    @Override
    public double mul(double a, double b) {
        return a * b;
    }

    @Override
    public double div(double a, double b) {
        return a / b;
    }
}
