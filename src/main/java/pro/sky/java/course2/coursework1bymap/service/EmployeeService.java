package pro.sky.java.course2.coursework1bymap.service;

import pro.sky.java.course2.coursework1bymap.Employee;

import java.util.Collection;


public interface EmployeeService {
    Employee add(String lastName, String firstName);


    Employee remove(String lastName, String firstName);

    Employee find(String lastName, String firstName);

    Collection<Employee> print();
}
