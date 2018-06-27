package service;

import java.util.List;

import Dao.NewsDao;
import Dao.NewsDaoImpl;
import entity.News;
import entity.NewsCategory;

public class NewsServiceImpl implements NewsService{

//	NewsDao newsDao = new NewsDaoImpl();
//	
//	public NewsDao getNewsDao() {
//		return newsDao;
//	}
//
//	public void setNewsDao(NewsDao newsDao) {
//		this.newsDao = newsDao;
//	}

	//上面的get和set方法容易形成耦合，所以现在用正规的接口开发模式
	private NewsDao newsDao=null;
	public NewsServiceImpl() { //面向接口开发，对外只能调用接口，不能实现方法
		newsDao = new NewsDaoImpl();
	}
	
	@Override
	public List<News> getNewsList() {
		// TODO Auto-generated method stub
		return newsDao.getNewsList();
	}

	@Override
	public boolean add(News news) {
		// TODO Auto-generated method stub
		return newsDao.add(news);
	}

	@Override
	public boolean delete(News news) {
		// TODO Auto-generated method stub
		return newsDao.delete(news);
	}

	@Override
	public boolean update(News news) {
		// TODO Auto-generated method stub
		return newsDao.update(news);
	}

	@Override
	public boolean deleteNewsCategory(NewsCategory newsCategory) {
		// TODO Auto-generated method stub
		boolean flag = false;
		//根据categoryId查询新闻信息(count)
		News news = new News();
		news.setCategoryId(newsCategory.getId());
		int count=newsDao.getNewsCount(news);
		if(count>0) {
			System.out.println("该类别下有新闻信息，请先删除新闻信息");
		}else {
			//根据categoryId删除新闻类别
			flag=newsDao.deleteNewsCategory(newsCategory);
		}
		return flag;
	}

	@Override
	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		return newsDao.getNewsById(id);
	}

	@Override
	public int getNewsCount() {
		// TODO Auto-generated method stub
		return newsDao.getNewsCount();
	}

	@Override
	public List<News> getPageNewsList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return newsDao.getPageNewsList(pageNo, pageSize);
	}

	@Override
	public List<NewsCategory> getNewsCategoryList() {
		// TODO Auto-generated method stub
		
		return newsDao.getNewsCategoryList();
	}

}
