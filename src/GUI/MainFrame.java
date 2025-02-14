package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes_HasA.*;
import SystemAndMain.PlaylistSys;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea PlaylistTA;

	/**
	 * Launch the application.
	 */
	PlaylistFrame pl = new PlaylistFrame(this);
	AddPlaylist addPframe = new AddPlaylist(this, pl);
	Delete deleteFrame = new Delete(this);
	
	
	public void clean() {
		PlaylistTA.setText("");
	}
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("PLMaP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 534);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 0, 0));
	

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(new Color(182, 217, 179));
		verticalBox.setBounds(0, 72, 436, -61);
		contentPane.add(verticalBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 59, 304, 268);
		contentPane.add(scrollPane);
		
		JTextArea PlaylistTA = new JTextArea();
		PlaylistTA.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		PlaylistTA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PlaylistTA.setText("\n\n\n\n\nBest Playlist Management Application Ever!!! \n\n\n\n ");
			}
		});
		scrollPane.setColumnHeaderView(PlaylistTA);
		
		JButton btnDisplayPl = new JButton("DISPLAY ALL PLAYLISTS");
		btnDisplayPl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDisplayPl.setBackground(new Color(230, 100, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDisplayPl.setBackground(new Color(255, 128, 64));
			}
		});
		btnDisplayPl.setForeground(new Color(0, 0, 0));

		btnDisplayPl.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
				if (PlaylistSys.getPlaylists().size() != 0) {
					PlaylistTA.setText(PlaylistSys.displayAll());
				} else {
					PlaylistTA.setText("You dont have any playlists!");
				}
			}
		});
		btnDisplayPl.setBackground(new Color(255, 128, 64));
		btnDisplayPl.setFont(new Font("MS Gothic", Font.PLAIN, 15));
		btnDisplayPl.setBounds(94, 364, 223, 29);
		contentPane.add(btnDisplayPl);
		
		JButton btnDeletePl = new JButton("DELETE PLAYLIST");
		btnDeletePl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDeletePl.setBackground(new Color(230, 100, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDeletePl.setBackground(new Color(255, 128, 64));
			}
		});
		
		btnDeletePl.setFont(new Font("MS Gothic", Font.PLAIN, 15));
		btnDeletePl.setBackground(new Color(255, 128, 64));
		btnDeletePl.setBounds(240, 403, 159, 28);
		contentPane.add(btnDeletePl);
		
		JButton btnAddPl = new JButton("ADD PLAYLIST");
		btnAddPl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAddPl.setBackground(new Color(230, 100, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAddPl.setBackground(new Color(255, 128, 64));
			}
		});
		btnAddPl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPframe.setVisible(true);
				setVisible(false);
				pl.getComboBox().setModel(new DefaultComboBoxModel(PlaylistSys.displayPlaylistTitles()));
			}
		});
		btnAddPl.setFont(new Font("MS Gothic", Font.PLAIN, 15));
		btnAddPl.setBackground(new Color(255, 128, 64));
		btnAddPl.setBounds(10, 403, 145, 28);
		contentPane.add(btnAddPl);
		
		JLabel lblNewLabel = new JLabel("welcome to PLMaP!!!");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		lblNewLabel.setBounds(132, 21, 145, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnEditPl = new JButton(" EDIT PLAYLIST");
		btnEditPl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEditPl.setBackground(new Color(230, 100, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEditPl.setBackground(new Color(255, 128, 64));
			}
		});
		btnEditPl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (PlaylistSys.getPlaylists().size() == 0) {
					PlaylistTA.setText("In order to edit a playlist, you must have a playlist!\n\nYou dont have any playlists!");
				} else {
					pl.getComboBox().setModel(new DefaultComboBoxModel(PlaylistSys.displayPlaylistTitles()));
					pl.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnEditPl.setForeground(Color.BLACK);
		btnEditPl.setFont(new Font("MS Gothic", Font.PLAIN, 15));
		btnEditPl.setBackground(new Color(255, 128, 64));
		btnEditPl.setBounds(120, 444, 175, 29);
		contentPane.add(btnEditPl);
		
		btnDeletePl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (PlaylistSys.getPlaylists().size() == 0) {
					PlaylistTA.setText("In order to delete a playlist, you must have a playlist!\n\nYou dont have any playlists!");
				} else {
					deleteFrame.setVisible(true);
					setVisible(false);
				}
			}
		});
	}
}