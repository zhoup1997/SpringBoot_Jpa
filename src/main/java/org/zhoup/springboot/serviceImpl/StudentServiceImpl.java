package org.zhoup.springboot.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zhoup.springboot.pojo.Student;
import org.zhoup.springboot.repository.StudentRepository;
import org.zhoup.springboot.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override   //分页查询
    public Page findBookNoCriteria(Integer currentPage, Integer pageSize) {

        return studentRepository.findAll(PageRequest.of(currentPage - 1, pageSize));
    }

    @Override   //查询全部
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override   //添加和修改
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override   //根据id删除
    public void deleteStudent(Integer sno) {
        studentRepository.deleteById(sno);
    }

    @Override   //根据id查找单个学生信息
    public Student findOne(Integer sno) {
        return studentRepository.findById(sno).get();
    }

    @Override   //批量添加和修改
    public void addList(List<Student> students) {
        studentRepository.saveAll(students);
    }

    @Override   //批量删除
    public void deleteAll(List<Student> students) {
        studentRepository.deleteInBatch(students);

    }
}
