package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InventoryTest {

    private Inventory inventory;
    private Recipe r1;

    private int normalQuantity;
    private int negativeQuantity;
    private int extremeQuantity;
    private int defaultQuantity;
    private String strNormalQuantity;
    private String strNegativeQuantity;
    private String strExtremeQuantity;
    private String nonNumerical;

    @BeforeAll
    public void setUpAll(){
        normalQuantity = 10;
        negativeQuantity = -1;
        extremeQuantity = 99999;
        defaultQuantity = 15;
        strNormalQuantity = "10";
        strNegativeQuantity = "-1";
        strExtremeQuantity = "99999";
        nonNumerical = "hello";
    }


    @BeforeEach
    public void setUp() throws Exception {
        inventory = new Inventory();

        //Set up for r1
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtCoffee("4");
        r1.setAmtMilk("3");
        r1.setAmtSugar("2");
        r1.setAmtChocolate("1");
        r1.setPrice("50");
    }

    @AfterEach
    public void tearDown() {
        inventory = null;
    }

    @Test
    public void testGetChocolate(){
        assertEquals(defaultQuantity, inventory.getChocolate());
    }

    @Test
    public void testSetChocolate_normalNumber() {
        inventory.setChocolate(normalQuantity);
        assertEquals("failure - chocolate not set to the correct value", normalQuantity, inventory.getChocolate());
    }

    @Test
    public void testSetChocolate_negativeNumber() {
        inventory.setChocolate(defaultQuantity);
        inventory.setChocolate(negativeQuantity);
        assertEquals(defaultQuantity, inventory.getChocolate());
    }

    @Test
    public void testSetChocolate_extremeNumber() {
        inventory.setChocolate(extremeQuantity);
        assertEquals(extremeQuantity, inventory.getChocolate());
    }

    @Test
    public void testSetChocolate_zero(){
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
    public void testGetCoffee(){
        inventory.setCoffee(normalQuantity);
        assertEquals(normalQuantity, inventory.getCoffee());
    }

    @Test
    public void testSetCoffee_normalNumber() {
        inventory.setCoffee(normalQuantity);
        assertEquals(normalQuantity, inventory.getCoffee());
    }

    @Test
    public void testSetCoffee_negativeNumber() {
        inventory.setCoffee(defaultQuantity);
        inventory.setCoffee(negativeQuantity);
        assertEquals(defaultQuantity, inventory.getCoffee());
    }

    @Test
    public void testSetCoffee_extremeNumber() {
        inventory.setCoffee(extremeQuantity);
        assertEquals(extremeQuantity, inventory.getCoffee());
    }

    @Test
    public void testSetCoffee_zero(){
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
    public void testGetMilk(){
        inventory.setMilk(normalQuantity);
        assertEquals(normalQuantity, inventory.getMilk());
    }

    @Test
    public void testSetMilk_normalNumber() {
        inventory.setMilk(normalQuantity);
        assertEquals("failure - milk not set to the correct value", normalQuantity, inventory.getMilk());
    }

    @Test
    public void testSetMilk_negativeNumber() {
        inventory.setMilk(defaultQuantity);
        inventory.setMilk(negativeQuantity);
        assertEquals(defaultQuantity, inventory.getMilk());
    }

    @Test
    public void testSetMilk_extremeNumber() {
        inventory.setMilk(extremeQuantity);
        assertEquals(extremeQuantity, inventory.getMilk());
    }

    @Test
    public void testSetMilk_zero(){
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
    public void testGetSugar(){
        inventory.setSugar(normalQuantity);
        assertEquals(normalQuantity, inventory.getSugar());
    }

    @Test
    public void testSetSugar_normalNumber() {
        inventory.setSugar(normalQuantity);
        assertEquals("failure - sugar not set to the correct value", normalQuantity, inventory.getSugar());
    }

    @Test
    public void testSetSugar_negativeNumber() {
        inventory.setSugar(defaultQuantity);
        inventory.setSugar(negativeQuantity);
        assertEquals(defaultQuantity, inventory.getSugar());
    }

    @Test
    public void testSetSugar_extremeNumber() {
        inventory.setSugar(extremeQuantity);
        assertEquals(extremeQuantity, inventory.getSugar());
    }

    @Test
    public void testSetSugar_zero(){
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
    public void testEnoughIngredients_true() {
        boolean result;

        inventory.setCoffee(15);
        inventory.setMilk(15);
        inventory.setSugar(15);
        inventory.setChocolate(15);

        result = inventory.enoughIngredients(r1);

        assertTrue("failure - should be true", result);
    }

    @Test
    public void testEnoughIngredients_coffee_false() {
        boolean result;

        inventory.setCoffee(3);
        inventory.setMilk(15);
        inventory.setSugar(15);
        inventory.setChocolate(15);

        result = inventory.enoughIngredients(r1);

        assertFalse("failure - should be false", result);
    }

    @Test
    public void testEnoughIngredients_milk_false() {
        boolean result;

        inventory.setCoffee(15);
        inventory.setMilk(2);
        inventory.setSugar(15);
        inventory.setChocolate(15);

        result = inventory.enoughIngredients(r1);

        assertFalse("failure - should be false", result);
    }

    @Test
    public void testEnoughIngredients_sugar_false() {
        boolean result;

        inventory.setCoffee(15);
        inventory.setMilk(15);
        inventory.setSugar(1);
        inventory.setChocolate(15);

        result = inventory.enoughIngredients(r1);

        assertFalse("failure - should be false", result);
    }

    @Test
    public void testEnoughIngredients_chocolate_false() {
        boolean result;

        inventory.setCoffee(15);
        inventory.setMilk(15);
        inventory.setSugar(15);
        inventory.setChocolate(0);

        result = inventory.enoughIngredients(r1);

        assertFalse("failure - should be false", result);
    }

    @Test
    public void testUseIngredients_true() {

        inventory.setCoffee(15);
        inventory.setMilk(15);
        inventory.setSugar(15);
        inventory.setChocolate(15);

        assertTrue("failure - should return true", inventory.useIngredients(r1));
    }

    @Test
    public void testUseIngredients_false() {

        inventory.setCoffee(15);
        inventory.setMilk(15);
        inventory.setSugar(15);
        inventory.setChocolate(0);

        assertFalse("failure - should return false", inventory.useIngredients(r1));
    }

    @Test
    public void testUseIngredients_coffeeAmt(){
        inventory.setCoffee(defaultQuantity);
        inventory.setMilk(defaultQuantity);
        inventory.setSugar(defaultQuantity);
        inventory.setChocolate(defaultQuantity);

        inventory.useIngredients(r1);

        assertEquals("failure - incorrect coffee amount deducted", defaultQuantity - r1.getAmtCoffee(), inventory.getCoffee());
    }

    @Test
    public void testUseIngredients_milkAmt(){
        inventory.setCoffee(defaultQuantity);
        inventory.setMilk(defaultQuantity);
        inventory.setSugar(defaultQuantity);
        inventory.setChocolate(defaultQuantity);

        inventory.useIngredients(r1);

        assertEquals("failure - incorrect milk amount deducted", defaultQuantity - r1.getAmtMilk(), inventory.getMilk());
    }

    @Test
    public void testUseIngredients_sugarAmt(){
        inventory.setCoffee(defaultQuantity);
        inventory.setMilk(defaultQuantity);
        inventory.setSugar(defaultQuantity);
        inventory.setChocolate(defaultQuantity);

        inventory.useIngredients(r1);

        assertEquals("failure - incorrect sugar amount deducted", defaultQuantity - r1.getAmtSugar(), inventory.getSugar());
    }

    @Test
    public void testUseIngredients_chocolateAmt(){
        inventory.setCoffee(defaultQuantity);
        inventory.setMilk(defaultQuantity);
        inventory.setSugar(defaultQuantity);
        inventory.setChocolate(defaultQuantity);

        inventory.useIngredients(r1);

        assertEquals("failure - incorrect chocolate amount deducted", defaultQuantity - r1.getAmtChocolate(), inventory.getChocolate());
    }

    @Test
    public void testToString(){
        inventory.setCoffee(10);
        inventory.setMilk(9);
        inventory.setSugar(8);
        inventory.setChocolate(7);

        String testString = inventory.toString();
        assertEquals(testString, "Coffee: 10\nMilk: 9\nSugar: 8\nChocolate: 7\n");
    }

}
