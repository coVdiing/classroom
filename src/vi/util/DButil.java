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
 * ���ݿ����ӹ���,ʹ��c3p0���ݿ����ӳ�
 * @author vi
 *
 */
public class DButil {
	static ComboPooledDataSource ds;
	static {//��ʼ�����ӳ�����
		try {
			Properties props = new Properties();
			props.load(DButil.class.getClassLoader().getResourceAsStream("config\\config.properties"));
			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String password = props.getProperty("password");
			//�������ӳ�ʵ��
			ds = new ComboPooledDataSource();
			ds.setDriverClass(driver);
			ds.setJdbcUrl(url);
			ds.setUser(user);
			ds.setPassword(password);
			//�������������
			ds.setMaxPoolSize(50);
			//������С������
			ds.setMinPoolSize(10);
			//���ó�ʼ������
			ds.setInitialPoolSize(10);
			//�������ӳػ���Statement�����
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
	
	//��ȡ����
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
