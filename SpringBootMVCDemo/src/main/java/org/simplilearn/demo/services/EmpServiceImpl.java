package org.simplilearn.demo.services;

import java.util.List;

import org.simplilearn.demo.entities.Emp;
import org.simplilearn.demo.repositories.EmpRepository;
//import org.simplilearn.demo.repositories.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
	
	private EmpRepository empRepo ;
	
	@Autowired
	public EmpServiceImpl(EmpRepository empRepo) {
		super();
		this.empRepo=empRepo;
	}

	@Override
	public void insertEmployee(Emp e) {
		empRepo.save(e);
		
	}

	@Override
	public void deleteEmployee(int eno) {
		empRepo.deleteById(eno);
		
	}

	@Override
	public List<Emp> getEmployees() {
            return empRepo.findAll();
	
	}

	@Override
	public Emp getEmployee(int eno) {
           return empRepo.findById(eno).get();

	}

}
