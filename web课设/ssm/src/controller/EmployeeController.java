package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import service.IDepartmentService;
import service.IEmployeeService;
import vo.Employee;
import vo.EmployeeQueryObject;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDepartmentService departmentService;


    @RequestMapping("list")
    public String list(Model model, @ModelAttribute("qo") EmployeeQueryObject qo) throws  Exception{

        model.addAttribute("result", employeeService.query(qo));
        model.addAttribute("currentMenu", "employee");
        model.addAttribute("depts", departmentService.list());

        return "employee/list";
    }

   

 
}
