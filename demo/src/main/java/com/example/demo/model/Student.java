package com.example.demo.model;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.PublicKey;

@NoArgsConstructor
public class Student implements Serializable {

    private BigInteger id;

    private String name;

    private Integer sex;

    private Integer age;

    public Student (BigInteger id, String name, Integer sex, Integer age){
        this.id=id;
        this.name=name;
        this.age=age;
        this.sex=sex;
    }

    private static final long serialVersionUID = -3427188660306294904L;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}