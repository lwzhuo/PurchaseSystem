package purchasesystem.controller;

import purchasesystem.model.Role.Employee;
import purchasesystem.service.IEmployeeService;
import purchasesystem.util.ReturnJson;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private IEmployeeService employeeService;
    private static Logger logger = Logger.getLogger(EmployeeController.class);
    @GetMapping(value = "/{id}",produces = "application/json")
    public @ResponseBody Employee selectEmployee(@PathVariable("id") long id){
        return employeeService.selectEmployee(id);
    }

    @RequestMapping(value = "/login")
    public @ResponseBody Map login(@RequestBody Map<String,String> map){
        String employeeId = map.get("employeeId");
        String password = map.get("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(employeeId,password);
        Map result = new HashMap();
        try {
            subject.login(token);
            Employee employee = employeeService.selectEmployee(Long.parseLong(employeeId));
            result.put("employeeId",employeeId);
            result.put("employeeName",employee.getName());
            result.put("status","success");
        }catch (IncorrectCredentialsException e) {
            String log = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
            logger.info(log);
            result.put("employeeId",employeeId);
            result.put("status","fail");
        } catch (ExcessiveAttemptsException e) {
            String log = "登录失败次数过多";
            logger.info(log);
        } catch (LockedAccountException e) {
            String log = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
            logger.info(log);
        } catch (DisabledAccountException e) {
            String log = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
            logger.info(log);
        } catch (ExpiredCredentialsException e) {
            String log = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
            logger.info(log);
        } catch (UnknownAccountException e) {
            String log = "帐号不存在. There is no user with username of " + token.getPrincipal();
            logger.info(log);
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
        return ReturnJson.returnMsgandStatus(401,"unauthorized");
    }
}
