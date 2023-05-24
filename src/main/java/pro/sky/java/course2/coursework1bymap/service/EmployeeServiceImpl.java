package pro.sky.java.course2.coursework1bymap.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework1bymap.Employee;
import pro.sky.java.course2.coursework1bymap.Exceptions.EmployeeAlreadyAdded;
import pro.sky.java.course2.coursework1bymap.Exceptions.EmployeeNotFound;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeesMap;

    public EmployeeServiceImpl() {
        this.employeesMap = new HashMap<>();
    }


    @Override
    public Employee add(String lastName, String firstName) {
        String key = lastName + " " + firstName;
        Employee employee = new Employee(lastName, firstName);


        if (employeesMap.containsKey(key)) {
            throw new EmployeeAlreadyAdded("Сотрудник " + lastName + " " + firstName + " уже внесен в реестр");
        } else {
            employeesMap.put(key, employee);
        }
        return employee;
    }

    @Override
    public Employee remove(String lastName, String firstName) {
        String key = lastName + " " + firstName;
        Employee employee = new Employee(lastName, firstName);
        if (!employeesMap.containsKey(key)) {
            throw new EmployeeNotFound("Сотрудник не найден");
        }
        employeesMap.remove(key);
        return employee;
    }

    @Override
    public Employee find(String lastName, String firstName) {
        String key = lastName + " " + firstName;
        Employee employee = new Employee(lastName, firstName);
        if (!employeesMap.containsKey(key)) {
            throw new EmployeeNotFound("Сотрудник не найден");
        }

        return employee;
    }

    @Override
    public String print() {
        return employeesMap.toString();
    }
}
