package ItemInheritance;
import javax.swing.ImageIcon;

import Classes_HasA.Artist;
import Classes_HasA.Duration;

public class Song extends Item{

	private Artist artist;

	public Song(Artist artist, String title, String releaseDate, Duration duration, String language, String genre, ImageIcon cover) {
		
		super(title, releaseDate, duration, language, genre, cover);
		this.artist=artist;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
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
		return "\nSong Info:\n Artist:" + artist + super.toString() + "\nDuration: " + toStringDuration(duration);
	}

	public String toStringDuration(Duration dur) {
		String out = "";
		out = dur.getMin() + " Minute(s)" + dur.getSec() + " Second(s), is the length of this song\n";
		return out;
	}
	
	public void notification() {
		System.out.println("This is a song!");
	}
	
}
