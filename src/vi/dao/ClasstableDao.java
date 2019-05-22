package vi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import vi.util.DButil;

public class ClasstableDao {
	/**
	 * ��ѯ����
	 * @param room
	 * @param day
	 * @param startWeek
	 * @param semester
	 * @return
	 */
	public static ResultSet query(String room,String day,String week,String semester) {
		HashMap<String,String> map = new HashMap<>();
		ResultSet rs = null;
		String sql = getSQL(week);
		Connection conn = DButil.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, room);
			pstmt.setString(2, day);
			pstmt.setString(3, "%"+semester);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
//			��ӡ��ѯ���������Ч��
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t");
			}
			rs.beforeFirst();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * ����sqlģ��
	 * ���ݴ������week���жϣ����week�ǵ������򷵻���ʾ���ܺ�ȫ�ܵ�sql�������˫�����򷵻���ʾ˫�ܺ�ȫ�ܵ�sql
	 * @return
	 */
	public static String getSQL(String week) {
		String sql;
		int value = Integer.valueOf(week);
		if(value%2==0) {
			sql = "select class_name,start_class,end_class,teacher_name from classtable where room = ? and  day = ? and semester like ? and (week_mark = 0 or  week_mark = 2) and ("+ value +" between start_week and end_week ) order by start_class";
		} else {
			sql = "select class_name,start_class,end_class,teacher_name from classtable where room = ? and  day = ? and semester like ? and (week_mark = 0 or  week_mark = 1) and ("+ value +" between start_week and end_week ) order by start_class";
		}
		return sql;
	}	
}
