package com.example.quiz_application.model;

import org.springframework.stereotype.Component;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name="questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int quesId;
	
	private String title;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	
	@Column(nullable = true)
	private int ans;
	
	@Column(nullable = true)
	private int chose;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(int questId, String title, String optionA, String optionB, String optionC, String optionD, int ans,
			int chose) {
		super();
		this.quesId = questId;
		this.title = title;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.ans = ans;
		this.chose = chose;
	}
	public int getQuesId() {
		return quesId;
	}
	public void setQuesId(int questId) {
		this.quesId = questId;
	}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public int getAns() {
		return ans;
	}
	public void setAns(int ans) {
		this.ans = ans;
	}
	public int getChose() {
		return chose;
	}
	public void setChose(int chose) {
		this.chose = chose;
	}
	
	@Override
	public String toString() {
		return "Question [quesId=" + quesId + ", title=" + title + ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC + ", ans=" + ans + ", chose=" + chose + "]";
	}
	
}
