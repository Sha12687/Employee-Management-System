package com.emp.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.entity.Employee;
import com.emp.service.EmpServices;

@Controller
public class EmpController {
	@Autowired
	private EmpServices  empServices;
	@GetMapping("/")
public String home(Model m) {
		List<Employee> allEmploye=empServices.getAllEmp();
		m.addAttribute("allEmploye",allEmploye);
	return "index";
}
	@GetMapping("/AddEMP")
	public String AddEmployee() {
		return "AddEmp";
	}
	@PostMapping("/register")
	public String EmpRegister( @ModelAttribute  Employee emp,HttpSession session ){
		System.out.println(emp);
	    empServices.AddEmp(emp);
	    session.setAttribute("msg", "Employee Added Successfully");
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
	  Employee e=	empServices.getEmpById(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee employee,HttpSession session) {
	empServices.AddEmp(employee);
	session.setAttribute("msg", "Value is Successfully Updated");
	return "redirect:/";
	}
}
