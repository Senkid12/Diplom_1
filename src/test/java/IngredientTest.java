import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final static Random random = new Random();
    private Ingredient ingredient;
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {IngredientType.SAUCE, RandomStringUtils.randomAlphabetic(15), random.nextFloat()},
                {IngredientType.FILLING, RandomStringUtils.randomAlphabetic(15), random.nextFloat()}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetType() {
        Assert.assertEquals(ingredientType, ingredient.getType());
    }


}
