package ItemInheritance;
import javax.swing.ImageIcon;
import Classes_HasA.Duration;

public class Song extends Item{

	private String artist;

	public Song(String artist, String title, String releaseDate, Duration duration, String language, String genre, ImageIcon cover) {
		
		super(title, releaseDate, duration, language, genre, cover);
		this.artist=artist;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public void calculateDuration(int sec, int min, int hr) {
		// TODO Auto-generated method stub
		if(sec > 60)
		{
			min += sec/60;
			sec%=60;
		}
		
		hr=0;
	}

	@Override
	public String toString() {
		return "\nSong Info:"
				+ "\nTitle: " + title
				+ "\nArtist: " + artist
				+ "\nRelease Date: " + releaseDate
				+ "\nLanguage: " + language
				+ "\nGenre: " + genre
				+ "\nDuration: " + duration.toString()
				+ "\n";
	}
	
	public void notification() {
		System.out.println("This is a song!");
	}
	
}
