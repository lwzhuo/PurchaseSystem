package PurchaseSystem.dao;
import PurchaseSystem.model.Role.Employee;

import java.util.List;

public interface employeeDao {
    public Employee selectEmployee(long id);
    public String getEmployeeNameById(int id);
    public String getEmployeePassword(long id);
    public List getEmployeeRole(long id);
    public List getPermissionByRole(String role);
}
