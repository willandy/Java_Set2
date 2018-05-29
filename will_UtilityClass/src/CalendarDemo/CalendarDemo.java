package CalendarDemo;

import java.util.Calendar;

public class CalendarDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Calendar calendar = Calendar.getInstance();
      System.out.println(calendar.get(Calendar.DATE));
      System.out.println(calendar.get(Calendar.MONTH)+1);
      System.out.println(calendar.get(Calendar.YEAR));
	}

}
