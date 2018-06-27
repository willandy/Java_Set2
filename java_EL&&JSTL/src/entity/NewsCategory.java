package entity;

import java.util.Date;

public class NewsCategory {

	private int id;
	private String name;
	private Date createDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public NewsCategory(int id, String name, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
	}
	public NewsCategory() {
		super();
	}
	
}
