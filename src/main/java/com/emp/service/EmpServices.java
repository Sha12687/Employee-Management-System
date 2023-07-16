package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Employee;
import com.emp.repo.EmpRepo;
@Service
public class EmpServices  {
	@Autowired
	private EmpRepo repo;
	public void AddEmp(Employee e) {
		repo.save(e);
	}
	public List<Employee> getAllEmp(){
		return repo.findAll();
	}
	public Employee getEmpById(int id) {
	Optional<Employee> emp= repo.findById(id);
	if(emp.isPresent())
		return emp.get();
	return null;}
	public void deleteEmp(Employee employee) {
		// TODO Auto-generated method stub
		repo.delete(employee);
	}
}
