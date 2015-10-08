import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

//
public class MainWindowEventListener implements ActionListener{
	private MainWindow main;
	public MainWindowEventListener (MainWindow main) {
		this.main = main;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case MainWindow.add:
			main.addBuddy(new BuddyInfo());
			break;
		case MainWindow.remove:
			main.removeBuddy();
			break;
		case MainWindow.save:
			main.saveAddress();
			break;
		case MainWindow.bSave:
			main.saveBuddy();
			break;
		}
		
	}

}
