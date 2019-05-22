package vi.servlet;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import net.sf.json.JSONException;

import vi.dao.ClasstableDao;
import vi.util.FormatDay;
import vi.util.ResultSetTool;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/query")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Servlet1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResultSet rs = null;
		System.out.println("�����ѯServlet");
		request.setCharacterEncoding("utf-8");
		String build = request.getParameter("build");
		String room = request.getParameter("room");
		String week = request.getParameter("week");
		String day = request.getParameter("day");
		String semester = request.getParameter("semester");
		System.out.println("��" + semester + "ѧ��");
		System.out.println(build + "-" + room + "-��" + week + "��" + "-����" + day);
		// ���ˣ��Ѿ���ȡ��С��������û���������ݣ�������ʹ����Щ���ݽ��в�ѯ,���ڼ���������Ҫת��һ�¸�ʽ
		rs = ClasstableDao.query(room, FormatDay.formatDay(day), week, semester);
		// ���ResultSet��Ϊ�գ����ù����ཫResultSetת��JSONArray
		if (rs != null) {
			try {
				JSONArray array = ResultSetTool.resultSetToJsonArray(rs);
				System.out.println("����:" + array.toString());
				response.getWriter().write(array.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// ���ResultSetΪ�գ�����""
			response.getWriter().write("");
		}

	}

}
