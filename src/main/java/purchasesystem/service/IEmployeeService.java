package purchasesystem.service;

import purchasesystem.model.Role.Employee;

public interface IEmployeeService {
    public Employee selectEmployee(long id);
}
