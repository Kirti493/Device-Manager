package com.device.emp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {
	@Autowired
	private EmpService service;

	@GetMapping("/")
	public String viewLoginPage() {
		return "login";
	}

	@GetMapping("/home")
	public String viewHomePage() {
		return "home";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("emp", new Emp());
		// System.out.print("calling get method");
		return "employee_registration";
	}

	@PostMapping("/register")
	public String processRegister(Emp emp) {

		service.save(emp);

		return "home";
	}

	@GetMapping("/employeerequest")
	public String RequestingPage() {
		return "Userrequesting";
	}

	@RequestMapping(path = { "/", "/empsearch" })
	public String home(Emp emp, Model model, String keyword) {
		if (keyword != null) {
			List<Emp> list = service.getByKeyword(keyword);
			model.addAttribute("list", list);
		} else {
			List<Emp> list = service.getAllEmps();
			model.addAttribute("list", list);
		}
		return "employee_report";
	}
}