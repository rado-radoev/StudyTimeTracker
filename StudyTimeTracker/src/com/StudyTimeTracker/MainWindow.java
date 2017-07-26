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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;

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
	private JPanel currentActivityPanel1;
	private JPanel currentActivityPanel2;
	private JPanel currentActivityPanel3;
	private ButtonGroup currentActivityGroup;
	private JRadioButton studyRadioButton;
	private JRadioButton exercicesRadioButton;
	private JRadioButton projectsRadioButton;
	private JComboBox<String> studySubjectsDropDown;
	private JPanel studySubjectsPanel1;
	private JScrollPane studySubjectsScrollPane;
	private JLabel studySubjectLabel;
	private JButton startStudy;
	private JButton pauseStudy;
	private JButton stopStudy;
	private JButton displayStats;
	private JButton gitHubUpload;
	private JPanel buttonsPanel1;
	private JPanel buttonsPanel2;
			
	private final JPanel mainCenterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
	private final JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
	private final BorderLayout mainLayout = new BorderLayout();
	
	
	public MainWindow() {
		super();

		activitySection();
		add(currentActivityPanel3, mainLayout.NORTH);
		timeLabelsSection();
		studySubjectSection();
		add(mainCenterPanel, mainLayout.CENTER);
		buttonSection();
		add(bottomPanel, mainLayout.SOUTH);
	}

	private void activitySection() {
		
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
//		add(currentActivityPanel3, mainLayout.NORTH);	// Add the activity panel to the north border (top)
	}

	private void timeLabelsSection() {
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
			
		mainCenterPanel.add(studyTimeJPanel2);
				
	}

	private void studySubjectSection() {
		// Create a list of study objects. TO DO: later on they will be read from a file
		String[] studySubjectsList = {"Java", "HTML & JavaScript", "Python"};
		
		// Label to select the study subject
		studySubjectLabel = new JLabel("Select type of study:");
		
		// Panel that holds the label and the dropdown box
		studySubjectsPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
		
		// The combo box containing the subjects. Java or Index 0 is the default one
		// Add it to scrollable box
		studySubjectsDropDown = new JComboBox<String>(studySubjectsList);
		studySubjectsDropDown.setSelectedIndex(0);
		studySubjectsScrollPane = new JScrollPane(studySubjectsDropDown);

		// Add both items to the panel
		studySubjectsPanel1.add(studySubjectLabel);
		studySubjectsPanel1.add(studySubjectsScrollPane);
		
		// Add the panel to the main panel
		mainCenterPanel.add(studySubjectsPanel1);
	}
	
	private void buttonSection() {
		// create buttons
		startStudy = new JButton ("Start");
		pauseStudy = new JButton ("Pause");
		stopStudy = new JButton ("Stop");
		displayStats = new JButton ("Display Stats");
		gitHubUpload = new JButton ("GitHub upload ...");
		
		// Create two panel holding the button
		// Start, pause, stop, display stats will be on one line
		// githbu upload is on a second line
		
		buttonsPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
		buttonsPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
		
		buttonsPanel1.add(startStudy);
		buttonsPanel1.add(pauseStudy);
		buttonsPanel1.add(stopStudy);
		buttonsPanel1.add(displayStats);
		
		buttonsPanel2.add(gitHubUpload);
		
		bottomPanel.add(buttonsPanel1);
		bottomPanel.add(buttonsPanel2);
	}
}























