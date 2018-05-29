package StringDemo;

/*
 * 字符串的查找或截取的方法：indexOf()\lastIndexOf()\subString()
 */
public class StringDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 无论是拼接还是截取，都是对String的副本的操作
		 */
		String str = "my name is jack";
		int firstNumber = str.indexOf("m");
		System.out.println(firstNumber);
		
		int lastNumber = str.lastIndexOf("m");
		System.out.println(lastNumber);
		
		//字符串从0开始
		String steName = str.substring(4);
		System.out.println(steName);
		
		String steName2 = str.substring(4, 6);
		System.out.println(steName2);
		
	}

}
