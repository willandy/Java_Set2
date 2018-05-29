package RandomDemo;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		
		Random random = new Random();//创建一个random对象
		for(int i=0;i<20;i++){
			int num=random.nextInt(20);
			System.out.println("第"+(i+1)+"各随机数："+num);
		}
		
	System.out.println("====================================");
	Random random2 = new Random(100);
	int num2 = random2.nextInt();
	Random random3 = new Random(100);
	int num3 = random3.nextInt();
	System.out.println(num2);
	System.out.println(num3);
	}
	
}
