package com.abc.zh.pojo;

public class Student {

    //**********字段*************//
    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex
                + ", phoneNum=" + phoneNum + "]";
    }



    Student(String str) {
        System.out.println("默认构造方法"+str);
    }

    public Student() {
        System.out.println("调用了公有，无参构造方法");
    }

    public Student(char name) {
        System.out.println("调用公有，有一参构造方法--->name:"+name);
    }

    public Student(String name, int age) {
        System.out.println("调用公有，有两参构造方法--->name:" + name + ",年龄:" + age);
    }

    protected Student(Boolean b) {
        System.out.println("调用受保护,有参的构造方法b:"+b);
    }

    private Student(int age) {
        System.out.println("调用私有,有参构造方法：age"+age);
    }


    //**************成员方法***************//
    public void show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }
    private String show4(int age){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        return "abcd";
    }

    //反射静态main方法
    public static void main(String[] args) {
        System.out.println("main方法执行了。。。");
    }

    //反射配置文件show方法
    public static void show() {
        System.out.println("show方法执行了。。。");
    }
}
