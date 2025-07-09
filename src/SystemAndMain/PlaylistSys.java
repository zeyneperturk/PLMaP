package SystemAndMain;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;

import Classes_HasA.Duration;
import ItemInheritance.AudioBook;
import ItemInheritance.Item;
import ItemInheritance.Podcast;
import ItemInheritance.Song;
import java.sql.*;

public class PlaylistSys {
	
	 private static ArrayList<Playlist> playlists = new ArrayList<Playlist>();
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
	 
	 public static void loadfiles()
	 {
		 String read = "SELECT * FROM playlists";
		 int sec=0, min=0, hr=0;
		 try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(read);
			
			while(res.next())
			{
				String title = res.getString("title");
				String creation  = res.getString("creation");
				String cover  = res.getString("cover");
				ArrayList<Item> items = new ArrayList();
				
				Playlist pl = new Playlist(items, null, creation, 0, title, null, res.getInt("pl_id"));
			 	playlists.add(pl);
			}
			
			String readSongs = "SELECT * FROM songs s JOIN items i ON s.item_id = i.item_id JOIN duration d ON d.item_id = i.item_id WHERE i.type = 's'";
			res = stmt.executeQuery(readSongs);
			
			while(res.next())
			{
				Duration dur = new Duration(res.getInt("sec"), res.getInt("min"), res.getInt("hr"));
				Song s = new Song(res.getString("artist"), res.getString("title"), res.getString("releaseD"), dur, res.getString("language"), res.getString("genre"), createImageIcon(res.getString("cover")));
				for(Playlist value : playlists)
					 if(value.getId() == res.getInt("pl_id"))
						 value.getItems().add(s);
				System.out.print("song");
			}
			
			String readAudiobooks = "SELECT * FROM audiobooks a JOIN items i ON a.item_id = i.item_id JOIN duration d ON d.item_id = i.item_id WHERE i.type = 's'";
			res = stmt.executeQuery(readAudiobooks);
			
			while(res.next())
			{
				Duration dur = new Duration(res.getInt("sec"), res.getInt("min"), res.getInt("hr"));
				AudioBook a = new AudioBook(res.getString("author"), res.getInt("chapters"), res.getString("title"), res.getString("releaseD"), dur, res.getString("language"), res.getString("genre"), createImageIcon(res.getString("cover")));
				for(Playlist value : playlists)
					 if(value.getId() == res.getInt("pl_id"))
						 value.getItems().add(a);
				System.out.print("audiobook");
			}
			
			String readPodcasts = "SELECT * FROM podcasts p JOIN items i ON p.item_id = i.item_id JOIN duration d ON d.item_id = i.item_id WHERE i.type = 's'";
			res = stmt.executeQuery(readPodcasts);
			
			while(res.next())
			{
				Duration dur = new Duration(res.getInt("sec"), res.getInt("min"), res.getInt("hr"));
				Podcast p = new Podcast(res.getString("host"), res.getString("desc"), res.getInt("episodes"), res.getString("title"), res.getString("releaseD"), dur, res.getString("language"), res.getString("genre"), createImageIcon(res.getString("cover")));
				for(Playlist value : playlists)
					 if(value.getId() == res.getInt("pl_id"))
						 value.getItems().add(p);
				System.out.print("podcast");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	 public static boolean createPlaylist(String title, String path)
	 {
		if(searchPlaylist(title)!=null)
		{
		 	System.out.println("Playlist already exists!");
		 	return false;
		}
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter cover image path (e.g. C:\\Users\\zeynep\\Desktop\\blond.jpg): ");

		ImageIcon image = PlaylistSys.createImageIcon(path);
		 
		String date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
		
		ArrayList<Item> items = new ArrayList();
		

	 	Playlist pl = new Playlist(items, null, date, 0, title, image);
	 	playlists.add(pl);
	 
	 	try {
			PreparedStatement stmt = con.prepareStatement("INSERT INTO playlists(title, creation, cover) VALUES(?,?,?)");
			stmt.setString(1, pl.getTitle());
			stmt.setString(2, pl.getCreationDate());
			stmt.setString(3, image.toString());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	System.out.println("New playlist has been added!");
	 	return true;
	 }

	public static ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	public static boolean removePlaylist(String title)
	 {
		 Playlist pl = searchPlaylist(title);
		 if(pl!=null)
		 {
			 playlists.remove(pl);
			 System.out.println("Playlist has been removed!");
			 
			 try {
				String delete = "DELETE FROM playlists WHERE pl_id IN (SELECT pl_id FROM (SELECT pl_id FROM playlists WHERE title = ?) AS temp)";
				PreparedStatement stmt = con.prepareStatement(delete);
				stmt.setString(1, title);
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return true;
		 }
		 System.out.println("Playlist doesnt exist!");
		 return false;
	 }
	 
	 public static String displayAll() 
	 {
		 String str="";
		 
		 for(Playlist value : playlists)
			 str += value.toString() + "\n\n";
		 
		 return str;
	 }
	 
	 public static Playlist searchPlaylist(String title)
	 {
		 for(Playlist value : playlists)
			 if(value.getTitle().equalsIgnoreCase(title))
				 return value;
		 return null;
	 }
	 
	 public static String totalDuration() {
		 String str="Total duration is ";
		 int hr=0, min=0, sec=0;
		 Duration dur = new Duration(0,0,0);
		 
		 for(Playlist pl : playlists)
		 {
			 dur = pl.getDuration();
			 pl.calculateDuration(dur.getSec(), dur.getMin(), dur.getHr());
			 hr+=dur.getHr();
			 min+=dur.getMin();
			 sec+=dur.getSec();
		 }
		 
		 dur.setHr(hr);
		 dur.setMin(min);
		 dur.setSec(sec);
		 str += dur.toString();
		 
		 return str;
	 }
	 
	 public static ImageIcon createImageIcon(String path) {
	        File image = new File(path);
	        
	        if (!image.exists()) {
	            System.out.println("The specified file cannot be found. Cover will be empty.");
	            return null;
	        }

	        return new ImageIcon(image.getAbsolutePath());
	    }
	 
	 public static String[] displayPlaylistTitles() {
		 int i = 0;
		 String[] plTitles = new String[playlists.size()];
		 for (Playlist pl : playlists) {
				plTitles[i] = pl.getTitle();
				i++;
		 }
		 return plTitles;
	 }
	 
	 public static Playlist chosePlaylistWithTitleBool(String pl_name) {
		 for (int i = 0; i < playlists.size(); i++) {
				if (playlists.get(i).getTitle().equalsIgnoreCase(pl_name)) {
					return playlists.get(i);
				}
		}
		 return null;
	 }
	 
	 public static int chosePlaylistWithTitleInt(String pl_name) {
		 int pl_index = -1;
		 for (int i = 0; i < playlists.size(); i++) {
				if (playlists.get(i).getTitle().equalsIgnoreCase(pl_name)) {
					pl_index = i;
				}
		}
		 return pl_index;
	 }
}
	 