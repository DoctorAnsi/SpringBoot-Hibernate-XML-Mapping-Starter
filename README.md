# SpringBoot-Hibernate-XML-Mapping-Starter
2020 , Maven Project for Spring Boot Hibernate XML Mapping ( Without annotations ) starter 

### Configuration
```
Configure Hibernate.cfg.xml in Resource Folder
Primary Changes Required: Database Name ( In my case, it's Database1.table_name )
```
### Start Application
``` 
To start the application, run Test.java 
```

### Mapping Files Needed ( One To One Mapping )
- Employee
- Address
- employee.hbm.xml
- address.hbm.xml
- Test

### Sample Mapping File XML for reference ( headers are important )
```
<?xml version = "1.0" encoding = "utf-8"?>
<!DOCTYPE hibernate-mapping PUBLIC
        "-//Hibernate/Hibernate Mapping DTD//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">

<hibernate-mapping>
    <class name = "com.ashish.hibernate.Employee" table ="emptable">
    <id  name="empId" column = "empid">
        <generator class="increment"></generator>

    </id>
    <property name = "name" column = "ename"></property>
    <property name = "salary" column = "esalary"></property>
    <one-to-one name="address" cascade="all"></one-to-one>
    </class>

</hibernate-mapping>

```
