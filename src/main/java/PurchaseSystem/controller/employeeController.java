package PurchaseSystem.controller;

import PurchaseSystem.model.Role.Employee;
import PurchaseSystem.service.IEmployeeService;
import PurchaseSystem.util.returnJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

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

    @RequestMapping(value = "/login")
    public @ResponseBody HashMap login(@RequestBody HashMap<String,String> hashMap){
        String employeeId = hashMap.get("employeeId");
        String password = hashMap.get("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(employeeId,password);
        HashMap result = new HashMap();
        try {
            subject.login(token);
            Employee employee = employeeService.selectEmployee(Long.parseLong(employeeId));
            result.put("employeeId",employeeId);
            result.put("employeeName",employee.getName());
            result.put("status","success");
        }catch (IncorrectCredentialsException e) {
            System.out.println("登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.");
            result.put("employeeId",employeeId);
            result.put("status","fail");
        } catch (ExcessiveAttemptsException e) {
            System.out.println("登录失败次数过多");
        } catch (LockedAccountException e) {
            System.out.println("帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.");
        } catch (DisabledAccountException e) {
            System.out.println("帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.");
        } catch (ExpiredCredentialsException e) {
            System.out.println("帐号已过期. the account for username " + token.getPrincipal() + "  was expired.");
        } catch (UnknownAccountException e) {
            System.out.println("帐号不存在. There is no user with username of " + token.getPrincipal());
        }
        return result;
    }
    @RequestMapping(value = "/logout")
    public void logout(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated())
            subject.logout();
    }
    @RequestMapping(value = "/unauthorized")//未授权页面
    public @ResponseBody String unauthorizedInfo(){
        return returnJson.returnMsgandStatus(401,"unauthorized");
    }
}
