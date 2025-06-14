
import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Predator predator;
    @Mock
    Feline feline;

    @Test
    public void lionWithInvalidSex() {
        String invalidSex = "Неизвестный пол";
        try {
            new Lion(invalidSex, predator, feline);
            fail("Должно было выбросить исключение");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самка", predator, feline);
        List<String> expectedFood = List.of("Мясо");
        when(predator.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
        verify(predator).eatMeat();
    }
    @Test
    public void testGetKittens() throws Exception{
        Lion lion = new Lion("Самец", predator, feline);
        when(feline.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
        verify(feline).getKittens();
    }
    @Test(expected = NullPointerException.class)
    public void constructor_ThrowsWhenPredatorIsNull() throws Exception {
        new Lion("Самец", null);
    }
    @Test
    public void getFood_CallsPredatorEatMeat() throws Exception {
        Predator predator = mock(Predator.class);
        when(predator.eatMeat()).thenReturn(List.of("Мясо"));

        Lion lion = new Lion("Самец", predator);
        assertEquals(List.of("Мясо"), lion.getFood());
    }
    @Test(expected = NullPointerException.class) // Изменили на NPE
    public void constructor_WhenPredatorIsNull_ThrowsException() throws Exception {
        new Lion("Самец", null, mock(Feline.class));
    }
    @Test(expected = NullPointerException.class) // Изменили на NPE
    public void simplifiedConstructor_WhenPredatorIsNull_ThrowsException() throws Exception {
        new Lion("Самец", null);
    }
    @Test(expected = NullPointerException.class)
    public void constructor_WhenFelineIsNull_ThrowsException() throws Exception {
        new Lion("Самец", mock(Predator.class), null);
    }
}
