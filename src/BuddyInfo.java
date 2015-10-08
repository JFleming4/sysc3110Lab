//
public class BuddyInfo {
	private int number;
	private String name;
	private String address;
	
	public BuddyInfo(){
		name = "";
		number = 0;
		address = "";
	}
	
	public BuddyInfo(int num, String na, String add) {
		number = num;
		name = na;
		address = add;
	}
	
	public static void main(String []args){
		BuddyInfo pie = new BuddyInfo();
		pie.setName("Fred Fred Burger");
		System.out.println("Hello "+ pie.getName());
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		if(name.equals("") || name == null) {
			return "BuddyInfo";
		}
		return name;
	}
}
