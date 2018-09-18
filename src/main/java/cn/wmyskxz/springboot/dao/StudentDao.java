package cn.wmyskxz.springboot.dao;

import cn.wmyskxz.springboot.common.BaseDao;
import cn.wmyskxz.springboot.common.BasePage;
import cn.wmyskxz.springboot.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao extends BaseDao {
/*    List<Student> findAll(BasePage var1);

    List<Student> findAll1();

    int count(BasePage var1);

    int count1();*/

    int del(String id);

    int insert(Student student);

    Student login(@Param("username") String username, @Param("pwd")String pwd);
}
