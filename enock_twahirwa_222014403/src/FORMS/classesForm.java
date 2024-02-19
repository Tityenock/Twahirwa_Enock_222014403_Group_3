package FORMS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ENTITIES.*;

public class classesForm implements ActionListener {
	JFrame frame;
	JLabel classID_lb = new JLabel("classID");
	JLabel names_lb = new JLabel("className");
	JLabel TeacherID_lb = new JLabel("TeacherID");

	JTextField classID_txf = new JTextField();
	JTextField names_txf = new JTextField();
	JTextField Teacher_txf = new JTextField();

	// Buttons CRUD
	JButton INSERT_btn = new JButton("INSERT");
	JButton READ_btn = new JButton("View");
	JButton UPDATE_tbtn = new JButton("UPDATE");
	JButton DELETE_btn = new JButton("DELETE");
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	int w = (int) screensize.getWidth();
	int h = (int) screensize.getHeight();

	public classesForm() {
		createForm();

	}

	private void ActionEvent() {
		INSERT_btn.addActionListener(this);
		READ_btn.addActionListener(this);
		UPDATE_tbtn.addActionListener(this);
		DELETE_btn.addActionListener(this);
		// fuel_typeBox.addActionListener(this);
	}

	private void createForm() {
		frame = new JFrame();
		frame.setTitle("class form");
		frame.setBounds(0, 0, 700, 400);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(97, 214, 245));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
	}

	private void setLocationandSize() {
		classID_lb.setBounds(0, 10, 150, 30);
		names_lb.setBounds(0, 50, 100, 30);
		TeacherID_lb.setBounds(0, 90, 100, 30);
		classID_txf.setBounds(180, 10, 300, 30);
		names_txf.setBounds(180, 50, 300, 30);
		Teacher_txf.setBounds(180, 90, 300, 30);

		// Buttons CRUD
		INSERT_btn.setBounds(100, 150, 100, 30);
		INSERT_btn.setBackground(Color.orange);
		READ_btn.setBounds(225, 150, 100, 30);
		READ_btn.setBackground(Color.white);
		UPDATE_tbtn.setBounds(350, 150, 100, 30);
		UPDATE_tbtn.setBackground(Color.cyan);
		DELETE_btn.setBounds(475, 150, 100, 30);
		DELETE_btn.setBackground(Color.red);
		setFontforall();
		addcomponentforFrame();

	}

	private void setFontforall() {
		Font font = new Font("Agency FB", Font.BOLD, 18);

		classID_lb.setFont(font);
		names_lb.setFont(font);
		TeacherID_lb.setFont(font);

		classID_txf.setFont(font);
		names_txf.setFont(font);
		Teacher_txf.setFont(font);

		// Buttons CRUD
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		INSERT_btn.setFont(fonti);
		READ_btn.setFont(fonti);
		UPDATE_tbtn.setFont(fonti);
		DELETE_btn.setFont(fonti);

	}

	private void addcomponentforFrame() {
		frame.add(classID_lb);
		frame.add(names_lb);
		frame.add(TeacherID_lb);
		frame.add(classID_txf);
		frame.add(names_txf);
		frame.add(Teacher_txf);
		// Buttons CRUD
		frame.add(INSERT_btn);
		frame.add(READ_btn);
		frame.add(UPDATE_tbtn);
		frame.add(DELETE_btn);
		ActionEvent();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		classes cust = new classes();
		if (e.getSource() == INSERT_btn) {

			cust.setclassName(names_txf.getText());
			cust.setteacherID(Teacher_txf.getText());

			cust.insertData();
		} else if (e.getSource() == READ_btn) {
			int id = Integer.parseInt(classID_txf.getText());
			cust.readwithclassID(id);
			classID_txf.setText(String.valueOf(cust.getclassID()));
			names_txf.setText(cust.getclassName());
			Teacher_txf.setText(cust.getteacherID());

		} else if (e.getSource() == UPDATE_tbtn) {
			int id = Integer.parseInt(classID_txf.getText());
			cust.setclassName(names_txf.getText());
			cust.setteacherID(Teacher_txf.getText());

			cust.update(id);
		} else {
			int id = Integer.parseInt(classID_txf.getText());
			cust.delete(id);
		}

	}

	public static void main(String[] args) {
		classesForm sft = new classesForm();
		System.out.println(sft);
	}
}
