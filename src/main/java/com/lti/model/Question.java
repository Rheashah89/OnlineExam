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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="TBL_QUESTION")
public class Question {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="QUESTION_GENERATOR")
	@SequenceGenerator(name="QUESTION_GENERATOR", sequenceName="QUESTION_GENERATOR",allocationSize=1)
	@Column(name="QUESTION_ID")
	private int questionId;
	
	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	private Subject subject;
	
	@Column(name="QUESTION")
	private String question;
	
	@Column(name="QUESTION_LEVEL")
	private int questionLevel;
	
	@OneToMany(mappedBy="question",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Option> options;
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getQuestionLevel() {
		return questionLevel;
	}
	public void setQuestionLevel(int questionLevel) {
		this.questionLevel = questionLevel;
	}
	public Set<Option> getOptions() {
		return options;
	}
	public void setOptions(Set<Option> options) {
		this.options = options;
	}
	
	
	
}
