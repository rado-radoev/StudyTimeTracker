package com.StudyTimeTracker;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
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

public class MainWindow extends JFrame implements ITime {
	
	private JLabel currentActivityLabel;
	private ButtonGroup currentActivityGroup;
	private JRadioButton[] studyActivities;
	private String[] studyActivityNames = {"Study", "Excerice", "Projects"};
	private JPanel currentActivityLabelPanel;
	private JPanel currentActivityRadioButtonsPanel;
	
	private JLabel[] timeLabels;
	private String[] timeLabelsNames = {"Current time", "Time started studying:" , "Time stopped studying:", 
			"Today study time:", "Total study time total:"};
	private JLabel timeLabel;
	private JPanel currentDateTimeJPanel1;
	private JPanel timeStudiedJPanel;
	private JPanel studyTimeJPanel;
	private JPanel studyTimeJPanelEmptySpace;
	
	private JComboBox<String> studySubjectsDropDown;
	private JPanel studySubjectsPanel1;
	private JScrollPane studySubjectsScrollPane;
	private String[] studySubjectsList = {"Java", "HTML & JavaScript", "Python"};

	private JLabel studySubjectLabel;
	private JButton[] buttons;
	private String[] buttonNames = {"Start", "Pause", "Stop", "Display Stats", "GitHub upload ..."};
	private JPanel buttonsPanel1;
	private JPanel buttonsPanel2;
			
	private final JPanel topPanel = new JPanel(new GridLayout(2, 1, 0, 0));
	private final JPanel mainCenterPanel = new JPanel(new GridLayout(2, 1, 0, 0));
	private final JPanel bottomPanel = new JPanel(new GridLayout(2, 1, 0 , 0));
	
	private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	public MainWindow() {
		super("Study Time Tracker");

		activitySection();
		timeLabelsSection();
		studySubjectSection();
		buttonSection();
		
		add(mainCenterPanel, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);
	}

	private void activitySection() {
			
		// Create current activity JPanel that will hold the 
		// CurrentActivity Label
		currentActivityLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		// Create and add the current activity label and add to its own panel
		currentActivityLabel = new JLabel("Current Activity");
		currentActivityLabelPanel.add(currentActivityLabel);
		
		// Create the Current Activity Radio Button group and
		// Add activity radio buttons to their own JPanel
		currentActivityRadioButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
		
		currentActivityGroup = new ButtonGroup();
		
		studyActivities = new JRadioButton[studyActivityNames.length];
		for (int i = 0; i < studyActivityNames.length; i++) {
			studyActivities[i] = new JRadioButton(studyActivityNames[i]); // Create the radio button
			currentActivityGroup.add(studyActivities[i]);	// Add to button Group
			currentActivityRadioButtonsPanel.add(studyActivities[i]);		// Add the radio buttons to the JPanel
		}	
		studyActivities[0].setSelected(true);
	

		// Add Activity Label and radio buttons to main Activity JPanel
		topPanel.add(currentActivityLabelPanel);
		topPanel.add(currentActivityRadioButtonsPanel);

	}

	private void timeLabelsSection() {
		// JPanel that will only hold the display for the current time
		currentDateTimeJPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		// JPanel that will hold all the calculations for the time spent studying
		timeStudiedJPanel = new JPanel(new GridLayout(2, 2, 100, 10));
		
		// Create all tha labels
		timeLabels = new JLabel[timeLabelsNames.length];
		for (int i = 0; i < timeLabelsNames.length; i++) {
			timeLabels[i] = new JLabel(timeLabelsNames[i]);		
			if (i == 0) {
				currentTime();
				currentDateTimeJPanel1.add(timeLabels[i]);
			}
			else {
				timeStudiedJPanel.add(timeLabels[i]);
			}
		}
		
		timeLabel = new JLabel();
		currentDateTimeJPanel1.add(timeLabel);
		
		// JPanel that will hold the current time panel and the time spent studying panel
		studyTimeJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 50));
		studyTimeJPanelEmptySpace = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,0));
		studyTimeJPanel.add(currentDateTimeJPanel1);
		studyTimeJPanel.add(studyTimeJPanelEmptySpace);
		studyTimeJPanel.add(timeStudiedJPanel);
		
		// Add this main panel to the border layout center panel
		mainCenterPanel.add(studyTimeJPanel);
			
	}

	private void studySubjectSection() {
		// Panel that holds the label and the dropdown box
		studySubjectsPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
		
		// Label to select the study subject
		studySubjectLabel = new JLabel("Select type of study:");
		
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
		// Create two panel holding the button
		// Start, pause, stop, display stats will be on one line
		// github upload is on a second line
		
		buttonsPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
		buttonsPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
		
		// create buttons
		buttons =  new JButton[buttonNames.length];
		for (int i = 0; i < buttons.length;i++) {
			buttons[i] = new JButton(buttonNames[i]);
			if (!buttonNames[i].equals("GitHub upload ...")) {
				buttonsPanel1.add(buttons[i]);
			}
			else {
				buttonsPanel2.add(buttons[i]);
			}
		}
		
		// Add the two panels to the bottom panel on the main window
		bottomPanel.add(buttonsPanel1);
		bottomPanel.add(buttonsPanel2);
	}

	@Override
	public void currentTime() {
		new Thread(() -> displayCurrentTime()).start();;
		
	}
	
	private void displayCurrentTime() {
		while (true) {
			try {
				timeLabels[0].setText(String.format("%s: %s",timeLabelsNames[0] ,LocalTime.now().format(timeFormatter)));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}























