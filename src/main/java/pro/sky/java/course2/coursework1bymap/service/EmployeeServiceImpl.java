package pro.sky.java.course2.coursework1bymap.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework1bymap.Employee;
import pro.sky.java.course2.coursework1bymap.Exceptions.EmployeeAlreadyAdded;
import pro.sky.java.course2.coursework1bymap.Exceptions.EmployeeNotFound;

import java.util.Collection;
import java.util.Collections;
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

        Employee employee = new Employee(lastName, firstName);


        if (employeesMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAdded("Сотрудник " + lastName + " " + firstName + " уже внесен в реестр");
        }
            employeesMap.put(employee.getFullName(), employee);

        return employee;
    }

    @Override
    public Employee remove(String lastName, String firstName) {

        Employee employee = new Employee(lastName, firstName);
        if (employeesMap.containsKey(employee.getFullName())) {
            return  employeesMap.remove(employee.getFullName());
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Employee find(String lastName, String firstName) {

        Employee employee = new Employee(lastName, firstName);
        if (employeesMap.containsKey(employee.getFullName())) {
            return employeesMap.get(employee.getFullName());
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Collection<Employee> print() {
        return Collections.unmodifiableCollection(employeesMap.values());
    }
}
