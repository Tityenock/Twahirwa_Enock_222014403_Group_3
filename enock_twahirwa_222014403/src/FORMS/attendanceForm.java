package FORMS;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ENTITIES.attendances;

import java.sql.Connection;

@SuppressWarnings("unused")
public class attendanceForm implements ActionListener {

	JFrame frame;// attendanceID;studentID;action;
	JLabel attendanceID_lb = new JLabel("AT No:");
	JLabel studentID_lb = new JLabel("studentID:");
	JLabel action_lb = new JLabel("status:");

	JTextField attendanceID_txf = new JTextField();
	JTextField studentID_txf = new JTextField();
	JTextField action_txf = new JTextField();

	// Buttons CRUD
	JButton insert_btn = new JButton("Insert");
	JButton Read_btn = new JButton("View");
	JButton update_tbtn = new JButton("Update");
	JButton delete_btn = new JButton("Delete");

	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	int w = (int) screensize.getWidth();
	int h = (int) screensize.getHeight();

	public attendanceForm() {
		createForm();

	}

	private void ActionEvent() {
		insert_btn.addActionListener((ActionListener) this);
		Read_btn.addActionListener((ActionListener) this);
		update_tbtn.addActionListener((ActionListener) this);
		delete_btn.addActionListener((ActionListener) this);
	}

	private void createForm() {
		frame = new JFrame();
		frame.setTitle(" welcome to attendance Form");
		frame.setForeground(Color.WHITE);
		frame.setFont(new Font("Arial", Font.BOLD, 24));

		frame.setBounds(2, 4, w / 2, h / 2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(97, 214, 245));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setactionandSize();

	}

	private void setactionandSize() {
		attendanceID_lb.setBounds(10, 10, 300, 30);
		studentID_lb.setBounds(10, 50, 300, 30);
		action_lb.setBounds(10, 90, 300, 30);

		attendanceID_txf.setBounds(160, 10, 300, 30);
		studentID_txf.setBounds(160, 50, 300, 30);
		action_txf.setBounds(160, 90, 300, 30);

		// Buttons CRUD
		insert_btn.setBounds(100, 150, 85, 30);
		Read_btn.setBounds(200, 150, 85, 30);
		update_tbtn.setBounds(300, 150, 85, 30);
		delete_btn.setBounds(400, 150, 85, 30);
		setFontforall();
		addcomponentforFrame();

	}

	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		attendanceID_lb.setFont(font);
		studentID_lb.setFont(font);
		action_lb.setFont(font);

		attendanceID_txf.setFont(font);
		studentID_txf.setFont(font);
		action_txf.setFont(font);

		Font fonti = new Font("Courier New", Font.BOLD, 12);
		insert_btn.setFont(fonti);
		insert_btn.setBackground(Color.orange);
		Read_btn.setFont(fonti);
		Read_btn.setBackground(Color.WHITE);
		Read_btn.setForeground(Color.cyan);
		update_tbtn.setFont(fonti);
		update_tbtn.setForeground(Color.white);
		update_tbtn.setBackground(Color.blue);
		delete_btn.setFont(fonti);
		delete_btn.setForeground(Color.white);
		delete_btn.setBackground(Color.red);
	}

	private void addcomponentforFrame() {
		frame.add(attendanceID_lb);
		frame.add(studentID_lb);
		frame.add(action_lb);
		frame.add(attendanceID_txf);
		frame.add(studentID_txf);
		frame.add(action_txf);

		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		ActionEvent();
	}

	public void actionPerformed(ActionEvent e) {
		attendances st = new attendances();
		if (e.getSource() == insert_btn) {
			st.setstudentID(studentID_txf.getText());
			st.setaction(action_txf.getText());

			// st.insertData(st.getstudentID(), st.getaction()
			st.insertData();
		} else if (e.getSource() == Read_btn) {
			int attendanceID = Integer.parseInt(attendanceID_txf.getText());
			st.readwithattendanceID(attendanceID);

			studentID_txf.setText(st.getstudentID());
			action_txf.setText(st.getaction());

		} else if (e.getSource() == update_tbtn) {
			int attendanceID = Integer.parseInt(attendanceID_txf.getText());

			st.setstudentID(studentID_txf.getText());
			st.setaction(action_txf.getText());
			st.update(attendanceID);
		} else {
			int attendanceID = Integer.parseInt(attendanceID_txf.getText());
			st.delete(attendanceID);
		}

	}

	public static void main(String[] args) {
		attendanceForm stf = new attendanceForm();

	}
}
