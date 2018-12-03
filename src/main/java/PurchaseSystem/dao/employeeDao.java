package PurchaseSystem.dao;
import PurchaseSystem.model.Role.Employee;
public interface employeeDao {
    public Employee selectEmployee(long id);
    public String getEmployeeNameById(int id);
}
