package com.springboot.crud.entity;

import java.util.List;

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
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_course")
	private long id;

	@Column(name = "titolo")
	private String nome;

	@Column(name = "insegnante_id")
	private String insegnanteId;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable( // tab di raccordo
			name = "course_student",
			joinColumns = @JoinColumn(name = "course_id"), // name column on tab joined in this case course_student
			inverseJoinColumns = @JoinColumn(name = "student_id") // same but secodn tab relation
			)	
	private List<Student> listStudent;

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

	public String getInsegnanteId() {
		return insegnanteId;
	}

	public void setInsegnanteId(String insegnanteId) {
		this.insegnanteId = insegnanteId;
	}

	public List<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}
	
	public void addStudent(Student student) {
		listStudent.add(student);
	    student.getListCourse().add(this);
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", nome=" + nome + ", insegnanteId=" + insegnanteId + ", listStudent0="
				+ listStudent + "]";
	}

}
