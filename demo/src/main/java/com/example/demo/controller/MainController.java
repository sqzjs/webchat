package com.example.demo.controller;

import cn.hutool.core.lang.Snowflake;
import com.example.demo.service.StudentService;
import com.example.demo.model.Student;
import com.example.demo.vo.StudentForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/sq")
public class MainController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private Snowflake snowflake;

    @GetMapping("/res")
    public String sad(){
        return "index";
    }

    @GetMapping("/root")
    public String roo(){
        return "rootUser";
    }
    @ResponseBody
    @PostMapping("/ins")
    public boolean createStudent(@RequestParam String name,
                                 @RequestParam int sex,
                                 @RequestParam int age) {
        log.info("{} {} {}", name, sex, age);
        return studentService.addStudent(BigInteger.valueOf(snowflake.nextId()), name, sex, age);
    }
    @ResponseBody
    @GetMapping("/sel")
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @ResponseBody
    @PostMapping("/set")
    public boolean setStudent(@RequestBody StudentForm studentForm) {
        return studentService.setStudent(studentForm);
    }

    @ResponseBody
    @PostMapping("/del")
    public boolean removeStudent(@RequestBody StudentForm studentForm){
        return studentService.removeStudent(studentForm);
    }

}
