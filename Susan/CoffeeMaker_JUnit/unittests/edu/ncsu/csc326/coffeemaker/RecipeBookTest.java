package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RecipeBookTest {

    private RecipeBook rb;
    private Recipe [] recipeArr;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;
    private Recipe r5;
    private Recipe r6;


    @BeforeEach
    public void setUp() throws Exception {

        rb = new RecipeBook();
        recipeArr = rb.getRecipes();

        //Set up for r1
        r1 = new Recipe();
        r1.setName("Cappuccino");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("4");
        r1.setAmtMilk("4");
        r1.setAmtSugar("1");
        r1.setPrice("65");

        //Set up for r2
        r2 = new Recipe();
        r2.setName("Flat White");
        r2.setAmtChocolate("0");
        r2.setAmtCoffee("4");
        r2.setAmtMilk("6");
        r2.setAmtSugar("1");
        r2.setPrice("50");

        //Set up for r3
        r3 = new Recipe();
        r3.setName("Mocha");
        r3.setAmtChocolate("10");
        r3.setAmtCoffee("5");
        r3.setAmtMilk("6");
        r3.setAmtSugar("3");
        r3.setPrice("70");

        //Set up for r4
        r4 = new Recipe();
        r4.setName("Hot Chocolate");
        r4.setAmtChocolate("20");
        r4.setAmtCoffee("0");
        r4.setAmtMilk("7");
        r4.setAmtSugar("3");
        r4.setPrice("60");

        //Set up for r5
        r5 = new Recipe();
        r5.setName("Long Black");
        r5.setAmtChocolate("0");
        r5.setAmtCoffee("5");
        r5.setAmtMilk("0");
        r5.setAmtSugar("0");
        r5.setPrice("40");

        //Set up for r6 to edit cappuccino recipe
        r6 = new Recipe();
        r6.setName("Cappuccino");
        r6.setAmtChocolate("2");
        r6.setAmtCoffee("6");
        r6.setAmtMilk("5");
        r6.setAmtSugar("3");
        r6.setPrice("5");
    }

    @AfterEach
    public void tearDown() {
        //TODO: What to put in here?
    }

    @Test
    public void testRecipeArr_emptyArr_shouldReturnNull(){
        assertNull("Should be null", recipeArr[0]);
        assertNull("Should be null", recipeArr[1]);
        assertNull("Should be null", recipeArr[2]);
        assertNull("Should be null", recipeArr[3]);
    }

    @Test
    public void testAddRecipe_emptyArr(){
        boolean result;
        result = rb.addRecipe(r1);

        assertTrue("failure - should return true.", result);
    }

    @Test
    public void testAddRecipe_recipeAlreadyExists(){
        boolean result;
        rb.addRecipe(r1);
        result = rb.addRecipe(r1);

        assertFalse("failure - should return false.", result);
    }

    @Test
    public void testAddRecipe_recipeNotExists(){
        boolean result;
        rb.addRecipe(r2);
        rb.addRecipe(r3);
        result = rb.addRecipe(r4);

        assertTrue("failure - should return true.", result);
    }

    @Test
    public void testAddRecipe_actuallyAdded(){
        rb.addRecipe(r1);

        assertEquals(r1, recipeArr[0]);
    }

    @Test
    public void testAddRecipe_fullArray(){
        boolean result;
        rb.addRecipe(r1);
        rb.addRecipe(r2);
        rb.addRecipe(r3);
        rb.addRecipe(r4);
        result = rb.addRecipe(r5);

        assertFalse("failure - should return false.", result);
    }

    @Test
    public void testGetRecipe(){
        rb.addRecipe(r1);
        rb.addRecipe(r2);
        rb.addRecipe(r3);
        rb.addRecipe(r4);

        assertEquals("failure - should return the same recipe.", recipeArr[0], r1);
        assertEquals("failure - should return the same recipe.", recipeArr[1], r2);
        assertEquals("failure - should return the same recipe.", recipeArr[2], r3);
        assertEquals("failure - should return the same recipe.", recipeArr[3], r4);
    }

    @Test
    public void testDeleteRecipe_emptyArr(){

        assertNull("failure - should return null.", rb.deleteRecipe(1));
    }

    @Test
    public void testDeleteRecipe_recipeExists(){
        String deletedRecipeName;
        rb.addRecipe(r1);
        deletedRecipeName = rb.deleteRecipe(0);
        assertEquals("failure - incorrect recipe deleted.", r1.getName(), deletedRecipeName);
    }

    @Test
    public void testDeleteRecipe_actuallyDeleted(){
        rb.addRecipe(r1);
        rb.deleteRecipe(0);

        assertNull("failure - index at deleted recipe should be null.", recipeArr[0]);
    }

    @Test
    public void testAddRecipe_afterDeletion(){
        rb.addRecipe(r1);
        rb.deleteRecipe(0);
        rb.addRecipe(r2);

        assertEquals("failure - should be the same recipe.", r2, recipeArr[0]);
    }

    @Test
    public void testDeleteRecipe_recipeNotExists(){
        String deletedRecipeName;
        rb.addRecipe(r1);
        deletedRecipeName = rb.deleteRecipe(1);
        assertNull("failure - should return null.", deletedRecipeName);
    }

    @Test
    public void testDeleteRecipe_exceedArrayLen() {
        rb.addRecipe(r1);
        rb.addRecipe(r2);
        rb.addRecipe(r3);
        rb.addRecipe(r4);

        //Throwable exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {rb.delete(1);});
        assertNull("failure - should return null, or really there should have been a check.",
                rb.deleteRecipe(5));
    }

    @Test
    public void testEditRecipe_emptyArr(){
        assertNull("failure - should return null.", rb.editRecipe(0, r1));
    }

    @Test
    public void testEditRecipe_recipeNotExist(){
        rb.addRecipe(r1);
        rb.addRecipe(r2);
        assertNull("failure - should return null.", rb.editRecipe(2, r3));
    }

    @Test
    public void testEditRecipe_recipeExist(){
        String recipeName;
        rb.addRecipe(r1);
        recipeName = rb.editRecipe(0, r6);

        assertEquals("failure - recipe name should be the same.", r1.getName(), recipeName);
    }

    @Test
    public void testEditRecipe_actuallyEdited(){
        rb.addRecipe(r1);
        rb.editRecipe(0, r6);

        assertEquals(r6, recipeArr[0]);
    }

    @Test
    public void testEditRecipe_exceedArrLen(){

        assertNull("failure - should return null, or really there should have been a check.",
                rb.editRecipe(7, r6));
    }

}