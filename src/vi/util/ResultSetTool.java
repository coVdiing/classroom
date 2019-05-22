package vi.util;

import java.sql.ResultSet;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import net.sf.json.JSONException;

/**
 * 将ResultSet转成JSON的工具类
 * 
 * @author vi
 *
 */
public class ResultSetTool {
	/**
	 * 将ResultSet转成JSONObject
	 * 查询的顺序是：select class_name,start_class,end_class,teacher_name
	 * @param rs
	 * @return
	 * @throws SQLException
	 * @throws JSONException
	 */
	public static JSONObject resultSetToJsonObject(ResultSet rs) throws SQLException, JSONException {
		// json对象
		JSONObject jsonObj = new JSONObject();
		// 获取列数
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		// 遍历ResultSet中每条数据,这个方法只能存rs中的最后一行数据，前面的数据会被最后一行的覆盖
		while (rs.next()) {
			// 遍历每一列
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
	 * 将ResultSet转成JSONArray
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 * @throws JSONException
	 */
	public static JSONArray resultSetToJsonArray(ResultSet rs) throws SQLException, JSONException {
		// json数组
		JSONArray array = new JSONArray();
		// 获取列数
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		// 遍历ResultSet中每条数据
		while (rs.next()) {
			JSONObject jsonObj = new JSONObject();
			// 遍历每一列
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
