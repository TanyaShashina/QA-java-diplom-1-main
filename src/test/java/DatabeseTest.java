//Проверка инициализации БД и того как можно забрать данные из неё
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.Database;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DatabeseTest {
    private  Database database = new Database();
    private  List<Bun> buns = new ArrayList<>();
    private  List<Ingredient> ingredients = new ArrayList<>();

    public DatabeseTest(){
    }

    @Test
    public void takeIngridientsNotNull(){
        ingredients = database.availableIngredients();
        assertNotNull("Список ингридиентов в базе пуст",ingredients);
    }
    @Test
    public void takeBunsNotNull(){
        buns = database.availableBuns();
        assertNotNull("Список булок в базе пуст",buns);
    }
    @Test
    public void takeIngridientsCheckHotSauce(){
        ingredients = database.availableIngredients();
        boolean checkIng = false;
        for (Ingredient el: ingredients){
            if(el.getName().equals("hot sauce")){
                checkIng = true;
                break;
            }
        }
        assertTrue("Пропал остренький соус!",checkIng);

    }
    @Test
    public void takeIngridientsCheckSourCream(){
        ingredients = database.availableIngredients();
        boolean checkIng = false;
        for (Ingredient el: ingredients){
            if(el.getName().equals("sour cream")){
                checkIng = true;
                break;
            }
        }
        assertTrue("Пропал мазик!",checkIng);

    }
    @Test
    public void takeIngridientsCheckChiliSauce(){
        ingredients = database.availableIngredients();
        boolean checkIng = false;
        for (Ingredient el: ingredients){
            if(el.getName().equals("chili sauce")){
                checkIng = true;
                break;
            }
        }
        assertTrue("Пропал чили!",checkIng);
    }
    @Test
    public void takeIngridientsCheckCutlet(){
        ingredients = database.availableIngredients();
        boolean checkIng = false;
        for (Ingredient el: ingredients){
            if(el.getName().equals("cutlet")){
                checkIng = true;
                break;
            }
        }
        assertTrue("Пропали котлетки!",checkIng);
    }
    @Test
    public void takeIngridientsCheckDinosaur(){
        ingredients = database.availableIngredients();
        boolean checkIng = false;
        for (Ingredient el: ingredients){
            if(el.getName().equals("dinosaur")){
                checkIng = true;
                break;
            }
        }
        assertTrue("Пропали динонагетсы,мааам!",checkIng);
    }
    @Test
    public void takeIngridientsCheckSausage(){
        ingredients = database.availableIngredients();
        boolean checkIng = false;
        for (Ingredient el: ingredients){
            if(el.getName().equals("sausage")){
                checkIng = true;
                break;
            }
        }
        assertTrue("Соснули плывиськи, ой пропали сосиски!",checkIng);
    }
    @Test
    public void takeIngridientsCheckNull(){
        ingredients = database.availableIngredients();
        boolean checkIng = true;
        for (Ingredient el: ingredients){
            if(el.getName().equals(null)){
                checkIng = false;
                break;
            }
        }
        assertTrue("Найденые null-е ингридиенты, хехе",checkIng);
    }
    @Test
    public void takeBunsCheckBlackBun(){
        this.buns = database.availableBuns();
        boolean checkIng = false;
        for (Bun el: buns){
            if(el.getName().equals("black bun")){
                checkIng = true;
                break;
            }
        }
        assertTrue("Пропали черные булки!",checkIng);

    }
    @Test
    public void takeBunsCheckWhiteBun(){
        this.buns = database.availableBuns();
        boolean checkIng = false;
        for (Bun el: buns){
            if(el.getName().equals("white bun")){
                checkIng = true;
                break;
            }
        }
        assertTrue("Пропали белые булки!",checkIng);

    }
    @Test
    public void takeBunsCheckRedBun(){
        this.buns = database.availableBuns();
        boolean checkIng = false;
        for (Bun el: buns){
            if(el.getName().equals("red bun")){
                checkIng = true;
                break;
            }
        }
        assertTrue("Пропали красные булки!",checkIng);

    }
    @Test
    public void takeBunsCheckNull(){
        this.buns = database.availableBuns();
        boolean checkIng = true;
        for (Bun el: buns){
            if(el.getName().equals(null)){
                checkIng = false;
                break;
            }
        }
        assertTrue("Найденые null-е булки, хехе",checkIng);

    }

}