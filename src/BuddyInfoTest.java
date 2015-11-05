import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BuddyInfoTest {
	private BuddyInfo above18;
	private BuddyInfo below18;
	@Before
	public void setUp() throws Exception {
		above18 = new BuddyInfo(1234,"Fred", "pie st");
		below18 = new BuddyInfo(4321,"Bob", "cake st");
		above18.setAge(20);
		below18.setAge(14);
	}

	@Test
	public void testBuddyInfo() {
		BuddyInfo pie = new BuddyInfo();
		assertNotEquals(null, pie);
	}
	
	@Test
	public void testBuddyInfoIntStringString() {
		BuddyInfo pie = new BuddyInfo(1,"a","b");
		assertEquals(1,pie.getNumber());
		assertEquals("a", pie.getName());
		assertEquals("b", pie.getAddress());
	}
	
	@Test
	public void testBuddyInfoBuddyInfo(){
		BuddyInfo pie = new BuddyInfo(above18);
		assertTrue(above18.equals(pie));
	}
	
	@Test
	public void testGetNumber() {
		assertEquals(1234, above18.getNumber());
		assertNotEquals(3214, above18.getNumber());
		assertEquals(4321, below18.getNumber());
	}

	@Test
	public void testSetNumber() {
		above18.setNumber(9876);
		assertEquals(9876, above18.getNumber());
		assertNotEquals(1234, above18.getNumber());
	}

	@Test
	public void testGetName() {
		assertEquals("Fred",above18.getName());
		assertEquals("Bob",below18.getName());
	}

	@Test
	public void testSetName() {
		below18.setName("George");
		assertEquals("George",below18.getName());
		assertNotEquals("Bob", below18.getName());
	}

	@Test
	public void testGetAddress() {
		assertEquals("pie st", above18.getAddress());
		assertEquals("cake st", below18.getAddress());
	}

	@Test
	public void testSetAddress() {
		above18.setAddress("blah");
		assertEquals("blah",above18.getAddress());
		assertNotEquals("pie st", above18.getAddress());
		assertNotEquals(null, above18.getAddress());
	}

	@Test
	public void testToString() {
		assertEquals("Fred",above18.getName());
		assertEquals("Bob", below18.getName());
	}

	@Test
	public void testGetAge() {
		assertEquals(20, above18.getAge());
		assertEquals(14, below18.getAge());
	}

	@Test
	public void testSetAge() {
		below18.setAge(100);
		assertEquals(100,  below18.getAge());
		assertNotEquals(14, below18.getAge());
	}
	
	@Test
	public void testEquals() {
		assertTrue(above18.equals(above18));
		assertFalse(above18.equals(below18));
		assertFalse(above18.equals(null));
	}
	
	@Test
	public void testIsOver18() {
		assertTrue(above18.isOver18());
		above18.setAge(18);
		assertTrue(above18.isOver18());
		assertFalse(below18.isOver18());
	}
	@Test
	public void testGreeting() {
		assertEquals("I Hate you Bob", below18.greeting());
		assertEquals("I Hate you Fred", above18.greeting());
	}

}
