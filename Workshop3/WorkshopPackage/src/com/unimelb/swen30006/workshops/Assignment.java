package com.unimelb.swen30006.workshops;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Assignment implements SubmissionValidator {
	
	
	private String name;
	private String description;
	private Date dueDate;
	private int maxAttempts;
	private String uploadMethod;
	private HashMap<Student, Submission> submissionMap;
	
	
	public Assignment(String name, String description, String dueDateString,
			int maxAttempts, String uploadMethod) throws ParseException {
		this.name = name;
		this.description = description;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss");
		dueDate = sdf.parse(dueDateString);
		this.maxAttempts = maxAttempts;
		this.uploadMethod = uploadMethod;
		submissionMap = new HashMap<>();
	}
	
	public String toString() {
		String ret = "   **************Assignment**************\n";
		ret += "Name:" + name + "\n";
		ret += "Description:" + description + "\n";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ret += "Deadline:" + sdf.format(dueDate) + "\n";
		ret += "Max Attempts:" + maxAttempts + "\n";
		ret += "   **************************************\n";
		return ret;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public Boolean checkOverdue(Date submitDate) {
		if(dueDate.compareTo(submitDate) < 0) {
			return true;
		}
		return false;
	}
	
	public Boolean getSubmission(Student student, Submission submission) {
		// check whether submission is overdue.
		Date submitDate = new Date();
		if(checkOverdue(submitDate)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss");
			System.out.println("It's too late to submit for this assignment" +
					" in " + sdf.format(submitDate) + ".");
			return false;
		}
		// set submission attempt time
		Submission lastSubmission = submissionMap.get(student);
		if (lastSubmission == null) {
			submission.setAttemptNum(1);
		} else {
			submission.setAttemptNum(lastSubmission.getAttemptNum() + 1);
		}
		// check whether the time of submission is more than max attempts.
		if (submission.getAttemptNum() > maxAttempts) {
			System.out.println("This submission has exceeded the max times of attmept.");
			return false;
		}
		// check upload method
		ValidationError[] errors = validateSubmission(submission);
		if (errors != null) {
			System.out.println("**************Error Happen**************");
			for(ValidationError error: errors) {
				System.out.println(error.toString());
			}
			System.out.println("****************************************");
			return false;
		}
		
		// now submit
		submissionMap.put(student, submission);
		sendEmailMsg(student);
		return true;
	}
	
	private void sendEmailMsg(Student student) {
		System.out.println("The system sends an email of receipt to " + 
				student.getEmail() + ".");
	}
	
    @Override
    public ValidationError[] validateSubmission(Submission submission) {
        ArrayList<ValidationError> errors = new ArrayList<ValidationError>();
        // Loop through all files and create an error if there are any no pdfs
        File[] files = submission.getFiles();
        for(File f : files){
            String type = f.getFileType();
            if(!type.equals(this.uploadMethod)){
                ValidationError error = new ValidationError(f);
                error.addError("File Type", "Unsupported filetype.");
                errors.add(error);
            }
        }
        if(errors.size() > 0){
           return errors.toArray(new ValidationError[0]);
        } else {
            return null;
        }
    }
}