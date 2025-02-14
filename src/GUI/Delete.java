package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SystemAndMain.PlaylistSys;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Delete extends JFrame {

	private JPanel contentPane;
	private static JTextField tfTitle;
	private JButton btnNewButton;
	
	
	public static JTextField getTfTitle() {
		return tfTitle;
	}
	/**
	 * Launch the application.
	 */
	MainFrame mainframe;
	private JButton btnClose;
	/**
	 * Create the frame.
	 */
	
	public void clean() {
		tfTitle.setText("");
	}
	public Delete(MainFrame frame) {
		mainframe = frame;
		setTitle("DELETE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 190);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Title:");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("MS PGothic", Font.PLAIN, 15));
		lblNewLabel.setBounds(41, 33, 86, 17);
		contentPane.add(lblNewLabel);
		
		JLabel warningLabel = new JLabel("");
		warningLabel.setForeground(new Color(221, 221, 255));
		
		tfTitle = new JTextField();
		tfTitle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (tfTitle.getText().isEmpty() || PlaylistSys.searchPlaylist(tfTitle.getText()) == null) {
						warningLabel.setText("Please enter a valid playlist name!");
					} else {
						Warning warning = new Warning();
						warning.setVisible(true);
				}
				}
			}
		});
		tfTitle.setFont(new Font("MS Gothic", Font.PLAIN, 10));
		tfTitle.setBounds(101, 31, 216, 25);
		contentPane.add(tfTitle);
		tfTitle.setColumns(10);
		
		btnNewButton = new JButton("DELETE");
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		btnNewButton.setBounds(41, 88, 156, 40);
		contentPane.add(btnNewButton);
		
	
		/*
		if (PlaylistSys.getCount() > 2) {
			warningLabel.setText(PlaylistSys.getPlaylists().get(0).getTitle() + ", " + PlaylistSys.getPlaylists().get(1).getTitle() + " ...");
		} else if (PlaylistSys.getCount() == 2) {
			warningLabel.setText(PlaylistSys.getPlaylists().get(0).getTitle() + ", " + PlaylistSys.getPlaylists().get(1).getTitle());
		} else {
			warningLabel.setText(PlaylistSys.getPlaylists().get(0).getTitle() + "");
		}
		*/
		warningLabel.setBounds(41, 60, 289, 23);
		contentPane.add(warningLabel);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.setVisible(true);
				setVisible(false);
				clean();
				warningLabel.setText("");
			}
		});
		btnClose.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		btnClose.setBackground(new Color(255, 255, 0));
		btnClose.setBounds(219, 88, 98, 40);
		contentPane.add(btnClose);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfTitle.getText().isEmpty() || PlaylistSys.searchPlaylist(tfTitle.getText()) == null) {
					warningLabel.setText("Please enter a valid playlist name!");
				} else {
					Warning warning = new Warning();
					warning.setVisible(true);
					
				}
			}
		});
	}
}
