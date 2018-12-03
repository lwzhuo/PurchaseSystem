package PurchaseSystem.controller;

import PurchaseSystem.model.Role.Employee;
import PurchaseSystem.service.IEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
@Controller
@RequestMapping("/employee")
public class employeeController {
    @Resource
    private IEmployeeService employeeService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody Employee selectEmployee(@PathVariable("id") long id){
        Employee employee = employeeService.selectEmployee(id);
        return employee;
    }
}
