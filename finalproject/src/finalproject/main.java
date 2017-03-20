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
			throw new lengthException("�b�����׻ݦb5��12����");
		}

		for (i = 0; i < account.length(); i++) {
			if (account.charAt(i) == '/' || account.charAt(i) == ',') {
				throw new charException("�b�����i�]�t'/'�άO','");
			}

		}

	}
	public static void check_password_char(String password) throws Exception {
		int  length,temp;
		char i;
     //   temp=Integer.parseInt(password[0]);
		length = password.length();
		if (length < 5 || length > 12) {
			throw new lengthException("�K�X���׻ݦb5��12����");
		}
		for(i='A';i<='Z';i++)
		{
			if(password.charAt(0)!=i)
			{
				throw new charException("�K�X�Ĥ@�r���ݬ��j�g�^��r��");
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
