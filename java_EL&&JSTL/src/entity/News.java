package entity;

import java.util.Date;

public class News {

	//新闻属性
	private int id;
	private int categoryId;
	private String title;
	private String summary;
	private String content;
	private String picPath;
	private String author;
	private Date createDate;
	private Date modifyDate;
	private String categoryName;//加这个是因为联表查询
	
	public News(int id, int categoryId, String title, String summary, String content, String picPath, String author,
			Date createDate, Date modifyDate, String categoryName) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.picPath = picPath;
		this.author = author;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.categoryName = categoryName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public News(int id, int categoryId, String title, String summary, String content, String picPath, String author,
			Date createDate, Date modifyDate) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.picPath = picPath;
		this.author = author;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	public News() {
		super();
	}
	
	
	
}
