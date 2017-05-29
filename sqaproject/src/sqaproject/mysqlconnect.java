package sqaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysqlconnect {
	public static void main(String[] args) {

		// creates three different Connection objects
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 註冊driver
			con = DriverManager.getConnection("jdbc:mysql://localhost/data?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","zh403027");
			// 取得connection
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			try
			{
				String sql="select * from information "; 
				ResultSet rs = stmt.executeQuery(sql);
				
				//顯示資料
				int i = 0;
				while(rs.next() && i<10)
				{
					System.out.println(rs.getString("account"));
					System.out.println(rs.getString("password"));
					
				}
				
				// 關閉連線
				rs.close();
				rs = null;
				stmt.close();
				stmt = null;
				con.close();
			}
			catch (Exception ex)
			{
				System.out.println("can't read data");
				System.out.println(ex.toString());
			}
		}
		catch (Exception e)
		{
			System.out.println("can't create statement");
			System.out.println(e.toString());
		}
	}
	}