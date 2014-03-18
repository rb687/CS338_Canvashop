import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.filechooser.*;
import javax.swing.ImageIcon;
import java.io.*;


public class customer_screen {
	public static JFrame customer_window = new JFrame("Customer Login");
	public static String[] columnNames = {"Painting Image", "Name", "Date", "Artist", "Price", "Quantity"};
	public static Object[][] data = {
							{"Painting Image URL", "Painting Name", "Date", "Artist", "Price", "Quantity"}
						
	};

	public static DefaultTableModel defaultTable = new DefaultTableModel(data, columnNames); 
	public static JTable table = new JTable(defaultTable);

	public static void logout()
    {
		customer_window.dispose();
    }
	
	public static void request()
    {
		customer_window.dispose();
		final JFrame request_window = new JFrame("Make a request");
		JPanel request_panel = new JPanel(new GridLayout(3,2));
		JLabel name = new JLabel("Painting Name");
		JTextField name_field = new JTextField("Name");
		
		JLabel purl = new JLabel("Painting URL");
		final JTextField purl_field = new JTextField();
		
		JButton browse = new JButton("Browse...");
		browse.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) 
			{ 
				JFileChooser fc = new JFileChooser();
				 int returnVal = fc.showOpenDialog(null);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	purl_field.setText(fc.getSelectedFile().toString());
				    }
				
			}
		    });
		JButton done = new JButton("Done");
		done.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) 
			{ 
				request_window.dispose();
			}
		    });
		
		request_panel.add(name);
		request_panel.add(name_field);
		request_panel.add(purl);
		request_panel.add(purl_field);
		request_panel.add(browse);
		request_panel.add(done);

		request_window.add(request_panel);
		request_window.setVisible(true);
		request_window.pack();
		
    }
	
	
	public static void buy()
    {
		//final int row_selected = table.getSelectedRow();
		//final int quantity_prev = Integer.parseInt((table.getModel().getValueAt(row_selected, 5)).toString());
		
		final JFrame quantity = new JFrame("Quantity");
		JPanel quant_panel = new JPanel(new GridLayout(8,2));
		
		JLabel quant = new JLabel("Quantity");
		final JTextField quant_field = new JTextField(0);
		
		JLabel cardno = new JLabel("Card Number");
		JTextField cardno_field = new JTextField("Card Number");
		
		JLabel ship_add = new JLabel("Shipping Address");
		JTextField ship_add_field = new JTextField("Address line 1");
		
		JLabel add_line2 = new JLabel("");
		JTextField add_line2_field = new JTextField("Address line 2");
		
		JLabel city = new JLabel("City");
		JTextField city_field = new JTextField("City");
		
		JLabel zipcode = new JLabel("Zip Code");
		JTextField zipcode_field = new JTextField("Zip Code");
		
		JLabel state = new JLabel("State");
		JTextField state_field = new JTextField("");
		
		String[] countries = { "", "USA", "India", "NZ", "Spain" };

		JComboBox countryList = new JComboBox(countries);
		countryList.setSelectedIndex(0);
		//countryList.addActionListener(this);
		
		
		JButton buy = new JButton("Buy");
		buy.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) 
			{ 
				final JFrame bought = new JFrame("Bought");
				JLabel text = new JLabel("Items bought will be shipped in 2-4 business days");
				quantity.dispose();
				JButton ok = new JButton("OK");
				ok.addActionListener (new ActionListener () {
					public void actionPerformed (ActionEvent e) 
					{ 
						bought.dispose();
					}
				    });
				bought.add(text, BorderLayout.PAGE_START);
				bought.add(ok, BorderLayout.PAGE_END);
				bought.setVisible(true);
				bought.pack();
				
			}
		    });
		quant_panel.add(quant);
		quant_panel.add(quant_field);
		quant_panel.add(cardno);
		quant_panel.add(cardno_field);
		quant_panel.add(ship_add);
		quant_panel.add(ship_add_field);
		quant_panel.add(add_line2);
		quant_panel.add(add_line2_field);
		quant_panel.add(city);
		quant_panel.add(city_field);
		quant_panel.add(zipcode);
		quant_panel.add(zipcode_field);
		quant_panel.add(state);
		quant_panel.add(state_field);
		quant_panel.add(countryList);
		quant_panel.add(buy);
		
		quantity.add(quant_panel);
		quantity.setVisible(true);
		quantity.pack();
		
		customer_window.dispose();
    }
	
	public void customer_screen_tabs()
	{
		JTabbedPane tabbedPane = new JTabbedPane(); 
	
		/* 
		 *  AVAILABLE PAINTINGS TAB 
		 */
		JPanel available_paintings_options = new JPanel(new GridLayout(1, 3));
		JPanel available_paintings = new JPanel(new GridLayout(3, 1));
		JPanel available_table = new JPanel(new GridLayout(1,1));

		
	
		JButton buy = new JButton("Buy");
		buy.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { buy(); }
		    });
		
		JButton Request = new JButton("Request");
		Request.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { request(); }
		    });
		
		JButton logout = new JButton("Logout");
		logout.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { logout(); }
		    });
		
		available_table.add(table, BorderLayout.PAGE_START);
	
		available_paintings_options.add(buy, BorderLayout.WEST);
		available_paintings_options.add(Request, BorderLayout.CENTER);
		available_paintings_options.add(logout, BorderLayout.EAST);
		available_paintings_options.add(logout, BorderLayout.PAGE_START);
		available_paintings.add(available_table, BorderLayout.PAGE_START);
		available_paintings.add(available_paintings_options, BorderLayout.PAGE_END);
	
		/* Available paintings tab done
		 * 
		 */
		
		/* REQUESTS TAB
		 * 
		 */
		JPanel request_options = new JPanel(new GridLayout(1, 2));
	    JPanel request_table = new JPanel(new GridLayout(1,1));
	    JPanel requests = new JPanel(new GridLayout(2,3));

		String[] columnNames_request = {"Painting Image", "Name", "Date", "Price"};
		Object[][] data_request = {
    									{"Painting Image URL", "Painting Name", "Date", "Price"}
			 
    					  };
    
		final DefaultTableModel defaultTable_request = new DefaultTableModel(data_request, columnNames_request)
		  {
		    public boolean isCellEditable(int row, int column)
		    {
		      return false; //This causes all cells to be editable
		    }
		  };
		  
		JTable table_request = new JTable(defaultTable_request);
		JButton logout_new_request = new JButton("Logout");
		logout_new_request.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) { logout(); }
		    });
		request_table.add(table_request, BorderLayout.PAGE_START);
		
		request_options.add(logout_new_request, BorderLayout.EAST);
		requests.add(request_table, BorderLayout.PAGE_START);
		requests.add(request_options, BorderLayout.PAGE_END);
		
		/* NEW REQUEST TAB ENDS HERE
		 * 
		 */

		tabbedPane.addTab("Available Paintings", available_paintings);
		tabbedPane.addTab("Requests", requests);

		customer_window.add(tabbedPane);
		customer_window.setVisible(true);
		customer_window.pack();
	}
}
