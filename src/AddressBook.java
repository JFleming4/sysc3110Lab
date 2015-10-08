import java.util.ArrayList;
import java.util.List;


public class AddressBook {
	private List<BuddyInfo> friends;
	
	public AddressBook() {
		friends = new ArrayList<BuddyInfo>();
	}
	
	public void removeBuddy(int i) {
		if ( i <= friends.size() ) {
			friends.remove(i);
		}
	}
	
	public void addBuddy(BuddyInfo b) {
		friends.add(b);
	}
	
	public static void main(String args[]) {
		System.out.println("Om Nom Nom");
		BuddyInfo pie = new BuddyInfo();
		pie.setName("Fred Fred Burger");
		AddressBook book = new AddressBook();
		book.addBuddy(pie);
		book.removeBuddy(0);
	}
}
