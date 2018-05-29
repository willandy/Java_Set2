package StringDemo;

/*
 * 字符串拼接
 */
public class StringDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "liwei";
		int age = 10;
		String result = name+"-->"+age;
		String newResult = result.concat(" 版权所有");
		result.concat(" 版权所有");
		/*
		 * result.concat就是创建了一个副本，然后在副本德基础上做出修改，同时需要用
		 * 新的对象来接收，不然，还是在原对象上
		 */
		System.out.println(result);
		
	}

}
