package DateDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //创建日期
		Date date = new Date();
		//定制日期格式
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String now=simpleDateFormat.format(date);
		System.out.println(now);
	}

}
