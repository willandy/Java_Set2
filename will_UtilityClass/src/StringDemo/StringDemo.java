package StringDemo;
/*
 * 判断equals和“==”的用法：用栈和堆来区分
 */
public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /*
        * 如果不是new对象，就是在栈里创建了对象
        * 如果new对象，就集会在栈里创建对象，也会在堆里创建对象
        */
		String s1 = "java";
		String s2 = "java";
		System.out.println(s1.equals(s2));
		
		String s3 = new String("java");
		System.out.println(s1.equals(s3));
		System.out.println("============================");
		
		String s4 = new String("java");
		System.out.println(s3.equals(s4));
		System.out.println(s3==s4);
		
		System.out.println("============================");
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		
		System.out.println("=============================");
		/*
		 * s5和s6都各自创建一个对象，在栈里
		 */
		String s5 = "java";
		String s6 = "java";
		System.out.println(s5 == s6);
		/*
		 * s7创建了二个对象，在栈里和堆里
		 */
		String s7 = new String("java");
		System.out.println(s5==s7);
		
	}

}
