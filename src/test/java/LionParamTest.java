import com.example.Lion;
import com.example.Predator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class LionParamTest {

    private final String sex;
    private final boolean expectedHasMane;

    @Mock
    Predator predator;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    public LionParamTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Test
    public void testLionConstructorWithValidSexAndMane() throws Exception {
        Lion lion = new Lion(sex, predator);
        assertNotNull(lion);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}

