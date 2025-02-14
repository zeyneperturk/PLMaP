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


	@Override
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
		return "\nPodcast Info\n Host:" + host + "\n Description=" + desc + "Duration Info: " + toStringDuration(duration) + "\n Episode Count=" + episodes + super.toString();
	}

	@Override
	public String toStringDuration(Duration dur) {
		String out = "";
		out = dur.getHr() + " Hour(s)" + dur.getMin() + " Minute(s)" + dur.getSec() + " Second(s), is the length of this podcast\n";
		return out;
	}
	
	public void notification() {
		System.out.println("This is a podcast!");
	}


}
