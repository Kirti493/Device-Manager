package com.device.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmpService {
	@Autowired
	private EmpRepository repository;

	/*
	 * TODO: Get the List of Shops
	 */
	public List<Emp> getAllEmps() {
		List<Emp> list = (List<Emp>) repository.findAll();
		return list;
	}

	/*
	 * TODO: Get Emp By keyword
	 */
	public List<Emp> getByKeyword(String keyword) {
		return repository.findByKeyword(keyword);
	}

	public void save(Emp emp) {

		repository.save(emp);
	}
}