package StringDemo;

import java.util.Scanner;

/*
 * 将一个数字字符串换成逗号分隔的数字串，即从右边开始每三个数字用逗号隔开
 */
public class StringDemo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner scanner = new Scanner(System.in);
       System.out.println("请输入一串数字：");
       String number = scanner.nextLine();
       StringBuffer stringBuffer = new StringBuffer(number);
       for(int i=number.length()-3;i>0;i-=3){
    	   stringBuffer.insert(i, ",");
       }
       System.out.println(stringBuffer.toString());
	}
	

}
