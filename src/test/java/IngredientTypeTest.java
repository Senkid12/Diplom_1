import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    private static final String SAUCE = "SAUCE";
    private static final String FILLING = "FILLING";

    @Test
    public void testSauce() {
        Assert.assertEquals(SAUCE, IngredientType.SAUCE.toString());
    }

    @Test
    public void testFilling() {
        Assert.assertEquals(FILLING, IngredientType.FILLING.toString());
    }
}
