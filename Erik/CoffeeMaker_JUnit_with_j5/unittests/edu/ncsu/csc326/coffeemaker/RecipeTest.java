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
    public void testSetAmtChocolateLargeValue() throws Exception {
        recipe.setAmtChocolate(hugeQ);
        assertEquals(Integer.parseInt(hugeQ), recipe.getAmtChocolate());

    }

    @Test
    public void testSetAmtChocolateNegative() throws Exception {
    //    recipe.setAmtChocolate(negativeQ);

        //assertEquals(recipe.getAmtChocolate(), null);
        Throwable throwable = assertThrows(RecipeException.class,() -> recipe.setAmtChocolate(negativeQ));

        //fail("Expected: RecipeException");

    }
    @Test
    public void setAmtCoffeeNormal() throws Exception {
        recipe.setAmtCoffee(normalq);
        assertEquals(Integer.parseInt(normalq), recipe.getAmtCoffee());
    }
    @Test
    public void setAmtCoffeeLargeValue() throws Exception {
        recipe.setAmtCoffee(hugeQ);
        assertEquals(Integer.parseInt(hugeQ), recipe.getAmtCoffee());

    }
    @Test
    public void setAmtCoffeeNegative() throws Exception {

            //recipe.setAmtCoffee(negativeQ);
        Throwable throwable = assertThrows(RecipeException.class,() -> recipe.setAmtCoffee(negativeQ));

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
    public void setAmtMilkLargeValue() throws Exception {
        recipe.setAmtMilk(hugeQ);
        assertEquals(Integer.parseInt(hugeQ), recipe.getAmtMilk());
    }
    @Test
    public void setAmtMilkNegative() throws Exception {
        //recipe.setAmtMilk(negativeQ);
       // assertEquals(Integer.parseInt(negativeQ), recipe.getAmtMilk());
        //fail();
        Throwable throwable = assertThrows(RecipeException.class,() -> recipe.setAmtMilk(negativeQ));

    }
    @Test
    public void setAmtSugarNormal() throws Exception {
        recipe.setAmtSugar(normalq);
        assertEquals(Integer.parseInt(normalq), recipe.getAmtSugar());
    }
    @Test
    public void setAmtSugarLargeValue() throws Exception {
        recipe.setAmtSugar(hugeQ);
        assertEquals(Integer.parseInt(hugeQ), recipe.getAmtSugar());
    }
    @Test
    public void setAmtSugarNegative() throws Exception {
        //recipe.setAmtSugar(negativeQ);
        //assertEquals(Integer.parseInt(negativeQ), null);
        //fail();
        Throwable throwable = assertThrows(RecipeException.class,() -> recipe.setAmtSugar(negativeQ));
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
        //recipe.setPrice(negativeQ);
        //fail();
        Throwable throwable = assertThrows(RecipeException.class,() -> recipe.setPrice(negativeQ));
        //assertEquals();
    }






}
