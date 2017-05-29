package sqaproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class main {

	public static void main(String[] args) {

		frame fr1 = new frame();

	}
}

class frame extends JMenuItem implements ActionListener {

	JMenuItem item_login, item_password, item3, item4;
	JPanel Control = new JPanel();
	Label title = new Label("�w��Ө쥻�t��");

	JMenu demo1;

	public frame() {

		JFrame frame = new JFrame("SwingDemo");
		frame.setSize(600, 400);
		frame.setLayout(new GridLayout(6, 4));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		title.setFont(new Font("�з���", Font.BOLD, 35));
		Control.add(title);

		frame.add(Control);

		JMenuItem item1, item2, item3, item4;
		JMenu demo1 = new JMenu("�\��");
		item_login = new JMenuItem("���U");
		item_password = new JMenuItem("�n�J");
		demo1.add(item_login);

		item_login.addActionListener(this);
		item_password.addActionListener(this);
		demo1.add(item_password);

		JMenuBar menubar = new JMenuBar();
		menubar.add(demo1);

		frame.setJMenuBar(menubar);

		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("�n�J")) {
			login t1 = new login();
			t1.setVisible(true);

		}
		if (e.getActionCommand().equals("���U")) {

			registered t = new registered();
			t.setVisible(true);

		}
	}

}

class login extends JFrame implements ActionListener {

	registered r = new registered();
	Random ran = new Random();
	TextField account_number, password, input_checkcode;
	int[] text = new int[50];
	int[] text2 = new int[50];
	Label input_account_number = new Label("�b��");
	Label input_password = new Label("�K�X");
	Label message = new Label("");
	Label check = new Label("��J���ҽX");
	Label checkcode = new Label("");
	JPanel Control = new JPanel();
	JPanel Control2 = new JPanel();
	JPanel Control3 = new JPanel();
	JPanel Control4 = new JPanel();
	JButton login = new JButton("�n�J");
	JButton forgotpassword = new JButton("�ѰO�K�X");
	int count_error = 0, ran_number, a;
	Connection con = null;
	String[] str_account = new String[10];
	String[] str_password = new String[10];
	String[] str_email = new String[20];
	String s;

	public login() {
		account_number = new TextField(10);
		password = new TextField(10);
		input_checkcode = new TextField(10);
		login.addActionListener(this);
		login.setFont(new Font("�з���", Font.BOLD, 18));

		forgotpassword.addActionListener(this);
		forgotpassword.setFont(new Font("�з���", Font.BOLD, 18));

		input_account_number.setForeground(Color.WHITE);
		input_account_number.setFont(new Font("�з���", Font.BOLD, 18));
		input_account_number.setBackground(Color.GRAY);

		input_password.setFont(new Font("�з���", Font.BOLD, 18));
		input_password.setForeground(Color.WHITE);
		input_password.setBackground(Color.GRAY);

		Control.setLayout(new GridLayout(0, 3));
		Control.add(input_account_number);
		Control.add(account_number);
		Control.add(forgotpassword);

		Control2.setLayout(new GridLayout(0, 3));
		Control2.add(input_password);
		Control2.add(password);
		Control2.add(login);

		Control4.setLayout(new GridLayout(0, 3));

		Control4.add(check);
		Control4.add(checkcode);
		Control4.add(input_checkcode);
		Random ran = new Random();
		ran_number = ran.nextInt(1000) + 1;
		s = String.valueOf(ran_number);

		checkcode.setText(String.valueOf(ran_number));

		Control3.setLayout(new GridLayout(0, 1));
		Control3.add(Control);
		Control3.add(Control2);
		Control3.add(Control4);

		this.add(Control3);
		pack();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("�n�J")) {

			int u = 0, count, flag = 0, flag2 = 0;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				// ���Udriver
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost/data?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
						"zh403027");
				// ���oconnection
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				try {
					// �إ�SQL�d��
					String sql = "select * from  information ";
					ResultSet rs = stmt.executeQuery(sql);

					// ��ܸ��
					int i = 0;
					while (rs.next()) {
						u = 0;
						str_account[u] = rs.getString("account");
						str_password[u] = rs.getString("password");
						str_email[u] = rs.getString("email");

						u++;

					}

					for (count = 0; count < u; count++) {
						if (account_number.getText().equals(str_account[count])
								&& password.getText().equals(str_password[count])) {

							flag = 1;
						}

						else {
							count_error++;
							flag = 2;
							flag2 = 0;

						}
					}
					if (input_checkcode.getText().equals(s)) {
						flag = 1;
					} else {
						count_error++;
						flag = 2;
						flag2 = 0;
					}

					if (flag == 1) {

						JOptionPane.showMessageDialog(this, "�n�J���\");
					} else if (flag == 2) {
						count_error--;
					}

					if (count_error == 3) {
						System.exit(0);
					}

					if (flag2 == 0) {

						JOptionPane.showMessageDialog(this, "���ҽX�αb�����~");
						account_number.setText(" ");
						password.setText(" ");
						input_checkcode.setText(" ");

					}

					// �����s�u
					rs.close();
					rs = null;
					stmt.close();
					stmt = null;
					con.close();
				} catch (Exception ex) {
					System.out.println("can't read data");
					System.out.println(ex.toString());
				}
			} catch (Exception e1) {
				System.out.println("can't create statement");
				System.out.println(e1.toString());
			}

		}

		if (arg0.getActionCommand().equals("�ѰO�K�X")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				int u = 0, count, r;

				// ���Udriver
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost/data?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
						"zh403027");
				// ���oconnection
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				try {
					// �إ�SQL�d��
					String sql = "select * from  information ";
					ResultSet rs = stmt.executeQuery(sql);

					// ��ܸ��
					int i = 0;
					while (rs.next()) {
						u = 0;
						str_account[u] = rs.getString("account");
						str_password[u] = rs.getString("password");
						str_email[u] = rs.getString("email");

						u++;

					}

					String input_mail = JOptionPane.showInputDialog("�п�J�b��");
					for (r = 0; r < u; r++) {
						if (input_mail.equals(str_account[r])) {
							a = r;

							send s = new send();
							s.send2(str_email[r], str_password[r]);

						}

					}

				} catch (Exception ex) {
					System.out.println("can't read data");
					System.out.println(ex.toString());
				}
			} catch (Exception e1) {
				System.out.println("can't create statement");
				System.out.println(e1.toString());
			}

		}

	}

}

class registered extends JFrame implements ActionListener {

	TextField account_number, password, email;
	int[] text = new int[50];
	int[] text2 = new int[50];
	int u, count = 0;
	Label input_account_number = new Label("�b��");
	Label input_account_rule = new Label("�b���W�h:�b�����׻ݦb5��12����,�b�����i�]�t'/'�άO','");
	Label input_password = new Label("�K�X");
	Label input_password_rule = new Label("�K�X�W�h:�b�����׻ݦb5��12����,�K�X�Ĥ@�r���ݬ��j�g�^��r��");
	Label input_email = new Label("�H�c");
	Label input_mail_rule = new Label("�@���ѰO�K�X�ϥ�");

	Label message = new Label("");
	JPanel Control = new JPanel();
	JPanel Control2 = new JPanel();
	JPanel Control3 = new JPanel();
	JPanel Control4 = new JPanel();
	JPanel Control5 = new JPanel();
	JButton login = new JButton("���U");
	JButton cancel = new JButton("����");

	String[] str_account = new String[10];
	String[] str_password = new String[10];
	String[] str_email = new String[20];

	public registered() {
		account_number = new TextField(10);
		password = new TextField(10);
		email = new TextField(10);
		login.addActionListener(this);
		login.setFont(new Font("�з���", Font.BOLD, 18));
		login.addActionListener(this);
		cancel.addActionListener(this);
		cancel.setFont(new Font("�з���", Font.BOLD, 18));

		input_account_number.setForeground(Color.WHITE);
		input_account_number.setFont(new Font("�з���", Font.BOLD, 18));
		input_account_number.setBackground(Color.GRAY);

		input_password.setFont(new Font("�з���", Font.BOLD, 18));
		input_password.setForeground(Color.WHITE);
		input_password.setBackground(Color.GRAY);

		Control.setLayout(new GridLayout(0, 3));
		Control.add(input_account_number);
		Control.add(account_number);
		Control.add(input_account_rule);

		Control2.setLayout(new GridLayout(0, 3));
		Control2.add(input_password);
		Control2.add(password);
		Control2.add(input_password_rule);

		Control4.setLayout(new GridLayout(0, 3));
		Control4.add(login);
		Control4.add(cancel);
		Control4.add(message);

		Control5.setLayout(new GridLayout(0, 3));
		Control5.add(input_email);
		Control5.add(email);
		Control5.add(input_mail_rule);

		Control3.setLayout(new GridLayout(0, 1));
		Control3.add(Control);
		Control3.add(Control2);

		Control3.add(Control5);
		Control3.add(Control4);
		this.add(Control3);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// creates three different Connection objects
		Connection con = null;
		int j, length_account = account_number.getText().length(), flag = 0;
		int length_password = password.getText().length();
		char c;
		if (e.getActionCommand().equals("���U")) {

			for (j = 0; j < length_account; j++) {
				if (account_number.getText().charAt(j) == ',' || account_number.getText().charAt(j) == '/') {
					flag = 1;
				} else if (account_number.getText().length() < 5 || account_number.getText().length() > 12) {
					flag = 1;
				}

			}
			for (c = 'A'; c <= 'Z'; c++) {

				if (password.getText().charAt(0) == c) {
					flag =0;
                   break;
				}
				else
				{
					flag =1;
				}
			}
			if (password.getText().length() < 5 || password.getText().length() > 12) {
				flag = 1;
			}

			if (email.getText().isEmpty() == true) {
				flag = 1;
			}

			if (flag == 0) {

				try {
					Class.forName("com.mysql.jdbc.Driver");
					// ���Udriver
					con = DriverManager.getConnection(
							"jdbc:mysql://localhost/data?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
							"zh403027");
					// ���oconnection
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

					try {
						// �إ�SQL�d��
						String sql = "INSERT INTO information (account, password,email) VALUES (?, ?, ?)";
						int i = 0;
						PreparedStatement statement = con.prepareStatement(sql);// ���إߤ@��
																				// SQL
																				// �y�y�æ^�Ǥ@��
																				// PreparedStatement
																				// ����
																				// ���A���w�g�ǳƦn���ԭz�N�٬��uprepared
																				// statement�v
						String sql2 = "select * from  information ";
						ResultSet rs2 = stmt.executeQuery(sql2);

						while (rs2.next()) {
							u = 0;
							str_account[u] = rs2.getString("account");
							str_password[u] = rs2.getString("password");
							str_email[u] = rs2.getString("email");
							u++;

						}

						for (count = 0; count < u; count++) {
							if (account_number.getText().equals(str_account[count])) {
								flag = 0;
							} else {
								flag = 1;
							}
						}

						if (flag == 1) {

							statement.setString(1, account_number.getText());
							statement.setString(2, password.getText());
							statement.setString(3, email.getText());
							int rowsInserted = statement.executeUpdate();
							if (rowsInserted > 0) {
								JOptionPane.showMessageDialog(this, "���U���\");
							}
							ResultSet rs = stmt.executeQuery(sql);
							// �q�LStatement������Ʈw�U�FSQL��Ƭd�߫��O�è��o�^�Ǥ�ResultSet����
							// (�I�sjava.sql.Statement����executeQuery()��k�õ���"select
							// *
							// from employees"�Ѽ�
							// �����s�u

							rs.close();
							rs = null;
							stmt.close();
							stmt = null;
							con.close();
						} else {
							assert (flag == 0);

							JOptionPane.showMessageDialog(this, "�b���w���U");

							account_number.setText(" ");
							password.setText(" ");
							email.setText(" ");

						}

					} catch (Exception ex) {
						System.out.println("can't read data");
						System.out.println(ex.toString());
					}
				} catch (Exception e1) {
					System.out.println("can't create statement");
					System.out.println(e1.toString());
				}
			} else {

				message.setText("error");
			}

		}

		if (e.getActionCommand().equals("����")) {
			System.exit(0);
		}

	}

}
