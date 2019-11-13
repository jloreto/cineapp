package net.itinajero.app.model;

import java.util.Date;

public class News {

	private Integer id;
	private String title;
	private String status;
	private String detail;
	private Date date;

	public News() {
		this.date = new Date();
		this.status = "Active";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", status=" + status + ", detail=" + detail + ", date=" + date
				+ "]";
	}

}
