package com.ashish.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = new Employee();
        employee.setName("Ashish");
        employee.setSalary(2000f);

        Address address = new Address();
        address.setCity("Telangana");
        address.setCountry("india");
        address.setState("Hyderabad");


        employee.setAddress(address);
        address.setEmployee(employee);

        session.save(employee);
        transaction.commit();
        session.close();

        System.out.println("Added employee to Database 1, table Address33_Table, Employee33_Table");
    }
}
