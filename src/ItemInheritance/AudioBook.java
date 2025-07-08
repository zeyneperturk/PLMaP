package ItemInheritance;

import javax.swing.ImageIcon;

import Classes_HasA.Duration;

public class AudioBook extends Item{

	private String author;
	private int chapters;
	
	public AudioBook(String author, int chapter,String title, String releaseDate, Duration duration, String language, String genre,ImageIcon cover) {
		
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
		return "\nAudio Book Info\n Author:" + author + "\nDuration: "+ toStringDuration(duration) + "\n Chapter Count=" + chapters + super.toString();
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

	public String toStringDuration(Duration dur) {
		String out = "";
		out = dur.getHr() + " Hour(s)" + dur.getMin() + " Minute(s)" + dur.getSec() + " Second(s), is the length of this audiobook\n";
		return out;
	}
	
	public void notification() {
		// TODO Auto-generated method stub
		System.out.println("This is an audiobook!");
	}

}
