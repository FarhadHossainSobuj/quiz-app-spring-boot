package com.example.quiz_application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.quiz_application.model.QuestForm;
import com.example.quiz_application.model.Question;
import com.example.quiz_application.model.Result;
import com.example.quiz_application.repository.QuestionRepository;
import com.example.quiz_application.repository.ResultRepo;

@Service
public class QuizService {
	
	@Autowired
	Question question;
	
	@Autowired
	QuestForm qForm;
	
	@Autowired
	QuestionRepository qRepo;
	
	@Autowired
	Result result;
	
	@Autowired
	ResultRepo rRepo;
	
	public QuestForm getQuestions() {
		List<Question> allQues = qRepo.findAll();
		List<Question> qList = new ArrayList<Question>();
		
		Random random = new Random();
		if(!allQues.isEmpty()) {
			for(int i = 0; i < 5; i++) {
				int rand = random.nextInt(allQues.size());
				qList.add(allQues.get(rand));
				allQues.remove(rand);
			}
		}		
		
		qForm.setQuestions(qList);
		return qForm;
		
	}
	
	public int getResult(QuestForm qForm) {
		int correct = 0;
		for(Question q : qForm.getQuestions()) {
			if(q.getAns() == q.getChose()) {
				correct++;
			}
		}
		
		return correct;
	}
	
	public void saveScore(Result result) {
		Result saveResult = new Result();
		saveResult.setUsername(result.getUsername());
		saveResult.setTotalCorrect(result.getTotalCorrect());
		rRepo.save(saveResult);
	}
	
	public List<Result> getTopScore(){
		List<Result> sList = rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));
		return sList;
	}
}
