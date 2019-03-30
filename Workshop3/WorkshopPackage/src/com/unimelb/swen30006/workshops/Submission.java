package com.unimelb.swen30006.workshops;

// Sample private submission class to be replaced by your implementation
class Submission {
	public final static int NO_SET_ATTEMPT_NUM = -1;
	
	private int attemptNum;
	private String note;
	private File[] files;
	
	public Submission(String note, File[] files) {
		this.files = files;
		this.note = note;
		this.attemptNum = NO_SET_ATTEMPT_NUM;
	}
	
	public void setAttemptNum(int attemptNum) {
		this.attemptNum = attemptNum;
	}
	
	public int getAttemptNum() {
		return attemptNum;
	}
	
	public File[] getFiles() {
		return files.clone();
	}
	
	public String toString() {
		String ret = "*****************Submission Info*****************\n";
		if (note != null) {
			ret += "   **************Note Info**************\n";
			ret += note + "\n";
			ret += "   *************************************\n";
		}
		for(int i = 0; i < files.length; i++) {
			ret += files[i].toString();
		}
		ret +=       "*************************************************\n";
		return ret;
	}
}
