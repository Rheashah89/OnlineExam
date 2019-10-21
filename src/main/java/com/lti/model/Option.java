package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TBL_OPTION")
public class Option {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="OPTION_GENERATOR")
	@SequenceGenerator(name="OPTION_GENERATOR", sequenceName="OPTION_GENERATOR",allocationSize=1)
	@Column(name="OPTION_ID")
	private int optionId;
	
	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
	private Question question;
	
	@Column(name="OPTION_NAME")
	private String option;
	
	@Column(name="CORRECT_OPTION") // y or n
	private char correctOption;

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public Question getQuestionId() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public char getCorrcetOption() {
		return correctOption;
	}

	public void setCorrcetOption(char correctOption) {
		this.correctOption = correctOption;
	}
	
	
	
}
