//проверяем воззможность создания ингридиентов разного типа параметризованным тестом
//реализован параметризованный тест на вариативность значений с проверкой разных пар значений, включая null и 0
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngridientTest {
    public final IngredientType type;
    public final String name;
    public final float  price;

    public IngridientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestions() {
        return new Object[][] {
                {SAUCE,"Кирилица", 1.0f},
                {SAUCE,"latin", 2.0f},
                {SAUCE,null, 1.1f},
                {SAUCE,"", 2.2f},
                {FILLING,"Кирилица", 1.0f},
                {FILLING,"latin", 2.0f},
                {FILLING,null, 1.1f},
                {FILLING,"", 2.2f},
                {null,"", 0}
        };
    }

    @Test
    public void makeDiffIngridientTest(){
        Ingredient ingredienttst = new Ingredient(type,name,price);
        assertEquals(name, ingredienttst.getName());
        assertEquals(price,
                ingredienttst.getPrice(),
                0);
        assertEquals(type,
                ingredienttst.getType());
    }
}
