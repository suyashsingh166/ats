package com.ats.ATS.Config;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class test {
	
	public static void main(String args[]) {
		try {
			String path="C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\ATSDocs\\1_Suyash Singh";
			String keyword="cyfutureLOI";
			deleteFilesContainingKeyword(path,keyword);
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	 public static void deleteDirectory(File file)  
	    {  
	        
	        for (File subfile : file.listFiles()) {  
	            // if the subfile is a folder, recursively call the deleteDirectory()method  
	            if (subfile.isDirectory()) {    // isDirectory() method is used to check whether subfile is a folder or not  
	                deleteDirectory(subfile);  
	            }  
	            // use delete() method for deleting file and empty folder  
	            subfile.delete();  
	        }  
	    }
	 public static void deleteFilesContainingKeyword(String path, String keyword) {
	        // Create a File object for the directory
	        File directory = new File(path);

	        // Check if the directory exists and is a directory
	        if (directory.exists() && directory.isDirectory()) {
	            // Get all files in the directory
	            File[] files = directory.listFiles();

	            // Check if the directory is empty
	            if (files != null) {
	                // Iterate over each file
	                for (File file : files) {
	                    // Check if the file name contains the keyword
	                    if (file.isFile() && file.getName().contains(keyword)) {
	                        // Delete the file
	                        if (file.delete()) {
	                            System.out.println("Deleted file: " + file.getName());
	                        } else {
	                            System.out.println("Failed to delete file: " + file.getName());
	                        }
	                    }
	                }
	            } else {
	                System.out.println("The directory is empty or an I/O error occurred.");
	            }
	        } else {
	            System.out.println("The specified path is not a directory or does not exist.");
	        }
	    }
}
