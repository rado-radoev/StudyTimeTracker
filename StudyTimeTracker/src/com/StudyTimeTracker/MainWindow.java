package com.StudyTimeTracker;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class MainWindow extends JFrame {
	
	private JLabel currentActivityLabel;
	private JLabel currentDateTimeLabel;
	private JPanel currentDateTimeJPanel1;
	private JLabel timeStartedStudyingLabel;
	private JLabel timeStoppedStudyingLabel;
	private JLabel totalStudyTimeLabel;
	private JLabel totalStudyTimeTodayLabel;
	private JPanel studyTimeJPanel1;
	private JPanel studyTimeJPanel2;
	private JPanel studyTimeJPanelEmptySpace;
	private final BorderLayout mainLayout = new BorderLayout();
	private JPanel currentActivityPanel1;
	private JPanel currentActivityPanel2;
	private JPanel currentActivityPanel3;
	private ButtonGroup currentActivityGroup;
	private JRadioButton studyRadioButton;
	private JRadioButton exercicesRadioButton;
	private JRadioButton projectsRadioButton;
	

	public MainWindow() {
		super();

		ActivitySection();
		TimeLabelsSection();
		
	}

	private void ActivitySection() {
		
		// Main JPanel that will hold the activity label and radio buttons
		currentActivityPanel3 = new JPanel(new GridLayout(2, 1, 0, 0));
		
		// Create current activity JPanel that will hold the 
		// CurrentActivity Label
		currentActivityPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		// Create and add the current activity label and add to its own panel
		currentActivityLabel = new JLabel("Current Activity");
		currentActivityPanel1.add(currentActivityLabel);
		
		// Create the Current Activity Radio Button group and
		// Add activity radio buttons to their own JPanel
		currentActivityPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
		
		currentActivityGroup = new ButtonGroup();
		
		studyRadioButton = new JRadioButton("Study", true);
		currentActivityGroup.add(studyRadioButton);
		exercicesRadioButton = new JRadioButton("Exercices", false);
		currentActivityGroup.add(exercicesRadioButton);
		projectsRadioButton = new JRadioButton("Projects", false);
		currentActivityGroup.add(projectsRadioButton);
		// Add the radio buttons to the JPanel
		currentActivityPanel2.add(studyRadioButton);
		currentActivityPanel2.add(exercicesRadioButton);
		currentActivityPanel2.add(projectsRadioButton);
		

		// Add Activity Label and radio buttons to main Activity JPanel
		currentActivityPanel3.add(currentActivityPanel1);
		currentActivityPanel3.add(currentActivityPanel2);
		
		// Add Activities JPanel to frame
		add(currentActivityPanel3, mainLayout.NORTH);	// Add the activity panel to the north border (top)
	}

	private void TimeLabelsSection() {
		currentDateTimeLabel = new JLabel("Current time:");
		currentDateTimeJPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		currentDateTimeJPanel1.add(currentDateTimeLabel);
		
		timeStartedStudyingLabel = new JLabel("Time started studying:");
		timeStoppedStudyingLabel = new JLabel("Time stopped studying:");
		totalStudyTimeLabel = new JLabel("Total study time:");
		totalStudyTimeTodayLabel = new JLabel("Total study time total:");
		studyTimeJPanel1 = new JPanel(new GridLayout(2, 2, 100, 10));
		
		studyTimeJPanel1.add(timeStartedStudyingLabel);
		studyTimeJPanel1.add(timeStoppedStudyingLabel);
		studyTimeJPanel1.add(totalStudyTimeLabel);
		studyTimeJPanel1.add(totalStudyTimeTodayLabel);

		studyTimeJPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 50));
		studyTimeJPanelEmptySpace = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,0));
		studyTimeJPanel2.add(currentDateTimeJPanel1);
		studyTimeJPanel2.add(studyTimeJPanelEmptySpace);
		studyTimeJPanel2.add(studyTimeJPanel1);
			
		add(studyTimeJPanel2, mainLayout.CENTER);

				
	}

}























