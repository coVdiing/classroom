package vi.util;

/**
 * ��С���򴫹������������ڼ�ת������
 * 
 * @author vi
 *
 */
public class FormatDay {
	public static String formatDay(String day) {
		if (day != null) {
			if (day.equals("һ"))
				return "1";
			if (day.equals("��"))
				return "2";
			if (day.equals("��"))
				return "3";
			if (day.equals("��"))
				return "4";
			if (day.equals("��"))
				return "5";
			if (day.equals("��"))
				return "6";
			if (day.equals("��"))
				return "7";
		}
		return "";
	}
}
