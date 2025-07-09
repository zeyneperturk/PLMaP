package SystemAndMain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	static Connection con;
	 static {
		 try {
			 String url = "jdbc:mysql://localhost:3306/plmap";
			 String user = "root";
			 String pwd = "";
			 con = DriverManager.getConnection(url, user, pwd);
			 Statement stmt = con.createStatement();
			 ResultSet res = stmt.executeQuery("SELECT * FROM playlists");
			 System.out.print("success");
		 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			 e1.printStackTrace();
		}
	 }
	
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
			
		try {
			if(item instanceof Song)
			{
				Song s = (Song) item;
				PreparedStatement stmt = con.prepareStatement("INSERT INTO items(type, title, releaseD, language, genre, cover, pl_id) VALUES('s',?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, s.getTitle());
				stmt.setString(2, s.getReleaseDate());
				stmt.setString(3, s.getLanguage());
				stmt.setString(4, s.getGenre());
				stmt.setString(5, "a");
				stmt.setInt(6, id);
				stmt.executeUpdate();
				ResultSet keys = stmt.getGeneratedKeys();
				keys.next();
				int key = keys.getInt(1);
	
		
				stmt = con.prepareStatement("INSERT INTO songs(item_id, artist) VALUES(?,?)");
				stmt.setInt(1, key);
				stmt.setString(2, s.getArtist());
				stmt.executeUpdate();
				
				stmt = con.prepareStatement("INSERT INTO duration(item_id, pl_id, sec, min, hr) VALUES(?,?,?,?,?)");
				stmt.setInt(1, key);
				stmt.setInt(2, id);
				stmt.setInt(3, s.getDuration().getSec());
				stmt.setInt(4, s.getDuration().getMin());
				stmt.setInt(5, s.getDuration().getHr());
				stmt.executeUpdate();
				
				System.out.print("new song added to the db");
			}
			else if(item instanceof AudioBook)
			{
				AudioBook a = (AudioBook) item;
				PreparedStatement stmt = con.prepareStatement("INSERT INTO items(type, title, releaseD, language, genre, cover, pl_id) VALUES('a',?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, a.getTitle());
				stmt.setString(2, a.getReleaseDate());
				stmt.setString(3, a.getLanguage());
				stmt.setString(4, a.getGenre());
				stmt.setString(5, "a");
				stmt.setInt(6, id);
				stmt.executeUpdate();
				ResultSet keys = stmt.getGeneratedKeys();
				keys.next();
				int key = keys.getInt(1);
	
		
				stmt = con.prepareStatement("INSERT INTO audiobooks(item_id, author, chapters) VALUES(?,?,?)");
				stmt.setInt(1, key);
				stmt.setString(2, a.getAuthor());
				stmt.setInt(3, a.getChapters());
				stmt.executeUpdate();
				
				stmt = con.prepareStatement("INSERT INTO duration(item_id, pl_id, sec, min, hr) VALUES(?,?,?,?,?)");
				stmt.setInt(1, key);
				stmt.setInt(2, id);
				stmt.setInt(3, a.getDuration().getSec());
				stmt.setInt(4, a.getDuration().getMin());
				stmt.setInt(5, a.getDuration().getHr());
				stmt.executeUpdate();
				
				System.out.print("new audiobook added to the db");
			}
			else
			{
				Podcast p = (Podcast) item;
				PreparedStatement stmt = con.prepareStatement("INSERT INTO items(type, title, releaseD, language, genre, cover, pl_id) VALUES('p',?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, p.getTitle());
				stmt.setString(2, p.getReleaseDate());
				stmt.setString(3, p.getLanguage());
				stmt.setString(4, p.getGenre());
				stmt.setString(5, "a");
				stmt.setInt(6, id);
				stmt.executeUpdate();
				ResultSet keys = stmt.getGeneratedKeys();
				keys.next();
				int key = keys.getInt(1);
	
		
				stmt = con.prepareStatement("INSERT INTO podcasts(item_id, host, description, episodes) VALUES(?,?,?,?)");
				stmt.setInt(1, key);
				stmt.setString(2, p.getHost());
				stmt.setString(3, p.getDesc());
				stmt.setInt(4, p.getEpisodes());
				stmt.executeUpdate();
				
				stmt = con.prepareStatement("INSERT INTO duration(item_id, pl_id, sec, min, hr) VALUES(?,?,?,?,?)");
				stmt.setInt(1, key);
				stmt.setInt(2, id);
				stmt.setInt(3, p.getDuration().getSec());
				stmt.setInt(4, p.getDuration().getMin());
				stmt.setInt(5, p.getDuration().getHr());
				stmt.executeUpdate();
				
				System.out.print("new podcast added to the db");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean removeItem(E item) {
		for (E e : items) {
			if (e.equals(item)) {
				((ArrayList<E>) item).remove(e);
				PreparedStatement stmt;
				try {
					stmt = con.prepareStatement("DELETE FROM items WHERE title = ?");
					stmt.setString(1, ((Item) item).getTitle());
					stmt.executeUpdate();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
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

	