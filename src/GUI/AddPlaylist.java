package GUI;

import SystemAndMain.PlaylistSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes_HasA.*;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddPlaylist extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitle;
	private JTextField tfCover;

	/**
	 * Launch the application.
	 */
	MainFrame mf;

	/**
	 * Create the frame.
	 */
	public void clean() {
		tfTitle.setText("");
		tfCover.setText("C:\\\\Users\\\\zeynep\\\\Desktop\\\\blond.jpg");
	
	}
	
	public AddPlaylist(MainFrame frame, PlaylistFrame pf) {
		mf = frame;
		setTitle("New Playlist");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 274);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("MS Gothic", Font.PLAIN, 16));
		lblTitle.setBounds(55, 46, 85, 16);
		contentPane.add(lblTitle);
		
		tfTitle = new JTextField();
		tfTitle.setFont(new Font("MS Gothic", Font.PLAIN, 10));
		tfTitle.setBounds(115, 42, 248, 30);
		contentPane.add(tfTitle);
		tfTitle.setColumns(10);
		
		JLabel lblCover = new JLabel("Cover:");
		lblCover.setForeground(Color.WHITE);
		lblCover.setFont(new Font("MS Gothic", Font.PLAIN, 16));
		lblCover.setBounds(55, 96, 71, 16);
		contentPane.add(lblCover);
		
		tfCover = new JTextField();
		tfCover.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfCover.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfCover.getText().isEmpty())
					tfCover.setText("C:\\\\Users\\\\zeynep\\\\Desktop\\\\blond.jpg");
			}
		});
		tfCover.setText("C:\\\\Users\\\\zeynep\\\\Desktop\\\\blond.jpg");
		tfCover.setToolTipText("");
		tfCover.setFont(new Font("Monospaced", Font.PLAIN, 10));
		tfCover.setColumns(10);
		tfCover.setBounds(115, 92, 248, 30);
		contentPane.add(tfCover);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		btnAdd.setBounds(65, 171, 102, 43);
		contentPane.add(btnAdd);
		
		JLabel lblWarning = new JLabel("");
		lblWarning.setForeground(new Color(221, 221, 255));
		lblWarning.setFont(new Font("MS Gothic", Font.PLAIN, 12));
		lblWarning.setBounds(54, 139, 329, 16);
		contentPane.add(lblWarning);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				dispose();
				clean();
				lblWarning.setText("");
			}
		});
		btnBack.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		btnBack.setBounds(281, 171, 102, 43);
		contentPane.add(btnBack);
		
	
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title;
				title = tfTitle.getText();
				String path = tfCover.getText();
				if (title.isEmpty() || !(PlaylistSys.searchPlaylist(title) == null)) {
					lblWarning.setText("Please enter a valid playlist name !");
				} 
				else if(PlaylistSys.createImageIcon(path)==null){
					lblWarning.setText("Please enter a valid cover path !");
				}
				else {

					PlaylistSys.createPlaylist(title, path);
					lblWarning.setText("Playlist called " + title + " has been created :)");
					pf.getComboBox().setModel(new DefaultComboBoxModel(PlaylistSys.displayPlaylistTitles()));
				}
			}
		});
	}
}
