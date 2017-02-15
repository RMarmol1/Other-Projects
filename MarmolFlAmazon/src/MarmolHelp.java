import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class MarmolHelp extends JFrame {

	private JPanel contentPane;
	private final JButton btnClose = new JButton("Close");
	private final JLabel lblhelp = new JLabel("*HELP*");
	private final JLabel lblMainPage = new JLabel("Main Page");
	private final JLabel lblMenuBar = new JLabel("Menu Bar");
	private final JLabel lblExit = new JLabel("Exit:");
	private final JLabel lblFile = new JLabel("File:");
	private final JLabel lblTools = new JLabel("Tools:");
	private final JLabel lblAddItem = new JLabel("Add Item:");
	private final JLabel lblSetSort = new JLabel("Set Sort:");
	private final JLabel lblSetFilter = new JLabel("Set Filter:");
	private final JLabel lblTable = new JLabel("Table:");
	private final JLabel lblLoad = new JLabel("Load:");
	private final JLabel lblClearSort = new JLabel("Clear Sort:");
	private final JLabel lblClearPriceFilter = new JLabel("Clear Price Filter:");
	private final JLabel lblClearCategoryFilter = new JLabel("Clear Category Filter:");
	private final JLabel lblClearAllSortsfilters = new JLabel("Clear All Sorts/Filters:");
	private final JLabel lblAddItemPage = new JLabel("Add Item Page");
	private final JLabel lblItemid = new JLabel("ItemID:");
	private final JLabel lblItemname = new JLabel("ItemName:");
	private final JLabel lblItemCategory = new JLabel("Item Category:");
	private final JLabel lblItemprice = new JLabel("ItemPrice:");
	private final JLabel lblQuantity = new JLabel("Quantity:");
	private final JLabel lblShipping = new JLabel("Shipping:");
	private final JLabel lblOk = new JLabel("OK:");
	private final JLabel lblCancel = new JLabel("Cancel:");
	private final JLabel lblByItemName = new JLabel("By Item Name:");
	private final JLabel lblByPrice = new JLabel("By Price:");
	private final JLabel lblByCategory = new JLabel("By Category:");
	private final JLabel lblByPrice_1 = new JLabel("By Price:");
	private final JLabel lblByCategory_1 = new JLabel("By Category:");
	private final JLabel lblSetFilterBy = new JLabel("Set Filter By Price Page");
	private final JLabel lblFirstSelection = new JLabel("First Selection:");
	private final JLabel lblSecondSelection = new JLabel("Second Selection:");
	private final JLabel lblOk_1 = new JLabel("OK:");
	private final JLabel lblClose = new JLabel("Close:");
	private final JLabel lblSetFilterBy_1 = new JLabel("Set Filter By Category Page");
	private final JLabel lblSelectWhichCheckbox = new JLabel("Select which checkbox items you want to filter by.");
	private final JLabel lblOk_2 = new JLabel("OK:");
	private final JLabel lblClose_1 = new JLabel("Close:");
	private final JLabel lblSelectToOpen = new JLabel("Select to open File options.");
	private final JLabel lblExitsThePage = new JLabel("Exits the page.");
	private final JLabel lblShowsAvaiableTools = new JLabel("Shows avaiable tools (Add Item, Set Sort, Set Filter).");
	private final JLabel lblOpensPageTo = new JLabel("Opens page to add an item to database.");
	private final JLabel lblSetsSortBy = new JLabel("Sets sort by item name, price, or category.");
	private final JLabel lblSortsByItem = new JLabel("Sorts by Item Name.");
	private final JLabel lblSortsByItem_1 = new JLabel("Sorts by item price.");
	private final JLabel lblSortsByItem_2 = new JLabel("Sorts by item category.");
	private final JLabel lblFiltersByPrice = new JLabel("Filters by price and/or category.");
	private final JLabel lblOpensPageTo_1 = new JLabel("Opens page to set up filter by price options.");
	private final JLabel lblOpensPageTo_2 = new JLabel("Opens page to set up filter by category options.");
	private final JLabel lblShowsShoppingCart = new JLabel("Shows shopping cart databse. ");
	private final JLabel lblOutputsShoppingCart = new JLabel("Outputs shopping cart database in table. Needs to be clicked after each filter is set.");
	private final JLabel lblClearsSortSettings = new JLabel("Clears sort settings back to default.");
	private final JLabel lblClearsAnyPrice = new JLabel("Clears any price filter user has entered.");
	private final JLabel lblClearsAnyCategory = new JLabel("Clears any category filter user has entered.");
	private final JLabel lblClearsAllSorts = new JLabel("Clears all sorts and filters user has entered.");
	private final JLabel lblEnterNumericId = new JLabel("Enter numeric id for item. *Must be unique*.");
	private final JLabel lblEnterNameOf = new JLabel("Enter name of item.");
	private final JLabel lblSelectCategoryOf = new JLabel("Select category of item.");
	private final JLabel lblEnterPriceOf = new JLabel("Enter price of item in $USD.");
	private final JLabel lblEnterQuantityOf = new JLabel("Enter quantity of item being purchased.");
	private final JLabel lblEnterPriceOf_1 = new JLabel("Enter price of shipping of item in $USD.");
	private final JLabel lblClickOkTo = new JLabel("Click OK to enter item into shopping cart.");
	private final JLabel lblClickCancelTo = new JLabel("Click Cancel to cancel item being added or exit the page.");
	private final JLabel lblSetPriceFilter = new JLabel("Set price filter by certain comparison (=, <, >, <=, >=) and price to be compared to.");
	private final JLabel lblSetPriceRange = new JLabel("Set price range of filter.");
	private final JLabel lblSetsFilterSelected = new JLabel("Sets filter selected and brings user back to main page.");
	private final JLabel lblCancelsFilterAnd = new JLabel("Cancels filter and exits page.");
	private final JLabel lblSetsFiltersChosen = new JLabel("Sets filters chosen and exits page.");
	private final JLabel lblCancelsFilterAnd_1 = new JLabel("Cancels filter and exits page.");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarmolHelp frame = new MarmolHelp();
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
	public MarmolHelp() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Marmol FlAmazon Help");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 782, 1027);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClose_actionPerformed(arg0);
			}
		});
		btnClose.setBounds(285, 965, 89, 23);
		
		contentPane.add(btnClose);
		lblhelp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblhelp.setBounds(349, 11, 103, 14);
		
		contentPane.add(lblhelp);
		lblMainPage.setBounds(64, 332, 79, 14);
		
		contentPane.add(lblMainPage);
		lblMenuBar.setBounds(64, 36, 79, 14);
		
		contentPane.add(lblMenuBar);
		lblExit.setBounds(182, 80, 46, 14);
		
		contentPane.add(lblExit);
		lblFile.setBounds(182, 55, 46, 14);
		
		contentPane.add(lblFile);
		lblTools.setBounds(173, 105, 55, 14);
		
		contentPane.add(lblTools);
		lblAddItem.setBounds(154, 131, 74, 14);
		
		contentPane.add(lblAddItem);
		lblSetSort.setBounds(156, 156, 72, 14);
		
		contentPane.add(lblSetSort);
		lblSetFilter.setBounds(156, 257, 72, 14);
		
		contentPane.add(lblSetFilter);
		lblTable.setBounds(172, 357, 43, 14);
		
		contentPane.add(lblTable);
		lblLoad.setBounds(173, 382, 55, 14);
		
		contentPane.add(lblLoad);
		lblClearSort.setBounds(150, 407, 65, 14);
		
		contentPane.add(lblClearSort);
		lblClearPriceFilter.setBounds(121, 432, 107, 14);
		
		contentPane.add(lblClearPriceFilter);
		lblClearCategoryFilter.setBounds(95, 457, 133, 14);
		
		contentPane.add(lblClearCategoryFilter);
		lblClearAllSortsfilters.setBounds(95, 482, 133, 14);
		
		contentPane.add(lblClearAllSortsfilters);
		lblAddItemPage.setBounds(64, 506, 164, 14);
		
		contentPane.add(lblAddItemPage);
		lblItemid.setBounds(165, 532, 50, 14);
		
		contentPane.add(lblItemid);
		lblItemname.setBounds(150, 557, 78, 14);
		
		contentPane.add(lblItemname);
		lblItemCategory.setBounds(131, 582, 97, 14);
		
		contentPane.add(lblItemCategory);
		lblItemprice.setBounds(150, 607, 78, 14);
		
		contentPane.add(lblItemprice);
		lblQuantity.setBounds(156, 632, 72, 14);
		
		contentPane.add(lblQuantity);
		lblShipping.setBounds(156, 657, 72, 14);
		
		contentPane.add(lblShipping);
		lblOk.setBounds(184, 682, 44, 14);
		
		contentPane.add(lblOk);
		lblCancel.setBounds(165, 707, 63, 14);
		
		contentPane.add(lblCancel);
		lblByItemName.setBounds(131, 181, 97, 14);
		
		contentPane.add(lblByItemName);
		lblByPrice.setBounds(160, 204, 68, 14);
		
		contentPane.add(lblByPrice);
		lblByCategory.setBounds(138, 229, 90, 14);
		
		contentPane.add(lblByCategory);
		lblByPrice_1.setBounds(160, 282, 55, 14);
		
		contentPane.add(lblByPrice_1);
		lblByCategory_1.setBounds(138, 306, 90, 14);
		
		contentPane.add(lblByCategory_1);
		lblSetFilterBy.setBounds(64, 726, 258, 14);
		
		contentPane.add(lblSetFilterBy);
		lblFirstSelection.setBounds(131, 751, 97, 14);
		
		contentPane.add(lblFirstSelection);
		lblSecondSelection.setBounds(113, 776, 115, 14);
		
		contentPane.add(lblSecondSelection);
		lblOk_1.setBounds(184, 801, 31, 14);
		
		contentPane.add(lblOk_1);
		lblClose.setBounds(172, 826, 43, 14);
		
		contentPane.add(lblClose);
		lblSetFilterBy_1.setBounds(64, 851, 208, 14);
		
		contentPane.add(lblSetFilterBy_1);
		lblSelectWhichCheckbox.setBounds(233, 867, 360, 14);
		
		contentPane.add(lblSelectWhichCheckbox);
		lblOk_2.setBounds(184, 894, 31, 14);
		
		contentPane.add(lblOk_2);
		lblClose_1.setBounds(173, 919, 42, 14);
		
		contentPane.add(lblClose_1);
		lblSelectToOpen.setBounds(233, 55, 312, 14);
		
		contentPane.add(lblSelectToOpen);
		lblExitsThePage.setBounds(233, 80, 258, 14);
		
		contentPane.add(lblExitsThePage);
		lblShowsAvaiableTools.setBounds(233, 105, 409, 14);
		
		contentPane.add(lblShowsAvaiableTools);
		lblOpensPageTo.setBounds(233, 131, 409, 14);
		
		contentPane.add(lblOpensPageTo);
		lblSetsSortBy.setBounds(233, 156, 350, 14);
		
		contentPane.add(lblSetsSortBy);
		lblSortsByItem.setBounds(233, 181, 312, 14);
		
		contentPane.add(lblSortsByItem);
		lblSortsByItem_1.setBounds(233, 204, 258, 14);
		
		contentPane.add(lblSortsByItem_1);
		lblSortsByItem_2.setBounds(233, 229, 350, 14);
		
		contentPane.add(lblSortsByItem_2);
		lblFiltersByPrice.setBounds(233, 257, 236, 14);
		
		contentPane.add(lblFiltersByPrice);
		lblOpensPageTo_1.setBounds(233, 282, 419, 14);
		
		contentPane.add(lblOpensPageTo_1);
		lblOpensPageTo_2.setBounds(233, 306, 350, 14);
		
		contentPane.add(lblOpensPageTo_2);
		lblShowsShoppingCart.setBounds(233, 357, 324, 14);
		
		contentPane.add(lblShowsShoppingCart);
		lblOutputsShoppingCart.setBounds(233, 382, 472, 14);
		
		contentPane.add(lblOutputsShoppingCart);
		lblClearsSortSettings.setBounds(233, 407, 490, 14);
		
		contentPane.add(lblClearsSortSettings);
		lblClearsAnyPrice.setBounds(233, 432, 462, 14);
		
		contentPane.add(lblClearsAnyPrice);
		lblClearsAnyCategory.setBounds(233, 457, 409, 14);
		
		contentPane.add(lblClearsAnyCategory);
		lblClearsAllSorts.setBounds(233, 482, 462, 14);
		
		contentPane.add(lblClearsAllSorts);
		lblEnterNumericId.setBounds(233, 532, 385, 14);
		
		contentPane.add(lblEnterNumericId);
		lblEnterNameOf.setBounds(233, 557, 462, 14);
		
		contentPane.add(lblEnterNameOf);
		lblSelectCategoryOf.setBounds(233, 582, 350, 14);
		
		contentPane.add(lblSelectCategoryOf);
		lblEnterPriceOf.setBounds(233, 607, 385, 14);
		
		contentPane.add(lblEnterPriceOf);
		lblEnterQuantityOf.setBounds(233, 632, 312, 14);
		
		contentPane.add(lblEnterQuantityOf);
		lblEnterPriceOf_1.setBounds(233, 657, 312, 14);
		
		contentPane.add(lblEnterPriceOf_1);
		lblClickOkTo.setBounds(233, 682, 350, 14);
		
		contentPane.add(lblClickOkTo);
		lblClickCancelTo.setBounds(233, 707, 271, 14);
		
		contentPane.add(lblClickCancelTo);
		lblSetPriceFilter.setBounds(233, 751, 472, 14);
		
		contentPane.add(lblSetPriceFilter);
		lblSetPriceRange.setBounds(233, 776, 409, 14);
		
		contentPane.add(lblSetPriceRange);
		lblSetsFilterSelected.setBounds(233, 801, 385, 14);
		
		contentPane.add(lblSetsFilterSelected);
		lblCancelsFilterAnd.setBounds(233, 826, 324, 14);
		
		contentPane.add(lblCancelsFilterAnd);
		lblSetsFiltersChosen.setBounds(233, 894, 271, 14);
		
		contentPane.add(lblSetsFiltersChosen);
		lblCancelsFilterAnd_1.setBounds(233, 919, 258, 14);
		
		contentPane.add(lblCancelsFilterAnd_1);
	}

	protected void do_btnClose_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
