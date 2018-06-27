package java_jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class NewsDaoImpl extends BaseDaoImpl implements BaseDao {

	@Override
	public void getNewsList() {
		// TODO Auto-generated method stub
        String sql="select * from news_detail";
        Object[] parms = {};
        ResultSet rs=this.executeQuery(sql, parms);
        //执行sql执行处理
        try {
			while(rs.next()) {
				int id=rs.getInt("id");
				String category=rs.getString("categoryId");
				String title=rs.getString("title");
				String summary=rs.getString("summary");
				String content=rs.getString("content");
				String author=rs.getString("author");
				//之所以用getTimestamp，是因为getDate取不到时分秒
				Timestamp createDate=rs.getTimestamp("createDate");
				System.out.println("id:"+id+"\t"+"title:"+title+"\t"+"createDate:"+createDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
	}

	@Override
	public void add(int id, int categoryId, String title, String summary, String content, String picPath, String author,
			Date createDate, Date modifyDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int id, String title) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		
		NewsDaoImpl newsDao = new NewsDaoImpl();
		newsDao.getNewsList();
		
	}
	
}
