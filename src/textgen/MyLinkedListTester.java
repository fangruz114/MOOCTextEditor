/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
	
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		// test empty list & upper bound
		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
        
		// test longer list content
		int b = longerList.remove(9);
		assertEquals("Remove: check b is correct", 9, b);
		assertEquals("Remove: check element 8 is correct", (Integer)8, longerList.get(8));
		assertEquals("Remove: check size is correct", 9, longerList.size());
		
		// test lower bounds on remove
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		list1.add((Integer)55);
		assertEquals("AddEnd: check element 1 is correct", (Integer)42, list1.get(2));
		assertEquals("AddEnd: check added element 2 is correct", (Integer)55, list1.get(3));
		assertEquals("AddEnd: check size is correct", 4, list1.size());
		
		//test lower bounds on add
		try {
			shortList.add(null);
			fail("null element");
		}
		catch (NullPointerException e) {
			
		}
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		list1.add((Integer)88);
		list1.remove(2);
		list1.add(2,(Integer)10);
		assertEquals("Size: check size is correct", 4, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		list1.add((Integer)1, 86);
		assertEquals("AddIndex: check element 1 is correct", (Integer)86, list1.get(1));
		assertEquals("AddIndex: check element 0 is correct", (Integer)65, list1.get(0));
		assertEquals("AddIndex: check element 2 is correct", (Integer)21, list1.get(2));
		assertEquals("AddIndex: check size is correct", 4, list1.size());
		
		//test upper bound
		try {
			longerList.add((Integer)15, 15);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		//test lower bounds
		try {
			longerList.add(-1, 11);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		//test null element
		try {
			longerList.add(5, null);
			fail("null element");
		}
		catch (NullPointerException e) {
			
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
	    longerList.set(2, 45);
	    assertEquals("Set: check element 2 is correct", (Integer)45, longerList.get(2));
	    assertEquals("Set: check element 1 is correct", (Integer)1, longerList.get(1));
	    assertEquals("Set: check element 3 is correct", (Integer)3, longerList.get(3));
	    assertEquals("Set: check size is correct", 10, longerList.size());
	    
	    // test upper bounds set
	    try {
	    	list1.set(5, 0);
	    	fail("Check out of bounds");
	    }
	    catch (IndexOutOfBoundsException e) {
	    }
	    
	    // test lower bounds
	    try {
	    	list1.set(-1, 0);
	    	fail("Check out of bounds");
	    }
	    catch (IndexOutOfBoundsException e) {
	    }
	    
	    // test null element
	    try {
	    	list1.set(1, null);
	    	fail("null element");
	    }
	    catch (NullPointerException e) {
	    }
	}
	
	
	// TODO: Optionally add more test methods.
	
}
