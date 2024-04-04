package com.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crud.entity.Employee;

@Repository // sostituisce in todo quando fatto fin ora nelle classi DAO con entityManager
public interface EmployeeJPARepository extends JpaRepository<Employee, Long>{

//	Employee findById(long id); // esiste un metodo con lo stesso nome nativo di jpa ma che ritona un Optional<Object> da cui verificare se obj è stato trovato o meno
	
}
