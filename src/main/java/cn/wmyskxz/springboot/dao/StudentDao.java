package cn.wmyskxz.springboot.dao;

import cn.wmyskxz.springboot.pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();

    int count();

    int del(int id);

    int insert(Student student);
}
