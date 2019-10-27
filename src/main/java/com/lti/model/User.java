package com.lti.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TBL_USER")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="USER_GENERATOR")
	@SequenceGenerator(name="USER_GENERATOR", sequenceName="USER_GENERATOR",allocationSize=1)
	@Column(name="USER_ID")
	private int userID;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="USER_DOB")
	private String userDateOfBirth;
	
	@Column(name="USER_MOBILE")
	private long userMobile;
	
	@Column(name="USER_EMAIL")
	private String userEmail;
	
	@Column(name="USER_PASSWORD")
	private String userPassword;
	
	@Column(name="USER_CITY")
	private String userCity;
	
	@Column(name="USER_STATE")
	private String userState;
	
	@Column(name="USER_ROLE")
	private String userRole;
	
	@Column(name="USER_DEGREE")
	private String userDegree;
	
	@Column(name="SECURITY_QUESTION")
	private String securityQuestion;
	
	@Column(name="SECURITY_ANSWER")
	private String securityAnswer;
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private Set<Exam> exams;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserDateOfBirth() {
		return userDateOfBirth;
	}
	public void setUserDateOfBirth(String userDateOfBirth) {
		this.userDateOfBirth = userDateOfBirth;
	}
	public long getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(long userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	
	public Set<Exam> getExams() {
		return exams;
	}
	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}
	public String getUserDegree() {
		return userDegree;
	}
	public void setUserDegree(String userDegree) {
		this.userDegree = userDegree;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
	
	
	
}
