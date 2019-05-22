package vi.util;

import java.sql.ResultSet;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import net.sf.json.JSONException;

/**
 * ��ResultSetת��JSON�Ĺ�����
 * 
 * @author vi
 *
 */
public class ResultSetTool {
	/**
	 * ��ResultSetת��JSONObject
	 * ��ѯ��˳���ǣ�select class_name,start_class,end_class,teacher_name
	 * @param rs
	 * @return
	 * @throws SQLException
	 * @throws JSONException
	 */
	public static JSONObject resultSetToJsonObject(ResultSet rs) throws SQLException, JSONException {
		// json����
		JSONObject jsonObj = new JSONObject();
		// ��ȡ����
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		// ����ResultSet��ÿ������,�������ֻ�ܴ�rs�е����һ�����ݣ�ǰ������ݻᱻ���һ�еĸ���
		while (rs.next()) {
			// ����ÿһ��
			for (int i = 1; i <= columnCount; i++) {
				if (i != 2 && i != 3) {
					String columnName = metaData.getColumnLabel(i);
					String value = rs.getString(columnName);
					jsonObj.put(columnName, value);
				} else {
					String columnName = metaData.getColumnLabel(i);
					int value = rs.getInt(columnName);
					jsonObj.put(columnName, value);
				}
			}
		}
		return jsonObj;
	}

	/**
	 * ��ResultSetת��JSONArray
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 * @throws JSONException
	 */
	public static JSONArray resultSetToJsonArray(ResultSet rs) throws SQLException, JSONException {
		// json����
		JSONArray array = new JSONArray();
		// ��ȡ����
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		// ����ResultSet��ÿ������
		while (rs.next()) {
			JSONObject jsonObj = new JSONObject();
			// ����ÿһ��
			for (int i = 1; i <= columnCount; i++) {
				if (i != 2 && i != 3) {
					String columnName = metaData.getColumnLabel(i);
					String value = rs.getString(columnName);
					jsonObj.put(columnName, value);
				} else {
					String columnName = metaData.getColumnLabel(i);
					int value = rs.getInt(columnName);
					jsonObj.put(columnName, value);
				}
			}
			array.put(jsonObj);
		}
		return array;
	}
}
