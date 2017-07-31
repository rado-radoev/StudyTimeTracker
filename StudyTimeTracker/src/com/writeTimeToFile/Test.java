package com.writeTimeToFile;

public class Test {

	public static void main(String[] args) {
		Study s = new Study();
		s.openFile();
		s.addStartTime();
		s.closeFile();

	}

}
