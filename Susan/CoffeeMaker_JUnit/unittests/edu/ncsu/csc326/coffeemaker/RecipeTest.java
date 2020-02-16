package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RecipeTest {
    private Recipe recipe;

    private String normalQ;
    private String hugeQ;
    private String negativeQ;
    private String wordQ;
    private String zeroQ;
    private String normalName;
    private Recipe r1;
    private Recipe r2;

    @BeforeAll
    public void setUpAll() throws Exception {

        normalQ = "1";
        hugeQ = "99999999";
        negativeQ = "-1";
        wordQ = "Hello";
        zeroQ = "0";
        normalName = "Name";

        //Set up for r1
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");

        r2 = r1;
    }

    @BeforeEach
    public void setUp() {
        recipe = new Recipe();
    }

    @AfterEach
    public void tearDown() {
        recipe = null;
    }

    @Test
    public void testGetAmtChocolate() throws RecipeException {
        recipe.setAmtChocolate(normalQ);
        assertEquals(Integer.parseInt(normalQ), recipe.getAmtChocolate());
    }

    @Test
    public void testSetAmtChocolate_normalNumber() throws RecipeException {
        recipe.setAmtChocolate(normalQ);
        assertEquals(Integer.parseInt(normalQ), recipe.getAmtChocolate());
    }

    @Test
    public void testSetAmtChocolate_zero() throws RecipeException {
        recipe.setAmtChocolate(zeroQ);
        assertEquals(Integer.parseInt(zeroQ), recipe.getAmtChocolate());
    }

    @Test
    public void testSetAmtChocolate_nonNumerical(){
        String expectedMessage = "Units of chocolate must be a positive integer";
        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtChocolate(wordQ));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testSetAmtChocolate_largeValue() throws RecipeException {
        recipe.setAmtChocolate(hugeQ);
        assertEquals(Integer.parseInt(hugeQ), recipe.getAmtChocolate());
    }

    @Test
    public void testSetAmtChocolate_negativeNumber() {
        String expectedMessage = "Units of chocolate must be a positive integer";

        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtChocolate(negativeQ));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testGetAmtCoffee() throws RecipeException {
        recipe.setAmtCoffee(normalQ);
        assertEquals(Integer.parseInt(normalQ), recipe.getAmtCoffee());
    }

    @Test
    public void testSetAmtCoffee_normalNumber() throws RecipeException {
        recipe.setAmtCoffee(normalQ);
        assertEquals(Integer.parseInt(normalQ), recipe.getAmtCoffee());
    }

    @Test
    public void testSetAmtCoffee_zero() throws RecipeException {
        recipe.setAmtCoffee(zeroQ);
        assertEquals(Integer.parseInt(zeroQ), recipe.getAmtCoffee());
    }

    @Test
    public void testSetAmtCoffee_largeValue() throws RecipeException {
        recipe.setAmtCoffee(hugeQ);
        assertEquals(Integer.parseInt(hugeQ), recipe.getAmtCoffee());
    }

    @Test
    public void testSetAmtCoffee_negativeNumber() {
        String expectedMessage = "Units of coffee must be a positive integer";

        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtCoffee(negativeQ));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testSetAmtCoffee_nonNumerical() {
        String expectedMessage = "Units of coffee must be a positive integer";

        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtCoffee(wordQ));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testGetAmtMilk() throws RecipeException {
        recipe.setAmtMilk(normalQ);
        assertEquals(Integer.parseInt(normalQ), recipe.getAmtMilk());
    }

    @Test
    public void testSetAmtMilk_normalNumber() throws RecipeException {
        recipe.setAmtMilk(normalQ);
        assertEquals(Integer.parseInt(normalQ), recipe.getAmtMilk());
    }

    @Test
    public void testSetAmtMilk_zero() throws RecipeException {
        recipe.setAmtMilk(zeroQ);
        assertEquals(Integer.parseInt(zeroQ), recipe.getAmtMilk());
    }

    @Test
    public void testSetAmtMilk_largeValue() throws RecipeException {
        recipe.setAmtMilk(hugeQ);
        assertEquals(Integer.parseInt(hugeQ), recipe.getAmtMilk());
    }
    @Test
    public void testSetAmtMilk_negativeNumber() {
        String expectedMessage = "Units of milk must be a positive integer";

        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtMilk(negativeQ));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testSetAmtMilk_nonNumerical() {
        String expectedMessage = "Units of milk must be a positive integer";

        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtMilk(wordQ));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testGetAmtSugar() throws RecipeException {
        recipe.setAmtSugar(normalQ);
        assertEquals(Integer.parseInt(normalQ), recipe.getAmtSugar());
    }

    @Test
    public void testSetAmtSugar_normalNumber() throws RecipeException {
        recipe.setAmtSugar(normalQ);
        assertEquals(Integer.parseInt(normalQ), recipe.getAmtSugar());
    }

    @Test
    public void testSetAmtSugar_zero() throws RecipeException {
        recipe.setAmtSugar(zeroQ);
        assertEquals(Integer.parseInt(zeroQ), recipe.getAmtSugar());

    }

    @Test
    public void testSetAmtSugar_largeValue() throws RecipeException {
        recipe.setAmtSugar(hugeQ);
        assertEquals(Integer.parseInt(hugeQ), recipe.getAmtSugar());
    }

    @Test
    public void testSetAmtSugar_negativeNumber() {
        String expectedMessage = "Units of sugar must be a positive integer";

        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtSugar(negativeQ));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testSetAmtSugar_nonNumerical() {
        String expectedMessage = "Units of sugar must be a positive integer";

        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtSugar(wordQ));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testSetName_normal() {
        recipe.setName(normalName);
        assertEquals(normalName, recipe.getName());
    }

    @Test
    public void testSetName_insertNull(){
        recipe.setName(normalName);
        recipe.setName(null);
        assertEquals(normalName, recipe.getName());
    }

    @Test
    public void testSetPrice_normal() throws RecipeException {
        recipe.setPrice(normalQ);
        assertEquals(Integer.parseInt(normalQ), recipe.getPrice());
    }
    @Test
    public void testSetPrice_largeValue() throws RecipeException {
        recipe.setPrice(hugeQ);
        assertEquals(Integer.parseInt(hugeQ), recipe.getPrice());
    }
    @Test
    public void testSetPrice_negativeNumber() {
        String expectedMessage = "Price must be a positive integer";

        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setPrice(negativeQ));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testSetAmtPrice_zero() throws RecipeException {
        recipe.setPrice(zeroQ);
        assertEquals(Integer.parseInt(zeroQ), recipe.getPrice());
    }

    @Test
    public void testSetPrice_nonNumerical() {
        String expectedMessage = "Price must be a positive integer";

        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setPrice(wordQ));
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    public void testToString() {
        recipe.setName("Name");
        assertEquals(recipe.toString(), "Name");
    }

    @Test
    public void testEquals() {
        assertTrue(r1.equals(r2));
    }
}
