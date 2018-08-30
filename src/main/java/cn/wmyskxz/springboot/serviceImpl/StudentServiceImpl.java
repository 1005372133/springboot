package cn.wmyskxz.springboot.serviceImpl;

import cn.wmyskxz.springboot.dao.StudentDao;
import cn.wmyskxz.springboot.pojo.Student;
import cn.wmyskxz.springboot.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentDao dao;

    @Override
    public List<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public int del(int id) {
        return dao.del(id);
    }

    @Override
    public Student insert(Student student) {

        student.setId(student.getId());
        student.setAge(student.getAge());
        student.setSex(student.getSex());
        student.setPwd(student.getPwd());
        student.setUsername(student.getUsername());

        dao.insert(student);
        return student;
    }
}
