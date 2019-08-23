package org.zhoup.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.zhoup.springboot.pojo.Student;
import org.zhoup.springboot.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@RestController     //rest风格的controller
public class StudentController {

    @Autowired
    StudentService studentService;

    //查找所有学生
    @RequestMapping("/findAll")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    //添加+修改学生信息
    @RequestMapping("/save")
    public void addStudent(Student student) {
        studentService.addStudent(student);
    }

    //删除学生信息
    @RequestMapping("/delete/{sno}")
    public void deleteStudent(@PathVariable("sno") Integer sno) {
        studentService.deleteStudent(sno);
    }

    //查找单个学生
    @GetMapping("/findOne/{sno}")
    public Student findOne(@PathVariable("sno") Integer sno) {
        return studentService.findOne(sno);
    }


    //批量添加和修改
    @GetMapping("/addList")
    public void addList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(5, "张飞", 55, "荆州"));
        students.add(new Student(6, "关羽", 55, "荆州"));
        students.add(new Student(7, "刘备", 55, "荆州"));
        studentService.addList(students);
    }

    //批量删除
    @GetMapping("/deleteAll")
    public void deleteAll() {
        ArrayList students = new ArrayList();
        students.add(new Student(5));
        students.add(new Student(6));
        students.add(new Student(7));
        studentService.deleteAll(students);   //批量删除，传入的是实体类集合（id）
    }

    //分页查询
    @GetMapping("/queryByPage")
    public Page queryByPage(@RequestParam(name = "currentpage", defaultValue = "1") Integer currentPage,//页码，默认为第一页
                            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) { //页面大小，写死每页展示5条数据
        return studentService.findBookNoCriteria(currentPage, pageSize);
    }



}
