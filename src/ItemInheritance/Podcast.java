package ItemInheritance;
import javax.swing.ImageIcon;

import Classes_HasA.Duration;

public class Podcast extends Item{

	private String host;
	private String desc;
	private int episodes;
	
	
	public Podcast(String host,String desc, int episodes, String title, String releaseDate, Duration duration, String language, String genre, ImageIcon cover){
		super(title, releaseDate, duration, language, genre, cover);
		this.host=host;
		this.desc=desc;
		this.episodes=episodes;
	}
	

	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public int getEpisodes() {
		return episodes;
	}


	public void setEpisodes(int episodes) {
		this.episodes = episodes;
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

	@Override
	public String toString() {
		return "\nPodcast Info"
				+ "\nTitle: " + title
				+ "\nHost: " + host
				+ "\nDescription: " + desc
				+ "\nRelease Date: " + releaseDate
				+ "\nLanguage: " + language
				+ "\nGenre: " + genre
				+ "\nDuration: " + duration.toString()
				+ "\nEpisode Count: " + episodes
				+ "\n";
	}
	
	public void notification() {
		System.out.println("This is a podcast!");
	}


}
