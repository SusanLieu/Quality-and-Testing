package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {

    private Inventory inventory;
    private static int coffee;
    private static int milk;
    private static int sugar;
    private static int chocolate;

    private int normalQuantity = 10;
    private int negativeQuantity = -1;
    private int extremeQuantity = 99999;
    private String strNormalQuantity = "10";
    private String strNegativeQuantity = "-1";
    private String strExtremeQuantity = "99999";


    @Before
    public void setUp() throws Exception {
        inventory = new Inventory();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetChocolate() {

    }

    @Test
    public void setChocolate_normalNumber() {
        inventory.setChocolate(normalQuantity);
        assertEquals(inventory.getChocolate(), normalQuantity);
    }

    @Test
    public void setChocolate_negativeNumber() {
        inventory.setChocolate(0);
        inventory.setChocolate(negativeQuantity);
        assertEquals(inventory.getChocolate(), 0);
    }

    @Test
    public void setChocolate_extremeNumber() {
        inventory.setChocolate(extremeQuantity);
        assertEquals(inventory.getChocolate(), 99999);
    }

    @Test
    public void testAddChocolate_normalNumber() throws InventoryException {
        inventory.setChocolate(0);
        inventory.addChocolate(strNormalQuantity);

        assertEquals(inventory.getChocolate(), normalQuantity);
    }

    @Test
    public void testAddChocolate_negativeNumber_() throws InventoryException {
        inventory.setChocolate(0);
        inventory.addChocolate(strNegativeQuantity);

        //Throw some exception?

        assertEquals(inventory.getChocolate(), 0);
    }

    @Test
    public void testAddChocolate_extremeNumber() throws InventoryException {
        inventory.setChocolate(0);
        inventory.addChocolate(strExtremeQuantity);

        assertEquals(inventory.getChocolate(), extremeQuantity);
    }

    @Test
    public void getCoffee() {
    }

    @Test
    public void setCoffee() {
    }

    @Test
    public void addCoffee() {
    }

    @Test
    public void getMilk() {
    }

    @Test
    public void setMilk() {
    }

    @Test
    public void addMilk() {
    }

    @Test
    public void getSugar() {
    }

    @Test
    public void setSugar() {
    }

    @Test
    public void addSugar() {
    }

    @Test
    public void enoughIngredients() {
    }

    @Test
    public void useIngredients() {
    }
}
