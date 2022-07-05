package com.djhu.imp.DesignMode.memento;

/**
 * @Author:mzq
 * @DATE:2019/8/1516:26
 * @VERSION:1.0.0
 */
//源发器类
public class Emp {
    private String name;
    private int age;
    private double salary;

    public Emp(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //进行备份操作，并返回备忘录对象
    public EmpMemento memento(){
        return new EmpMemento(this);
    }
    //恢复操作
    public void recovery(EmpMemento mmt){
        this.name = mmt.getName();
        this.age = mmt.getAge();
        this.salary = mmt.getSalary();
    }

}
