package PurchaseSystem.service.implement;

import PurchaseSystem.dao.EmployeeDao;
import PurchaseSystem.model.Role.Employee;
import PurchaseSystem.service.IEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("employeeService")
public class EmployeeImpl implements IEmployeeService {
    @Resource
    private EmployeeDao employeeDao;
    public Employee selectEmployee(long id){
        return this.employeeDao.selectEmployee(id);
    }
}
