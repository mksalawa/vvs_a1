package AllCouplingUseCoverageTest;

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
	 
	 //[0,1,2,4,6,8]
	 @Test
	 public void testWithUpdateValue(){
		 String input = "b";
		 Integer val = 5;
		 tree.put(input,val);
		 assertEquals("Object should update value",val,tree.get(input));
	 }
	 
	 
	 //DONE???
	 //	[0,2,3,0,2,4,6,8]
	 @Test
	 public void testWithValueOnLeft(){
		 String input = "b";
		 Integer val = 5;
		 tree.put("c", val); //insert root
		 tree.put(input, val - 1); //insert left
		 tree.put(input,val); //change the value
		 assertEquals("Object should update value",val,tree.get(input));
	 }
	 
	 //DOUBT: CAN THEY BE DONE LIKE THIS???
	 //[0,2,4,5,0,2,4,6,8]
	 @Test
	 public void testWithValueOnRight(){
		 String input = "d";
		 Integer val = 5;
		 tree.put("c", val); //insert root
		 tree.put(input, val - 1); //insert right
		 tree.put(input,val); // actual test
		 assertEquals("Object should update value",val,tree.get(input));
	 }
	
	 
	 //[0,2,4,6,7,0,2,4,6,8]
	 @Test
	 public void testWithNodeInTheMiddle(){
		 String input = "dd";
		 Integer val = 5;
		 tree.put(input, val); //insert root
		 tree.put(input, val); //insert middle
		 //tree.put(input, val - 1); //insert value to change
		 tree.put(input,val); // actual test
		 assertEquals("Object should update value",val,tree.get(input));
	 }
}
