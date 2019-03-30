package com.unimelb.swen30006.workshops;

import java.text.ParseException;

public class Staff extends Person {
	public static final String INSTRUCTOR = "instructor";
	
	public String staffID;
	public String[] roles;
	
	public Staff(String name, String dobString, String address,String staffID,
			String[] roles) throws ParseException {
		super(name, dobString, address);
		this.staffID = staffID;
		this.roles = roles;
	}
	
	public String toString() {
		String staffInfo = super.toString();
		staffInfo += "Staff ID:" + staffID  + "\n";
		staffInfo += "Role:";
		for(String role: roles) {
			staffInfo += role + " ";
		}
		staffInfo += "\n";
		return staffInfo;
	}
	
	public Boolean createAssignment(Subject subject, String name, 
			String description, String dueDateString, int maxAttempts, 
			String uploadMethod) throws ParseException {
		if (!subject.containStaff(this)) {
			System.out.println("Staff ID:" + staffID + 
					" has no right to create an assignment in "
					+ subject.getName() + ".");
			return false;
		}
		
		// print who is creating the assignment
		System.out.println("Staff ID:" + staffID + " creates an assignment in " + 
				subject.getName() + ".");
		subject.addAssignment(name, description, dueDateString, maxAttempts,
				uploadMethod);
		return true;
	}
}