package sqaproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
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
		 * lengthException("帳號長度需在5到12之間"); }
		 * 
		 * for (i = 0; i < account.length(); i++) { if (account.charAt(i) == '/'
		 * || account.charAt(i) == ',') { throw new
		 * charException("帳號不可包含'/'或是','"); }
		 * 
		 * }
		 * 
		 * } public static void check_password_char(String password) throws
		 * Exception { int length,temp; char i; //
		 * temp=Integer.parseInt(password[0]); length = password.length(); if
		 * (length < 5 || length > 12) { throw new
		 * lengthException("密碼長度需在5到12之間"); } for(i='A';i<='Z';i++) {
		 * if(password.charAt(0)!=i) { throw new
		 * charException("密碼第一字元需為大寫英文字母"); } }
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
		item1 = new JMenuItem("註冊");
		item2 = new JMenuItem("登入");
		demo1.add(item1);
		item1.addActionListener(this);
		item2.addActionListener(this);
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
		if (e.getActionCommand().equals("登入")) {
			login t1 = new login();
			t1.setVisible(true);

		}
		if (e.getActionCommand().equals("註冊")) {

			registered t = new registered();
			t.setVisible(true);

		}
	}

}

class login extends JFrame implements ActionListener {

	registered r = new registered();

	TextField account_number, password;
	int[] text = new int[50];
	int[] text2 = new int[50];
	Label input_account_number = new Label("帳號");
	Label input_password = new Label("密碼");
	JPanel Control = new JPanel();
	JPanel Control2 = new JPanel();
	JPanel Control3 = new JPanel();
	JButton login = new JButton("登入");
	JButton forgotpassword = new JButton("忘記密碼");

	public login() {
		account_number = new TextField(10);
		password = new TextField(10);

		login.addActionListener(this);
		login.setFont(new Font("標楷體", Font.BOLD, 18));

		forgotpassword.addActionListener(this);
		forgotpassword.setFont(new Font("標楷體", Font.BOLD, 18));

		input_account_number.setForeground(Color.WHITE);
		input_account_number.setFont(new Font("標楷體", Font.BOLD, 18));
		input_account_number.setBackground(Color.GRAY);

		input_password.setFont(new Font("標楷體", Font.BOLD, 18));
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
		if (arg0.getActionCommand().equals("登入")) {
			Connection con = null;
			int u = 0, count;
			String[] str_account = new String[10];
			String[] str_password = new String[10];
			try {
				Class.forName("com.mysql.jdbc.Driver");
				// 註冊driver
				con = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/member?useUnicode=true&characterEncoding=Big5", "root",
						"zh403027");
				// 取得connection
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				try {
					// 建立SQL查詢
					String sql = "select * from  information ";
					ResultSet rs = stmt.executeQuery(sql);

					// 顯示資料
					int i = 0;
					while (rs.next()) {
						u = 0;
						str_account[u] = rs.getString("account");
						str_password[u] = rs.getString("password");

						u++;

					}

					for (count = 0; count < u; count++)
						if (account_number.getText().equals(str_account[count])) {
							System.out.println("ok");
							System.out.println(u);
						}

					// 關閉連線
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
	}

}

class registered extends JFrame implements ActionListener {

	TextField account_number, password;
	int[] text = new int[50];
	int[] text2 = new int[50];
	Label input_account_number = new Label("帳號");
	Label input_account_rule = new Label("帳號規則:帳號長度需在5到12之間,帳號不可包含'/'或是','");
	Label input_password = new Label("密碼");
	Label input_password_rule = new Label("密碼規則:帳號長度需在5到12之間,密碼第一字元需為大寫英文字母");
	JPanel Control = new JPanel();
	JPanel Control2 = new JPanel();
	JPanel Control3 = new JPanel();
	JPanel Control4 = new JPanel();
	JButton login = new JButton("註冊");
	JButton cancel = new JButton("取消");
	char[][] account_1 = new char[10][20];
	char[][] password_2 = new char[10][20];

	public registered() {
		account_number = new TextField(10);
		password = new TextField(10);

		login.addActionListener(this);
		login.setFont(new Font("標楷體", Font.BOLD, 18));
		login.addActionListener(this);
		cancel.addActionListener(this);
		cancel.setFont(new Font("標楷體", Font.BOLD, 18));

		input_account_number.setForeground(Color.WHITE);
		input_account_number.setFont(new Font("標楷體", Font.BOLD, 18));
		input_account_number.setBackground(Color.GRAY);

		input_password.setFont(new Font("標楷體", Font.BOLD, 18));
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

		Control4.setLayout(new GridLayout(0, 2));
		Control4.add(login);
		Control4.add(cancel);

		Control3.setLayout(new GridLayout(0, 1));
		Control3.add(Control);
		Control3.add(Control2);
		Control3.add(Control4);
		this.add(Control3);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// creates three different Connection objects
		Connection con = null;
		int j, length_account = account_number.getText().length(), flag = 0;
		if (e.getActionCommand().equals("註冊")) {

			for (j = 0; j < length_account; j++) {
				if (account_number.getText().charAt(j) == ',' || account_number.getText().charAt(j) == '/') {
					flag = 1;
				} else if (account_number.getText().length() < 5 || account_number.getText().length() > 12) {
					flag = 1;
				}

			}

			if (flag == 0) {

				try {
					Class.forName("com.mysql.jdbc.Driver");
					// 註冊driver
					con = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/member?useUnicode=true&characterEncoding=Big5", "root",
							"zh403027");
					// 取得connection
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

					try {
						// 建立SQL查詢
						String sql = "INSERT INTO information (account, password) VALUES (?, ?)";
						int i = 0;
						PreparedStatement statement = con.prepareStatement(sql);// 先建立一個
																				// SQL
																				// 語句並回傳一個
																				// PreparedStatement
																				// 物件
																				// 伺服器已經準備好的敘述就稱為「prepared
																				// statement」
						statement.setString(1, account_number.getText());
						statement.setString(2, password.getText());

						int rowsInserted = statement.executeUpdate();
						if (rowsInserted > 0) {
							System.out.println("A new user was inserted successfully!");
						}
						ResultSet rs = stmt.executeQuery(sql);
						// 通過Statement物件對資料庫下達SQL資料查詢指令並取得回傳之ResultSet物件
						// (呼叫java.sql.Statement中的executeQuery()方法並給予"select *
						// from employees"參數
						// 關閉連線
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

		}

	}

}
