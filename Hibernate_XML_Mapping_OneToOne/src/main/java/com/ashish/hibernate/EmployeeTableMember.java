package com.ashish.hibernate;

public class EmployeeTableMember {
    int employeeId;
    String firstName;
    String lastName;
    int age;
    String departmentName;
    int employeeTableCol;

    @Override
    public String toString() {
        return "EmployeeTableMember{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", departmentName='" + departmentName + '\'' +
                ", employeeTableCol=" + employeeTableCol +
                '}';
    }

    public EmployeeTableMember() {
        firstName = "temp";
        lastName = "gupta";
        age = 24;
        departmentName = "gs";
        employeeTableCol = 1000;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getEmployeeTableCol() {
        return employeeTableCol;
    }

    public void setEmployeeTableCol(int employeeTableCol) {
        this.employeeTableCol = employeeTableCol;
    }

    public EmployeeTableMember(int employeeId, String firstName, String lastName, int age, String departmentName, int employeeTableCol) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.departmentName = departmentName;
        this.employeeTableCol = employeeTableCol;
    }
}
