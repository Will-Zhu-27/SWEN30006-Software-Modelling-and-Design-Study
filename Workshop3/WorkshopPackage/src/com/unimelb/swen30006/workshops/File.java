package com.unimelb.swen30006.workshops;

import java.text.SimpleDateFormat;
import java.util.Date;

// Sample private file class to be replaced by your implementaiton
class File {
	public final static String FILE_TYPE1 = "pdf";
	public final static String FILE_TYPE2 = "docx";
	
	private String fileName;
	private Date createdDate;
	private String fileType;
	private String fileData;
	
	public File(String fileName, String fileType, String fileData) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileData = fileData;
		createdDate = new Date();
	}
	  
    public String getFileType() {
    	return (new String(fileType));
    }
    
    public int fileSize() {
    	return fileData.length();
    }
    
    public String content() {
    	String ret = new String(fileData);
    	return ret;
    }
    
    public String toString() {
    	String ret = "File Name:" + fileName + "\n";
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss");
    	ret += "Created Date:" + sdf.format(createdDate) + "\n";
    	ret += "File Type:" + fileType + "\n";
    	return ret;
    }
    
    public String getFileName() {
    	return (new String(fileName));
    }
}