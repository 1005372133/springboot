package cn.wmyskxz.springboot.service;


import cn.wmyskxz.springboot.common.BaseService;
import cn.wmyskxz.springboot.dao.StudentDao;
import cn.wmyskxz.springboot.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




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
        student.setPwd(student.getPwd());
        student.setUsername(student.getUsername());

        dao.insert(student);
        return student;
    }
}
