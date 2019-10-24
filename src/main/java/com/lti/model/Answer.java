package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ANSWERS")
public class Answer {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ANSWER_GENERATOR")
	@SequenceGenerator(name="ANSWER_GENERATOR", sequenceName="ANSWER_GENERATOR",allocationSize=1)
	@Column(name="ANSWER_ID")
	private int answerId;
	
	@ManyToOne
	@JoinColumn(name="EXAM_ID")
	private Exam exam;
	
	@OneToOne
	@JoinColumn(name="QUESTION_ID")
	private Question question;
	
	@Column(name="SELECTED_ID")
	private int selectedId;
	
	@Column(name="SCORE")
	private int score;
	
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExamId(Exam exam) {
		this.exam = exam;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getSelectedId() {
		return selectedId;
	}
	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
