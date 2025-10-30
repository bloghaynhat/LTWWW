package iuh.fit.se.controllers;

import iuh.fit.se.dtos.EmployeeDTO;
import iuh.fit.se.services.EmployeeAPIService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeViewController {
    private final EmployeeAPIService employeeAPIService;

    public EmployeeViewController(EmployeeAPIService employeeAPIService) {
        this.employeeAPIService = employeeAPIService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("employees", employeeAPIService.findAll());
        return "employee-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        return "employee-add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute EmployeeDTO employee) {
        employeeAPIService.create(employee);
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", employeeAPIService.findById(id));
        return "employee-add";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute EmployeeDTO employee) {
        employeeAPIService.update(id, employee);
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        employeeAPIService.delete(id);
        return "redirect:/employee";
    }
}
