package com.abc.zh.study.json;

import java.io.Serializable;

/**
 * 学生实体类
 */

public class Student implements Serializable {

    private Integer id;

    private String name;

    private String age;

    private String intro;

    public Student(Integer id, String name, String age, String intro) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.intro = intro;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
