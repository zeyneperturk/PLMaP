package SystemAndMain;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;

import Classes_HasA.Duration;
import ItemInheritance.AudioBook;
import ItemInheritance.Podcast;
import ItemInheritance.Song;

public class Playlist<E>{
	private ArrayList<E> items = new ArrayList<E>(); //changed Item to E
	private Duration duration;
	private String creationDate;
	private int itemAmount;
	private String title;
	private ImageIcon cover;
	private static int count=0;
	
	public Playlist(ArrayList<E> item, Duration duration, String date, int amount, String title, ImageIcon cover) {
		this.cover = cover;
		this.creationDate = date;
		this.duration = new Duration(0,0,0);
		this.itemAmount = amount;
		this.items = item;
		this.title = title;
	}
	
	public void shuffle() {
		Collections.shuffle(items);
	}
	
	public boolean addItem(E item) {
		items.add(item);
		count++;
		return true;
	}
	
	public boolean removeItem(E item) {
		for (E e : items) {
			if (e.equals(item)) {
				((ArrayList<E>) item).remove(e);
				count--;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "\nPlaylist \n"
				+ "\nDuration= " + toStringDuration(duration) 
				+ "\nCreationDate= " + creationDate
				+ "\nItemAmount= " + itemAmount 
				+ "\nTitle= " + title 
				+ "\nCover= " + cover + "\n";
	}
	
	public String display() {
		if (items == null) {
			return "Please create a playlist first!";
		}
		
		String out = "";
		for (E item : items) {
			out += item.toString();
		}
		return out;
	}
	
	public void sort() {
		items.sort(null); 
	}
	
	public E searchItem(String title) {
		
		if (items==null) {
			return null;
		}
		
		for (E item : items) { 
			if (item instanceof Song ) {
				if (((Song) item).getTitle().equalsIgnoreCase(title)) {
					((Song) item).notification();
					return item;
				}
			}
			else if (item instanceof Podcast) {
				if (((Podcast) item).getTitle().equalsIgnoreCase(title)) {
					((Podcast) item).notification();
					return item;
				}
			}
			else if (item instanceof AudioBook) {
				if (((AudioBook) item).getTitle().equalsIgnoreCase(title)) {
					((AudioBook) item).notification();
					return item;
				}
			}
		}
		return null;
	}
	
	public void calculateDuration(int hour, int min, int sec)
	{
		if(sec > 60)
		{
			min += sec/60;
			sec%=60;
		}
		
		if(min > 60)
		{
			hour+=min/60;
			min%=60;
		}
	}
	
	public String toStringDuration(Duration dur)
	{
		String str ="Duration: ";
		
		if(dur.getHr()>0)
			str+= dur.getHr() + "hours ";
		
		if(dur.getMin()>0)
			str+= dur.getMin() + "minutes ";
		
		if(dur.getSec()>0)
			str+= dur.getSec() + "seconds ";
		
		return str;
	}

	public ArrayList<E> getItems() {
		return items;
	}

	public void setItems(ArrayList<E> items) {
		this.items = items;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ImageIcon getCover() {
		return cover;
	}

	public void setCover(ImageIcon cover) {
		this.cover = cover;
	}

}

	