import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private Bun bun;
    private String name;
    private float price;

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
