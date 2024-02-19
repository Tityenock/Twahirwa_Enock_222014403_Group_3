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

public class studentsForm implements ActionListener {
	JFrame frame;
	JLabel id_lb = new JLabel("student_ID");
	JLabel Firstname_lb = new JLabel("Firstname");
	JLabel lastname_lb = new JLabel("LastName");
	JLabel DOB_lb = new JLabel("DOB");
	JLabel teacherID_lb = new JLabel("teacherID");

	JTextField id_txf = new JTextField();
	JTextField Firstname_txf = new JTextField();
	JTextField lastname_txf = new JTextField();
	JTextField DOB_txf = new JTextField();
	JTextField teacherID_txf = new JTextField();
	// Buttons CRUD
	JButton INSERT_btn = new JButton("INSERT");
	JButton READ_btn = new JButton("View");
	JButton UPDATE_tbtn = new JButton("UPDATE");
	JButton DELETE_btn = new JButton("DELETE");
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	int w = (int) screensize.getWidth();
	int h = (int) screensize.getHeight();

	public studentsForm() {
		createForm();

	}

	private void ActionEvent() {
		INSERT_btn.addActionListener(this);
		READ_btn.addActionListener(this);
		UPDATE_tbtn.addActionListener(this);
		DELETE_btn.addActionListener(this);
		// methodpaymentBox.addActionListener(this);
	}

	private void createForm() {
		frame = new JFrame();
		frame.setTitle("student form");
		frame.setBounds(0, 0, 700, 400);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(97, 214, 245));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
	}

	private void setLocationandSize() {
		id_lb.setBounds(10, 10, 150, 30);
		Firstname_lb.setBounds(10, 50, 100, 30);
		lastname_lb.setBounds(10, 90, 100, 30);
		DOB_lb.setBounds(10, 130, 100, 30);
		teacherID_lb.setBounds(10, 170, 100, 30);

		id_txf.setBounds(180, 10, 300, 30);
		Firstname_txf.setBounds(180, 50, 300, 30);
		lastname_txf.setBounds(180, 90, 300, 30);
		DOB_txf.setBounds(180, 130, 300, 30);
		teacherID_txf.setBounds(180, 170, 300, 30);
		// Buttons CRUD
		INSERT_btn.setBounds(100, 220, 85, 30);
		INSERT_btn.setBackground(Color.orange);
		READ_btn.setBounds(200, 220, 85, 30);
		READ_btn.setBackground(Color.white);
		UPDATE_tbtn.setBounds(300, 220, 85, 30);
		UPDATE_tbtn.setBackground(Color.cyan);
		DELETE_btn.setBounds(400, 220, 85, 30);
		DELETE_btn.setBackground(Color.red);
		setFontforall();
		addcomponentforFrame();

	}

	private void setFontforall() {
		Font font = new Font("Courier New", Font.BOLD, 18);

		id_lb.setFont(font);
		Firstname_lb.setFont(font);
		lastname_lb.setFont(font);
		DOB_lb.setFont(font);
		teacherID_lb.setFont(font);

		id_txf.setFont(font);
		Firstname_txf.setFont(font);
		lastname_txf.setFont(font);
		DOB_txf.setFont(font);
		teacherID_txf.setFont(font);
		// Buttons CRUD
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		INSERT_btn.setFont(fonti);
		READ_btn.setFont(fonti);
		UPDATE_tbtn.setFont(fonti);
		DELETE_btn.setFont(fonti);

	}

	private void addcomponentforFrame() {
		frame.add(id_lb);
		frame.add(Firstname_lb);
		frame.add(lastname_lb);
		frame.add(DOB_lb);
		frame.add(teacherID_lb);

		frame.add(id_txf);
		frame.add(Firstname_txf);
		frame.add(lastname_txf);
		frame.add(DOB_txf);
		frame.add(teacherID_txf);

		// Buttons CRUD
		frame.add(INSERT_btn);
		frame.add(READ_btn);
		frame.add(UPDATE_tbtn);
		frame.add(DELETE_btn);
		ActionEvent();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		students cust = new students();
		if (e.getSource() == INSERT_btn) {
			cust.setFirstname(Firstname_txf.getText());
			cust.setlastname(lastname_txf.getText());
			cust.setDateOFBirth(DOB_txf.getText());
			cust.setteacherID(teacherID_txf.getText());

			cust.insertDataa();
		} else if (e.getSource() == READ_btn) {
			int id = Integer.parseInt(id_txf.getText());
			cust.readwithstudentID(id);
			id_txf.setText(String.valueOf(cust.getstudentID()));
			Firstname_txf.setText(cust.getFirstname());
			lastname_txf.setText(cust.getlastname());
			DOB_txf.setText(cust.getDateOFBirth());
			teacherID_txf.setText(cust.getteacherID());

		} else if (e.getSource() == UPDATE_tbtn) {
			int id = Integer.parseInt(id_txf.getText());
			cust.setFirstname(Firstname_txf.getText());
			cust.setlastname(lastname_txf.getText());
			cust.setDateOFBirth(DOB_txf.getText());
			cust.setteacherID(teacherID_txf.getText());

			cust.update(id);
		} else {
			int id = Integer.parseInt(id_txf.getText());
			cust.delete(id);
		}

	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		studentsForm cusf = new studentsForm();

	}

}
