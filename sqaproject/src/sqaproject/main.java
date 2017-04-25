package sqaproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class main {

	public static void main(String[] args) {

		frame fr1 = new frame();

		/*
		 * Scanner scan = new Scanner(System.in); String account =
		 * scan.nextLine(); String password = scan.nextLine();
		 * 
		 * System.out.println(account); int i; try {
		 * check_account_char(account); check_password_char(password);
		 * 
		 * } catch (charException e) { e.printStackTrace(); } catch
		 * (lengthException e) { e.printStackTrace(); }
		 * 
		 * }
		 * 
		 * public static void check_account_char(String account) throws
		 * Exception { int i, length;
		 * 
		 * length = account.length(); if (length < 5 || length > 12) { throw new
		 * lengthException("�b�����׻ݦb5��12����"); }
		 * 
		 * for (i = 0; i < account.length(); i++) { if (account.charAt(i) == '/'
		 * || account.charAt(i) == ',') { throw new
		 * charException("�b�����i�]�t'/'�άO','"); }
		 * 
		 * }
		 * 
		 * } public static void check_password_char(String password) throws
		 * Exception { int length,temp; char i; //
		 * temp=Integer.parseInt(password[0]); length = password.length(); if
		 * (length < 5 || length > 12) { throw new
		 * lengthException("�K�X���׻ݦb5��12����"); } for(i='A';i<='Z';i++) {
		 * if(password.charAt(0)!=i) { throw new
		 * charException("�K�X�Ĥ@�r���ݬ��j�g�^��r��"); } }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * class charException extends Exception {
		 * 
		 * public charException(String str) { super(str); }
		 * 
		 * }
		 * 
		 * class lengthException extends Exception { public
		 * lengthException(String str) { super(str); }
		 */
	}
}

class frame extends JMenuItem implements ActionListener {

	JMenuItem item1, item2, item3, item4;

	JMenu demo1;

	public frame() {

		JFrame frame = new JFrame("SwingDemo");
		frame.setSize(600, 400);
		frame.setLayout(new GridLayout(6, 4));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuItem item1, item2, item3, item4;
		JMenu demo1 = new JMenu("demo1");
		item1 = new JMenuItem("���U");
		item2 = new JMenuItem("�n�J");
		demo1.add(item1);
		item1.addActionListener(this);
		demo1.add(item2);
		/*
		 * JMenu demo2 = new JMenu("demo2"); item3 = new JMenuItem("three");
		 * item4 = new JMenuItem("four"); demo2.add(item3); demo2.add(item4);
		 */
		JMenuBar menubar = new JMenuBar();
		menubar.add(demo1);
		// menubar.add(demo2);
		frame.setJMenuBar(menubar);

		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("�n�J")) {
			frame1 t = new frame1();
			t.setVisible(true);

		}
		if (e.getActionCommand().equals("���U")) {
			frame2 t = new frame2();
			t.setVisible(true);

		}
	}

}

class frame1 extends JFrame implements ActionListener {

	TextField account_number, password;
	int[] text = new int[50];
	int[] text2 = new int[50];
	Label input_account_number = new Label("�b��");
	Label input_password = new Label("�K�X");
	JPanel Control = new JPanel();
	JPanel Control2 = new JPanel();
	JPanel Control3 = new JPanel();
	JButton login = new JButton("�n�J");
	JButton forgotpassword = new JButton("�ѰO�K�X");

	public frame1() {
		account_number = new TextField(10);
		password = new TextField(10);

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
		Control.add(input_password);
		Control.add(forgotpassword);

		Control2.setLayout(new GridLayout(0, 3));
		Control2.add(account_number);
		Control2.add(password);
		Control2.add(login);

		Control3.setLayout(new GridLayout(0, 1));
		Control3.add(Control);
		Control3.add(Control2);

		this.add(Control3);
		pack();
	}

	public void actionPerformed(ActionEvent arg0) {

	}

}
class frame2 extends JFrame implements ActionListener {
	TextField account_number, password;
	int[] text = new int[50];
	int[] text2 = new int[50];
	Label input_account_number = new Label("�b��");
	Label input_password = new Label("�K�X");
	JPanel Control = new JPanel();
	JPanel Control2 = new JPanel();
	JPanel Control3 = new JPanel();
	JButton login = new JButton("���U");
	JButton cancel = new JButton("����");

	public frame2() {
		account_number = new TextField(10);
		password = new TextField(10);

		login.addActionListener(this);
		login.setFont(new Font("�з���", Font.BOLD, 18));

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
		Control.add(input_password);
		Control.add(cancel);

		Control2.setLayout(new GridLayout(0, 3));
		Control2.add(account_number);
		Control2.add(password);
		Control2.add(login);

		Control3.setLayout(new GridLayout(0, 1));
		Control3.add(Control);
		Control3.add(Control2);

		this.add(Control3);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
