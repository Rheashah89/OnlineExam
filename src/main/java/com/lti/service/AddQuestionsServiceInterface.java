package com.lti.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.lti.model.Question;

public interface AddQuestionsServiceInterface {

	public void addQuestion(Question question);
	public LinkedHashMap<Integer, ArrayList<ArrayList<String>>> addQuestionsUsingFile(String finalPath);
}
