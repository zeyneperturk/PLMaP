package SystemAndMain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.ImageIcon;

import Classes_HasA.Duration;
import ItemInheritance.AudioBook;
import ItemInheritance.Item;
import ItemInheritance.Podcast;
import ItemInheritance.Song;

public class Playlist<E>{
	private ArrayList<E> items = new ArrayList<E>(); //changed Item to E
	private Duration duration;
	private String creationDate;
	private int itemAmount;
	private String title;
	private ImageIcon cover;
	private int id;
	private static int count=0;
	
	public Playlist(ArrayList<E> item, Duration duration, String date, int amount, String title, ImageIcon cover) {
		this.cover = cover;
		this.creationDate = date;
		this.duration = new Duration(0,0,0);
		this.itemAmount = amount;
		this.items = item;
		this.title = title;
	}
	
	public Playlist(ArrayList<E> item, Duration duration, String date, int amount, String title, ImageIcon cover, int id) {
		this.cover = cover;
		this.creationDate = date;
		this.duration = new Duration(0,0,0);
		this.itemAmount = amount;
		this.items = item;
		this.title = title;
		this.id = id;
	}

	public int getId() {
		return id;
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
		return "\nTitle= " + title +
				"\nDuration= " + duration.toString()
				+ "\nCreationDate= " + creationDate
				+ "\nItemAmount= " + itemAmount 
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
		items.sort(Comparator.comparing(item->((Item) item).getTitle()));
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
	
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Playlist.count = count;
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

	