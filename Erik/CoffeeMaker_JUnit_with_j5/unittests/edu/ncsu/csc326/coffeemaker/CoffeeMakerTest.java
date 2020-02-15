package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
//import junit.framework.TestCase;
//import org.junit.Test;
import org.junit.jupiter.api.*;


//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.TestInstance;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

/**
 * 
 * @author Sarah Heckman
 *
 * Unit tests for CoffeeMaker class.
 */
public class CoffeeMakerTest {
	
	private CoffeeMaker cm;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;
	private Recipe r5;
	private int negative = -1;

	@BeforeEach
	protected void setUp() throws Exception {
		cm = new CoffeeMaker();
		
		//Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");
		
		//Set up for r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("20");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");
		
		//Set up for r3
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setAmtChocolate("0");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("3");
		r3.setAmtSugar("1");
		r3.setPrice("100");
		
		//Set up for r4
		r4 = new Recipe();
		r4.setName("Hot Chocolate");
		r4.setAmtChocolate("4");
		r4.setAmtCoffee("0");
		r4.setAmtMilk("1");
		r4.setAmtSugar("1");
		r4.setPrice("65");

		r5 = new Recipe();
		r5.setName("Hello");
		r5.setAmtCoffee("1");
		r5.setPrice("1000");

		
		//super.setUp();
	}
	@Test
	public void testAddInventory() {
		try {
			cm.addInventory("4","7","0","9");
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
	}
	@Test
	public void testAddInventoryException() {
		try {
			cm.addInventory("4", "-1", "asdf", "3");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			//success if thrown
		}
	}


/*
	public void testMakeCoffee() {
		cm.addRecipe(r1);
		assertEquals(25, cm.makeCoffee(0, 75));
	}
	*/

	@Test
	public void makeCoffeeNegativeInput() {
		cm.addRecipe(r2);
		assertEquals(negative, cm.makeCoffee(0, negative));
	}
	@Test
	public void makeCoffeePositive() {
		cm.addRecipe(r3);
		assertEquals(0, cm.makeCoffee(0, 100));
	}

	@Test
	public void makeCoffeeLess() {
		cm.addRecipe(r2);
		assertEquals(30, cm.makeCoffee(0, 30));
	}


	@Test
	public void makeCoffeNull() {
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		assertEquals(100, cm.makeCoffee(3, 100));
	}

	@Test
	public void testAddRecipe() {
		cm.addRecipe(r1);
		Recipe[] recipes = cm.getRecipes();

		assertEquals(recipes[0].toString(), r1.toString());
	}

	@Test
	public void testAddRecipeTrue() {


		assertTrue(cm.addRecipe(r1));
	}
	@Test
	public void testAddRecipeFalse() {
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		assertFalse(cm.addRecipe(r5));
	}
	@Test
	public void testDeleteRecipe() {
		cm.addRecipe(r1);
		assertEquals(cm.deleteRecipe(0), r1.getName());
	}
	@Test
	public void testDeleteRecipeNull() {
		assertEquals( null, cm.deleteRecipe(0));
	}

	@Test
	public void testEditRecipe() throws Exception {
		cm.addRecipe(r1);
		Recipe r10 = new Recipe();
		r10.setName("???");
		r10.setPrice("10");
		r10.setAmtCoffee("1");
		cm.editRecipe(0, r10);
	}

	@Test
	public void testReturnInventory() throws Exception {
		cm.addInventory("10", "10", "0", "0");
		assertEquals("Coffee: 25\nMilk: 25\nSugar: 15\nChocolate: 15\n", cm.checkInventory());
	}



	/*
	@Test
	public void testAddInventory() {
		cm.addInventory("20", "20", "20", "20");
	}

*/




/*

	@Test
	public void testMakeCoffeeNegativePaid() {
		cm.addRecipe(r1);
		assertEquals(25, cm.makeCoffee(0, 75));
	}
	*/


}
