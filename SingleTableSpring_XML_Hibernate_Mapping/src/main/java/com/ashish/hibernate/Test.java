package com.ashish.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class Test {

    private static SessionFactory factory;

    public Test() {
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Test TEST= new Test();
        Integer shiftId1 = TEST.addShift("shift1", "attr1", 100);
        Integer shiftId2 = TEST.addShift("shift1", "attr1", 100);
        Integer shiftId3 = TEST.addShift("shift1", "attr1", 100);
        System.out.println("Shifts added");
        TEST.listShifts();
        System.out.println("Listed Shifts");
        TEST.updateShift(shiftId1, "shiftfaskjfklaf", "attrsfdjlfkajd", 34938190);
        System.out.println("Updated Shifts");
        TEST.listShifts();
        System.out.println("Listed Shifts");
        System.out.println("Shift object created successfully");
    }

    /**
     *
     * @param shiftName
     * @param attr1
     * @param attr2
     * @return
     */
    public Integer addShift(String shiftName, String attr1, Integer attr2)
    {
                 Session session = factory.openSession();
        Transaction tx = null;
        Integer shiftId = null;
        try{
            tx = session.beginTransaction();
            Shift shift = new Shift(shiftName, attr1, attr2);
            shiftId = (Integer) session.save(shift);
            tx.commit();
        }
        catch(HibernateException e)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
            e.printStackTrace();
        } finally{
            session.close();
        }
        return shiftId;
    }

    /**
     *
     */
    public void listShifts(){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List shifts = session.createQuery("From Shift").list();
            for(Iterator iterator = shifts.iterator(); iterator.hasNext();)
            {
                Shift shift = (Shift) iterator.next();
                System.out.println("SHIFT NAME: "+shift.getShiftName());
                System.out.println("SHIFT ATTR 1: "+shift.getShiftAttr1());
                System.out.println("SHIFT ATTR 2: "+shift.getShiftAttr2());
            }
            tx.commit();
        }
        catch(HibernateException e)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
            e.printStackTrace();
        } finally{
            session.close();
        }
    }

    /**
     *
     * @param shiftId
     * @param shiftName
     * @param attr1
     * @param attr2
     */
    public void updateShift( Integer shiftId, String shiftName, String attr1, Integer attr2){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Shift shift = (Shift)session.get(Shift.class, shiftId);
            shift.setShiftAttr1(attr1);
            shift.setShiftAttr2(attr2);
            shift.setShiftName(shiftName);
            session.update(shift);
            tx.commit();
        }
        catch(HibernateException e)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
            e.printStackTrace();
        } finally{
            session.close();
        }
    }

    /* Method to UPDATE salary for an employee */
    public void updateEmployee(Integer EmployeeID, int salary ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);
            employee.setSalary( salary );
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer EmployeeID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteShift(Long shiftId)
    {

    }

}
