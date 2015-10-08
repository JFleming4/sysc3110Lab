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
	
	public void addBuddy(BuddyInfo b) {
		friends.add(b);
	}
	
	public ArrayList<BuddyInfo> getFriends() {
		return friends;
	}
	
	public BuddyInfo getFriends(int i) {
		return friends.get(i);
	}
	
	public void setFriends(ArrayList<BuddyInfo> list) {
		friends = list;
	}
	
	public void setFriends(int i, BuddyInfo bi) {
		friends.set(i, bi);
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i<friends.size(); i++) {
			s+= "Name: " + friends.get(i).getName() + 
					" Number: "+ friends.get(i).getNumber() +
					" Address: "+ friends.get(i).getAddress()+"\n";
		}
		return s;
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
