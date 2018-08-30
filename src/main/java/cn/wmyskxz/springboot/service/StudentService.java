package cn.wmyskxz.springboot.service;


import cn.wmyskxz.springboot.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    int count();

    int del(int id);

    Student insert(Student student);
}
