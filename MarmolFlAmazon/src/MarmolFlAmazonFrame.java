import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class MarmolFlAmazonFrame extends JFrame {

	//sets up items in fram
	private JPanel contentPane;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnTools = new JMenu("Tools");
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmAddItem = new JMenuItem("Add Item ...");
	private final JMenu mnSetSort = new JMenu("Set Sort");
	private final JMenuItem mntmByItemName = new JMenuItem("By Item Name");
	private final JMenuItem mntmByPrice = new JMenuItem("By Price");
	private final JMenuItem mntmByCategory = new JMenuItem("By Category");
	private final JMenu mnSetFilter = new JMenu("Set Filter");
	private final JMenuItem mntmByPrice_1 = new JMenuItem("By Price ...");
	private final JMenuItem mntmByCategory_1 = new JMenuItem("By Category ...");
	private final JTable shoppingCartTable = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblNewLabel = new JLabel("FlAmazon");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	
	//sets up data to be shared
	private ByPrice it = new ByPrice();
	private ByCategory it1 = new ByCategory();

	//initializes sort setting to 0 or by itemID
	int sortSetting = 0;
	
	private final JButton btnClearPriceFilter = new JButton("Clear Price Filter");
	private final JButton btnClearCategpryFilter = new JButton("Clear Category Filter");
	private final JButton btnClearAllFilters = new JButton("Clear All Sorts/Filters");
	private final JButton btnClearSort = new JButton("Clear Sort");
	private final JLabel lblCurrentSort = new JLabel("Current Sort:");
	private final JLabel lblCurrentPriceFilter = new JLabel("Current Price Filter:");
	private final JLabel lblCurrentSortSetting = new JLabel("Default (by ItemID)");
	private final JLabel lblCurrentCategoryFilter = new JLabel("Current Category Filter:");
	private final JLabel lblPriceFilter1 = new JLabel("None");
	private final JLabel lblCategoryFilter = new JLabel("None");
	private final JMenuItem mntmHelp = new JMenuItem("Help ...");
	private final JLabel lblPriceFilter2 = new JLabel("None");
	private final JSeparator separator = new JSeparator();
	private final JLabel lblMyShoppingCart = new JLabel("My Shopping Cart");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarmolFlAmazonFrame frame = new MarmolFlAmazonFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MarmolFlAmazonFrame() {
		jbInit();
	}
	private void jbInit() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				do_this_windowGainedFocus(arg0);
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		
		setTitle("Marmol FlAmazon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 625);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmExit_actionPerformed(arg0);
			}
		});
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnTools);
		mntmAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmAddItem_actionPerformed(arg0);
			}
		});
		
		mnTools.add(mntmAddItem);
		
		mnTools.add(mnSetSort);
		mntmByItemName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByItemName_actionPerformed(arg0);
			}
		});
		
		mnSetSort.add(mntmByItemName);
		mntmByPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByPrice_actionPerformed(arg0);
			}
		});
		
		mnSetSort.add(mntmByPrice);
		mntmByCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByCategory_actionPerformed(arg0);
			}
		});
		
		mnSetSort.add(mntmByCategory);
		
		mnTools.add(mnSetFilter);
		mntmByPrice_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByPrice_1_actionPerformed(arg0);
			}
		});
		
		mnSetFilter.add(mntmByPrice_1);
		mntmByCategory_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByCategory_1_actionPerformed(arg0);
			}
		});
		
		mnSetFilter.add(mntmByCategory_1);
		
		
		
		menuBar.add(mnHelp);
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmHelp_actionPerformed(arg0);
			}
		});
		
		mnHelp.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setToolTipText("Shows items in shopping cart");
		scrollPane.setBounds(45, 100, 773, 206);
		
		contentPane.add(scrollPane);
		shoppingCartTable.setToolTipText("Shows items in shopping cart");
		shoppingCartTable.setFont(new Font("Courier New", Font.PLAIN, 11));
		shoppingCartTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ItemID", "ItemName", "Category", "Quantity", "Price", "Shipping"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Object.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(shoppingCartTable);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(374, 11, 117, 21);
		
		contentPane.add(lblNewLabel);
		
		//load the driver
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnClearPriceFilter.setToolTipText("Clears any set price filters");
		btnClearPriceFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClearPriceFilter_actionPerformed(arg0);
			}
		});
		btnClearPriceFilter.setBounds(471, 465, 185, 23);
		
		contentPane.add(btnClearPriceFilter);
		btnClearCategpryFilter.setToolTipText("Clears any set category filters");
		btnClearCategpryFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClearCategpryFilter_actionPerformed(arg0);
			}
		});
		btnClearCategpryFilter.setBounds(471, 499, 185, 23);
		
		contentPane.add(btnClearCategpryFilter);
		btnClearAllFilters.setToolTipText("Clears all set sorts and filters");
		btnClearAllFilters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClearAllFilters_actionPerformed(arg0);
			}
		});
		btnClearAllFilters.setBounds(666, 499, 185, 23);
		
		contentPane.add(btnClearAllFilters);
		btnClearSort.setToolTipText("Clears Sort Setting Back to Normal");
		btnClearSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClearSort_actionPerformed(arg0);
			}
		});
		btnClearSort.setBounds(666, 465, 185, 23);
		
		contentPane.add(btnClearSort);
		lblCurrentSort.setToolTipText("Shows current sort");
		lblCurrentSort.setBounds(60, 465, 78, 14);
		
		contentPane.add(lblCurrentSort);
		lblCurrentPriceFilter.setToolTipText("Shows current price filter(s)");
		lblCurrentPriceFilter.setBounds(33, 490, 128, 14);
		
		contentPane.add(lblCurrentPriceFilter);
		lblCurrentSortSetting.setToolTipText("Shows current sort");
		lblCurrentSortSetting.setBounds(148, 465, 111, 14);
		
		contentPane.add(lblCurrentSortSetting);
		lblCurrentCategoryFilter.setToolTipText("Shows current category filter(s)");
		lblCurrentCategoryFilter.setBounds(10, 540, 151, 14);
		
		contentPane.add(lblCurrentCategoryFilter);
		lblPriceFilter1.setToolTipText("Shows current price filter");
		lblPriceFilter1.setBounds(148, 490, 371, 14);
		
		contentPane.add(lblPriceFilter1);
		lblCategoryFilter.setBounds(148, 540, 703, 14);
		
		contentPane.add(lblCategoryFilter);
		lblPriceFilter2.setToolTipText("Shows current price filter");
		lblPriceFilter2.setBounds(148, 515, 314, 14);
		
		contentPane.add(lblPriceFilter2);
		separator.setBounds(10, 447, 841, 7);
		
		contentPane.add(separator);
		lblMyShoppingCart.setBounds(45, 75, 145, 14);
		
		contentPane.add(lblMyShoppingCart);
	}
	
	
	
	//closes window when exit is clicked
	protected void do_mntmExit_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
	
	//when Add Item is clicked opens new window
	protected void do_mntmAddItem_actionPerformed(ActionEvent arg0) {
		MarmolAddItemFrame addItemFrame = new MarmolAddItemFrame();
		addItemFrame.setVisible(true);
	}
	
	//sets up sprt setting and loads database sorted by item name
	protected void do_mntmByItemName_actionPerformed(ActionEvent arg0) {
		sortSetting = 1;
		showDatabase();
	}
	//sets up sprt setting and loads database sorted by price
	protected void do_mntmByPrice_actionPerformed(ActionEvent arg0) {
		sortSetting = 2;
		showDatabase();
	}
	//sets up sprt setting and loads database sorted by category
	protected void do_mntmByCategory_actionPerformed(ActionEvent arg0) {
		sortSetting = 3;
		showDatabase();
	}
	
	
	//loads database based on sorts and filters
	public void showDatabase()
	{
		Statement stmt = null;
		ResultSet rs = null;
		
	
		try{
			//estbalish the connection
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Rafael/Downloads/MarmolFlAmazon/MarmolFlAmazon/MarmolFlAmazon.accdb");
			
			//create the statement
			stmt = conn.createStatement();
			String query = "SELECT * FROM ShoppingCart WHERE (1=1)";
			
			//if comparison was selected adds that to query
			if(!it.getComparison().equals(""))
			{
				System.out.println(it.getComparison());
				System.out.println(Double.parseDouble(it.getNum()));
				//query+= "AND Price < '2.00'"; 
				query += "And Price "+ it.getComparison() + " '" + Double.parseDouble(it.getNum()) + "'";
				lblPriceFilter1.setText("Price is " + it.getComparison() + "$" + Double.parseDouble(it.getNum()));
			}
			
			//if range was selected adds to query
			if(!it.getRange1().equals("0") && !it.getRange2().equals("0"))
			{
				System.out.println(Double.parseDouble(it.getRange1()));
				System.out.println(Double.parseDouble(it.getRange2()));
				query += "And Price >= '" + Double.parseDouble(it.getRange1()) + "'";
				query += "And Price <= '" + Double.parseDouble(it.getRange2()) + "'";
				lblPriceFilter2.setText("Price is in range from $" + Double.parseDouble(it.getRange1()) + " to $" + Double.parseDouble(it.getRange2()) );
			}
			
			
			//sets filters and sorts to none if none are present
			if(it.getComparison().equals("") )
			{
				lblPriceFilter1.setText("None");
			}
			
			if(it.getRange1().equals("0") && it.getRange2().equals("0"))
			{
				lblPriceFilter2.setText("None");
			}
			
			
			if(!it1.getCategory().isEmpty())
			{
				query += "AND ((1=2)";
				for (int i = 0; i < it1.getCategory().size(); i ++)
				{
					query += "OR Category = '" + it1.getCategory().get(i) + "'";
				}
				query += ")";
				lblCategoryFilter.setText(it1.getCategory().toString());
			}
			
			//sets sort according to sort setting
			if(sortSetting == 0)
			{
				query += "ORDER BY ItemID";
				lblCurrentSortSetting.setText("Default (by ItemID)");
			}
			
			if(sortSetting == 1)
			{
				query += "ORDER BY ItemName";
				lblCurrentSortSetting.setText("by ItemName");
			}
			
			if(sortSetting == 2)
			{
				query += "ORDER BY Price";
				lblCurrentSortSetting.setText("by Price");
			}
			
			if(sortSetting == 3)
			{
				query += "ORDER BY Category";
				lblCurrentSortSetting.setText("by Category");
			}
			
			
			
			
			
			//execute the statement
			rs = stmt.executeQuery(query);
					
			//process the results
					
		   //this part is different when using jtables!!!
			
					
		  //remove any previously added rows
			while (shoppingCartTable.getRowCount() > 0)
			{
				((DefaultTableModel) shoppingCartTable.getModel()).removeRow(0);
			}
					
			int numColumns = rs.getMetaData().getColumnCount();
			
			while(rs.next())
			{
				Object[] row = new Object[numColumns];
				for(int i = 0; i < numColumns; i++)
					row[i] = rs.getObject(i + 1); //java arrays are 0-based, resultSet records are 1-based
				((DefaultTableModel) shoppingCartTable.getModel()).insertRow(rs.getRow() - 1, row);
			}//while
			
			
			
			rs.close();
			conn.close();
			
		}//try 
		catch (SQLException ex)
		{
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		} //catch
	}
	
	//opens set filter by price
	protected void do_mntmByPrice_1_actionPerformed(ActionEvent arg0) {
		MarmolSetFilterByPrice byPriceFrame = new MarmolSetFilterByPrice(it);
		byPriceFrame.setVisible(true);
	}
	protected void do_mntmByCategory_1_actionPerformed(ActionEvent arg0) {
		MarmolSetFilterByCategory byCategoryFrame = new MarmolSetFilterByCategory(it1);
		byCategoryFrame.setVisible(true);
	}
	
	//clears price filters
	protected void do_btnClearPriceFilter_actionPerformed(ActionEvent arg0) {
		it.setComparison("");
		it.setRange1("0");
		it.setRange2("0");
		lblPriceFilter1.setText("None");
		lblPriceFilter2.setText("None");
		showDatabase();
	}
	
	//clears category filters
	protected void do_btnClearCategpryFilter_actionPerformed(ActionEvent arg0) {
		ArrayList<String> clear = new ArrayList<String>();
		it1.setCategory(clear);
		lblCategoryFilter.setText("None");
		showDatabase();
	}
	
	//clears all filters
	protected void do_btnClearAllFilters_actionPerformed(ActionEvent arg0) {
		
		sortSetting = 0;
		it.setComparison("");
		it.setRange1("0");
		it.setRange2("0");
		ArrayList<String> clear = new ArrayList<String>();
		it1.setCategory(clear);
		lblPriceFilter1.setText("None");
		lblPriceFilter2.setText("None");
		lblCategoryFilter.setText("None");
		showDatabase();
	}
	
	//clears sort (sorts by itemid)
	protected void do_btnClearSort_actionPerformed(ActionEvent arg0) {
		sortSetting = 0;
		showDatabase();
		
	}
	
	
	
	//every time window gains focus, databse is reloaded
	protected void do_this_windowGainedFocus(WindowEvent arg0) {
		showDatabase();
	}
	//opens help window
	protected void do_mntmHelp_actionPerformed(ActionEvent arg0) {
		MarmolHelp helpFrame = new MarmolHelp();
		helpFrame.setVisible(true);
	}
}
