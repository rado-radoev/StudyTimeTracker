package com.StudyTimeTracker;

import javax.swing.JFrame;
import java.awt.FlowLayout;
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
	
	private final JLabel currentActivityLabel;
//	private final JLabel currentDateTimeLabel;
//	private final JLabel timeStartedStudyingLabel;
//	private final JLabel timeStoppedStudyingLabel;
//	private final JLabel totalStudyTimeLabel;
//	private final JLabel totalStudyTimeTodayLabel;
	private final BorderLayout mainLayout;
	private final JPanel currentActivitiPanel;
	private final ButtonGroup currentActivityGroup;
	private final JRadioButton studyRadioButton;
	private final JRadioButton exercicesRadioButton;
	private final JRadioButton projectsRadioButton;
	

	public MainWindow() {
		super();
		mainLayout = new BorderLayout();
		
		// Create current activity JPanel that will hold the 
		// CurrentActivity Label and Radio buttons
		currentActivitiPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		currentActivityLabel = new JLabel("Current Activity");
		currentActivitiPanel.add(currentActivityLabel);
		
		// Create the Current Activity Radio Button group and
		// Add activity radio buttons
		currentActivityGroup = new ButtonGroup();
		studyRadioButton = new JRadioButton("Study", true);
		currentActivityGroup.add(studyRadioButton);
		exercicesRadioButton = new JRadioButton("Exercices", false);
		currentActivityGroup.add(exercicesRadioButton);
		projectsRadioButton = new JRadioButton("Projects", false);
		currentActivityGroup.add(projectsRadioButton);
		
		// Add the radio buttons to the JPanel
		currentActivitiPanel.add(studyRadioButton);
		currentActivitiPanel.add(exercicesRadioButton);
		currentActivitiPanel.add(projectsRadioButton);
		
		
		add(currentActivitiPanel);
	}

	
}
