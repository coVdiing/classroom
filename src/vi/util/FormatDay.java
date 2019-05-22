package vi.util;

/**
 * 把小程序传过来的中文星期几转成数字
 * 
 * @author vi
 *
 */
public class FormatDay {
	public static String formatDay(String day) {
		if (day != null) {
			if (day.equals("一"))
				return "1";
			if (day.equals("二"))
				return "2";
			if (day.equals("三"))
				return "3";
			if (day.equals("四"))
				return "4";
			if (day.equals("五"))
				return "5";
			if (day.equals("六"))
				return "6";
			if (day.equals("日"))
				return "7";
		}
		return "";
	}
}
