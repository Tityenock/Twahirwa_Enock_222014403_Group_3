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

public class teacherForm implements ActionListener {
	JFrame frame;
	JLabel id_lb = new JLabel("teacher_ID");
	JLabel Firstname_lb = new JLabel("Firstname");
	JLabel lastname_lb = new JLabel("LastName");
	JLabel email_lb = new JLabel("email");
	JLabel phone_lb = new JLabel("phone");
	JLabel department_lb = new JLabel("DERPT");
	JLabel admin_lb = new JLabel("adminCODE");

	JTextField id_txf = new JTextField();
	JTextField Firstname_txf = new JTextField();
	JTextField lastname_txf = new JTextField();
	JTextField email_txf = new JTextField();
	JTextField phone_txf = new JTextField();
	JTextField department_txf = new JTextField();
	JTextField admin_txf = new JTextField();
	// Buttons CRUD
	JButton INSERT_btn = new JButton("INSERT");
	JButton READ_btn = new JButton("View");
	JButton UPDATE_tbtn = new JButton("UPDATE");
	JButton DELETE_btn = new JButton("DELETE");
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	int w = (int) screensize.getWidth();
	int h = (int) screensize.getHeight();

	public teacherForm() {
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
		frame.setTitle("teacher form");
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
		email_lb.setBounds(10, 130, 100, 30);
		phone_lb.setBounds(10, 170, 100, 30);
		department_lb.setBounds(10, 210, 100, 30);
		admin_lb.setBounds(10, 250, 100, 30);

		id_txf.setBounds(210, 10, 300, 30);
		Firstname_txf.setBounds(210, 50, 300, 30);
		lastname_txf.setBounds(210, 90, 300, 30);
		email_txf.setBounds(210, 130, 300, 30);
		phone_txf.setBounds(210, 170, 300, 30);
		department_txf.setBounds(210, 210, 300, 30);
		admin_txf.setBounds(210, 250, 300, 30);
		// Buttons CRUD
		INSERT_btn.setBounds(150, 300, 85, 30);
		INSERT_btn.setBackground(Color.orange);
		READ_btn.setBounds(250, 300, 85, 30);
		READ_btn.setBackground(Color.white);
		UPDATE_tbtn.setBounds(350, 300, 85, 30);
		UPDATE_tbtn.setBackground(Color.cyan);
		DELETE_btn.setBounds(450, 300, 85, 30);
		DELETE_btn.setBackground(Color.red);
		setFontforall();
		addcomponentforFrame();

	}

	private void setFontforall() {
		Font font = new Font("Courier New", Font.BOLD, 18);

		id_lb.setFont(font);
		Firstname_lb.setFont(font);
		lastname_lb.setFont(font);
		email_lb.setFont(font);
		phone_lb.setFont(font);
		department_lb.setFont(font);
		admin_lb.setFont(font);

		id_txf.setFont(font);
		Firstname_txf.setFont(font);
		lastname_txf.setFont(font);
		email_txf.setFont(font);
		phone_txf.setFont(font);
		department_txf.setFont(font);
		admin_txf.setFont(font);
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
		frame.add(email_lb);
		frame.add(phone_lb);
		frame.add(department_lb);
		frame.add(admin_lb);

		frame.add(id_txf);
		frame.add(Firstname_txf);
		frame.add(lastname_txf);
		frame.add(email_txf);
		frame.add(phone_txf);
		frame.add(department_txf);
		frame.add(admin_txf);

		// Buttons CRUD
		frame.add(INSERT_btn);
		frame.add(READ_btn);
		frame.add(UPDATE_tbtn);
		frame.add(DELETE_btn);
		ActionEvent();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		teacher cust = new teacher();
		if (e.getSource() == INSERT_btn) {
			cust.setFirstname(Firstname_txf.getText());
			cust.setlastname(lastname_txf.getText());
			cust.setEmail(email_txf.getText());
			cust.setphone(phone_txf.getText());
			cust.setdepartment(department_txf.getText());
			cust.setadmin(admin_txf.getText());

			cust.insertDataa();
		} else if (e.getSource() == READ_btn) {
			int id = Integer.parseInt(id_txf.getText());
			cust.readwithteacherID(id);
			id_txf.setText(String.valueOf(cust.getteacherID()));
			Firstname_txf.setText(cust.getFirstname());
			lastname_txf.setText(cust.getlastname());
			email_txf.setText(cust.getEmail());
			phone_txf.setText(cust.getphone());
			department_txf.setText(cust.getdepartment());
			admin_txf.setText(cust.getadmin());

		} else if (e.getSource() == UPDATE_tbtn) {
			int id = Integer.parseInt(id_txf.getText());
			cust.setFirstname(Firstname_txf.getText());
			cust.setlastname(lastname_txf.getText());
			cust.setEmail(email_txf.getText());
			cust.setphone(phone_txf.getText());
			cust.setdepartment(department_txf.getText());
			cust.setadmin(admin_txf.getText());

			cust.update(id);
		} else {
			int id = Integer.parseInt(id_txf.getText());
			cust.delete(id);
		}

	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		teacherForm cusf = new teacherForm();

	}

}
