package com.lti.service;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.QuestionDao;
import com.lti.model.Question;

@Service
public class AddQuestionsService implements AddQuestionsServiceInterface{

	@Autowired
	QuestionDao questionDao;
	
	public static final String SAMPLE_XLSX_FILE_PATH = "D:\\INPUT\\";
	@Override
	public LinkedHashMap<Integer, ArrayList<ArrayList<String>>> addQuestionsUsingFile(String finalName) {
		Workbook workbook;
		DataFormatter dataFormatter = new DataFormatter();
		LinkedHashMap<Integer, ArrayList<ArrayList<String>>> data = null;
		try {
			
			String filePath=SAMPLE_XLSX_FILE_PATH+finalName;
			workbook = WorkbookFactory.create(new File(filePath));
			// Retrieving the number of sheets in the Workbook
			Sheet sheet = workbook.getSheetAt(0);

			//int rowcount = sheet.getPhysicalNumberOfRows();
			boolean status = false;
			//	System.out.println("Total Number of Rows is ::" + rowcount);
			ArrayList<String> listOfQuestionsAndOptions = new ArrayList<String>();
			data = new LinkedHashMap<Integer, ArrayList<ArrayList<String>>>();
			Integer subject = 0;
			for (Row row : sheet) {
				int num = row.getRowNum();
				if (num == 0)
					continue;
				if ((row != null)) {
					for (Cell cell : row) {

						Cell cell1 = row.getCell(0);
						subject = Integer.parseInt(dataFormatter.formatCellValue(cell1));
						//		System.out.println(subject);
						String cellValue = dataFormatter.formatCellValue(cell);
						if (cellValue.isEmpty())
							continue;
						status = true;
						listOfQuestionsAndOptions.add(cellValue);
					}
					if (status) {
						if (data.containsKey(subject)) {
							ArrayList<ArrayList<String>> listOfQuestions = data.get(subject);
							listOfQuestions.add(listOfQuestionsAndOptions);
							data.replace(subject, listOfQuestions);
							listOfQuestionsAndOptions = new ArrayList<String>();
						} else {
							ArrayList<ArrayList<String>> listOfQuestions = new ArrayList<ArrayList<String>>();
							listOfQuestions.add(listOfQuestionsAndOptions);
							data.put(subject, listOfQuestions);
							listOfQuestionsAndOptions = new ArrayList<String>();
						}
					}
				}
			}

			//			for (Map.Entry<Integer, ArrayList<ArrayList<String>>> entry : data.entrySet()) {
			//			    System.out.println("Key = " + entry.getKey());
			//			    ArrayList<ArrayList<String>> listOfQuestions = entry.getValue();
			//			    for (ArrayList<String> arrayList : listOfQuestions) {
			//					System.out.println(arrayList);
			//				}
			//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	@Override
	public void addQuestion(Question question) {
		questionDao.save(question);
	}
	
}





