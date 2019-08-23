package org.zhoup.springboot.service;

import org.springframework.data.domain.Page;
import org.zhoup.springboot.pojo.Student;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface StudentService {

    //查找所有学生
    public List<Student> findAll();

    //添加+修改学生信息
    public void addStudent(Student student);

    //删除学生信息
    public void deleteStudent(Integer sno);

    //查找单个学生
    public Student findOne(Integer sno);

    //批量添加和修改
    public void addList(List<Student> students);

    //批量删除
    public void deleteAll(List<Student> students);
    //分页查询
    public Page findBookNoCriteria(Integer currentpage,Integer pagesize);

}
