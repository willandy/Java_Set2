package java_jdbc;

import java.util.Date;

public interface BaseDao {

	//查询新闻明细表
	public void getNewsList();
	//增加新闻信息
	public void add(int id,int categoryId,String title,String summary,String content,String picPath,String author,Date createDate,Date modifyDate);
	//修改新闻标题
	public void update(int id,String title);
	//删除新闻信息
	public void delete(int id);
}
