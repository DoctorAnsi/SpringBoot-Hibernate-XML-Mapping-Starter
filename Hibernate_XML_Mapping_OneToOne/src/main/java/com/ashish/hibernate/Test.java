package com.ashish.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = new Employee();
        employee.setName("afsdafadsfasd");
        employee.setSalary(1346546f);

        Address address = new Address();
        address.setCity("dasfasd");
        address.setCountry("afd");
        address.setState("adsf");

        // test create query method



        employee.setAddress(address);
        address.setEmployee(employee);

        session.save(employee);


        System.out.println("\n\nCreate Query Method Test Start \n\n");

        Query query = session.createSQLQuery("select * from emptable").addEntity(Employee.class);
        List<Employee> result = query.list();
        for(Employee x: result)
        {
            System.out.println(x.getEmpId());
            System.out.println(x.getName());
            System.out.println(x.getSalary());
        }





        System.out.println(result.toString());
//        ArrayList<Employee> x = new ArrayList<>(result);
//        for(Employee emp : result)
//        {
//            System.out.println(emp.getAddress());
//            System.out.println(emp.getEmpId());
//            System.out.println(emp.getName());
//        }

        System.out.println("\n\nCreate Query Method Test End \n\n");

        System.out.println("------------\n");
        Query q = session.createSQLQuery("select empid from emptable");
        System.out.println(q.list().toString());
        List y = q.list();
        for(Object x: y)
        {
            System.out.println(Long.valueOf(x.toString()));
        }
        System.out.println("------------\n");

        transaction.commit();
        session.close();

        System.out.println("Added employee to Database 1, table addrtable, emptable");
    }
}
