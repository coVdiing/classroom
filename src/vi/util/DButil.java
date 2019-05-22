package vi.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接工具
 * @author vi
 *
 */
public class DButil {
	public static Connection getConnection() {
		Connection conn = null;
		String driver;
		String url;
		String user;
		String password;
		//通过Properties获取数据库连接参数
		Properties props = new Properties();
		try {
			props.load(DButil.class.getClassLoader().getResourceAsStream("config\\config.properties"));
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (conn != null) 
			return conn;
		return conn;
	}
}
