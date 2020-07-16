package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    ArrayList<Employee> allEmployees = new ArrayList<Employee>();

    @RequestMapping("/")
    public String loadEmployeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/confirmEmployee")
    public String confirmEmployee(@ModelAttribute Employee employee, Model model){

        allEmployees.add(employee);
        model.addAttribute("allEmployees", allEmployees);
        return "listAll";
    }

    @RequestMapping("/listAll")
    public String listAllEmployees(Model model){
        model.addAttribute("allEmployees", allEmployees);
        return "listAll";
    }


}
