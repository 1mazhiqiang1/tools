package com.djhu.imp.DesignMode.memento;

/**
 * @Author:mzq
 * @DATE:2019/8/1516:26
 * @VERSION:1.0.0
 */


//备忘录类
class EmpMemento{
    private String name;
    private int age;
    private double salary;

    public EmpMemento(Emp emp){
        this.age = emp.getAge();
        this.name = emp.getName();
        this.salary = emp.getSalary();
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getSalary() {
        return salary;
    }
}
