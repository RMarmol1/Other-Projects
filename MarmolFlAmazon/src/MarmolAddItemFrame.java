import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

public class MarmolAddItemFrame extends JFrame {

	private JPanel contentPane;
	
	//input verifiers
	NumberFormat numFormat = NumberFormat.getNumberInstance();
	NumberFormat doubleFormat = NumberFormat.getCurrencyInstance();
	
	
	private final JButton btnCancel = new JButton("Cancel");
	private final JLabel lblEnterItemYou = new JLabel("Enter Item you want to add to your shopping cart:");
	private final JLabel lblItemid = new JLabel("ItemID:");
	private final JLabel lblItemname = new JLabel("ItemName:");
	private final JLabel lblCategory = new JLabel("Category:");
	private final JLabel lblQuantity = new JLabel("Quantity:");
	private final JLabel lblPrice = new JLabel("Price:");
	private final JLabel lblShipping = new JLabel("Shipping:");
	private final JButton btnOk = new JButton("OK");
	private final JComboBox categoryComboBox = new JComboBox();
	private final JFormattedTextField itemIDFTF = new JFormattedTextField(numFormat);
	private final JFormattedTextField itemNameFTF = new JFormattedTextField();
	private final JFormattedTextField qtyFTF = new JFormattedTextField(numFormat);
	private final JFormattedTextField priceFTF = new JFormattedTextField(doubleFormat);
	private final JFormattedTextField shippingFTF = new JFormattedTextField(doubleFormat);
	//initializes values for FTF
	int num1 = 0;
	int num3 = 1;
	double num2 = 0.00;
	private final JLabel lblMissing = new JLabel("*Please fill in missing fields*");
	private final JLabel lblMissingName = new JLabel("*");
	private final JLabel lblMissingCategory = new JLabel("*");
	private final JLabel lblmakeItemidUnique = new JLabel("<HTML>\r\n*Item may already be in Shopping Cart*<br>\r\n*Be sure to make ItemID unique*\r\n</HTML>");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarmolAddItemFrame frame = new MarmolAddItemFrame();
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
	public MarmolAddItemFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("MarmolFlAmazon Add Item");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClose_actionPerformed(arg0);
			}
		});
		btnCancel.setBounds(175, 356, 89, 23);
		
		contentPane.add(btnCancel);
		
		//load the driver
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
		    // TODO Auto-generated catch block
			e.printStackTrace();
		}
		itemIDFTF.setToolTipText("Enter itemID. Must be unique.");
		
		itemIDFTF.setValue(num1);
		qtyFTF.setToolTipText("Enter quantity");
		qtyFTF.setValue(num3);
		priceFTF.setToolTipText("Enter price in $USD");
		priceFTF.setValue(num2);
		shippingFTF.setToolTipText("Enter shipping in $USD");
		shippingFTF.setValue(num2);
		
		
		lblEnterItemYou.setBounds(10, 11, 318, 14);
		
		contentPane.add(lblEnterItemYou);
		lblItemid.setToolTipText("Enter itemID. Must be unique.");
		lblItemid.setBounds(119, 43, 59, 14);
		
		contentPane.add(lblItemid);
		lblItemname.setToolTipText("Enter item name");
		lblItemname.setBounds(106, 74, 72, 14);
		
		contentPane.add(lblItemname);
		lblCategory.setToolTipText("Select category");
		lblCategory.setBounds(106, 105, 72, 14);
		
		contentPane.add(lblCategory);
		lblQuantity.setToolTipText("Enter quantity");
		lblQuantity.setBounds(106, 136, 100, 14);
		
		contentPane.add(lblQuantity);
		lblPrice.setToolTipText("Enter price in $USD");
		lblPrice.setBounds(106, 167, 46, 14);
		
		contentPane.add(lblPrice);
		lblShipping.setToolTipText("Enter shipping in $USD");
		lblShipping.setBounds(106, 198, 72, 14);
		
		contentPane.add(lblShipping);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnOk_actionPerformed(arg0);
			}
		});
		btnOk.setBounds(175, 322, 89, 23);
		
		contentPane.add(btnOk);
		categoryComboBox.setToolTipText("Select category");
		categoryComboBox.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "Electronics", "Computers", "Clothing", "Music", "Books", "Movies", "HomeGarden", "Sports", "Automotive", "Other"}));
		categoryComboBox.setBounds(175, 99, 89, 20);
		
		contentPane.add(categoryComboBox);
		itemIDFTF.setBounds(175, 36, 89, 21);
		
		contentPane.add(itemIDFTF);
		itemNameFTF.setToolTipText("Enter item name");
		itemNameFTF.setBounds(175, 67, 89, 21);
		
		contentPane.add(itemNameFTF);
		qtyFTF.setBounds(175, 129, 89, 21);
		
		contentPane.add(qtyFTF);
		priceFTF.setBounds(175, 160, 89, 21);
		
		contentPane.add(priceFTF);
		shippingFTF.setBounds(175, 191, 89, 21);
		
		contentPane.add(shippingFTF);
		lblMissing.setBounds(106, 238, 158, 14);
		
		lblMissing.setVisible(false);
		
		contentPane.add(lblMissing);
		lblMissingName.setBounds(93, 74, 46, 14);
		
		lblMissingName.setVisible(false);
		
		contentPane.add(lblMissingName);
		lblMissingCategory.setBounds(93, 105, 46, 14);
		
		lblMissingCategory.setVisible(false);
		
		contentPane.add(lblMissingCategory);
		lblmakeItemidUnique.setBounds(106, 259, 193, 46);
		
		lblmakeItemidUnique.setVisible(false);
		
		contentPane.add(lblmakeItemidUnique);
	}
	
	//closes frame
	protected void do_btnClose_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
	
	//adds item to shopping cart
	protected void do_btnOk_actionPerformed(ActionEvent arg0) {
		
		if(itemNameFTF.getText().equals("") || categoryComboBox.getSelectedItem().equals("--Select--"))
		{
			lblMissing.setVisible(true);
			if(itemNameFTF.getText().equals(""))
			{
				lblMissingName.setVisible(true);
			}
			if(categoryComboBox.getSelectedItem().equals("--Select--"))
			{
				lblMissingCategory.setVisible(true);
			}
			
		}
		else
		{
			Statement stmt = null;
			
			try {
				//2. Establish the connection
				Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Rafael/Downloads/MarmolFlAmazon/MarmolFlAmazon/MarmolFlAmazon.accdb");
				
				//3. Create the statement
				//different type of statement to allow insert/update!!!
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				String query = "INSERT INTO ShoppingCart VALUES (";
				query += itemIDFTF.getValue() + ", ";
				query += "'" + itemNameFTF.getText().trim() + "', ";
				query += "'" + categoryComboBox.getSelectedItem() + "', ";
				query += qtyFTF.getValue() + ", ";
				if(priceFTF.getValue().equals(0))
				{
					priceFTF.setValue(0.00);
				}
				query += priceFTF.getValue() + ", ";
				if(shippingFTF.getValue().equals(0))
				{
					shippingFTF.setValue(0.00);
				}
				query += shippingFTF.getValue() + ")";
				
				System.out.println(query);
				
				//4. Execute the statement (and process results)
				if (stmt.executeUpdate(query) != 0)
				{
					System.out.println("Success!");
				}
				else
				{
					System.out.println("Nope!");
				}
				
				conn.close();
				this.dispose();
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				lblmakeItemidUnique.setVisible(true);
			}
		}
		
		
		
		
	}
}
