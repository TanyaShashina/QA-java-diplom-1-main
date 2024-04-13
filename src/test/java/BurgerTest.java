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
    public void tryToSetHotSauceWOCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(0));
        String recBur = burger.getReceipt();
        assertTrue("Острый соус не на месте",recBur.contains(ingredients.get(0).getName()));
    }
    @Test
    public void tryToSetHotSauceWCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(0));
        String recBur = burger.getReceipt();
        String expResult = String.format("(==== "+buns.get(1).getName()+" ====)%n" +
                "= sauce "+ingredients.get(0).getName()+" =%n" +
                "(==== "+buns.get(1).getName()+" ====)%n" +
                "%n" +
                "Price: 500,000000%n");
        assertEquals("При добавлении ингридиентов(Острый соус) сломался вид чека",expResult,recBur);
    }
    @Test
    public void tryToSetSourCreamWOCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(1));
        String recBur = burger.getReceipt();
        assertTrue("Мазик не на месте",recBur.contains(ingredients.get(1).getName()));
    }
    @Test
    public void tryToSetSourCreamWCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(1));
        String recBur = burger.getReceipt();
        String expResult = String.format("(==== "+buns.get(1).getName()+" ====)%n" +
                "= sauce "+ingredients.get(1).getName()+" =%n" +
                "(==== "+buns.get(1).getName()+" ====)%n" +
                "%n" +
                "Price: 600,000000%n");
        assertEquals("При добавлении ингридиентов(Мазик) сломался вид чека",expResult,recBur);
    }
    @Test
    public void tryToSetChiliSauceWOCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(2));
        String recBur = burger.getReceipt();
        assertTrue("Чили не на месте",recBur.contains(ingredients.get(2).getName()));
    }
    @Test
    public void tryToSetChiliSauceWCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(2));
        String recBur = burger.getReceipt();
        String expResult = String.format("(==== "+buns.get(1).getName()+" ====)%n" +
                "= sauce "+ingredients.get(2).getName()+" =%n" +
                "(==== "+buns.get(1).getName()+" ====)%n" +
                "%n" +
                "Price: 700,000000%n");
        assertEquals("При добавлении ингридиентов(чили) сломался вид чека",expResult,recBur);
    }
    @Test
    public void tryToSetCutletWOCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(3));
        String recBur = burger.getReceipt();
        assertTrue("Котлета не на месте",recBur.contains(ingredients.get(3).getName()));
    }
    @Test
    public void tryToSetCutletWCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(3));
        String recBur = burger.getReceipt();
        String expResult = String.format("(==== "+buns.get(1).getName()+" ====)%n" +
                "= filling "+ingredients.get(3).getName()+" =%n" +
                "(==== "+buns.get(1).getName()+" ====)%n" +
                "%n" +
                "Price: 500,000000%n");
        assertEquals("При добавлении ингридиентов(динонагетсы) сломался вид чека",expResult,recBur);
    }
    @Test
    public void tryToSetDinosaurWOCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(4));
        String recBur = burger.getReceipt();
        assertTrue("Динонагетсы не на месте",recBur.contains(ingredients.get(4).getName()));
    }
    @Test
    public void tryToSetDinosaurWCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(4));
        String recBur = burger.getReceipt();
        String expResult = String.format("(==== "+buns.get(1).getName()+" ====)%n" +
                "= filling "+ingredients.get(4).getName()+" =%n" +
                "(==== "+buns.get(1).getName()+" ====)%n" +
                "%n" +
                "Price: 600,000000%n");
        assertEquals("При добавлении ингридиентов(динонагетсы) сломался вид чека",expResult,recBur);
    }
    @Test
    public void tryToSetSausageWOCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(5));
        String recBur = burger.getReceipt();
        assertTrue("Сосиски не на месте",recBur.contains(ingredients.get(5).getName()));
    }
    @Test
    public void tryToSetSausageWCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(5));
        String recBur = burger.getReceipt();
        String expResult = String.format("(==== "+buns.get(1).getName()+" ====)%n" +
                "= filling "+ingredients.get(5).getName()+" =%n" +
                "(==== "+buns.get(1).getName()+" ====)%n" +
                "%n" +
                "Price: 700,000000%n");
        assertEquals("При добавлении ингридиентов(соски) сломался вид чека",expResult,recBur);
    }
    @Test
    public void tryToRemoveIngWOCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(5));
        burger.removeIngredient(1);
        String recBur = burger.getReceipt();
        assertFalse("Чили не убрали!",recBur.contains(ingredients.get(4).getName()));
    }
    @Test
    public void tryToRemoveIngWCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(5));
        burger.removeIngredient(1);
        String recBur = burger.getReceipt();
        String expResult = String.format("(==== "+buns.get(1).getName()+" ====)%n" +
                "= filling "+ingredients.get(4).getName()+" =%n" +
                "(==== "+buns.get(1).getName()+" ====)%n" +
                "%n" +
                "Price: 600,000000%n");
        assertEquals("При удалении ингридиентов(чили) сломался вид чека",expResult,recBur);
    }
    @Test
    public void tryToSetMoveIngWOCheckRecFormat(){
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
    public void tryToSetMoveIngWCheckRecFormat(){
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(5));
        burger.moveIngredient(1,0);
        String recBur1 = burger.getReceipt();
        String expResult = String.format("(==== "+buns.get(1).getName()+" ====)%n" +
                "= sauce "+ingredients.get(1).getName()+" =%n" +
                "= filling "+ingredients.get(4).getName()+" =%n" +
                "= filling "+ingredients.get(5).getName()+" =%n" +
                "(==== "+buns.get(1).getName()+" ====)%n" +
                "%n" +
                "Price: 1100,000000%n");
        assertEquals("При смене ингридиентов(соус и динонагетсы) сломался вид чека",expResult,recBur1);
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
