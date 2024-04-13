//реализован параметризованный тест на вариативность значений с проверкой разных пар значений, включая null и 0
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price){
        this.name=name;
        this.price=price;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestions() {
        return new Object[][] {
                {"Кирилица", 1.0f},
                {"latin", 2.0f},
                {null, 1.1f},
                {"", 2.2f},
                {"", 0}
        };
    }

    @Test
    public void makeDiffBunsTest(){
        Bun testBun = new Bun(name,price);
        assertEquals(name, testBun.getName());
        assertEquals(price,
                testBun.getPrice(),
                0);
    }

}
