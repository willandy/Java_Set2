package Dao;

import java.util.List;

import entity.News;
import entity.NewsCategory;

public interface NewsDao {

	//查询新闻信息
	public List<News> getNewsList();
	
	//根据categoryId查询新闻信息
	public int getNewsCount(News news);
	
	//增加新闻信息
	public boolean add(News news);
	//删除新闻信息by id
	public boolean delete(News news);
	//修改新闻标题信息
	public boolean update(News news);
	//删除新闻类别（联表删除）
	//public boolean deleteNewsCategory(NewsCategory newsCategory);
	
	//根据ID删除新闻类别
    public boolean deleteNewsCategory(NewsCategory newsCategory);
    
    //根据新闻ID查找新闻明细
    public News getNewsById(int id);
    
    //获取新闻信息总数量
    public int getNewsCount();
    
    //获取分页列表
    public List<News> getPageNewsList(int pageNo,int pageSize);
    
  	//获取新闻分类列表
  	public List<NewsCategory> getNewsCategoryList();
    
    
}
