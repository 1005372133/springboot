package cn.wmyskxz.springboot.mapper;

import cn.wmyskxz.springboot.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM student")
    List<Student> findAll();

    @Select("SELECT count(1) FROM student")
    int count();


    @Delete("DELETE FROM student WHERE id = #{value}")
    int del(int id);
}
