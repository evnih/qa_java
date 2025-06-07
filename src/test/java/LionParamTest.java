import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class LionParamTest {

    private final String sex;

    @Mock
    Predator predator;

    public LionParamTest(String sex) {
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Самец"}, {"Самка"}
        };
    }

    @Test
    public void testLionConstructorWithValidSex() throws Exception {
        Lion lion = new Lion(sex, predator);
        assertNotNull(lion);
    }
}

