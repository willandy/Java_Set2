package StringDemo;

import java.util.Scanner;

/*
 * 合法的文件名应该以.java结尾
 * 合法的邮箱至少包含"@"和"."，并检查"@"是否在"."之前
 */
public class StringDemo4 {
  public static void main(String[] args) {
	
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("---欢迎进入作业提交系统---");
	  System.out.println("请输入Java文件名：");
	  String JavaName = scanner.nextLine();
	  System.out.println("请输入你的邮箱：");
	  String email = scanner.nextLine();
	  //获取java文件名的长度
	  int length = JavaName.length();
	  System.out.println("length:"+length);
	  String subName=JavaName.substring(length-5, length);
	  System.out.println("subName:"+subName);
	  //邮箱有"@"和"."
	  int exit1 = email.indexOf("@");
	  System.out.println("exit1:"+exit1);
	  int exit2 = email.indexOf(".");
	  System.out.println("exit2:"+exit2);
	  
	  if(!subName.equals(".java") && exit1==-1 && exit2==-1 && exit1>exit2){
		  System.out.println("作业提交失败!");
	  }else{
		  System.out.println("作业提交成功!");
	  }
	  
}
}
