package com.device.emp.update;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "devicesreport")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "emp_Id", nullable = false, length = 20)
	private String empId;

	@Column(name = "device_Id", nullable = false, length = 20)
	private String deviceId;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name = "date_Of_Issue", nullable = false, length = 20)
	private Date dateOfIssue;

	@Column(name = "device_Name", nullable = false, length = 20)
	private String deviceName;

	@Column(name = "device_Type", nullable = false, length = 20)
	private String deviceType;

	@Column(name = "status_Type", nullable = false, length = 20)
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

}
