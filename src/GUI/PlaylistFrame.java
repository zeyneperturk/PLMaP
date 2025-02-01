package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SystemAndMain.PlaylistSys;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlaylistFrame extends JFrame {


	private JPanel contentPane;
	private JComboBox<String> comboBox;
	AddItem addItem = new AddItem(this);

	public JComboBox<String> getComboBox() {
	     return comboBox;
	 }

	/**
	 * Launch the application.
	 */
	MainFrame mf;
	DeleteItem del = new DeleteItem(this);

	/**
	 * Create the frame.
	 */
	public static void fillComboBox(String[] items) {
        //for (String item : items) {
        //    comboBox.addItem(item);
        //}
    }
	
	@SuppressWarnings("unchecked")
	public PlaylistFrame(MainFrame frame) {
		mf = frame;
		setTitle("Playlists");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 491);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLAYLISTS:");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(65, 20, 88, 36);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("MS PGothic", Font.PLAIN, 10));
		comboBox.setBounds(150, 30, 208, 21);
		contentPane.add(comboBox);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("MS PGothic", Font.PLAIN, 12));
		btnAdd.setBounds(29, 399, 85, 21);
		contentPane.add(btnAdd);
		
		JButton btnShuffle = new JButton("SHUFFLE");
		btnShuffle.setFont(new Font("MS PGothic", Font.PLAIN, 12));
		btnShuffle.setBounds(142, 399, 85, 21);
		contentPane.add(btnShuffle);
		
		JButton btnSort = new JButton("SORT");
		btnSort.setFont(new Font("MS PGothic", Font.PLAIN, 12));
		btnSort.setBounds(258, 399, 85, 21);
		contentPane.add(btnSort);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("MS PGothic", Font.PLAIN, 12));
		btnDelete.setBounds(378, 399, 85, 21);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 73, 434, 295);
		contentPane.add(scrollPane);
		
		JTextArea textAreaPlaylist = new JTextArea();
		textAreaPlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textAreaPlaylist.setText(PlaylistSys.searchPlaylist((String)comboBox.getSelectedItem()).display());
			}
		});
		
		
		scrollPane.setViewportView(textAreaPlaylist);
		textAreaPlaylist.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		
		JButton closeButton = new JButton("close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				dispose();
				textAreaPlaylist.setText("");
			}
		});
		closeButton.setBounds(394, 30, 69, 21);
		contentPane.add(closeButton);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem.setVisible(true);
			}
		});
		
		btnShuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlaylistSys.searchPlaylist((String)comboBox.getSelectedItem()).shuffle();
				textAreaPlaylist.setText(PlaylistSys.searchPlaylist((String)comboBox.getSelectedItem()).display());
			}
		});
		
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlaylistSys.searchPlaylist((String)comboBox.getSelectedItem()).sort();
				textAreaPlaylist.setText(PlaylistSys.searchPlaylist((String)comboBox.getSelectedItem()).display());
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				del.setVisible(true);
				setVisible(false);
			}
		});
		
	}

	
}
