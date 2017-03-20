package finalproject;

import java.util.Scanner;

public class main {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String account = scan.nextLine();
		String password = scan.nextLine();

		System.out.println(account);
		int i;
		try {
			check_account_char(account);
			check_password_char(password);

		} catch (charException e) {
			e.printStackTrace();
		} catch (lengthException e) {
			e.printStackTrace();
		}

	}

	public static void check_account_char(String account) throws Exception {
		int i, length;

		length = account.length();
		if (length < 5 || length > 12) {
			throw new lengthException("帳號長度需在5到12之間");
		}

		for (i = 0; i < account.length(); i++) {
			if (account.charAt(i) == '/' || account.charAt(i) == ',') {
				throw new charException("帳號不可包含'/'或是','");
			}

		}

	}
	public static void check_password_char(String password) throws Exception {
		int  length,temp;
		char i;
     //   temp=Integer.parseInt(password[0]);
		length = password.length();
		if (length < 5 || length > 12) {
			throw new lengthException("密碼長度需在5到12之間");
		}
		for(i='A';i<='Z';i++)
		{
			if(password.charAt(0)!=i)
			{
				throw new charException("密碼第一字元需為大寫英文字母");
			}
		}

	}

}

class charException extends Exception {

	public charException(String str) {
		super(str);
	}

}

class lengthException extends Exception {
	public lengthException(String str) {
		super(str);
	}
}
