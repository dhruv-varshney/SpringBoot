package com.example.springMVCWithCRUD.Controller;

import com.example.springMVCWithCRUD.Repository.EmployeeRepository;
import com.example.springMVCWithCRUD.entity.Employee;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DemoController {

    private EmployeeRepository employeeRepository;

    public DemoController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    @RequestMapping ("/employees")
    private String employee(Model themodel) {
        addintoTheModel(themodel);
        List<Employee> employees = employeeRepository.findAll();
        themodel.addAttribute("employees",employees);
        return "employeeList";
    }
    @RequestMapping("/?continue")
    public String showList() {
        return "redirect:/employees";
    }

    @RequestMapping("/")
    public String showHome() {
        return "redirect:/employees";
    }

    @RequestMapping("/logout")
    public String logout(Model theModel) {
        theModel.addAttribute("logout",Boolean.TRUE);
        return "redirect:/showMyLoginPage?logout=true";
    }

    @RequestMapping("/accessDenied")
    public String accessDenied(Model theModel){
        addintoTheModel(theModel);
        return "showaccessDeniedPage";
    }

    @GetMapping("/error")
    public String showErrorPage(Model theModel) {
        theModel.addAttribute("error", "Access Denied");
        return "showaccessDeniedPage";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(AccessDeniedException ex, Model theModel) {
        theModel.addAttribute("error", ex.getMessage());
        return "showaccessDeniedPage";
    }

    private void addintoTheModel(Model themodel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication !=null && authentication.getPrincipal() instanceof UserDetails){
            UserDetails user = (UserDetails) authentication.getPrincipal();
            themodel.addAttribute("username",user.getUsername());
            themodel.addAttribute("Role",user.getAuthorities());
        }
    }

    @RequestMapping("/delete/{employee_id}")
    private String employee(@PathVariable("employee_id") int employee_id, Model theModel){
        employeeRepository.deleteById(employee_id);
        List<Employee> employees = employeeRepository.findAll();
        theModel.addAttribute("employees", employees);
        return "redirect:/employees";
    }

    @RequestMapping("/postEmployee")
    private String addEmployee(Model theModel) {
        theModel.addAttribute("employee",new Employee());
        return "postEmployeeForm";
    }

    @RequestMapping("/submitNewEmployee")
    private String displayAddedEmployee(@ModelAttribute Employee employee,Model theModel){
        employeeRepository.save(employee);
        List<Employee> employees = employeeRepository.findAll();
        theModel.addAttribute("employees", employees);
        return "redirect:/employees";
    }

    @RequestMapping("/update/{employee_id}")
    private String fetchData(@PathVariable int employee_id, Model theModel, HttpServletResponse response) {
        Optional<Employee> theEmployee = employeeRepository.findById(employee_id);
        if (theEmployee.isPresent()) {
            theModel.addAttribute("employee", theEmployee.get());
        }
        System.out.println(response);
        if(response.getStatus()==403){
            theModel.addAttribute("error","Access denied");
            return "redirect:/employees";
        }
        return "updateEmployeeForm";
    }
    @RequestMapping("/updateEmployee")
    private String displayUpdatedEmployee(@ModelAttribute Employee employee, Model theModel){
        employeeRepository.save(employee);
        List<Employee> employees = employeeRepository.findAll();
        theModel.addAttribute("employees", employees);
        return "redirect:/employees";
    }
}

// Add a dependency of security    D   D
// Create a InMemoryUserDetailManager  D D
// Create the JDBC UserDetailManager D D
// Add a pop up or a page displaying that access denied for each specific user  D D
// Create a custom login form D D
// Show the user on UI who logged in with the role D D
// Display only those part which can be accessible to the specific role NW


