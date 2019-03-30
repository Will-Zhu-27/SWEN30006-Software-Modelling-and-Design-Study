package com.unimelb.swen30006.workshops;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
	private String studentId;
	private String email;
	private List<Subject> subjectList;
	
	public Student(String name, String dobString, String address, 
			String studentID, String email) throws ParseException {
		super(name, dobString, address);
		this.studentId = studentID;
		this.email = email;
		subjectList = new ArrayList<Subject>();
	}
	
	public void enroll(Subject subject) {
		if(subjectList.contains(subject)) {
			System.out.println("You have enrolled this subject.");
		} else {
			subjectList.add(subject);
			System.out.println("Student ID:" + studentId + " enrolls " 
					+ subject.getName() + " successfully.");
		}
	}
	
	public Boolean submitAssignment(Subject subject, Assignment assignment,
			Submission submission) {
		// check whether subject exists
		if (!subjectList.contains(subject)) {
			System.out.println("Student ID:" + studentId +" doesn't enroll " +
					subject.getName() + ".");
			return false;
		}
		// check whether assignment exists.
		if(!subject.containAssignment(assignment)) {
			System.out.println("This assignment doesn't exist.");
			return false;
		}
		// submit
		return assignment.getSubmission(this, submission);
	}
	
	public String getEmail() {
		return (new String(email));
	}
	
	public String getStudentId() {
		String ret = new String(studentId);
		return ret;
	}
	public String toString() {
		String studentInfo = super.toString();
		studentInfo += "Student ID:" + studentId + "\n";
		studentInfo += "email:" + email + "\n";
		return studentInfo;
	}
	public float totalGrade() {
		float temp = 0f;
		return temp;
	}
}