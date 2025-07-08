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
	}
	

}
