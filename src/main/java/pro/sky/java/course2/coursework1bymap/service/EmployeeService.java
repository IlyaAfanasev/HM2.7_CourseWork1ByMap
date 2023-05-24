package pro.sky.java.course2.coursework1bymap.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework1bymap.Employee;


public interface EmployeeService {
    Employee add(String lastName, String firstName);


    Employee remove(String lastName, String firstName);

    Employee find(String lastName, String firstName);

    String print();
}
