package com.StudyTimeTracker;

import java.io.IOException;
import java.io.File;


// Class to manipulate files
public class BinFiles {

	// Static method used to verify if the files exist and create them if they don't
	// executed at application launch
	public static void checkFile(String fileName) {
		File file = new File(fileName);
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
