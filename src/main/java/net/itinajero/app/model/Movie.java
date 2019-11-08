package net.itinajero.app.model;

import java.util.Date;

public class Movie {

	private Integer id;
	private String title;
	private Integer duration;
	private String classification;
	private String genre;
	private String image = "cinema.png"; // default image
	private Date premiereDate;
	private String status = "Active";

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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getPremiereDate() {
		return premiereDate;
	}

	public void setPremiereDate(Date premiereDate) {
		this.premiereDate = premiereDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", duration=" + duration + ", classification=" + classification
				+ ", genre=" + genre + ", image=" + image + ", premiereDate=" + premiereDate + ", status=" + status
				+ "]";
	}

}
