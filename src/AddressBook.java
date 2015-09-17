import java.util.ArrayList;
import java.util.List;


public class AddressBook {
	private List<BuddyInfo> friends;
	
	public AddressBook() {
		friends = new ArrayList<BuddyInfo>();
	}
	
	public void removeBuddy() {
		if (!friends.isEmpty()) {
			friends.remove(friends.size() -1);
		}
	}
	
	public void addBuddy(BuddyInfo b) {
		friends.add(b);
	}
	
	public static void main(String args[]) {
		System.out.println("Om Nom Nom");
	}
}
