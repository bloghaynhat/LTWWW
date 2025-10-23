package iuh.fit.se.controllers;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Hiển thị danh sách tất cả nhân viên.
     *
     * @param model Model để truyền dữ liệu sang view
     * @return tên view "employee_list" (file .html hoặc .jsp tương ứng)
     */
    @GetMapping
    public String index(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    /**
     * Hiển thị form đăng ký nhân viên mới.
     * View sẽ hiển thị các input để nhập thông tin nhân viên.
     *
     * @return ModelAndView chứa view "employee_register" và đối tượng trống Employee
     */
    @GetMapping("/show-form")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("employee_register");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    /**
     * Lưu thông tin nhân viên (thêm mới hoặc cập nhật).
     * Kiểm tra dữ liệu hợp lệ bằng @Valid và BindingResult.
     *
     * @param employee đối tượng Employee được binding từ form
     * @param result   chứa lỗi nếu có
     * @return redirect về trang danh sách nếu thành công, ngược lại quay lại form
     */
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            // Nếu có lỗi validate, quay lại form
            return "employee_register";
        }

        employeeService.save(employee);
        // Sau khi lưu xong, redirect về trang danh sách nhân viên
        return "redirect:/";
    }

    /**
     * Hiển thị form cập nhật thông tin nhân viên dựa theo ID.
     * Nếu ID không tồn tại, hiển thị trang lỗi.
     *
     * @param id           ID của nhân viên cần cập nhật
     * @param modelAndView ModelAndView để truyền dữ liệu và chọn view
     * @return ModelAndView chứa view tương ứng
     */
    @GetMapping("/update")
    public ModelAndView update(@RequestParam("employeeId") int id, ModelAndView modelAndView) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            modelAndView.addObject("error", "Employee ID không tồn tại");
            modelAndView.setViewName("error");
        } else {
            modelAndView.addObject("employee", employee);
            modelAndView.setViewName("employee_register");
        }

        return modelAndView;
    }
}
