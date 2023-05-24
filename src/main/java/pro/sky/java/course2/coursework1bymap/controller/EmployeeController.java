package pro.sky.java.course2.coursework1bymap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.coursework1bymap.Employee;
import pro.sky.java.course2.coursework1bymap.service.EmployeeService;
import pro.sky.java.course2.coursework1bymap.service.EmployeeServiceImpl;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam("name1") String lastName, @RequestParam("name2") String firstName) {

        return employeeService.add(lastName, firstName);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam("name1") String lastName, @RequestParam("name2") String firstName) {
        return employeeService.remove(lastName, firstName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("name1") String lastName, @RequestParam("name2") String firstName) {
        return employeeService.find(lastName, firstName);
    }

    @GetMapping
    public String print() {
        return employeeService.print();
    }
}
