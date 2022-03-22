package com.device.emp.update;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query(value = "select * from devicesreport r where r.device_Id like %:keyword% or r.emp_Id like %:keyword% or r.status_Type like %:keyword% ", nativeQuery = true)
	List<Employee> getAllEmployees(@Param("keyword") String keyword);
}