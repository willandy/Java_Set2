package Test;

import java.util.ArrayList;
import java.util.List;

import Dao.NewsDao;
import Dao.NewsDaoImpl;
import entity.News;
import entity.NewsCategory;
import service.NewsServiceImpl;

public class TestNewsService {
  public static void main(String[] args) {
	
	  NewsServiceImpl newsServiceImpl = new NewsServiceImpl();
	 
//	  NewsCategory newsCategory = new NewsCategory();
//	  newsCategory.setId(2);
//	  newsServiceImpl.deleteNewsCategory(newsCategory); 
	  
	  
//	  List<News> list=newsServiceImpl.getNewsList();
//	  System.out.println(list.size());
//	  for(News news:list) {
//		  System.out.println("id:"+news.getId()+",title:"+news.getTitle());
//	  }
	  
	  /*News news = new News();
	 news= newsServiceImpl.getNewsById(2);
	  System.out.println("news===>"+news.getTitle());*/
	  
	  //System.out.print("news count ===>"+newsServiceImpl.getNewsCount());
     /* List<News> newsList = new ArrayList<News>();
      newsList=newsServiceImpl.getPageNewsList(2, 2);
      for(News news:newsList) {
    	  System.out.println("news page--->"+news.getId()+",title:"+news.getTitle());
      }*/
      
	  List<NewsCategory> newsList = new ArrayList<NewsCategory>();
	  newsList=newsServiceImpl.getNewsCategoryList();
      for(NewsCategory newsCategory:newsList) {
    	 System.out.println("name:"+newsCategory.getName()); 
      }
	  
  }
}
