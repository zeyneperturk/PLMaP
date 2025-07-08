package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes_HasA.*;
import ItemInheritance.AudioBook;
import ItemInheritance.Podcast;
import ItemInheritance.Song;
import SystemAndMain.PlaylistSys;

import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class AddItem extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfTitle;
	private JTextField tfReleaseDate;
	private JTextField tfGenre;
	private JTextField tfDuration;
	private JTextField tfLanguage;
	private JTextField tfCover;
	private JTextField tfArtistStageName;
	private JTextField tfPodcastHost;
	private JTextField tfPodcastDesc;
	private JTextField tfPodcastEpisodes;
	private JTextField tfAudioBookChapters;
	private JTextField tfAudioBookAuthor;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public void clean() {
		
	tfTitle.setText("");
	tfReleaseDate.setText("");
	tfDuration.setText("");
	tfLanguage.setText("");
	tfGenre.setText("");
	tfCover.setText("");
	tfArtistStageName.setText("");
	tfPodcastHost.setText("");
	tfPodcastEpisodes.setText("");
	tfPodcastDesc.setText("");
	tfAudioBookAuthor.setText("");
	tfAudioBookChapters.setText("");

	}

	public AddItem(PlaylistFrame pf) {
		setTitle("Add Item");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 64));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfTitle = new JTextField();
		tfTitle.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		tfTitle.setBounds(178, 78, 195, 19);
		contentPane.add(tfTitle);
		tfTitle.setColumns(10);
		
		JLabel lblReleaseDate = new JLabel("Release Date:");
		lblReleaseDate.setForeground(Color.WHITE);
		lblReleaseDate.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		lblReleaseDate.setBounds(81, 107, 100, 13);
		contentPane.add(lblReleaseDate);
		
		tfReleaseDate = new JTextField();
		tfReleaseDate.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		tfReleaseDate.setColumns(10);
		tfReleaseDate.setBounds(178, 107, 195, 19);
		contentPane.add(tfReleaseDate);
		
		tfGenre = new JTextField();
		tfGenre.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		tfGenre.setColumns(10);
		tfGenre.setBounds(179, 193, 195, 19);
		contentPane.add(tfGenre);
		
		tfDuration = new JTextField();
		tfDuration.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		tfDuration.setColumns(10);
		tfDuration.setBounds(179, 133, 195, 19);
		contentPane.add(tfDuration);
		
		tfLanguage = new JTextField();
		tfLanguage.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		tfLanguage.setColumns(10);
		tfLanguage.setBounds(179, 162, 195, 19);
		contentPane.add(tfLanguage);
		
		JLabel lblDuration = new JLabel("Duration(hr min sec):");
		lblDuration.setForeground(Color.WHITE);
		lblDuration.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		lblDuration.setBounds(20, 136, 161, 13);
		contentPane.add(lblDuration);
		
		JLabel lblLanguage = new JLabel("Language:");
		lblLanguage.setForeground(Color.WHITE);
		lblLanguage.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		lblLanguage.setBounds(105, 161, 66, 21);
		contentPane.add(lblLanguage);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		lblGenre.setBounds(126, 196, 45, 13);
		contentPane.add(lblGenre);
		
		JLabel lblCover = new JLabel("Cover:");
		lblCover.setForeground(Color.WHITE);
		lblCover.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		lblCover.setBounds(126, 223, 45, 13);
		contentPane.add(lblCover);
		
		tfCover = new JTextField();
		tfCover.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		tfCover.setColumns(10);
		tfCover.setBounds(178, 220, 195, 19);
		contentPane.add(tfCover);
		
		tfArtistStageName = new JTextField();
		tfArtistStageName.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		tfArtistStageName.setColumns(10);
		tfArtistStageName.setBounds(178, 249, 195, 19);
		contentPane.add(tfArtistStageName);
		
		JLabel lblArtistStageName = new JLabel("Artist Name:");
		lblArtistStageName.setForeground(Color.WHITE);
		lblArtistStageName.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		lblArtistStageName.setBounds(45, 250, 136, 13);
		contentPane.add(lblArtistStageName);
		

		JRadioButton rdbtnSong = new JRadioButton("SONG");
		
		rdbtnSong.setForeground(new Color(255, 255, 255));
		rdbtnSong.setBackground(new Color(0, 0, 96));
		buttonGroup.add(rdbtnSong);
		rdbtnSong.setFont(new Font("MS UI Gothic", Font.PLAIN, 13));
		rdbtnSong.setBounds(47, 33, 64, 21);
		contentPane.add(rdbtnSong);
		
		JRadioButton rdbtnPodcast = new JRadioButton("PODCAST");
		
		rdbtnPodcast.setBackground(new Color(0, 0, 89));
		rdbtnPodcast.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnPodcast);
		rdbtnPodcast.setFont(new Font("MS PGothic", Font.PLAIN, 13));
		rdbtnPodcast.setBounds(179, 33, 92, 21);
		contentPane.add(rdbtnPodcast);
		
		JRadioButton rdbtnAudioBook = new JRadioButton("AUDIO BOOK");
		
		rdbtnAudioBook.setForeground(new Color(255, 255, 255));
		rdbtnAudioBook.setBackground(new Color(0, 0, 89));
		buttonGroup.add(rdbtnAudioBook);
		rdbtnAudioBook.setFont(new Font("MS UI Gothic", Font.PLAIN, 13));
		rdbtnAudioBook.setBounds(308, 33, 108, 21);
		contentPane.add(rdbtnAudioBook);
		
		JLabel lblWarning = new JLabel("");
		lblWarning.setForeground(new Color(221, 221, 255));
		lblWarning.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		lblWarning.setBounds(27, 339, 376, 13);
		contentPane.add(lblWarning);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		btnAdd.setBounds(59, 375, 108, 44);
		contentPane.add(btnAdd);
		

		JButton btnClose = new JButton("CLOSE");
		btnClose.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		btnClose.setBounds(283, 375, 119, 44);
		contentPane.add(btnClose);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				clean();
				lblWarning.setText("");
			}
		});
		
		
		
		tfPodcastHost = new JTextField();
		tfPodcastHost.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		tfPodcastHost.setColumns(10);
		tfPodcastHost.setBounds(178, 249, 195, 19);
		contentPane.add(tfPodcastHost);
		
		tfPodcastDesc = new JTextField();
		tfPodcastDesc.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		tfPodcastDesc.setColumns(10);
		tfPodcastDesc.setBounds(178, 278, 195, 19);
		contentPane.add(tfPodcastDesc);
		
		tfPodcastEpisodes = new JTextField();
		tfPodcastEpisodes.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		tfPodcastEpisodes.setColumns(10);
		tfPodcastEpisodes.setBounds(178, 307, 195, 19);
		contentPane.add(tfPodcastEpisodes);
		
		tfAudioBookChapters = new JTextField();
		tfAudioBookChapters.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		tfAudioBookChapters.setColumns(10);
		tfAudioBookChapters.setBounds(178, 278, 195, 19);
		contentPane.add(tfAudioBookChapters);
		
		tfAudioBookAuthor = new JTextField();
		tfAudioBookAuthor.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		tfAudioBookAuthor.setColumns(10);
		tfAudioBookAuthor.setBounds(178, 249, 195, 19);
		contentPane.add(tfAudioBookAuthor);
		
		JLabel lblPodcastHost = new JLabel("Podcast Host:");
		lblPodcastHost.setForeground(new Color(255, 255, 255));
		lblPodcastHost.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		lblPodcastHost.setBounds(81, 250, 100, 13);
		contentPane.add(lblPodcastHost);
		
		JLabel lblPodcastDesc = new JLabel("Podcast Desc:");
		lblPodcastDesc.setForeground(new Color(255, 255, 255));
		lblPodcastDesc.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		lblPodcastDesc.setBounds(77, 279, 104, 13);
		contentPane.add(lblPodcastDesc);
		
		JLabel lblPodcastEpisodes = new JLabel("Podcast Episodes:");
		lblPodcastEpisodes.setForeground(Color.WHITE);
		lblPodcastEpisodes.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		lblPodcastEpisodes.setBounds(45, 305, 126, 21);
		contentPane.add(lblPodcastEpisodes);
		
		JLabel lblAudioBookAuthor = new JLabel("Audio Book Author:");
		lblAudioBookAuthor.setForeground(Color.WHITE);
		lblAudioBookAuthor.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		lblAudioBookAuthor.setBounds(50, 250, 159, 13);
		contentPane.add(lblAudioBookAuthor);
		
		JLabel lblAudioBookChapters = new JLabel("Audio Book Chapters:");
		lblAudioBookChapters.setForeground(Color.WHITE);
		lblAudioBookChapters.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		lblAudioBookChapters.setBounds(27, 276, 149, 19);
		contentPane.add(lblAudioBookChapters);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		lblTitle.setBounds(125, 79, 51, 13);
		contentPane.add(lblTitle);

		lblArtistStageName.setVisible(false);
		tfArtistStageName.setVisible(false);
		
		lblAudioBookAuthor.setVisible(false);
		lblAudioBookChapters.setVisible(false);
		tfAudioBookAuthor.setVisible(false);
		tfAudioBookChapters.setVisible(false);
		
		lblPodcastHost.setVisible(false);
		lblPodcastDesc.setVisible(false);
		lblPodcastEpisodes.setVisible(false);
		tfPodcastHost.setVisible(false);
		tfPodcastDesc.setVisible(false);
		tfPodcastEpisodes.setVisible(false);

		rdbtnSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					lblArtistStageName.setVisible(true);
					tfArtistStageName.setVisible(true);
					
					lblAudioBookAuthor.setVisible(false);
					lblAudioBookChapters.setVisible(false);
					tfAudioBookAuthor.setVisible(false);
					tfAudioBookChapters.setVisible(false);
					
					lblPodcastHost.setVisible(false);
					lblPodcastDesc.setVisible(false);
					lblPodcastEpisodes.setVisible(false);
					tfPodcastHost.setVisible(false);
					tfPodcastDesc.setVisible(false);
					tfPodcastEpisodes.setVisible(false);
					
				
			}
		});
		
		rdbtnPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
					lblPodcastHost.setVisible(true);
					lblPodcastDesc.setVisible(true);
					lblPodcastEpisodes.setVisible(true);
					tfPodcastHost.setVisible(true);
					tfPodcastDesc.setVisible(true);
					tfPodcastEpisodes.setVisible(true);
					
					lblArtistStageName.setVisible(false);
					tfArtistStageName.setVisible(false);
				
					lblAudioBookAuthor.setVisible(false);
					lblAudioBookChapters.setVisible(false);
					tfAudioBookAuthor.setVisible(false);
					tfAudioBookChapters.setVisible(false);
					
			}
			
		});
		
		rdbtnAudioBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblAudioBookAuthor.setVisible(true);
				lblAudioBookChapters.setVisible(true);
				tfAudioBookAuthor.setVisible(true);
				tfAudioBookChapters.setVisible(true);
				
				lblArtistStageName.setVisible(false);
				tfArtistStageName.setVisible(false);
				
				lblPodcastHost.setVisible(false);
				lblPodcastDesc.setVisible(false);
				lblPodcastEpisodes.setVisible(false);
				tfPodcastHost.setVisible(false);
				tfPodcastDesc.setVisible(false);
				tfPodcastEpisodes.setVisible(false);
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title, releaseDate, language, genre;
				ImageIcon cover = null;
				String[] duration = new String[3];
				
				
				if (tfDuration.getText().isEmpty() || tfTitle.getText().isEmpty()) {
					lblWarning.setText("Fill in the text areas!");
				} else {
					if (rdbtnSong.isSelected()) {
						String artist;
						title = tfTitle.getText();
						releaseDate = tfReleaseDate.getText();
						duration = tfDuration.getText().split(" ");
						Duration dur = new Duration(Integer.parseInt(duration[2]), Integer.parseInt(duration[1]), Integer.parseInt(duration[0]));
						language = tfLanguage.getText();
						genre = tfGenre.getText();
						//cover = 
						artist = tfArtistStageName.getText();
		
						Song song = new Song(artist, title, releaseDate, dur, language, genre, cover);
						
						PlaylistSys.chosePlaylistWithTitleBool((String)pf.getComboBox().getSelectedItem()).addItem(song);
					} else if (rdbtnPodcast.isSelected()) {
						String host, desc; 
						int episodes;
						title = tfTitle.getText();
						releaseDate = tfReleaseDate.getText();
						duration = tfDuration.getText().split(" ");
						Duration dur = new Duration(Integer.parseInt(duration[2]), Integer.parseInt(duration[1]), Integer.parseInt(duration[0]));
						language = tfLanguage.getText();
						genre = tfGenre.getText();
						//cover =
						host = tfPodcastHost.getText();
						desc = tfPodcastDesc.getText();
						episodes = Integer.parseInt(tfPodcastEpisodes.getText());
						
						Podcast podcast = new Podcast(host, desc, episodes, title, releaseDate, dur, language, genre, cover); 
						PlaylistSys.chosePlaylistWithTitleBool((String)pf.getComboBox().getSelectedItem()).addItem(podcast);
					} else if (rdbtnAudioBook.isSelected()) {
						String author;
						int chapters;
						title = tfTitle.getText();
						releaseDate = tfReleaseDate.getText();
						duration = tfDuration.getText().split(" ");
						Duration dur = new Duration(Integer.parseInt(duration[2]), Integer.parseInt(duration[1]), Integer.parseInt(duration[0]));
						language = tfLanguage.getText();
						genre = tfGenre.getText();
						//cover =
						author = tfAudioBookAuthor.getText();
						chapters = Integer.parseInt(tfAudioBookChapters.getText());
						
						AudioBook audiobook = new AudioBook(author, chapters, title, releaseDate, dur, language, genre, cover);
						PlaylistSys.chosePlaylistWithTitleBool((String)pf.getComboBox().getSelectedItem()).addItem(audiobook);
					} else {
						lblWarning.setText("Please select song/podcast/audiobook");
					}
				}
				
				
				
			}
		});
	}
}
