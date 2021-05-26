package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.vo.StudentForm;


import java.math.BigInteger;
import java.util.List;

public interface StudentService{

    public List<Student> getAllStudents();
    public boolean addStudent(BigInteger id, String name, Integer sex, Integer age);
    public boolean addStudent(Student s);
    public boolean removeStudent(StudentForm form);
    public boolean removeStudent(Student s);
    public boolean setStudent(StudentForm form);
    public boolean setStudent(Student s);
}
