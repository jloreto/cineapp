package net.itinajero.app.model;

import java.util.Date;

public class Banner {

	private int id;
	private String title;
	private Date date;
	private String file;
	private String status;

	public Banner() {
		this.date = new Date();
		this.status = "Active";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Banner [id=" + id + ", title=" + title + ", date=" + date + ", file=" + file + ", status=" + status
				+ "]";
	}

}
