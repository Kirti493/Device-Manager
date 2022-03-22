package com.device.emp.update;

import java.util.List;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	void saveEmployee(Employee employee);

	Employee getEmployeeById(long id);

	void deleteEmployeeById(long id);

	List<Employee> listAll(String keyword);

}
