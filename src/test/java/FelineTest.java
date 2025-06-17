import com.example.Feline;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class FelineTest {
    private Feline feline = new Feline();

    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }
    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void testGetKittensWithoutParametr() {
        assertEquals(1, feline.getKittens());
    }
}
