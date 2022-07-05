package com.djhu.imp.DesignMode.memento;

/**
 * @Author:mzq
 * @DATE:2019/8/1516:28
 * @VERSION:1.0.0
 */
public class Test {

    public static void main(String[] args){
        CareTaker taker = new CareTaker();
        Emp emp = new Emp("小明" , 18,900);
        System.out.println("第一次：emp.getName()"+emp.getName()+"+emp.getAge()"+emp.getAge()+"+emp.getSalary() = "+emp.getSalary());
        taker.setMemento(emp.memento()); //备份一次

        System.out.println("###对原对象数据进行修改####");
        emp.setAge(38);
        emp.setName("小白");
        emp.setSalary(10000);
        System.out.println("第二次：emp.getName()"+emp.getName()+"+emp.getAge()"+emp.getAge()+"+emp.getSalary() = "+emp.getSalary());
        System.out.println("###对原对象恢复####");
        emp.recovery(taker.getMemento());
        System.out.println("第三次：emp.getName()"+emp.getName()+"+emp.getAge()"+emp.getAge()+"+emp.getSalary() = "+emp.getSalary());
        System.out.println();
    }
}
