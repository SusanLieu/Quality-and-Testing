package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InventoryTest {

    private Inventory inventory;
    private Recipe r1;

    private int normalQuantity = 10;
    private int negativeQuantity = -1;
    private int extremeQuantity = 99999;
    private int defaultQuantity = 15;
    private String strNormalQuantity = "10";
    private String strNegativeQuantity = "-1";
    private String strExtremeQuantity = "99999";
    private String nonNumerical = "hello";


    @BeforeAll
    public void setUp() throws Exception {
        inventory = new Inventory();

        //Set up for r1
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");

    }

    @AfterAll
    public void tearDown() {
        inventory = null;
    }

    @Test
    public void setChocolate_normalNumber() {
        inventory.setChocolate(normalQuantity);
        assertEquals("failure - chocolate not set to the correct value", normalQuantity, inventory.getChocolate());
    }

    @Test
    public void setChocolate_negativeNumber() {
        inventory.setChocolate(defaultQuantity);
        inventory.setChocolate(negativeQuantity);
        assertEquals(defaultQuantity, inventory.getChocolate());
    }

    @Test
    public void setChocolate_extremeNumber() {
        inventory.setChocolate(extremeQuantity);
        assertEquals(extremeQuantity, inventory.getChocolate());
    }

    @Test
    public void setChocolate_zero(){
        inventory.setChocolate(0);
        assertEquals(0, inventory.getChocolate());
    }

    @Test
    public void testAddChocolate_normalNumber() throws InventoryException {
        inventory.setChocolate(defaultQuantity);
        inventory.addChocolate(strNormalQuantity);

        assertEquals(normalQuantity + defaultQuantity, inventory.getChocolate());
    }

    @Test
    public void testAddChocolate_negativeNumber_shouldThrowException() {
        String expectedMessage = "Units of chocolate must be a positive integer";
        Throwable exception = assertThrows(InventoryException.class, () -> {inventory.addChocolate(strNegativeQuantity);});

        assertEquals("failure - InventoryException should be thrown", expectedMessage, exception.getMessage());
    }

    @Test
    public void testAddChocolate_extremeNumber() throws InventoryException {
        inventory.setChocolate(defaultQuantity);
        inventory.addChocolate(strExtremeQuantity);

        assertEquals(extremeQuantity + defaultQuantity, inventory.getChocolate());
    }

    @Test
    public void testAddChocolate_zero() throws InventoryException {
        inventory.setChocolate(defaultQuantity);
        inventory.addChocolate("0");

        assertEquals(defaultQuantity, inventory.getChocolate());
    }

    @Test
    public void testAddChocolate_nonNumerical_shouldThrowException() {
        String expectedMessage = "Units of chocolate must be a positive integer";
        Throwable exception = assertThrows(InventoryException.class, () -> {inventory.addChocolate(nonNumerical);});

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void setCoffee_normalNumber() {
        inventory.setCoffee(normalQuantity);
        assertEquals(normalQuantity, inventory.getCoffee());
    }

    @Test
    public void setCoffee_negativeNumber() {
        inventory.setCoffee(defaultQuantity);
        inventory.setCoffee(negativeQuantity);
        assertEquals(defaultQuantity, inventory.getCoffee());
    }

    @Test
    public void setCoffee_extremeNumber() {
        inventory.setCoffee(extremeQuantity);
        assertEquals(extremeQuantity, inventory.getCoffee());
    }

    @Test
    public void setCoffee_zero(){
        inventory.setCoffee(0);
        assertEquals(0, inventory.getCoffee());
    }

    @Test
    public void testAddCoffee_normalNumber() throws InventoryException {
        inventory.setCoffee(defaultQuantity);
        inventory.addCoffee(strNormalQuantity);
        assertEquals("failure - incorrect addition to coffee", normalQuantity + defaultQuantity, inventory.getCoffee());
    }

    @Test
    public void testAddCoffee_negativeNumber_shouldThrowException() {
        inventory.setCoffee(defaultQuantity);

        String expectedMessage = "Units of coffee must be a positive integer";
        Throwable exception = assertThrows(InventoryException.class, () -> {inventory.addCoffee(nonNumerical);});

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testAddCoffee_extremeNumber() throws InventoryException {
        inventory.setCoffee(defaultQuantity);
        inventory.addCoffee(strExtremeQuantity);

        assertEquals("failure - incorrect addition to coffee", extremeQuantity + defaultQuantity, inventory.getCoffee());
    }

    @Test
    public void testAddCoffee_zero() throws InventoryException {
        inventory.setCoffee(defaultQuantity);
        inventory.addCoffee("0");

        assertEquals("failure - incorrect addition to coffee", defaultQuantity, inventory.getCoffee());
    }

    @Test
    public void testAddCoffee_nonNumerical_shouldThrowException() {
        String expectedMessage = "Units of coffee must be a positive integer";
        Throwable exception = assertThrows(InventoryException.class, () -> {inventory.addCoffee(nonNumerical);});

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void setMilk_normalNumber() {
        inventory.setMilk(normalQuantity);
        assertEquals("failure - milk not set to the correct value", normalQuantity, inventory.getMilk());
    }

    @Test
    public void setMilk_negativeNumber() {
        inventory.setMilk(defaultQuantity);
        inventory.setMilk(negativeQuantity);
        assertEquals(defaultQuantity, inventory.getMilk());
    }

    @Test
    public void setMilk_extremeNumber() {
        inventory.setMilk(extremeQuantity);
        assertEquals(extremeQuantity, inventory.getMilk());
    }

    @Test
    public void setMilk_zero(){
        inventory.setMilk(0);
        assertEquals(0, inventory.getMilk());
    }

    @Test
    public void testAddMilk_normalNumber() throws InventoryException {
        inventory.setMilk(defaultQuantity);
        inventory.addMilk(strNormalQuantity);
        assertEquals("failure - incorrect addition to milk", normalQuantity + defaultQuantity, inventory.getMilk());
    }

    @Test
    public void testAddMilk_negativeNumber_shouldThrowException() {
        String expectedMessage = "Units of milk must be a positive integer";

        Throwable exception = assertThrows(InventoryException.class, () -> {inventory.addMilk(strNegativeQuantity);});
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testAddMilk_extremeNumber() throws InventoryException {
        inventory.setMilk(defaultQuantity);
        inventory.addMilk(strExtremeQuantity);

        assertEquals("failure - incorrect addition to milk", extremeQuantity + defaultQuantity, inventory.getMilk());
    }

    @Test
    public void testAddMilk_zero() throws InventoryException {
        inventory.setMilk(defaultQuantity);
        inventory.addMilk("0");

        assertEquals("failure - incorrect addition to milk", defaultQuantity, inventory.getMilk());
    }

    @Test
    public void testAddMilk_nonNumerical_shouldThrowException() {
        String expectedMessage = "Units of milk must be a positive integer";

        Throwable exception = assertThrows(InventoryException.class, () -> {inventory.addMilk(nonNumerical);});
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void setSugar_normalNumber() {
        inventory.setSugar(normalQuantity);
        assertEquals("failure - sugar not set to the correct value", normalQuantity, inventory.getSugar());
    }

    @Test
    public void setSugar_negativeNumber() {
        inventory.setSugar(defaultQuantity);
        inventory.setSugar(negativeQuantity);
        assertEquals(defaultQuantity, inventory.getSugar());
    }

    @Test
    public void setSugar_extremeNumber() {
        inventory.setSugar(extremeQuantity);
        assertEquals(extremeQuantity, inventory.getSugar());
    }

    @Test
    public void setSugar_zero(){
        inventory.setSugar(0);
        assertEquals(0, inventory.getSugar());
    }

    @Test
    public void testAddSugar_normalNumber() throws InventoryException {
        inventory.setSugar(defaultQuantity);
        inventory.addSugar(strNormalQuantity);

        assertEquals(normalQuantity + defaultQuantity, inventory.getSugar());
    }

    @Test
    public void testAddSugar_negativeNumber_shouldThrowException() {
        String expectedMessage = "Units of sugar must be a positive integer";
        Throwable exception = assertThrows(InventoryException.class, () -> {inventory.addSugar(strNegativeQuantity);});

        assertEquals("failure - InventoryException should be thrown", expectedMessage, exception.getMessage());

    }

    @Test
    public void testAddSugar_ExtremeNumber() throws InventoryException {
        inventory.setSugar(defaultQuantity);
        inventory.addSugar(strExtremeQuantity);

        assertEquals(extremeQuantity, inventory.getSugar());
    }

    @Test
    public void testAddSugar_zero() throws InventoryException {
        inventory.setSugar(defaultQuantity);
        inventory.addSugar("0");
        assertEquals(defaultQuantity, inventory.getSugar());
    }

    @Test
    public void testAddSugar_nonNumerical_shouldThrowException(){

        String expectedMessage = "Units of sugar must be a positive integer";
        Throwable exception = assertThrows(InventoryException.class, () -> {inventory.addSugar(strNegativeQuantity);});

        assertEquals("failure - InventoryException should be thrown", expectedMessage, exception.getMessage());
    }

    @Test
    public void enoughIngredients_shouldPass() {
        // boolean result
        inventory.setChocolate(15);
        inventory.setSugar(15);
        inventory.setMilk(15);
        inventory.setCoffee(15);
        //boolean answer = inventory.enoughIngredients(r1);
    }

    @Test
    public void enoughIngredients_shouldFail() {
        inventory.setSugar(0);
        inventory.setChocolate(15);
        inventory.setMilk(1);
        inventory.setCoffee(2);
        inventory.enoughIngredients(r1);
    }

    @Test
    public void useIngredients() {
    }
}
