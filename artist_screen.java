import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;


public class artist_screen {
	public static String[] columnNames = {"Painting Image", "Name", "Date", "Price"};
	public static Object[][] data = {
									{"Enter Painting Image URL", "Enter Painting Name", "Enter Date", "Enter Price"}
		 
					  };

	public static DefaultTableModel defaultTable = new DefaultTableModel(data, columnNames); 
	public static JTable table = new JTable(defaultTable);
	public static JFrame artist_window = new JFrame("Artist Login");
	
	public static void edit()
    {
		final JFrame edit_window = new JFrame("Edit");
		JPanel edit_panel = new JPanel(new GridLayout(5,2));
		
		final int row_selected = table.getSelectedRow();
		
		JLabel Purl = new JLabel("Painting Image URL");
		final JTextField Purl_field = new JTextField();
		Purl_field.setText( table.getModel().getValueAt(row_selected, 0).toString() );
		
		JLabel Pname = new JLabel("Painting Name");
		final JTextField Pname_field = new JTextField();
		Pname_field.setText( table.getModel().getValueAt(row_selected, 1).toString() );

		JLabel date = new JLabel("Date");
		final JTextField date_field = new JTextField();
		date_field.setText( table.getModel().getValueAt(row_selected, 2).toString() );

		
		JLabel price = new JLabel("Price in USD");
		final JTextField price_field = new JTextField();
		price_field.setText( table.getModel().getValueAt(row_selected, 3).toString() );

		JButton done = new JButton("Done");
		done.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) 
			{ 
				defaultTable.removeRow(row_selected);
				ImageIcon image = new ImageIcon(Purl_field.getText());
				defaultTable.addRow(new Object[]{image, Pname_field.getText(), date_field.getText(), price_field.getText()});
				edit_window.dispose();
			}
		    });
		
		edit_panel.add(Purl);
		edit_panel.add(Purl_field);
		edit_panel.add(Pname);
		edit_panel.add(Pname_field);
		edit_panel.add(date);
		edit_panel.add(date_field);
		edit_panel.add(price);
		edit_panel.add(price_field);
		edit_panel.add(done);
		
		edit_window.add(edit_panel);
		edit_window.setVisible(true);
		edit_window.pack();
    }
	
	public static void add()
    {
		final JFrame add_window = new JFrame("Add");
		JPanel add_panel = new JPanel(new GridLayout(5,2));
		
		JLabel Purl = new JLabel("Painting Image URL");
		final JTextField Purl_field = new JTextField("Painting Image URL");
		
		JLabel Pname = new JLabel("Painting Name");
		final JTextField Pname_field = new JTextField("Painting Name");
		
		JLabel date = new JLabel("Date");
		final JTextField date_field = new JTextField("Date");
		
		JLabel price = new JLabel("Price in USD");
		final JTextField price_field = new JTextField("Price");
		
		JButton done = new JButton("Done");
		done.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) 
			{ 
				ImageIcon image = new ImageIcon(Purl_field.getText());
				defaultTable.addRow(new Object[]{image, Pname_field.getText(), date_field.getText(), price_field.getText()});
				add_window.dispose();
			}
		    });
		
		add_panel.add(Purl);
		add_panel.add(Purl_field);
		add_panel.add(Pname);
		add_panel.add(Pname_field);
		add_panel.add(date);
		add_panel.add(date_field);
		add_panel.add(price);
		add_panel.add(price_field);
		add_panel.add(done);
		
		add_window.add(add_panel);
		add_window.setVisible(true);
		add_window.pack();
	
    }
	
	public static void delete()
    {
		final int row_selected = table.getSelectedRow();
		defaultTable.removeRow(row_selected);
    }
	
	public static void accept()
    {
		
    }
	
	public static void deny()
    {
		
    }
	
	public static void logout()
    {
		artist_window.dispose();
    }
	
	
	public void artist_screen_tabs()
	{
		JTabbedPane tabbedPane = new JTabbedPane(); 
		
		/*  
		 * AVAILABLE PAINTINGS TAB
		 * 
		 */
	    JPanel available_paintings_options = new JPanel(new GridLayout(1, 3));
	    JPanel available_paintings = new JPanel(new GridLayout(2, 1));
	    JPanel available_table = new JPanel(new GridLayout(1,1));

		JButton edit = new JButton("Edit");
		edit.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { edit(); }
		    });
		
		JButton delete = new JButton("Delete");
		delete.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { delete(); }
		    });
		
		JButton add = new JButton("Add");
		add.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { add(); }
		    });
		
		JButton logout = new JButton("Logout");
		logout.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { logout(); }
		    });
		
		available_table.add(table, BorderLayout.PAGE_START);
		
		available_paintings_options.add(edit, BorderLayout.WEST);
		available_paintings_options.add(delete, BorderLayout.CENTER);
		available_paintings_options.add(add, BorderLayout.EAST);
		available_paintings_options.add(logout, BorderLayout.PAGE_START);
		available_paintings.add(available_table, BorderLayout.PAGE_START);
		available_paintings.add(available_paintings_options, BorderLayout.PAGE_END);
		
		/* Available paintings tab done
		 * 
		 */
		
		
		/* NEW REQUESTS TAB
		 * 
		 */
		JPanel new_request_options = new JPanel(new GridLayout(1, 2));
	    JPanel new_request_table = new JPanel(new GridLayout(1,1));
	    JPanel new_requests = new JPanel(new GridLayout(2,3));

		String[] columnNames_new_request = {"Painting Image", "Name", "Date", "Price"};
		Object[][] data_new_request = {
    									{"Painting Image URL", "Painting Name", "Date", "Price"}
			 
    					  };
    
		// = new DefaultTableModel(data_new_request, columnNames_new_request); 
		final DefaultTableModel defaultTable_new_request = new DefaultTableModel(data_new_request, columnNames_new_request)
		  {
		    public boolean isCellEditable(int row, int column)
		    {
		      return false; //This causes all cells to be not editable
		    }
		  };
		  
		JTable table_new_request = new JTable(defaultTable_new_request);
		
		JButton accept = new JButton("Accept");
		accept.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { accept(); }
		    });
		
		JButton deny = new JButton("Deny");
		deny.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { deny(); }
		    });
		
		JButton logout_new_request = new JButton("Logout");
		logout_new_request.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { logout(); }
		    });
		
		new_request_table.add(table_new_request, BorderLayout.PAGE_START);
		
		new_request_options.add(accept, BorderLayout.WEST);
		new_request_options.add(deny, BorderLayout.CENTER);
		new_request_options.add(logout_new_request, BorderLayout.EAST);
		new_requests.add(new_request_table, BorderLayout.PAGE_START);
		new_requests.add(new_request_options, BorderLayout.PAGE_END);
		
		/* 
		 * NEW REQUEST TAB ENDS HERE
		 * 
		 */
		
		
		/* 
		 * SOLD OUT TAB
		 * 
		 */
		
	    JPanel sold = new JPanel(new GridLayout(2,3));

		String[] columnNames_sold = {"Painting Image", "Name", "Date", "Price"};
		Object[][] data_sold = {
    									{"Painting Image URL", "Painting Name", "Date", "Price"}
			 
    					  };
    
		final DefaultTableModel defaultTable_sold = new DefaultTableModel(data_sold, columnNames_sold)
		  {
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		  };
		  
		JTable table_sold = new JTable(defaultTable_sold);
		JButton logout_sold = new JButton("Logout");
		logout_sold.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { logout(); }
		    });
		sold.add(table_sold, BorderLayout.PAGE_START);
		sold.add(logout_sold, BorderLayout.PAGE_END);
		
		/* SOLD TAB ENDS HERE
		 * 
		 */
		
		tabbedPane.addTab("Available Paintings", available_paintings);
		tabbedPane.addTab("New Requests", new_requests);
		tabbedPane.addTab("Sold", sold);

		
		artist_window.add(tabbedPane);
		artist_window.setVisible(true);
		artist_window.pack();
		
	}
	
}
