package purchasesystem.service;

import purchasesystem.model.role.Employee;

public interface IEmployeeService {
    public Employee selectEmployee(long id);
}
