//проверяем создание бургеров с разными ингридиентами без бд
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class BurgerTest {
    private Database database = new Database();;
    public List<Ingredient> ingredients;
    private List<Bun> buns;

    public BurgerTest() {
        this.ingredients = database.availableIngredients();
        this.buns = database.availableBuns();
    }

    @Test
    public void tryToSetBlackBun(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(0));
        String recBur = burger.getReceipt();
        assertTrue("Чёрные булочки не на месте",recBur.contains(buns.get(0).getName()));
    }
    @Test
    public void tryToSetWhiteBun(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        String recBur = burger.getReceipt();
        assertTrue("Белые булочки не на месте",recBur.contains(buns.get(1).getName()));
    }
    @Test
    public void tryToSetRedBun(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(2));
        String recBur = burger.getReceipt();
        assertTrue("Красные булочки не на месте",recBur.contains(buns.get(2).getName()));
    }

    @Test
    public void tryToSetHotSauce(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(0));
        String recBur = burger.getReceipt();
        assertTrue("Острый соус не на месте",recBur.contains(ingredients.get(0).getName()));
    }
    @Test
    public void tryToSetSourCream(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(1));
        String recBur = burger.getReceipt();
        assertTrue("Мазик не на месте",recBur.contains(ingredients.get(1).getName()));
    }
    @Test
    public void tryToSetChiliSauce(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(2));
        String recBur = burger.getReceipt();
        assertTrue("Чили не на месте",recBur.contains(ingredients.get(2).getName()));
    }
    @Test
    public void tryToSetCutlet(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(3));
        String recBur = burger.getReceipt();
        assertTrue("Котлета не на месте",recBur.contains(ingredients.get(3).getName()));
    }
    @Test
    public void tryToSetDinosaur(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(4));
        String recBur = burger.getReceipt();
        assertTrue("Чили не на месте",recBur.contains(ingredients.get(4).getName()));
    }
    @Test
    public void tryToSetSausage(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(5));
        String recBur = burger.getReceipt();
        assertTrue("Сосиски не на месте",recBur.contains(ingredients.get(5).getName()));
    }
    @Test
    public void tryToRemoveIng(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(5));
        burger.removeIngredient(1);
        String recBur = burger.getReceipt();
        assertFalse("Чили не убрали!",recBur.contains(ingredients.get(4).getName()));
    }
    @Test
    public void tryToSetMoveIng(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(5));
        String recBur = burger.getReceipt();
        burger.moveIngredient(1,0);
        String recBur1 = burger.getReceipt();
        assertEquals("Соус и динонагетсы НЕ поменяны местами",recBur.indexOf("filling dinosaur"),recBur1.indexOf("sauce sour cream"));
    }
    @Test
    public void tryToGetPriceOnlyBun(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        Float priceBurg = burger.getPrice();
        assertTrue("Не сошлись манисы",
                priceBurg.equals(buns.get(1).getPrice()*2));
    }
    @Test
    public void tryToGetPriceBunIngr(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(1));
        Float priceBurg = burger.getPrice();
        assertTrue("Не сошлись манисы",
                priceBurg.equals((buns.get(1).getPrice()*2)+ingredients.get(1).getPrice()));
    }
}
