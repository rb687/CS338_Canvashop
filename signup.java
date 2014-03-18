import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signup {
	
	public signup()
	{
		final JFrame signup_window = new JFrame("Sign Up");
		JPanel signup_panel = new JPanel(new GridLayout(5,2));
		
		JLabel Fname = new JLabel("First Name");
		JTextField Fname_field = new JTextField("First Name");
		
		JLabel Lname = new JLabel("Last Name");
		JTextField Lname_field = new JTextField("Last Name");
		
		JLabel email = new JLabel("Email");
		JTextField email_field = new JTextField("Email");
		
		JLabel password = new JLabel("Password");
		JTextField password_field = new JTextField("Password");
		
		JButton signup = new JButton("Sign Up");
		signup.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) 
			{ 
				signup_window.dispose();
			}
		    });
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { signup_window.dispose(); }
		    });
		
		signup_panel.add(Fname);
		signup_panel.add(Fname_field);
		signup_panel.add(Lname);
		signup_panel.add(Lname_field);
		signup_panel.add(email);
		signup_panel.add(email_field);
		signup_panel.add(password);
		signup_panel.add(password_field);
		signup_panel.add(signup);
		signup_panel.add(cancel);
		
		signup_window.add(signup_panel);
		signup_window.setVisible(true);
		signup_window.pack();
		
		
	}

}
