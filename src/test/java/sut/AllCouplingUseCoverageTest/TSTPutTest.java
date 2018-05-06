<<<<<<< HEAD
package AllCouplingUseCoverageTest;
=======
package sut.AllCouplingUseCoverageTest;
>>>>>>> 5f1a1540358110c51718899b65ca962d50a09e69

import org.junit.Before;
import org.junit.Test;

import sut.TST;

import static org.junit.Assert.*;

public class TSTPutTest {
	
	 private TST<Integer> tree;

	 @Before
	 public void setUp() {
		 tree = new TST<>();
	 }
	/**
	* Test paths:
	* c -> last-def {0}, first-use {1}
	* d -> last-def {0} first-use {0}
	* key -> last-def {0} first-use {0}
	*/
>>>>>>> 5f1a1540358110c51718899b65ca962d50a09e69
	 @Test
	 public void testWithUpdateValue(){
		 String input = "b";
		 Integer val = 5;
		 tree.put(input,val);
		 assertEquals("Object should update value",val,tree.get(input));
	 }

	 /**
	 * Test paths
	 * val -> last-def {0}, first-use {3}
	 * x -> last-def {(3,5,8)}, first-use {(3,5,8)}
	 */
	 @Test
	 public void testWithValOnTheLeft(){
>>>>>>> 5f1a1540358110c51718899b65ca962d50a09e69
		 String input = "b";
		 Integer val = 5;
		 tree.put("c", val); //insert root
		 tree.put(input, val - 1); //insert left
		 assertEquals(new Integer(val - 1),tree.get(input)); //verify the value is there
		 tree.put(input,val); //change the value
		 assertEquals("Object should return expected value",val,tree.get(input));
	 }
}