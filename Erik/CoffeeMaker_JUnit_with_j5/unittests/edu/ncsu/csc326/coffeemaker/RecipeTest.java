package edu.ncsu.csc326.coffeemaker;



import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RecipeTest {

    private String name;
    private int price;
    private int amtCoffee;
    private int amtMilk;
    private int amtSugar;
    private int amtChocolate;
    private Recipe recipe;

    private String normalq = "1";
    private String hugeQ = "99999999";
    private String negativeQ = "-1";
    private String wordQ = "Hello";
    private String zeroQ = "0";

    private String normalName = "Name";
    private int intName = 111;




    @BeforeAll
    public void setUp() throws Exception {
         recipe = new Recipe();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
   public void testSetAmtChocolateNormal() throws Exception {
        recipe.setAmtChocolate(normalq);
        assertEquals(Integer.parseInt(normalq), recipe.getAmtChocolate());

   }

    @Test
    public void testSetAmtChocolateZero() throws Exception {
        recipe.setAmtChocolate(zeroQ);
        assertEquals(Integer.parseInt(zeroQ), recipe.getAmtChocolate());

    }

   @Test
   public void testSetAmtChocolateWord() throws Exception {
        String expectedMessage = "Units of chocolate must be a positive integer";
        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtChocolate(wordQ));
        assertEquals(expectedMessage, exception.getMessage());
   }

    @Test
    public void testSetAmtChocolateLargeValue() throws Exception {
        recipe.setAmtChocolate(hugeQ);
        assertEquals(Integer.parseInt(hugeQ), recipe.getAmtChocolate());

    }

    @Test
    public void testSetAmtChocolateNegative() throws Exception {
    //    recipe.setAmtChocolate(negativeQ);
        String expectedMessage = "Units of chocolate must be a positive integer";

        //assertEquals(recipe.getAmtChocolate(), null);
        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtChocolate(negativeQ));
        assertEquals(expectedMessage, exception.getMessage());

        //fail("Expected: RecipeException");

    }
    @Test
    public void setAmtCoffeeNormal() throws Exception {
        recipe.setAmtCoffee(normalq);
        assertEquals(Integer.parseInt(normalq), recipe.getAmtCoffee());
    }

    @Test
    public void testSetAmtCoffeeZero() throws Exception {
        recipe.setAmtCoffee(zeroQ);
        assertEquals(Integer.parseInt(zeroQ), recipe.getAmtCoffee());

    }

    @Test
    public void setAmtCoffeeLargeValue() throws Exception {
        recipe.setAmtCoffee(hugeQ);
        assertEquals(Integer.parseInt(hugeQ), recipe.getAmtCoffee());

    }
    @Test
    public void setAmtCoffeeNegative() throws Exception {

        String expectedMessage = "Units of coffee must be a positive integer";

        //assertEquals(recipe.getAmtChocolate(), null);
        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtCoffee(negativeQ));
        assertEquals(expectedMessage, exception.getMessage());

            /*
            fail("Excepcted: RecipeException");
*/

        //assertEquals(Integer.parseInt(negativeQ), null);

    }

    @Test
    public void setAmtMilkNormal() throws Exception {
        recipe.setAmtMilk(normalq);
        assertEquals(Integer.parseInt(normalq), recipe.getAmtMilk());
    }

    @Test
    public void testSetAmtMilkZero() throws Exception {
        recipe.setAmtMilk(zeroQ);
        assertEquals(Integer.parseInt(zeroQ), recipe.getAmtMilk());

    }

    @Test
    public void setAmtMilkLargeValue() throws Exception {
        recipe.setAmtMilk(hugeQ);
        assertEquals(Integer.parseInt(hugeQ), recipe.getAmtMilk());
    }
    @Test
    public void setAmtMilkNegative() throws Exception {
        String expectedMessage = "Units of milk must be a positive integer";

        //assertEquals(recipe.getAmtChocolate(), null);
        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtMilk(negativeQ));
        assertEquals(expectedMessage, exception.getMessage());

    }

    @Test
    public void setAmtMilkWord() throws Exception {
        String expectedMessage = "Units of milk must be a positive integer";

        //assertEquals(recipe.getAmtChocolate(), null);
        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtMilk(wordQ));
        assertEquals(expectedMessage, exception.getMessage());

    }


    @Test
    public void setAmtSugarNormal() throws Exception {
        recipe.setAmtSugar(normalq);
        assertEquals(Integer.parseInt(normalq), recipe.getAmtSugar());
    }

    @Test
    public void testSetAmtSugarZero() throws Exception {
        recipe.setAmtSugar(zeroQ);
        assertEquals(Integer.parseInt(zeroQ), recipe.getAmtSugar());

    }

    @Test
    public void setAmtSugarLargeValue() throws Exception {
        recipe.setAmtSugar(hugeQ);
        assertEquals(Integer.parseInt(hugeQ), recipe.getAmtSugar());
    }
    @Test
    public void setAmtSugarNegative() throws Exception {
        String expectedMessage = "Units of sugar must be a positive integer";

        //assertEquals(recipe.getAmtChocolate(), null);
        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtSugar(negativeQ));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void setAmtSugarWord() throws Exception {
        String expectedMessage = "Units of sugar must be a positive integer";

        //assertEquals(recipe.getAmtChocolate(), null);
        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setAmtSugar(wordQ));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void setNameNormal() throws Exception {
        recipe.setName(normalName);
        assertEquals(normalName, recipe.getName());
    }
    @Test
    public void setPriceNormal() throws Exception {
        recipe.setPrice(normalq);
        assertEquals(Integer.parseInt(normalq), recipe.getPrice());
    }
    @Test
    public void setPriceLargeValue() throws Exception {
        recipe.setPrice(hugeQ);
        assertEquals(Integer.parseInt(hugeQ), recipe.getPrice());
    }
    @Test
    public void setPriceNegative() throws Exception {
        String expectedMessage = "Price must be a positive integer";

        //assertEquals(recipe.getAmtChocolate(), null);
        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setPrice(negativeQ));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testSetAmtPriceZero() throws Exception {
        recipe.setPrice(zeroQ);
        assertEquals(Integer.parseInt(zeroQ), recipe.getPrice());

    }

    @Test
    public void setPriceWord() throws Exception {
        String expectedMessage = "Price must be a positive integer";

        //assertEquals(recipe.getAmtChocolate(), null);
        Throwable exception = assertThrows(RecipeException.class,() -> recipe.setPrice(wordQ));
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    public void testToString() {
        recipe.setName("Name");
        assertEquals(recipe.toString(), "Name");
    }








}
