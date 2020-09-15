package com.ashish.hibernate;


import com.google.gson.JsonObject;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.util.*;

public class Test {
    public static void main(String[] args) {
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
        // querying a table using Spring Hibernate
        Query query = session.createSQLQuery("select * from emptable").addEntity(Employee.class);
        List<Employee> result = query.list();
        for (Employee x : result) {
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
        for (Object x : y) {
            System.out.println(Long.valueOf(x.toString()));
        }
        System.out.println("------------\n");


        // Manipulating hashmaps using Entry in maps
        HashMap<Long, Long> x = new HashMap<>();
        x.put(20l, 20l);
        x.put(1000l, 1000l);
        x.put(131230l, 534232l);


        Set<Map.Entry<Long, Long>> temp = x.entrySet();
        Iterator<Map.Entry<Long, Long>> itr = temp.iterator();
        while (itr.hasNext()) {
            Map.Entry<Long, Long> keyValue = itr.next();
            Long memberId = keyValue.getKey();
            Long shiftId = keyValue.getValue();

            System.out.println(memberId + " " + shiftId);
        }

        System.out.println("start");
        int employeeId = 103;
        String firstName = "DOE";

        // getting and printing object from a database using sql
        Query query1 = session.createSQLQuery("SELECT * FROM employee_table where employee_id = :employeeId and first_name = :firstName")
                .setParameter("employeeId", employeeId)
                .setParameter("firstName", firstName);

        List tempMember = query1.list();


        List rs = query1.getResultList();
        for (Iterator iterator = rs.iterator(); iterator.hasNext(); ) {
            System.out.println(ReflectionToStringBuilder.toString(iterator.next()));
        }
        for (Iterator iterator = tempMember.iterator(); iterator.hasNext(); ) {
            Object j = iterator.next();
            System.out.println(j.toString());
        }

        System.out.println("end");
        transaction.commit();
        session.close();

        System.out.println("Added employee to Database 1, table addrtable, emptable");
    }
}
