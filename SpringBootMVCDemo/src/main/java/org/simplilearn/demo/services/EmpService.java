package org.simplilearn.demo.services;

import java.util.List;

import org.simplilearn.demo.entities.Emp;

public interface EmpService {
	
	void insertEmployee(Emp e);
	void deleteEmployee(int eno);
	List<Emp> getEmployees();
	Emp getEmployee(int eno);

}
