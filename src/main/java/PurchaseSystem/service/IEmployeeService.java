package PurchaseSystem.service;

import PurchaseSystem.model.Role.Employee;

public interface IEmployeeService {
    public Employee selectEmployee(long id);
}
