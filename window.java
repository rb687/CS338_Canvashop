import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;


public class window {
	public static JFrame welcome_screen = new JFrame ("Cavashop");
	public static JPanel panel_user_info = new JPanel(new GridLayout(2,1));
	public static JPanel login_options = new JPanel(new GridLayout(1,3));
	
	
	public static void artist_login ()
    {
		welcome_screen.dispose();
		artist_screen artistScreen = new artist_screen();
		artistScreen.artist_screen_tabs();
    }
	
	public static void customer_login ()
    {
		welcome_screen.dispose();
		customer_screen customerScreen = new customer_screen();
		customerScreen.customer_screen_tabs();
    }
	
	public static void signup ()
    {
		welcome_screen.dispose();
		signup sign_up = new signup();
    }
	
	public static void main (String argv[])
    {
		welcome_screen.setVisible(true);
		welcome_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField username = new JTextField("username");
		JTextField password = new JTextField("passowrd");
		
		JButton artist_login = new JButton("Login as artist");
		artist_login.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { artist_login(); }
		    });
		
		JButton signup = new JButton("Sign Up");
		signup.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { signup(); }
		    });
		JButton customer_login = new JButton("Login as customer");
		customer_login.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { customer_login(); }
		    });
		
		panel_user_info.add(username,BorderLayout.PAGE_START );
		panel_user_info.add(password,BorderLayout.PAGE_START );
		welcome_screen.add(panel_user_info, BorderLayout.PAGE_START);
		login_options.add(artist_login, BorderLayout.WEST);
		login_options.add(customer_login, BorderLayout.EAST);
		login_options.add(signup, BorderLayout.CENTER);
		welcome_screen.add(login_options, BorderLayout.PAGE_END);
		
		welcome_screen.pack();
		
    }

}
