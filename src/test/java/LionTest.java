import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest{

    private final String sexOption;
    private final boolean expected;

    public LionTest(String sexOption, boolean expected) {
        this.sexOption = sexOption;
        this.expected = expected;
    }

    @Before
    public void initMocks() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }
    Feline feline = Mockito.mock(Feline.class);

    @Parameterized.Parameters
    public static Object[] getListOfMealDataForHerbivoreAndPredator() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void lionSex() throws Exception {
        Lion lion = new Lion(feline, sexOption);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lionHasMane() throws Exception {
        Lion lion = new Lion(feline, sexOption);
        boolean actual = lion.doesHaveMane();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lionGetKittens() throws Exception {
        Lion lion = new Lion(feline, sexOption);
        int expected = 1;
        Mockito.when(feline.getKittens()).thenReturn(expected);
        int actual = lion.getKittens();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lionGetFood() throws Exception {
        Lion lion = new Lion(feline, sexOption);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lionSexException() {
        String sexInvalidOption = "неизвестно";
        Exception actualException = null;
        try {
            new Lion(feline, sexInvalidOption);
        } catch (Exception e) {
            actualException = e;
        }
        Assert.assertNotNull(actualException);
    }
}
