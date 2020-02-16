package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * @author Sarah Heckman
 *
 * Unit tests for CoffeeMaker class.
 */
public class CoffeeMakerTest {
	
	private CoffeeMaker cm;
	private Inventory inventory;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;
	private Recipe r5;
	private int negative;
	private int defaultQuantity;

	@BeforeEach
	protected void setUp() throws Exception {
		cm = new CoffeeMaker();
		inventory = new Inventory();
		negative = -1;
		defaultQuantity = 15;

		
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

		//Set up for r5
		r5 = new Recipe();
		r5.setName("Hello");
		r5.setAmtChocolate("5");
		r5.setAmtCoffee("1");
		r4.setAmtMilk("2");
		r4.setAmtSugar("3");
		r5.setPrice("1000");
	}

	@Test
	public void testAddRecipe_shouldReturnTrue() {
		assertTrue(cm.addRecipe(r1));
	}

	//TODO maybe we don't actually need this since recipe book takes care of this?
	@Test
	public void testAddRecipe_correctRecipeAdded() {
		cm.addRecipe(r1);
		Recipe[] recipes = cm.getRecipes();

		assertEquals(r1.toString(), recipes[0].toString());
	}

	@Test
	public void testAddRecipe_shouldReturnFalse() {
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);

		assertFalse(cm.addRecipe(r5));
	}

	@Test
	public void testDeleteRecipe_recipeExists_shouldReturnName(){
		cm.addRecipe(r1);

		assertEquals(r1.getName(), cm.deleteRecipe(0));
	}

	@Test
	public void testDeleteRecipe_shouldReturnNull(){
		cm.addRecipe(r1);

		assertNull(cm.deleteRecipe(2));
	}

	@Test
	public void testEditRecipe_shouldReturnName(){
		cm.addRecipe(r1);

		assertEquals(r1.getName(), cm.editRecipe(0, r2));
	}

	@Test
	public void testEditRecipe_shouldReturnNull(){
		cm.addRecipe(r1);
		assertNull(cm.editRecipe(2, r3));
	}

	@Test
	public void testAddInventory_actuallyAdded() throws InventoryException {
		cm.addInventory("4","7","0","9");

		assertEquals(defaultQuantity + 4, inventory.getCoffee());
		assertEquals(defaultQuantity + 7, inventory.getMilk());
		assertEquals(defaultQuantity + 0, inventory.getSugar());
		assertEquals(defaultQuantity + 9, inventory.getChocolate());
	}

	@Test
	public void testAddInventory_shouldThrowException() {
		assertThrows(InventoryException.class, () -> {
			cm.addInventory("4", "-1", "asdf", "3");});
	}

	@Test
	public void testAddInventory_shouldNotThrowException() throws InventoryException {
		Boolean exceptionThrown = false;
		try{
			cm.addInventory("1", "2", "3", "4");
		} catch (InventoryException e) {
			exceptionThrown = true;
		}
		assertFalse(exceptionThrown, "failure - exception was thrown.");
	}

	@Test
	public void testAddInventory_shouldReturnTrue() throws InventoryException {

		//assertTrue(cm.addInventory("4","3","4","8"));
	}

	@Test
	public void testAddInventory_shouldReturnFalse() throws InventoryException {

		//assertFalse(cm.addInventory("-1","3","4","8"));
	}

	@Test
	public void testCheckInventory(){
		inventory.setSugar(10);
		inventory.setMilk(10);
		inventory.setChocolate(10);
		inventory.setCoffee(10);
		assertEquals("Coffee: 10\nMilk: 10\nSugar: 10\nChocolate: 10\n", cm.checkInventory());
	}

	@Test
	public void testMakeCoffee_enoughPaid() {
		cm.addRecipe(r1);
		assertEquals(25, cm.makeCoffee(0, 75));
	}

	@Test
	public void testMakeCoffee_notEnoughPaid() {
		cm.addRecipe(r1);
		assertEquals(25, cm.makeCoffee(0, 25));
	}

	@Test
	public void testMakeCoffee_noRecipeAtIndex() {
		cm.addRecipe(r1);
		assertEquals(75, cm.makeCoffee(1, 75));
	}

	@Test
	public void testMakeCoffee_notEnoughInventory() {
		inventory.setCoffee(2);
		cm.addRecipe(r1);
		assertEquals(75, cm.makeCoffee(0, 75));
	}

	@Test
	public void testMakeCoffee_negativeInput() {
		cm.addRecipe(r2);
		assertEquals(negative, cm.makeCoffee(0, negative));
	}

	//Additional test added after exploratory testing
	@Test
	public void testMakeCoffee_negativeIndex(){

		assertEquals(-1, cm.makeCoffee(-1, 100));
	}
}
