package ItemInheritance;

import javax.swing.ImageIcon;

import Classes_HasA.Duration;

public class AudioBook extends Item{

	private String author;
	private int chapters;
	
	public AudioBook(String author, int chapters, String title, String releaseDate, Duration duration, String language, String genre,ImageIcon cover) {
		
		super(title, releaseDate, duration, language, genre, cover);
		this.author=author;
		this.chapters=chapters;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getChapters() {
		return chapters;
	}

	public void setChapters(int chapters) {
		this.chapters = chapters;
	}

	@Override
	public String toString() {
		return "\nAudio Book Info"
				+ "\nTitle: " + title
				+ "\nAuthor: " + author
				+ "\nRelease Date: " + releaseDate
				+ "\nLanguage: " + language
				+ "\nGenre: " + genre
				+ "\nDuration: " + duration.toString()
				+ "\nChapter Count: " + chapters
				+ "\n";
	}

	public void calculateDuration(int sec, int min, int hr) {
		// TODO Auto-generated method stub
		if(sec > 60)
		{
			min += sec/60;
			sec%=60;
		}
		
		if(min > 60)
		{
			hr+=min/60;
			min%=60;
		}
	}
	
	public void notification() {
		// TODO Auto-generated method stub
		System.out.println("This is an audiobook!");
	}

}
