import java.util.ArrayList;
import java.util.List;

//
public class AddressBook {
	private ArrayList<BuddyInfo> friends;
	
	public AddressBook() {
		friends = new ArrayList<BuddyInfo>();
	}
	
	public void removeBuddy(int i) {
		if ( i <= friends.size() ) {
			friends.remove(i);
		}
	}
	
	public int size() {
		return friends.size();
	}
	
	public void clear() {
		friends.clear();
	}
	
	public void addBuddy(BuddyInfo b) {
		friends.add(b);
	}
}
