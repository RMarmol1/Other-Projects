import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MarmolSetFilterByCategory extends JFrame {

	private JPanel contentPane;
	private final JLabel lblSetFilterBy = new JLabel("Set Filter by Category");
	private final JLabel lblChoose = new JLabel("Choose categories you wish to see:");
	private final JCheckBox chckbxElectronics = new JCheckBox("Electronics");
	private final JCheckBox chckbxComputers = new JCheckBox("Computers");
	private final JCheckBox chckbxClothing = new JCheckBox("Clothing");
	private final JCheckBox chckbxMusic = new JCheckBox("Music");
	private final JCheckBox chckbxBooks = new JCheckBox("Books");
	private final JCheckBox chckbxMovies = new JCheckBox("Movies");
	private final JCheckBox chckbxHomegarden = new JCheckBox("HomeGarden");
	private final JCheckBox chckbxSports = new JCheckBox("Sports");
	private final JCheckBox chckbxAutomotive = new JCheckBox("Automotive");
	private final JCheckBox chckbxOther = new JCheckBox("Other");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	//sets up data to be shared
	private ByCategory byCategory;
	
	private final JButton btnClose = new JButton("Close");
	private final JButton btnOk = new JButton("OK");
	
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MarmolSetFilterByCategory(ByCategory item) {
		byCategory = item;
		jbInit();
	}
	private void jbInit() {
		setTitle("Marmol FlAmazon Set Filter By Category");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblSetFilterBy.setBounds(166, 11, 149, 14);
		
		contentPane.add(lblSetFilterBy);
		lblChoose.setBounds(40, 50, 202, 14);
		
		contentPane.add(lblChoose);
		chckbxElectronics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_chckbxElectronics_actionPerformed(arg0);
			}
		});
		chckbxElectronics.setBounds(250, 47, 97, 23);
		
		contentPane.add(chckbxElectronics);
		chckbxComputers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_chckbxComputers_actionPerformed(arg0);
			}
		});
		chckbxComputers.setBounds(250, 73, 97, 23);
		
		contentPane.add(chckbxComputers);
		chckbxClothing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_chckbxClothing_actionPerformed(arg0);
			}
		});
		chckbxClothing.setBounds(250, 99, 97, 23);
		
		contentPane.add(chckbxClothing);
		chckbxMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_chckbxMusic_actionPerformed(arg0);
			}
		});
		chckbxMusic.setBounds(250, 125, 97, 23);
		
		contentPane.add(chckbxMusic);
		chckbxBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_chckbxBooks_actionPerformed(arg0);
			}
		});
		chckbxBooks.setBounds(250, 151, 97, 23);
		
		contentPane.add(chckbxBooks);
		chckbxMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_chckbxMovies_actionPerformed(arg0);
			}
		});
		chckbxMovies.setBounds(250, 177, 97, 23);
		
		contentPane.add(chckbxMovies);
		chckbxHomegarden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_chckbxHomegarden_actionPerformed(arg0);
			}
		});
		chckbxHomegarden.setBounds(250, 203, 97, 23);
		
		contentPane.add(chckbxHomegarden);
		chckbxSports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_chckbxSports_actionPerformed(arg0);
			}
		});
		chckbxSports.setBounds(250, 229, 97, 23);
		
		contentPane.add(chckbxSports);
		chckbxAutomotive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_chckbxAutomotive_actionPerformed(arg0);
			}
		});
		chckbxAutomotive.setBounds(250, 255, 97, 23);
		
		contentPane.add(chckbxAutomotive);
		chckbxOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_chckbxOther_actionPerformed(arg0);
			}
		});
		chckbxOther.setBounds(250, 281, 97, 23);
		
		contentPane.add(chckbxOther);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClose_actionPerformed(arg0);
			}
		});
		btnClose.setBounds(166, 379, 89, 23);
		
		contentPane.add(btnClose);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnOk_actionPerformed(arg0);
			}
		});
		btnOk.setBounds(166, 345, 89, 23);
		
		contentPane.add(btnOk);
	}
	//sets up arraylist of categories to be made if selected
	protected void makeCategories(){
			
		ArrayList<String> catSelected = new ArrayList<String>();

			if(chckbxElectronics.isSelected()){
				catSelected.add("Electronics");
			}
			if(chckbxComputers.isSelected()){
				catSelected.add("Computers");
			}
			if(chckbxClothing.isSelected()){
				catSelected.add("Clothing");
			}
			if(chckbxMusic.isSelected()){
				catSelected.add("Music");
			}
			if(chckbxBooks.isSelected()){
				catSelected.add("Books");
			}
			if(chckbxMovies.isSelected()){
				catSelected.add("Movies");
			}
			if(chckbxHomegarden.isSelected()){
				catSelected.add("HomeGarden");
			}
			if(chckbxSports.isSelected()){
				catSelected.add("Sports");
			}
			if(chckbxAutomotive.isSelected()){
				catSelected.add("Automotive");
			}
			if(chckbxOther.isSelected()){
				catSelected.add("Other");
			}
			byCategory.setCategory(catSelected);
			System.out.println(catSelected);
		}
	//if selected adds to arraylist
	protected void do_chckbxElectronics_actionPerformed(ActionEvent arg0) {
		makeCategories();
	}
	protected void do_chckbxComputers_actionPerformed(ActionEvent arg0) {
		makeCategories();
	}
	protected void do_chckbxClothing_actionPerformed(ActionEvent arg0) {
		makeCategories();
	}
	
	protected void do_chckbxMusic_actionPerformed(ActionEvent arg0) {
		makeCategories();
	}
	protected void do_chckbxBooks_actionPerformed(ActionEvent arg0) {
		makeCategories();
	}
	protected void do_chckbxMovies_actionPerformed(ActionEvent arg0) {
		makeCategories();
	}
	protected void do_chckbxHomegarden_actionPerformed(ActionEvent arg0) {
		makeCategories();
	}
	protected void do_chckbxSports_actionPerformed(ActionEvent arg0) {
		makeCategories();
	}
	protected void do_chckbxAutomotive_actionPerformed(ActionEvent arg0) {
		makeCategories();
	}
	protected void do_chckbxOther_actionPerformed(ActionEvent arg0) {
		makeCategories();
	}
	//shares arraylist closes window
	protected void do_btnOk_actionPerformed(ActionEvent arg0) {
		//byCategory.setCategory(catSelected);
		this.dispose();
	}
	//closes window
	protected void do_btnClose_actionPerformed(ActionEvent arg0) {
		ArrayList<String> cancel = new ArrayList<String>();
		byCategory.setCategory(cancel);
		this.dispose();
	}
}
