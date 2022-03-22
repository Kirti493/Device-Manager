package com.device.emp.update;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.device.emp.Emp;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// display list of employees
	@GetMapping("/details")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "device_report";
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "device_management";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee to database
		employeeService.saveEmployee(employee);
		return "home";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get employee from the service
		Employee employee = employeeService.getEmployeeById(id);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_allocation";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}

	@RequestMapping("/search")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {

		List<Employee> listAll = employeeService.listAll(keyword);
		model.addAttribute("listEmployees", listAll);
		model.addAttribute("keyword", keyword);
		return "device_report";

	}
}