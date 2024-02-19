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

public class userForm implements ActionListener {
	JFrame frame;
	JLabel ID_lb = new JLabel("ID");
	JLabel username_lb = new JLabel("username");
	JLabel password_lb = new JLabel("password");
	JLabel role_lb = new JLabel("role");

	JTextField ID_txf = new JTextField();
	JTextField username_txf = new JTextField();
	JTextField password_txf = new JTextField();
	JTextField role_txf = new JTextField();

	// Buttons CRUD
	JButton INSERT_btn = new JButton("INSERT");
	JButton READ_btn = new JButton("View");
	JButton UPDATE_tbtn = new JButton("UPDATE");
	JButton DELETE_btn = new JButton("DELETE");
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	int w = (int) screensize.getWidth();
	int h = (int) screensize.getHeight();

	public userForm() {
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
		frame.setTitle("user form");
		frame.setBounds(0, 0, 700, 400);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(97, 214, 245));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
	}

	private void setLocationandSize() {
		ID_lb.setBounds(0, 10, 150, 30);
		username_lb.setBounds(0, 50, 100, 30);
		password_lb.setBounds(0, 90, 100, 30);
		role_lb.setBounds(0, 130, 100, 30);
		ID_txf.setBounds(180, 10, 300, 30);
		username_txf.setBounds(180, 50, 300, 30);
		password_txf.setBounds(180, 90, 300, 30);
		role_txf.setBounds(180, 130, 300, 30);

		// Buttons CRUD
		INSERT_btn.setBounds(100, 200, 85, 30);
		INSERT_btn.setBackground(Color.orange);
		READ_btn.setBounds(200, 200, 85, 30);
		READ_btn.setBackground(Color.white);
		UPDATE_tbtn.setBounds(300, 200, 85, 30);
		UPDATE_tbtn.setBackground(Color.cyan);
		DELETE_btn.setBounds(400, 200, 85, 30);
		DELETE_btn.setBackground(Color.red);
		setFontforall();
		addcomponentforFrame();

	}

	private void setFontforall() {
		Font font = new Font("Agency FB", Font.BOLD, 18);

		ID_lb.setFont(font);
		username_lb.setFont(font);
		password_lb.setFont(font);
		role_lb.setFont(font);

		ID_txf.setFont(font);
		username_txf.setFont(font);
		password_txf.setFont(font);
		role_txf.setFont(font);

		// Buttons CRUD
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		INSERT_btn.setFont(fonti);
		READ_btn.setFont(fonti);
		UPDATE_tbtn.setFont(fonti);
		DELETE_btn.setFont(fonti);

	}

	private void addcomponentforFrame() {
		frame.add(ID_lb);
		frame.add(username_lb);
		frame.add(password_lb);
		frame.add(role_lb);
		frame.add(ID_txf);
		frame.add(username_txf);
		frame.add(password_txf);
		frame.add(role_txf);
		// Buttons CRUD
		frame.add(INSERT_btn);
		frame.add(READ_btn);
		frame.add(UPDATE_tbtn);
		frame.add(DELETE_btn);
		ActionEvent();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		user cust = new user();
		if (e.getSource() == INSERT_btn) {

			cust.setusername(username_txf.getText());
			cust.setpassword(password_txf.getText());
			cust.setrole(role_txf.getText());

			cust.insertData();

			// Open the index form
			new login().setVisible(true);

		} else if (e.getSource() == READ_btn) {
			int id = Integer.parseInt(ID_txf.getText());
			cust.readwithid(id);
			ID_txf.setText(String.valueOf(cust.getid()));
			username_txf.setText(cust.getusername());
			password_txf.setText(cust.getpassword());
			role_txf.setText(cust.getrole());

		} else if (e.getSource() == UPDATE_tbtn) {
			int id = Integer.parseInt(ID_txf.getText());
			cust.setusername(username_txf.getText());
			cust.setpassword(password_txf.getText());
			cust.setrole(role_txf.getText());

			cust.update(id);
		} else {
			int id = Integer.parseInt(ID_txf.getText());
			cust.delete(id);
		}

	}

	public static void main(String[] args) {
		userForm sft = new userForm();
		System.out.println(sft);
	}
}
