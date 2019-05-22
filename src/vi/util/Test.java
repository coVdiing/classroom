package vi.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vi.util.DButil;
//������С������
public class Test {

	public static void main(String[] args) {
		String sql = "select DISTINCT room  from classtable WHERE room like '��%' ORDER BY room ;";
		Connection conn = DButil.getConnection();
		ArrayList<String> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
//				System.out.println(rs.getString(1));
				list.add("\""+rs.getString(1)+"\"");
			}
			System.out.println(list.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
