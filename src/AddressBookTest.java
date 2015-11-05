import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AddressBookTest {
	private AddressBook book1;
	private AddressBook book2;
	private BuddyInfo bud1;
	private BuddyInfo bud2;
	private BuddyInfo bud3;
	private BuddyInfo bud4;
	@Before
	public void setUp() throws Exception {
		book1 = new AddressBook();
		book2 = new AddressBook();
		bud1 = new BuddyInfo();
		bud2 = new BuddyInfo();
		bud3 = new BuddyInfo();
		bud4 = new BuddyInfo();
		
		book1.addBuddy(bud1);
		book1.addBuddy(bud3);
		
		book2.addBuddy(bud1);
		book2.addBuddy(bud2);
		book2.addBuddy(bud4);
	}

	@Test
	public void testAddressBook() {
		AddressBook b = new AddressBook();
		assertNotEquals(null, b);
	}

	@Test
	public void testRemoveBuddy() {
		book1.removeBuddy(0);
		assertEquals(1, book1.size());
		book1.removeBuddy(0);
		assertEquals(0,book1.size());
	}

	@Test
	public void testSize() {
		assertEquals(2, book1.size());
		assertEquals(3, book2.size());
	}

	@Test
	public void testClear() {
		book1.clear();
		book2.clear();
		assertEquals(0, book1.size());
		assertEquals(0, book2.size());
	}

	@Test
	public void testAddBuddy() {
		book1.addBuddy(new BuddyInfo());
		assertEquals(3, book1.size());
		book1.addBuddy(new BuddyInfo());
		assertEquals(4, book1.size());
	}

}
