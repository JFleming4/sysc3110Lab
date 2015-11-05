//
public class BuddyInfo {
	private int number;
	private int age;
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
	
	public BuddyInfo (BuddyInfo b) {
		number = b.number;
		name = b.name;
		address = b.address;
		age = b.age;
	}
	
	public static void main(String []args){
		BuddyInfo pie = new BuddyInfo();
		pie.setName("Fred Fred Burger");
		System.out.println("Hello "+ pie.getName());
	}
	
	public boolean isOver18() {
		return age >= 18;
	}
	
	public String greeting() {
		return "I Hate you " + name;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean equals(Object o){
		if(o == null) return false;
		if(o == this) return true;
		if(o instanceof BuddyInfo) {
			BuddyInfo b = (BuddyInfo) o;
			if(b.address.equals(this.address) && b.age == this.age && b.name.equals(this.name) && b.number == this.number)
				return true;
		}
		return false;
	}
}
