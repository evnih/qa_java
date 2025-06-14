import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamTest {

    private final int kittensCount;
    private final Feline feline = new Feline();

    public FelineParamTest(int kittensCount) {
            this.kittensCount = kittensCount;
        }
        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {0}, {1}, {5}, {10}
            });
        }
        @Test
        public void testGetKittensWithParameter() {
            assertEquals(kittensCount, feline.getKittens(kittensCount));
        }
    }
