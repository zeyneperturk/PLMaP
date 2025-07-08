package SystemAndMain;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.ImageIcon;
import java.sql.*;

import GUI.*;

public class PLMaP_Main {

	public static void main(String[] args) {
		
		PlaylistSys.loadfiles();
		
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		/*
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("          Menu\n------------------------\n1- Create Playlist\n2- Remove Playlist\n3- Display A Playlist\n4- Display All Playlists\n5- Edit Playlist\n6- Exit");
		System.out.print("Enter choice: ");
		int choice = input.nextInt();
		
		while(choice>6 || choice<1)
		{
			System.out.print("Please enter a valid choice: ");
			choice = input.nextInt();
		}
		
		while(choice!=6)
		{
			switch(choice)
			{
			case 1: System.out.print("Enter title: ");
					input.skip("\\R");
					String titleToAdd = input.nextLine();
					PlaylistSys.createPlaylist(titleToAdd);
					break;
			case 2: PlaylistSys.displayPlaylistTitles();
					System.out.print("Enter a playlist title to remove: ");
					input.skip("\\R");
					String titleToDelete = input.nextLine();
					PlaylistSys.removePlaylist(titleToDelete);
					break;
			case 3: PlaylistSys.displayPlaylistTitles();
					System.out.println();
					System.out.print("Enter a playlist title to display: ");
					input.skip("\\R");
					String titleToDisplay = input.nextLine();
					if ((PlaylistSys.searchPlaylist(titleToDisplay)) == null) {
						System.out.println("Please create a playlist first. ");
					} else {
						System.out.println((PlaylistSys.searchPlaylist(titleToDisplay)).display());
					}
					
					break;
			case 4: System.out.println(PlaylistSys.displayAll());
					break;
			case 5: PlaylistSys.displayPlaylistTitles();
					System.out.print("Which playlist would you like to edit?");
					input.skip("\\R");
					String titleToEdit = input.nextLine();
					if (PlaylistSys.chosePlaylistWithTitleBool(titleToEdit)) {
						int pl_index = PlaylistSys.chosePlaylistWithTitleInt(titleToEdit);
						PlaylistSys.editPlaylist(titleToEdit, pl_index);
					} else {
						System.out.println("Playlist doesnt exist!!!");
					}
					break;
			}
			System.out.println();
			System.out.println("          Menu\n------------------------\n1- Create Playlist\n2- Remove Playlist\n3- Display A Playlist\n4- Display All Playlists\n5- Edit Playlist\n6- Exit");
			System.out.print("Enter choice: ");
			choice = input.nextInt();
			
			while(choice>6 || choice<1)
			{
				System.out.print("Please enter a valid choice: ");
				choice = input.nextInt();
			}
		}
	

		System.out.println("Program Terminated");
	
		*/
	}
	

}
