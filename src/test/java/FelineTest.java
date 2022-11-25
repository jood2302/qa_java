import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void felineGetFamily() {
        Assert.assertEquals("Кошачьи",feline.getFamily());
    }

    @Test
    public void felineGetKittens() {
        Assert.assertEquals(1,feline.getKittens());
    }

    @Test
    public void felineEatMeat() throws Exception{
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, feline.eatMeat());
    }
}
