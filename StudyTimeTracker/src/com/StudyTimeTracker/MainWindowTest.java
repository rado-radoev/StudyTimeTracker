package com.StudyTimeTracker;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class MainWindowTest {

	public static void main(String[] args) {
		MainWindow mw = new MainWindow();
		mw.setTitle("Study Time Tracking");
		mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mw.setVisible(true);
		mw.setSize(650, 450);
		mw.setResizable(false);
		mw.setLocationRelativeTo(null);
	}

}
