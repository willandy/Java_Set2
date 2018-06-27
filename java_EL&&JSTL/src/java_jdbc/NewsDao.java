package java_jdbc;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;


public class NewsDao {
	String driver = ConfigManager.getInstance().getString("jdbc.driver.class");
	String url = ConfigManager.getInstance().getString("jdbc.connection.url");
	String username = ConfigManager.getInstance().getString("jdbc.connection.username");
	String password = ConfigManager.getInstance().getString("jdbc.connection.password");
	
	//查询新闻明细表
	public void getNewsList() throws Exception{
		//1、加载驱动
		//这里初始化不用new，因为这里是java的反射机制，属于后加载
		Class.forName(driver);
		//2、获取数据库链接
		/*String url="jdbc:mysql://127.0.0.1:3306/news";
		String username="root";
		String password="123";*/
		Connection connection=DriverManager.getConnection(url, username, password);
	    //3、获取Statement对象，执行sql语句
		String sql ="select * from news_detail";
		Statement statement=connection.createStatement();
		ResultSet set=statement.executeQuery(sql);
		//循环遍历数据
		while(set.next()){
			int id=set.getInt("id");
			String category=set.getString("categoryId");
			String title=set.getString("title");
			String summary=set.getString("summary");
			String content=set.getString("content");
			String author=set.getString("author");
			//之所以用getTimestamp，是因为getDate取不到时分秒
			Timestamp createDate=set.getTimestamp("createDate");
			System.out.println("id:"+id+"\t"+"title:"+title+"\t"+"createDate:"+createDate);
		}
		set.close();
		statement.close();
		connection.close();
	}
	
	//新增数据
	public void addNewsList(int id,int categoryId,String title,String summary,String content,String picPath,String author,Date createDate,Date modifyDate) throws Exception{
		//1、加载驱动
		Class.forName(driver);
		//2、获取数据库连接
		Connection connection=DriverManager.getConnection(url, username, password);
		//执行sql
		//String sql="insert into news_detail values("+id+","+categoryId+",'"+title+"','"+summary+"','"+content+"','"+picPath+"','"+author+"','"+new Timestamp(createDate.getTime())+"','"+new Timestamp(modifyDate.getTime())+"')";
		String sql="insert into news_detail values(?,?,?,?,?,?,?,?,?)";
		//创建statement
		//Statement statement=connection.createStatement();
		//现在就用占位符的形式来添加数据
		PreparedStatement prepareStatement=connection.prepareStatement(sql);//已经预编译sql语句
		prepareStatement.setInt(1, id);
		prepareStatement.setInt(2, categoryId);
		prepareStatement.setString(3, title);
		prepareStatement.setString(4, summary);
		prepareStatement.setString(5, content);
		prepareStatement.setString(6, picPath);
		prepareStatement.setString(7, author);
		prepareStatement.setTimestamp(8, new Timestamp(createDate.getTime()));
		prepareStatement.setTimestamp(9, new Timestamp(modifyDate.getTime()));
		int i=prepareStatement.executeUpdate();//因为上面已经预编译，所以这里就不用在加载sql
		if(i>0) {
			System.out.println("数据插入成功!");
		}
		prepareStatement.close();
		connection.close();
	}
	
	//修改更新数据
	public void update(int id,String title) throws Exception {
		String sql="update news_detail set title=? where id=?";
		Class.forName(driver);
		Connection connection=DriverManager.getConnection(url, username, password);
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1, title);
		statement.setInt(2, id);
		int i=statement.executeUpdate();
		if(i>0) {
			System.out.println("数据修改成功!");
		}
	}
	
	//删除与上面一致，不作描述
	
	public static void main(String[] args) throws Exception {
		NewsDao newsDao = new NewsDao();
		//newsDao.addNewsList(3, 3, "测试", "摘要", "", "", "", new Date(), new Date());
		newsDao.update(3, "增加测试");
		newsDao.getNewsList();
	}
	
}
