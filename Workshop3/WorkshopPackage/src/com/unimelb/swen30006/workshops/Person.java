package com.unimelb.swen30006.workshops;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person{
	private String name;
	private Date dob;
	private String address;
	
	public Person(String name, String dobString, String address)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		dob = sdf.parse(dobString);
		this.name = name;
		this.address = address;
	}
	
	public String toString() {
		String printInfo;
		printInfo = "Name:" + name + "\n";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dobString = sdf.format(dob);
		printInfo += "Date of Birth:" + dobString + "\n";
		printInfo += "Address:" + address + "\n";
		return printInfo;
	}
}