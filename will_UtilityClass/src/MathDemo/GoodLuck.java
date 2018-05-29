package MathDemo;

import java.util.Scanner;

/*
 * 随机输入四位数，判断百位数与随机产生的数字一样
 */
public class GoodLuck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //随机产生一个0-9之间的任意整数
	 int random = (int)(Math.random()*10);
	 //随机输入四位数
	 Scanner scanner = new Scanner(System.in);
	 System.out.println("请输入四位数：");
	 int number=scanner.nextInt();
	 int baiwei = number/100%10;
	 System.out.println("输入的数字的百位为："+baiwei);
	 System.out.println("产生的随机数为："+random);
	 if(baiwei==number){
		 System.out.println("恭喜，您是幸运顾客！");
	 }else{
		 System.out.println("谢谢参与！");
	 }
	}

}
