package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SystemAndMain.Playlist;
import SystemAndMain.PlaylistSys;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DeleteItem extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitle;
	
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

	/**
	 * Create the frame.
	 */
	public void clean() {
		tfTitle.setText("");
	}
	
	public DeleteItem(PlaylistFrame plf) {
		setTitle("Delete Item");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 190);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDelete = new JButton("DELETE");
	
		btnDelete.setForeground(new Color(64, 0, 0));
		btnDelete.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setBounds(35, 84, 156, 40);
		contentPane.add(btnDelete);
		
		JLabel warningLabel = new JLabel("");
		warningLabel.setForeground(new Color(255, 255, 255));
		warningLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 9));
		warningLabel.setBounds(46, 64, 289, 23);
		contentPane.add(warningLabel);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				plf.setVisible(true);
				clean();
				warningLabel.setText("");
			}
		});
		btnClose.setForeground(new Color(64, 0, 0));
		btnClose.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		btnClose.setBackground(new Color(255, 255, 255));
		btnClose.setBounds(237, 84, 98, 40);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel = new JLabel("Title:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("MS PGothic", Font.PLAIN, 15));
		lblNewLabel.setBounds(53, 37, 86, 17);
		contentPane.add(lblNewLabel);
		
		tfTitle = new JTextField();
		tfTitle.setFont(new Font("MS Gothic", Font.PLAIN, 10));
		tfTitle.setColumns(10);
		tfTitle.setBounds(99, 35, 216, 25);
		contentPane.add(tfTitle);
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfTitle.getText().isEmpty()) {
					warningLabel.setText("Enter valid item");
				} else {
					String itemT = tfTitle.getText();
					String plT = (String) plf.getComboBox().getSelectedItem();
					String getItem = "SELECT title FROM items i JOIN playlists p ON i.pl_id = p.pl_id WHERE p.title = ? AND i.title = ?";
					PreparedStatement stmt;
					try {
						stmt = con.prepareStatement(getItem);
						stmt.setString(1, plT);
						stmt.setString(2, itemT);
						ResultSet res = stmt.executeQuery();
						String 
						PlaylistSys.chosePlaylistWithTitleBool();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
	}
}
