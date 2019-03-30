package com.unimelb.swen30006.workshops;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {
	public final static int DAY_AFTER_TODAY = 10;
	public final static int MAX_ATTEMPTS = 3;
	public final static String LOAD_METHOD = File.FILE_TYPE1;
	
	public static void main(String[] args) throws ParseException {
		// create a subject	called SWEN30006
		Subject SWEN30006 = new Subject("Software Modelling and Design",
				"SWEN30006");
		
		// create an instructor
		String[] staffRoles = {Staff.INSTRUCTOR, "dean"};
		Staff instructor = new Staff("Bob", "1993-03-03", "Unimelb",
					"001", staffRoles);
		
		// add this instructor into SWEN30006
		SWEN30006.addSubjectStaff(instructor);
		
		// instructor create an assignment
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, DAY_AFTER_TODAY);
		String dueDateString = sdf.format(calendar.getTime());
		instructor.createAssignment(SWEN30006, "Project1", "Design a new LMS.",
				dueDateString, MAX_ATTEMPTS, LOAD_METHOD);
		
		System.out.println(SWEN30006.toString());
		
		// create a student
		Student student = new Student("Joel", "1999-09-12", "199 William St",
				"998877", "Joel@student.unimelb.edu.au");
		
		// student enroll SWEN30006
		student.enroll(SWEN30006);
		
		File file1 = new File("File1", File.FILE_TYPE1, "11111");
		File file2 = new File("File2", File.FILE_TYPE2, "22222");
		File[] work1 = {file1, file2};
		File[] work2 = {file1, file1};
		// first time to submit
		System.out.println("\n\nTest: student uploads wrong submission.");
		Submission submission1 = new Submission("note1", work1);
		student.submitAssignment(SWEN30006, SWEN30006.getAssignment(0),
				submission1);
		
		// second time to submit
		System.out.println("\n\nTest: student uploads right submission.");
		Submission submission2 = new Submission("note2", work2);
		student.submitAssignment(SWEN30006, SWEN30006.getAssignment(0),
				submission2);	
	}
}