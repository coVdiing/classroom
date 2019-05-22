package vi.util;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库连接工具,使用c3p0数据库连接池
 * @author vi
 *
 */
public class DButil {
	static ComboPooledDataSource ds;
	static {//初始化连接池配置
		try {
			Properties props = new Properties();
			props.load(DButil.class.getClassLoader().getResourceAsStream("config\\config.properties"));
			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String password = props.getProperty("password");
			//创建连接池实例
			ds = new ComboPooledDataSource();
			ds.setDriverClass(driver);
			ds.setJdbcUrl(url);
			ds.setUser(user);
			ds.setPassword(password);
			//设置最大连接数
			ds.setMaxPoolSize(50);
			//设置最小连接数
			ds.setMinPoolSize(10);
			//设置初始连接数
			ds.setInitialPoolSize(10);
			//设置连接池缓存Statement最大数
			ds.setMaxStatements(500);
			ds.setMaxStatementsPerConnection(30);
			
		}  catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			 conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}	
}
