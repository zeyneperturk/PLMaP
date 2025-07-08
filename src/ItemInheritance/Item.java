package ItemInheritance;
import javax.swing.ImageIcon;

import Classes_HasA.Duration;

public abstract class Item{
	protected String title;
	protected String releaseDate;
	protected Duration duration;
	protected String language;
	protected String genre;
	protected ImageIcon cover;
	
	public Item(String title, String releaseDate, Duration duration, String language, String genre, ImageIcon cover) {
		this.cover = cover;
		this.duration = duration;
		this.genre = genre;
		this.language = language;
		this.releaseDate = releaseDate;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public ImageIcon getCover() {
		return cover;
	}

	public void setCover(ImageIcon cover) {
		this.cover = cover;
	}
	
	public abstract void notification();

	public abstract void calculateDuration(int sec, int min, int hr);
}
