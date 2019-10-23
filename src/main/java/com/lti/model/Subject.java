package com.lti.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TBL_SUBJECT")
public class Subject {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SUBJECT_GENERATOR")
	@SequenceGenerator(name="SUBJECT_GENERATOR", sequenceName="SUBJECT_GENERATOR",allocationSize=1)
	@Column(name="SUBJECT_ID")
	private int subjectId;
	
	@Column(name="SUBJECT_NAME")
	private String subjectName;
	
	@Column(name="NO_OF_QUESTIONS")
	private int noOfQuestions;
	
	@OneToMany(mappedBy="subject",cascade = CascadeType.ALL)
	private Set<Question> questions;
	
	@OneToMany(mappedBy="subject",cascade = CascadeType.ALL)
	private Set<Exam> exam;
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getNoOfQuestions() {
		return noOfQuestions;
	}
	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	
}
