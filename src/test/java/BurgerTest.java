import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import praktikum.Bun;
import praktikum.Burger;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1, ingredient2, ingredient3;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        Assert.assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        testAddIngredient();
        burger.removeIngredient(2);
        Assert.assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        testAddIngredient();
        burger.moveIngredient(2, 1);
        Assert.assertEquals(ingredient3, burger.ingredients.get(1));
        Assert.assertEquals(ingredient2, burger.ingredients.get(2));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        when(bun.getPrice()).thenReturn(45F);
        when(ingredient1.getPrice()).thenReturn(15F);
        when(ingredient2.getPrice()).thenReturn(12F);
        when(ingredient3.getPrice()).thenReturn(10F);

        float expected = (45F * 2) + 15F + 12F + 10F;

        Assert.assertEquals(expected, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        when(bun.getName()).thenReturn("Big Mak");
        when(ingredient1.getName()).thenReturn("cucumber");
        when(ingredient2.getName()).thenReturn("ketchup");
        when(ingredient3.getName()).thenReturn("onion");

        when(bun.getPrice()).thenReturn(45F);
        when(ingredient1.getPrice()).thenReturn(15F);
        when(ingredient2.getPrice()).thenReturn(12F);
        when(ingredient3.getPrice()).thenReturn(10F);

        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient3.getType()).thenReturn(IngredientType.FILLING);

        String expected = String.format("(==== Big Mak ====)%n" +
                "= filling cucumber =%n" +
                "= sauce ketchup =%n" +
                "= filling onion =%n" +
                "(==== Big Mak ====)%n" +
                "%nPrice: 127,000000%n");

        Assert.assertEquals(expected, burger.getReceipt());
    }
}
