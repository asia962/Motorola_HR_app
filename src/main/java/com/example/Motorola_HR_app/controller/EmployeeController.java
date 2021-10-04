package com.example.Motorola_HR_app.controller;

import com.example.Motorola_HR_app.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage() {
        return "home";
    }


    @GetMapping("/employees")
    public String getAllEmployees(Model model) {
        model.addAttribute("products", employeeService.getAllEmployees());
        return "employess";
    }

    @GetMapping("/employees/{id}")
    public String getEmployeeById(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employee_id";
    }


    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect: employeees";

    }

    @GetMapping("/EmployeeForm")
    public String showNewEmployeeForm(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/Employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

}
