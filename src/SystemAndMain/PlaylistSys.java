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

import Classes_HasA.Artist;
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
		 try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(read);
			
			while(res.next())
			{
				String title = res.getString("title");
				String creation  = res.getString("creation");
				String cover  = res.getString("cover");
				ArrayList<Item> items = new ArrayList();
				Playlist pl = new Playlist(items, null, creation, 0, title, null);
			 	playlists.add(pl);
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
	 
	 @SuppressWarnings("unchecked")
	public static void editPlaylist(String pl_name, int pl_index) {
		 String edit;
		 Scanner scanner = new Scanner(System.in);
		 
		 System.out.println("Would you like to add an item or remove an item (add/remove) OR shuffle or sort the playlist (shuffle/sort): ");
		 edit = scanner.nextLine();
		 
		 //statement below will be updated to be a switch statement
		 if (edit.equalsIgnoreCase("add")) {
			 
			 Item obj;
			 String type;
			 Duration duration;
			 String title , date, language, genre, cover;
			 
			 System.out.println("Do you want to add a song, podcast, or audiobook? ");
			 type = scanner.nextLine();
			 
			 //statement below will be updated to be a switch statement
			 if (type.equalsIgnoreCase("song")) {
				 Artist artist;
				
				 System.out.println("Enter first name, last name , and stage name of artist:");
				 artist = new Artist(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
				 
				 System.out.println("Enter seconds, minutes ,and hours of the item:");
				 duration = new Duration(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
				 
				 System.out.println("Enter title: ");
				 scanner.skip("\\R");
				 title = scanner.nextLine();
				 
				 System.out.println("Enter release date: ");
				 date = scanner.nextLine();
				 
				 System.out.println("Enter language: ");
				 language = scanner.nextLine();
				 
				 System.out.println("Enter genre: ");
				 genre = scanner.nextLine();
				 
				 System.out.println("Enter cover image path (e.g. C:\\Users\\zeynep\\Desktop\\blond.jpg): ");
				 cover = scanner.nextLine();
				 
				 obj = new Song(artist, title, date, duration,language, genre, createImageIcon(cover));
				 obj.calculateDuration(duration.getSec(), duration.getMin(), duration.getHr());
				 playlists.get(pl_index).addItem(obj);
			 } else if (type.equalsIgnoreCase("podcast")) {
				 System.out.println("Enter seconds, minutes ,and hours of the item:");
				 duration = new Duration(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
				 
				 String host, desc;
				 int numOfEp;
				 
				 scanner.skip("\\R");
				 System.out.println("Enter host name: ");
				 host = scanner.nextLine();
				 
				 System.out.println("Enter description: ");
				 desc = scanner.nextLine();
				 
				 System.out.println("Enter num of episodes: ");
				 numOfEp = scanner.nextInt();
				 scanner.skip("\\R");
				 
				 System.out.println("Enter title of podcast: ");
				 title = scanner.nextLine();
				 
				 System.out.println("Enter release date: ");
				 date = scanner.nextLine();
				 
				 System.out.println("Enter language: ");
				 language = scanner.nextLine();
				 
				 System.out.println("Enter genre of podcast: ");
				 genre = scanner.nextLine();
				 
				 System.out.println("Enter cover image path (e.g. C:\\Users\\zeynep\\Desktop\\blond.jpg): ");
				 cover = scanner.nextLine();
				 
				 obj = new Podcast(host, desc, numOfEp, title, date, duration, language, genre, createImageIcon(cover));
				 obj.calculateDuration(duration.getSec(), duration.getMin(), duration.getHr());
				 
				 playlists.get(pl_index).addItem(obj);
			 } else if (type.equalsIgnoreCase("audiobook")) {
				 System.out.println("Enter seconds, minutes ,and hours of the item:");
				 duration = new Duration(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
				 
				 String author;
				 int chapter;
				 
				 scanner.skip("\\R");
				 System.out.println("Enter audiobook authors name: ");
				 author = scanner.nextLine();
				 
				 System.out.println("Enter the number of chapters: ");
				 chapter = scanner.nextInt();
				 
				 scanner.skip("\\R");
				 System.out.println("Enter title of audiobook: ");
				 title = scanner.nextLine();
				 
				 System.out.println("Enter release date: ");
				 date = scanner.nextLine();
				 
				 System.out.println("Enter language: ");
				 language = scanner.nextLine();
				 
				 System.out.println("Enter genre: ");
				 genre = scanner.nextLine();
				 
				 System.out.println("Enter cover image path (e.g. C:\\Users\\zeynep\\Desktop\\blond.jpg): ");
				 cover = scanner.nextLine();
				 
				 obj = new AudioBook(author, chapter, title, date, duration, language, genre, createImageIcon(cover));
				 obj.calculateDuration(duration.getSec(), duration.getMin(), duration.getHr());
				 
				 playlists.get(pl_index).addItem(obj);
			 }
		 } else if (edit.equalsIgnoreCase("remove")) {
			 
			 String titleToRemove;
			 System.out.println("Enter title of item: ");
			 titleToRemove = scanner.nextLine();
			 
			 if (playlists.get(pl_index).removeItem(playlists.get(pl_index).searchItem(titleToRemove))) {
				 System.out.println("Successfully removed!");
			 } else {
				 System.out.println("oops... something went wrong!");
			 }
		 } else if (edit.equalsIgnoreCase("shuffle")) {
			 playlists.get(pl_index).shuffle();
		 } else if (edit.equalsIgnoreCase("sort")) {
			 playlists.get(pl_index).sort();
		 }
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
	 