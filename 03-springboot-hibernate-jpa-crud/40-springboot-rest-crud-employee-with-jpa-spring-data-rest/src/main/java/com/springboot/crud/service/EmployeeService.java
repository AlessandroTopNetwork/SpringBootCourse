//package com.springboot.crud.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.springboot.crud.entity.Employee;
//import com.springboot.crud.repository.EmployeeJPARepository;
//
//@Service
//public class EmployeeService implements EmployeeServiceInterface {
//
////	@Autowired
//	private EmployeeJPARepository employeeRepository;
//
//	@Autowired
//	public EmployeeService(EmployeeJPARepository employeeRepository) {// superfluo basta autowired sulla interfaccia
//		this.employeeRepository = employeeRepository;
//	}
//
//	@Override
//	public List<Employee> findAll() {
//		return employeeRepository.findAll();
//	}
//
//	@Override
//	public Employee findById(long id) {
//		Optional<Employee> result = employeeRepository.findById(id);
//		return result.isPresent() ? result.get() : null; // prende il valore dell'optional employee se esiste altrimenti restituisce null (operatore ternaio un if swemplice su un unica riga)
//	}
//
//	@Override
//	public Employee save(Employee employee) {
//		Employee empolyee = employeeRepository.save(employee); // cannot execute merge to save or modify record without @Transctional
//		return employee;
//	}
//
//	@Override
//	public void delete(long id) {
//		Optional<Employee> empolyee = employeeRepository.findById(id); // find record
//		
//		if(empolyee.isPresent()) {
//			employeeRepository.delete(empolyee.get()); // delete record
//		}
//				
////		employeeDAO.delete(employeeDAO.findById(id)); // find record and remove
//	}
//
//}
