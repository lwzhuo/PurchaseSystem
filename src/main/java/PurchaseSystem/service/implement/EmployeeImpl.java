package PurchaseSystem.service.implement;

import PurchaseSystem.dao.employeeDao;
import PurchaseSystem.model.Employee;
import PurchaseSystem.service.IEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("employeeService")
public class EmployeeImpl implements IEmployeeService {
    @Resource
    private employeeDao employeeDao;
    public Employee selectEmployee(long id){
        return this.employeeDao.selectEmployee(id);
    }
}
