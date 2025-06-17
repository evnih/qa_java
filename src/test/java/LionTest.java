
import com.example.Feline;
import com.example.Lion;
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
    Feline feline;

    @Test
    public void lionWithInvalidSex() {
        String invalidSex = "Неизвестный пол";
        try {
            new Lion(invalidSex, feline);
            fail("Должно было выбросить исключение");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> expectedFood = List.of("Мясо");
        when(feline.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
        verify(feline).eatMeat();
    }
    @Test
    public void testGetKittens() throws Exception{
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
        verify(feline).getKittens();
    }
    @Test(expected = NullPointerException.class)
    public void constructor_ThrowsWhenFelineIsNull() throws Exception {
        new Lion("Самец", null);
    }

}
