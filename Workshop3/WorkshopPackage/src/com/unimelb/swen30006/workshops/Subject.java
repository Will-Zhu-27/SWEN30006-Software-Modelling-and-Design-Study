package com.unimelb.swen30006.workshops;

import java.text.ParseException;
import java.util.ArrayList;

public class Subject {
	private String name;
	private String subjectCode;
	private ArrayList<Staff> staffList;
	private ArrayList<Assignment> assignmentList;
	
	public Subject(String name, String subjectCode) {
		this.name = name;
		this.subjectCode = subjectCode;
		staffList = new ArrayList<Staff>();
		assignmentList = new ArrayList <Assignment>();
	}
	
	public void addSubjectStaff(Staff staff) {
		staffList.add(staff);
	}
	
	public void removeSubjectStaff(Staff staff) {
		staffList.remove(staff);
	}
	
	public Boolean containStaff(Staff staff) {
		return staffList.contains(staff);
	}
	
	public Boolean containAssignment(Assignment assignment) {
		return assignmentList.contains(assignment);
	}
	
	public String staffListInfo() {
		String allSubjectStaffInfo = new String();
		for(int i = 0; i < staffList.size(); i++) {
			allSubjectStaffInfo += staffList.get(i).toString();
		}
		return allSubjectStaffInfo;
	}
	
	public String assignmentListInfo() {
		String ret = new String();
		for(int i = 0; i < assignmentList.size(); i++) {
			ret += assignmentList.get(i).toString();
		}
		return ret;
	}
	
	public String getName() {
		return name;
	}
	public String toString() {
		String ret = "*****************Subject Info*****************\n";
		ret += "Subject Name:" + name + "\n";
		ret += "Subject Code:" + subjectCode + "\n";
		ret += "   **************Staff Info**************\n";
		ret += staffListInfo();
		ret += "   **************************************\n";
		ret += this.assignmentListInfo();
		ret += "**********************************************\n";
		return ret;
	}
	
	public Assignment getAssignment(int index) {
		return assignmentList.get(index);
	}
	
	public void addAssignment(String name, String description, 
		String dueDateString,int maxAttempts, String uploadMethod)
		throws ParseException {
		Assignment assignment = new Assignment(name, description, dueDateString,
				maxAttempts, uploadMethod);
		assignmentList.add(assignment);
	}
	

	public void deleteAssignment(String name) {
		
	}
}