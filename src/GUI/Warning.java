package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SystemAndMain.PlaylistSys;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Warning extends JFrame {

	private JPanel contentPane;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Warning() {
		setTitle("WARNING!!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 207);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 41, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Do you really want to delete it?");
		lblNewLabel.setForeground(new Color(3, 80, 156));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 19, 379, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblThisWillBe = new JLabel("This will be your last warning. Make your final choice. ");
		lblThisWillBe.setForeground(new Color(0, 0, 0));
		lblThisWillBe.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblThisWillBe.setBounds(10, 57, 379, 28);
		contentPane.add(lblThisWillBe);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlaylistSys.removePlaylist(Delete.getTfTitle().getText());
				setVisible(false);
			}
		});
		btnDelete.setFont(new Font("SansSerif", Font.PLAIN, 10));
		btnDelete.setBounds(241, 115, 84, 28);
		contentPane.add(btnDelete);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setFont(new Font("SansSerif", Font.PLAIN, 10));
		btnCancel.setBounds(335, 115, 84, 28);
		contentPane.add(btnCancel);
	}

}
