package com.codecool.feb2021pl.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static com.codecool.feb2021pl.springdemo.Employee.Employee;

@Controller
public class ExampleController {

    private final EmployeeDao employeeDao;
    private final EmployeeFactory employeeFactory;

    // Don't do this!! SimpleDateFormat is not thread safe!
    private final DateFormat timeFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public ExampleController(EmployeeDao employeeDao, EmployeeFactory employeeFactory) {
        this.employeeDao = employeeDao;
        this.employeeFactory = employeeFactory;
    }

    @GetMapping("/current_date")
    @ResponseBody
    public String showDate() {
        Date date = new Date();
        // This is OK. SimpleDateFormat is not thread safe but each thread creates own instance.
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        return dateFormat.format(date);
    }

    @GetMapping("/current_date_time")
    @ResponseBody
    public String showTime() {
        Date date = new Date();
        synchronized (timeFormat) {
            return timeFormat.format(date);
        }
    }

    @GetMapping("/employees")
    public String allEmployees(Model model) {
        model.addAttribute("employees", employeeDao.all());
        return "employees.html";
    }

    @PostMapping("/employees/{name}")
    public String changeName(String name, String newName) {
        Employee employee = employeeDao.findEmployeeByName(name).get();
        employee.setName(newName);
        return "redirect:/employees";
    }

    @GetMapping("/new_employee")
    public String newEmployee() {
        return "new_employee.html";
    }

    @PostMapping("/new_employee")
    public String newEmployee(String name) {

        Employee employee = employeeFactory.create(name);
//        employee = Employee("aaa");
//        employee = new Employee("aaa");
//        employee = employeeFactory.create(name);

        employeeDao.save(employee);

        return "redirect:/employees";
    }

}
