package org.zhoup.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zhoup.springboot.pojo.Student;
import org.zhoup.springboot.service.StudentService;

//继承jparepository来完成对数据库的操作
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
