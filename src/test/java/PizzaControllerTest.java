import attachments.Pizza;
import controller.PizzaController;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class PizzaControllerTest {

    @Test
    public void testCheapestSpicy() {
        Pizza caruso = Pizza.CARUSO;
        PizzaController pizzaController = new PizzaController();
        Pizza testedPizza = pizzaController.findCheapestSpicy();
        assertEquals(caruso, testedPizza);
    }

    @Test
    public void testExpensiveVegetarian() {
        Pizza vegetariana = Pizza.VEGETARIANA;
        PizzaController pizzaController = new PizzaController();
        Pizza testedPizza = pizzaController.findMostExpensiveVegetarian();
        assertEquals(vegetariana, testedPizza);
    }

    @Test
    public void testMeatPizza() {
        List<Pizza> listMeatPizza = Arrays.asList(Pizza.SOPRANO, Pizza.CALABRESE, Pizza.TABASCO, Pizza.FARMER, Pizza.CAPRI, Pizza.HAVAI, Pizza.CARUSO, Pizza.MAMA_MIA, Pizza.AMORE);
        PizzaController pizzaController = new PizzaController();
        List<Pizza> testedListPizza = pizzaController.iLikeMeat();
        assertEquals(listMeatPizza, testedListPizza);
    }

    @Test
    public void testGroupPrice() {
        Map<Integer, List<Pizza>> mapGroupPrice = new TreeMap<>();
        mapGroupPrice.put(13, Arrays.asList(Pizza.MARGHERITA));
        mapGroupPrice.put(15, Arrays.asList(Pizza.CARUSO));
        mapGroupPrice.put(16, Arrays.asList(Pizza.PASCETORE, Pizza.AMORE));
        mapGroupPrice.put(17, Arrays.asList(Pizza.CAPRI, Pizza.HAVAI));
        mapGroupPrice.put(18, Arrays.asList(Pizza.MAMA_MIA));
        mapGroupPrice.put(19, Arrays.asList(Pizza.CAPRESE, Pizza.FOUR_CHEESE));
        mapGroupPrice.put(20, Arrays.asList(Pizza.VEGETARIANA));
        mapGroupPrice.put(22, Arrays.asList(Pizza.TABASCO, Pizza.FARMER));
        mapGroupPrice.put(23, Arrays.asList(Pizza.SOPRANO));
        mapGroupPrice.put(24, Arrays.asList(Pizza.CALABRESE));

        PizzaController pizzaController = new PizzaController();
        Map<Integer, List<Pizza>> testedMap = new TreeMap<>(pizzaController.groupByPrice());

        assertEquals(mapGroupPrice, testedMap);
    }
}
