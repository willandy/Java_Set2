package enumDemo;

/*
 * 性别枚举：男、女
 */
public enum Gender {
   男,女
}
/*
 * 学员
 */
class Student{
  public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getSex() {
		return sex;
	}
	public void setSex(Gender sex) {
		this.sex = sex;
	}
	//学号、姓名、性别
	private int number;
	private String name;
	private Gender sex;
	public Student(int number, String name, Gender sex) {
		super();
		this.number = number;
		this.name = name;
		this.sex = sex;
	}
	public Student() {
		super();
	}
	
	public static void main(String[] args) {
		
		Student student = new Student();
		student.setSex(Gender.男);
		System.out.println("学员性别是："+student.getSex());
		
	}
	
}
