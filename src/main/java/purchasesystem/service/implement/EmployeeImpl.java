package purchasesystem.service.implement;

import purchasesystem.dao.EmployeeDao;
import purchasesystem.model.role.Employee;
import purchasesystem.service.IEmployeeService;
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
