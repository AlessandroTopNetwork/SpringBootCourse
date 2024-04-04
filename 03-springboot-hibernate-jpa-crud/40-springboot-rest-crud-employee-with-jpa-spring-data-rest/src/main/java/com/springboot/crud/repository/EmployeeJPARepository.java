package com.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.crud.entity.Employee;

@RepositoryRestResource(path = "members") // specific path in your url for this repository-entity
public interface EmployeeJPARepository extends JpaRepository<Employee, Long>{

//	Employee findById(long id); // esiste un metodo con lo stesso nome nativo di jpa ma che ritona un Optional<Object> da cui verificare se obj è stato trovato o meno
	
}
