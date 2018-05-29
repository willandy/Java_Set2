package PackagingDemo;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.omg.PortableInterceptor.IORInterceptor;

public class Packaging {

	//包装类实例构造
	public static void main(String[] args){
		//1、所有包装类：都可将与之对应的基本数据类型作为参数，来构造它们的实例
		Integer integer = new Integer(1);
		System.out.println(integer);
		Character character = new Character('a');
		System.out.println(character);
		Boolean boolean1 = new Boolean(false);
		System.out.println(boolean1);
		//2、除Character类外：其他包装类可将一个字符串作为参数构造它们的实例
		System.out.println("===============================");
		Integer integer2 = new Integer("1");
		System.out.println(integer2);
		//Character character2 = new Character("a");//报错
	    Boolean boolean2 = new Boolean("java");
	    System.out.println(boolean2);
		
	    //3、Number：**Value() 包装类--》基本数据类型
	    System.out.println("===============================");
	    Integer integer3 = new Integer(1);
	    int iValue=integer3.intValue();
	    System.out.println(iValue);
	    Boolean boolean3 = new Boolean("true");
	    boolean b=boolean3.booleanValue();
	    System.out.println(b);
	    
	    //4、toString():以字符串形式返回包装对象表示的基本类型数据
	    System.out.println("===============================");
	      String sex = character.toString('男');
	      String id = Integer.toString(25);
	      System.out.println(sex);
	      System.out.println(id);
	    //5、valueOf()
	      System.out.println("===============================");
	      Character character2 = Character.valueOf('a');
	      System.out.println(character2);
	    //parseXXX():把字符串转换为相应的基本数据类型数据
	      
	    
	      
	      
	}
	
}
