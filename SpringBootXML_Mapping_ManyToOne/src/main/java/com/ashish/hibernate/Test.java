package com.ashish.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Department department = new Department();
        department.setDeptName("Java Stack");


        Employee employee = new Employee();
        employee.setEmpAddress("Chandana , Kadubesanalli");
        employee.setEmpName("Ashish");
        employee.setDepartment(department);

        Employee employee2 = new Employee();
        employee2.setEmpAddress("Hyderabad , Telangana");
        employee2.setEmpName("Vijay");
        employee2.setDepartment(department);

        session.save(employee);
        session.save(employee2);
        transaction.commit();
        session.close();
        System.out.println("Added department to the database1 table: manytooneDepartment and manytooneEmployee");

    }
}