
import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Predator predator;
    @Test
    public void lionWithInvalidSex() {
        String invalidSex = "Неизвестный пол";
        try {
            new Lion(invalidSex, predator);
            fail("Должно было выбросить исключение");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }

    @Test
    public void doesHaveManeForMale() throws Exception {
        Lion lion = new Lion("Самец", predator);
        assertTrue(lion.doesHaveMane());
    }
    @Test
    public void doesHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", predator);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", predator);
        List<String> expectedFood = Arrays.asList("Животные", "Птица", "Рыба");
        when(predator.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
    }

   @Test
    public void testGetKittens() throws Exception{
        Lion lion = new Lion("Самец", predator);
        when(predator.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
    }
    @Test
    public void getKittens_WhenPredatorIsNull_UsesFeline() throws Exception {
        Lion lion = new Lion("Самец", null);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFood_WhenPredatorIsNull_UsesFeline() throws Exception {
        Lion lion = new Lion("Самец", null);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, lion.getFood());
    }

}
