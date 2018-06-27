package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//操作数据库的基类
public class BaseDaoImpl {

	protected Connection connection;
	protected PreparedStatement pstm;
	protected ResultSet rs;
	
	//获取数据库连接
	public boolean getConnection() {
		
		String driver = ConfigManager.getInstance().getString("jdbc.driver.class");
		String url = ConfigManager.getInstance().getString("jdbc.connection.url");
		String username = ConfigManager.getInstance().getString("jdbc.connection.username");
		String password = ConfigManager.getInstance().getString("jdbc.connection.password");
		
		try {
			//1、加载驱动
			Class.forName(driver);
			//2、获取数据库连接
			connection=DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	//查询
	public ResultSet executeQuery(String sql,Object[] params) {
		if(this.getConnection()) {
			try {
				pstm=connection.prepareStatement(sql);
				//填充占位符
				for(int i=0;i<params.length;i++) {
					pstm.setObject(i+1, params[i]);
				}
				rs = pstm.executeQuery();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	//增删改
	public int executeUpdate(String sql,Object[] params) {
		int updateRows = 0;
		if(this.getConnection()) {
			try {
				pstm=connection.prepareStatement(sql);
				//填充占位符
				for(int i=0;i<params.length;i++) {
					pstm.setObject(i+1, params[i]);
				}
				updateRows=pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//为了防止子表没有数据，返回0.不能写返回值大于0，然后删主表的时候，异常为-1，在异常情况下就不能执行下面的代码
				updateRows = -1;
			}
		}
		return updateRows;
	}
	
	//释放资源
	public boolean close() {
		//后入先释放
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		if(pstm!=null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	//使用数据源获取连接
	public Connection getConnectionDS() {
		try {
			//初始化上下文
			//注意引包是javax.naming包中
			Context ctx = new InitialContext();
			//javax.sql.DataSource包下
			//java:comp/env相当于协议名
			//jdbc/news相当于逻辑名
			DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/news");
		    connection=ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
}
