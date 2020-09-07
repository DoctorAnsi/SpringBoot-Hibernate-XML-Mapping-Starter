package com.ashish.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = new Employee();
        employee.setEmpAddress("Chandana , Kadubesanalli");
        employee.setEmpName("Ashish");
        Set<Employee> employeeList = new HashSet<Employee>();
        employeeList.add(employee);
        Department department = new Department();
        department.setDeptName("Java Stack");
        department.setEmployees(employeeList);

        session.save(department);
        transaction.commit();
        session.close();
        System.out.println("Added department to the database1 table: deptTable and EmpTable");

    }
}