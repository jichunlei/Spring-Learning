package cn.jicl.service;

import cn.jicl.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/30 22:04
 * @Description: TODO
 */
@Service
public class EmpService {

    @Autowired
    private EmpDao empDao;


    /**
     * @Description: TODO
     * @param name1 1
     * @param id1 2
     * @param name2 3
     * @param id2 4
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/30 22:10
     **/
    @Transactional
    public void updateName(String name1,int id1,String name2,int id2) throws FileNotFoundException {
        empDao.update(name1,id1);
        empDao.update(name2,id2);
        new FileInputStream("D/hahahhaahh.txt");
//        int i=1/0;
    }
}
