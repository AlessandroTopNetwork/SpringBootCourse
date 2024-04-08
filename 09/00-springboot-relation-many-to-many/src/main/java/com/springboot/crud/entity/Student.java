package com.springboot.crud.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_student")
	private long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cognome")
	private String cognome;

	@Column(name = "email")
	private String email;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable( // tab di raccordo
			name = "course_student",
			joinColumns = @JoinColumn(name = "student_id"), // name of column (on join will be set name of key of entity class in inverse join tab relationated) on tab joined in this case course_student
			inverseJoinColumns = @JoinColumn(name = "course_id") // same but secodn tab relation
			)
	private List<Course> listCourse;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getListCourse() {
		return listCourse;
	}

	public void setListCourse(List<Course> listCourse) {
		this.listCourse = listCourse;
	}
	
	public void addCourse(Course course) {
		listCourse.add(course);
		if(CollectionUtils.isEmpty(course.getListStudent())) {
			course.setListStudent(new ArrayList<>());
		}
	    course.getListStudent().add(this);
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", listCourse="
				+ listCourse + "]";
	}
	
}
