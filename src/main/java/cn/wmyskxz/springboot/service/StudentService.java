package cn.wmyskxz.springboot.service;


import cn.wmyskxz.springboot.common.BaseService;
import cn.wmyskxz.springboot.dao.StudentDao;
import cn.wmyskxz.springboot.pojo.Student;
import cn.wmyskxz.springboot.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService extends BaseService {
    @Autowired
   StudentDao dao;

    public StudentDao getDao() {
        return dao;
    }

/*    public List<Student> findAll1() {
        return dao.findAll1();
    }

    public int count(BasePage page) {
        return this.getDao().count(page);
    }
    public int count1() {
        return dao.count1();
    }*/

    public int del(String id) {
        return dao.del(id);
    }

    public Student insert(Student student) {

        student.setId(cn.wmyskxz.springboot.util.UUID.randomUUID10());
        student.setAge(student.getAge());
        student.setSex(student.getSex());
        //加密
        // student.setPwd(PasswordUtils.encryptPassword(student.getPwd()));
        student.setPwd(student.getPwd());
        student.setUsername(student.getUsername());

        dao.insert(student);
        return student;
    }


    public Student login (String username,String pwd){
        return dao.login(username,pwd);
    }

    public List<Student> queryOrgByAccount(String username){
        return dao.queryOrgByAccount(username);
    }

    public String queryOrgByPwd(String username){return  dao.queryOrgByPwd(username);}
}
