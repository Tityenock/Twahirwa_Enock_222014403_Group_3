package FORMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menu extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2982199799068547857L;
	private JMenuBar menuBar;
	private JMenu home, teacher, students, classes, attendance, user;
	private JMenuItem exitMenuItem, aboutT, aboutST, aboutCL, aboutAT, aboutuser;
	private JTextArea textArea;

	public menu() {

		setTitle("NURSERY MANAGEMENT SYSTEM Application");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Create menu bar
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		// Create file menu
		home = new JMenu("Home");
		home.setForeground(Color.orange);
		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setForeground(Color.red);
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		home.add(exitMenuItem);

		teacher = new JMenu("Teacher");
		teacher.setForeground(Color.WHITE);
		aboutT = new JMenuItem("teacher");
		teacher.addActionListener(this);
		aboutT.addActionListener(this);
		aboutT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == aboutT) {
					new teacherForm();
					dispose();
				}
			}
		});

		students = new JMenu("Student");
		students.setForeground(Color.WHITE);
		aboutST = new JMenuItem("Student");
		students.addActionListener(this);
		aboutST.addActionListener(this);
		aboutST.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == aboutST) {
					new studentsForm();
					dispose();
				}
			}
		});
		// create attendance menu

		attendance = new JMenu("attendance");
		attendance.setForeground(Color.WHITE);
		aboutAT = new JMenuItem("attedance");
		attendance.addActionListener(this);
		aboutAT.addActionListener(this);
		aboutAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == aboutAT) {

					new attendanceForm();
					dispose();

				}
			}
		});

		classes = new JMenu("class");
		classes.setForeground(Color.WHITE);
		aboutCL = new JMenuItem("class");
		classes.addActionListener(this);
		aboutCL.addActionListener(this);
		aboutCL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == aboutCL) {
					new classesForm();
					dispose();
				}
			}
		});
		// create user menu
		user = new JMenu("User");
		user.setForeground(Color.cyan);
		user.setBackground(Color.black);
		aboutuser = new JMenuItem("user");
		aboutuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == aboutuser) {
					new userForm();
					dispose();
				}
			}
		});
		teacher.add(aboutT);
		students.add(aboutST);
		attendance.add(aboutAT);
		classes.add(aboutCL);
		user.add(aboutuser);

		menuBar.add(home);
		menuBar.add(teacher);
		menuBar.add(students);
		menuBar.add(attendance);
		menuBar.add(classes);
		menuBar.add(user);

		setJMenuBar(menuBar);

		// Create home page with menu paragraphs and short story details
		textArea = new JTextArea();
		textArea.setBackground(new Color(157, 142, 172));
		textArea.setForeground(Color.white);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setText(" WELCOME  to NURSERY MANAGEMNT SYSTEM!\n\n"
				+ "This SYSTEM allows you to perform various tasks using GUI.\n\n"
				+ "OUR PURPOSE is to MANAGE nersery student's performance.\n\n"
				+ " decide to develop this system . \n\n " + "due to i studied JAVA .\n\n"
				+ " so  this project hold five main part that are teacher,student,classes,users,and also attendance .\n\n "
				+ "In all part of this system allow to apply CRUD. " + " \n\n"
				+ " this systme developed and designed  by MR TWAHIRWA ENOCK,\n\n"
				+ " student in BIT Department GROUP 2 \n\n" + "REG number : 222014403.\n\n"

				+ " alright reserved. copy right 2023-2024 ");

		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}

	@SuppressWarnings("unused")
	private void showStory() {
		JOptionPane.showMessageDialog(null, textArea.getText());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new menu().setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
