package com.lti.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TBL_EXAM")
public class Exam {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="EXAM_GENERATOR")
	@SequenceGenerator(name="EXAM_GENERATOR", sequenceName="EXAM_GENERATOR",allocationSize=1)
	@Column(name="EXAM_ID")
	private int examId;
	
	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	private Subject subject;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@Column(name="CURRENT_LEVEL")
	private int currentLevel;
	
	@Column(name="NO_OF_ATTEMPTS")
	private int noOfAttempts;
	
	@OneToMany(mappedBy="exam",cascade=CascadeType.ALL)
	private Set<Answer> answers;
	
	@OneToOne(mappedBy="exam",fetch=FetchType.LAZY)
	private Report report;
	
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCurrentLevel() {
		return currentLevel;
	}
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	public int getNoOfAttempts() {
		return noOfAttempts;
	}
	public void setNoOfAttempts(int noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}
	public Set<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
	
	
	
}
