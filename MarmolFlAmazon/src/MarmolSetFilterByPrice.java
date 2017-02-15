import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MarmolSetFilterByPrice extends JFrame {

	private JPanel contentPane;
	private final JLabel lblSetFilterByPrice = new JLabel("Set Filter By Price");
	private final JComboBox comparisonComboBox = new JComboBox();
	private final JFormattedTextField comparisonFTF = new JFormattedTextField();
	private final JRadioButton rdbtnSpecific = new JRadioButton("All items should be");
	private final JRadioButton rdbtnRange = new JRadioButton("All items should be in the range");
	private final JFormattedTextField range1FTF = new JFormattedTextField();
	private final JFormattedTextField range2FTF = new JFormattedTextField();
	private final JLabel lblTo = new JLabel("to");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JLabel lblpleaseChoose = new JLabel("*Please choose 1 option*");
	private final JButton btnClose = new JButton("Close");
	private final JButton btnOk = new JButton("OK");
	//sets up data to be shared
	private ByPrice byPrice;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MarmolSetFilterByPrice(ByPrice item) {
		//sets up data tobe shared
		byPrice = item;
		comparisonComboBox.setToolTipText("Choose comparison");
		comparisonComboBox.setSelectedItem(item.getComparison());
		comparisonFTF.setToolTipText("Enter number");
		comparisonFTF.setText(item.getNum());
		range1FTF.setToolTipText("Enter range min");
		range1FTF.setText(item.getRange1());
		range2FTF.setToolTipText("Enter range max");
		range2FTF.setText(item.getRange2());
		jbInit();
	}
	private void jbInit() {
		setTitle("MarmolFlAmazon Set Filter By Price");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblSetFilterByPrice.setBounds(182, 41, 120, 14);
		
		contentPane.add(lblSetFilterByPrice);
		comparisonComboBox.setEnabled(false);
		comparisonComboBox.setModel(new DefaultComboBoxModel(new String[] {"=", "<", ">", "<=", ">="}));
		comparisonComboBox.setBounds(226, 90, 41, 20);
		
		contentPane.add(comparisonComboBox);
		comparisonFTF.setEditable(false);
		comparisonFTF.setBounds(277, 90, 76, 20);
		
		contentPane.add(comparisonFTF);
		buttonGroup.add(rdbtnSpecific);
		rdbtnSpecific.setToolTipText("Choose button of you want specific comparison");
		rdbtnSpecific.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_rdbtnSpecific_actionPerformed(arg0);
			}
		});
		
		
		rdbtnSpecific.setBounds(42, 89, 178, 23);
		
		contentPane.add(rdbtnSpecific);
		buttonGroup.add(rdbtnRange);
		rdbtnRange.setToolTipText("Choose button if you want range");
		rdbtnRange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_rdbtnRange_actionPerformed(arg0);
			}
		});
		rdbtnRange.setBounds(42, 132, 225, 23);
		
		contentPane.add(rdbtnRange);
		range1FTF.setEditable(false);
		range1FTF.setBounds(277, 133, 76, 20);
		
		contentPane.add(range1FTF);
		range2FTF.setEditable(false);
		range2FTF.setBounds(383, 133, 76, 20);
		
		contentPane.add(range2FTF);
		lblTo.setBounds(363, 136, 46, 14);
		
		contentPane.add(lblTo);
		lblpleaseChoose.setBounds(42, 65, 135, 14);
		
		contentPane.add(lblpleaseChoose);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClose_actionPerformed(arg0);
			}
		});
		btnClose.setBounds(281, 281, 89, 23);
		
		contentPane.add(btnClose);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnOk_actionPerformed(arg0);
			}
		});
		btnOk.setBounds(281, 247, 89, 23);
		
		contentPane.add(btnOk);
	}
	
	//if specific is slected options are available
	protected void do_rdbtnSpecific_actionPerformed(ActionEvent arg0) {
		if(rdbtnSpecific.isSelected())
		{
			comparisonComboBox.setEnabled(true);
			comparisonFTF.setEditable(true);
			range1FTF.setEditable(false);
			range2FTF.setEditable(false);
		}
	}
	//if range is sleceted options are available
	protected void do_rdbtnRange_actionPerformed(ActionEvent arg0) {
		if(rdbtnRange.isSelected())
		{
			comparisonComboBox.setEnabled(false);
			comparisonFTF.setEditable(false);
			range1FTF.setEditable(true);
			range2FTF.setEditable(true);
		}
	}
	//closes window
	protected void do_btnClose_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
	protected void do_btnOk_actionPerformed(ActionEvent arg0) {
		if(rdbtnSpecific.isSelected() == true)
		{
			byPrice.setComparison(comparisonComboBox.getSelectedItem());
			byPrice.setNum(comparisonFTF.getText());
		}
		if(rdbtnRange.isSelected() == true)
		{
			byPrice.setRange1(range1FTF.getText());
			byPrice.setRange2(range2FTF.getText());
		}
		this.dispose();
	}
}
