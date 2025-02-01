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
import java.awt.event.ActionEvent;

public class DeleteItem extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitle;

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
					String title = tfTitle.getText();
					PlaylistSys.chosePlaylistWithTitleBool((String)plf.getComboBox().getSelectedItem()).removeItem(title.getClass());
				}
			}
		});
	}
}
