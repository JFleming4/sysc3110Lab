import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//
public class MainWindow extends JFrame {
	public static final String save 	= "save";
	public static final String bSave	= "bSave";
	public static final String add 		= "Add";
	public static final String remove 	= "Remove";
	
	private JSplitPane 					splitpane;
	private JList<BuddyInfo> 			buddyList;
	private DefaultListModel<BuddyInfo> buddyListModel;
	private JPanel 						leftPanel;
	private JPanel 						rightPanel;
	private JPanel leftButtons;
	private JButton addressSave;
	private JButton buddyAdd;
	private JButton buddyRemove;
	private JButton buddySave;
	private JLabel nameLabel;
	private JLabel numberLabel;
	private JLabel addressLabel;
	private JTextField nameField;
	private JTextField numberField;
	private JTextField addressField;
	private MainWindowEventListener listener;
	
	public MainWindow() {
		buddyListModel 	 = new DefaultListModel<BuddyInfo>();
		buddyList 	 	 = new JList<BuddyInfo>(buddyListModel);
		
		leftPanel 		 = new JPanel(new BorderLayout());
		rightPanel 		 = new JPanel(new GridLayout(7,3));
		leftButtons 	 = new JPanel(new GridLayout(1,5));
		
		addressSave		 = new JButton("Save");
		buddySave		 = new JButton("Save");
		buddyAdd		 = new JButton("+");
		buddyRemove		 = new JButton("-");
		
		nameLabel		 = new JLabel("Name: ");
		numberLabel 	 = new JLabel("Number: ");
		addressLabel     = new JLabel("Address: ");
		
		nameField 		 = new JTextField(90);
		numberField  	 = new JTextField(90);
		addressField	 = new JTextField(90);
		
		listener		 = new MainWindowEventListener(this);
		
		addressSave.setActionCommand(save);
		buddyAdd.setActionCommand(add);
		buddyRemove.setActionCommand(remove);
		buddySave.setActionCommand(bSave);

		buddyAdd.addActionListener(listener);
		buddyRemove.addActionListener(listener);
		buddySave.addActionListener(listener);
		addressSave.addActionListener(listener);
		
		leftButtons.add(buddyAdd);
		leftButtons.add(new JLabel());
		leftButtons.add(addressSave);
		leftButtons.add(new JLabel());
		leftButtons.add(buddyRemove);
		
		buddyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addListListener();
		
		leftPanel.add(buddyList, BorderLayout.CENTER);
		leftPanel.add(leftButtons, BorderLayout.SOUTH);
		
		rightPanel.add(nameLabel);
		rightPanel.add(new JLabel());
		rightPanel.add(nameField);
		
		rightPanel.add(new JPanel());
		rightPanel.add(new JPanel());
		rightPanel.add(new JPanel());
		
		rightPanel.add(numberLabel);
		rightPanel.add(new JLabel());
		rightPanel.add(numberField);
		
		rightPanel.add(new JPanel());
		rightPanel.add(new JPanel());
		rightPanel.add(new JPanel());
		
		rightPanel.add(addressLabel);
		rightPanel.add(new JLabel());
		rightPanel.add(addressField);
		
		
		rightPanel.add(new JPanel());
		rightPanel.add(new JPanel());
		rightPanel.add(new JPanel());
		
		rightPanel.add(new JPanel());
		rightPanel.add(buddySave);
		rightPanel.add(new JPanel());
		
		splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
		
		this.getContentPane().add(splitpane);
		this.setSize(800, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void addBuddy(BuddyInfo bi) {
		buddyListModel.addElement(bi);
		
	}
	
	public void removeBuddy() {
		int i = buddyList.getSelectedIndex();
		if((i >= 0) && (i < buddyListModel.getSize())){
			buddyListModel.removeElementAt(i);
		}
	}
	
	public void saveBuddy() {
		int i = buddyList.getSelectedIndex();
		buddyListModel.get(i).setAddress(addressField.getText());
		buddyListModel.get(i).setName(nameField.getText());
		String num = numberField.getText();
		try {
			buddyListModel.get(i).setNumber(new Integer(num));
		}catch(Exception e) {
			System.out.println("Not a Number");
		}
	}
	
	public void saveAddress() {
		AddressBook book = new AddressBook();
		for(int i = 0; i < buddyListModel.getSize(); i ++) {
			book.addBuddy(buddyListModel.getElementAt(i));
		}
		JFileChooser chooser = new JFileChooser();
		if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				//System.out.println(book);
				BufferedWriter writer = new BufferedWriter(new FileWriter(chooser.getSelectedFile()));
				writer.write(book.toString());
				writer.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
	}
	
	private void addListListener() {
		buddyList.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int i = buddyList.getSelectedIndex();
				if((i >= 0) && (i < buddyListModel.getSize())){
					BuddyInfo selected = buddyListModel.get(i);
					nameField.setText(selected.getName());
					numberField.setText("" + selected.getNumber());
					addressField.setText(selected.getAddress());
				}
			}
		});
	}
	
	public static void main(String args[]) {
		MainWindow main = new MainWindow();
	}
	
}
