package com.example.demo.service.impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.model.StudentExample;
import com.example.demo.service.StudentService;
import com.example.demo.vo.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAllStudents() {
        StudentExample se =new StudentExample();
        return studentMapper.selectByExample(se);
    }

    @Override
    public boolean addStudent(BigInteger id, String name, Integer sex, Integer age) {
            Student s=new Student(id,name,sex,age);
            return this.addStudent(s);
    }

    @Override
    public boolean addStudent(Student s) {
        int res =studentMapper.insert(s);
        return res ==1;
    }

//    @Override
//    public boolean removeStudent(BigInteger id) {
//        StudentExample se =new StudentExample();
//        se.createCriteria().andIdEqualTo(id);
//        int res =studentMapper.deleteByExample(se);
//        return res==1;
//    }

    @Override
    public boolean removeStudent(StudentForm form) {
        Student student = new Student();
        student.setId(BigInteger.valueOf(form.getId()));
        student.setSex(form.getSex());
        student.setName(form.getName());
        student.setAge(form.getAge());
        return this.removeStudent(student);
    }

    @Override
    public boolean removeStudent(Student s) {
        StudentExample se =new StudentExample();
        se.createCriteria().andIdEqualTo(s.getId());
        int res =studentMapper.deleteByExample(se);
        return res==1;
    }

    @Override
    public boolean setStudent(StudentForm form) {
        Student student = new Student();
        student.setId(BigInteger.valueOf(form.getId()));
        student.setSex(form.getSex());
        student.setName(form.getName());
        student.setAge(form.getAge());
        return this.setStudent(student);
    }

    @Override
    public boolean setStudent(Student s) {
        StudentExample se =new StudentExample();
        se.createCriteria().andIdEqualTo(s.getId());
        int res =studentMapper.updateByExample(s,se);
        return res==1;
    }

}
