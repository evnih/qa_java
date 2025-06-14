import com.example.LionAlex;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    @Mock
    Predator predator;

    @Test
    public void getFriends_ReturnsCorrectList() throws Exception {
        LionAlex lionAlex = new LionAlex(predator);
        assertEquals(List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман"), lionAlex.getFriends());
    }
    @Test
    public void getPlaceOfLiving_ReturnsZoo() throws Exception {
        LionAlex lionAlex = new LionAlex(predator);
        assertEquals("Нью-Йоркский зоопарк", lionAlex.getPlaceOfLiving());
    }
    @Test
    public void getKittens_AlwaysReturnsZero() throws Exception {
        LionAlex lionAlex = new LionAlex(predator);
        assertEquals(0, lionAlex.getKittens());
    }
    @Test
    public void constructor_SetsMaleSexAutomatically() throws Exception {
        LionAlex lionAlex = new LionAlex(predator);
        assertTrue(lionAlex.doesHaveMane());
    }
    @Test
    public void getFood_CallsParentMethod() throws Exception {
        LionAlex lionAlex = new LionAlex(predator);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(predator.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, lionAlex.getFood());
    }
}

