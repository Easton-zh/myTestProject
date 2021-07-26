package com.abc.zh.study.newfeatures.Stream;

import lombok.Data;

@Data
public class Student {

    private String idNum;

    private String name;

    private Integer age;

    private String classNum;

    public Student(String idNum, String name, Integer age, String classNum) {
        this.idNum = idNum;
        this.name = name;
        this.age = age;
        this.classNum = classNum;
    }

}
