package controller;

import attachments.Ingredient;
import attachments.Pizza;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PizzaController {

    private static Integer pricePizza(Pizza pizza) {
        return pizza.getIngredients()
                .stream()
                .mapToInt(Ingredient::getPrice)
                .sum();
    }

    public Pizza findCheapestSpicy() {
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients()
                        .stream()
                        .anyMatch(Ingredient::isSpicy))
                .min(Comparator.comparingInt(pizza -> pricePizza(pizza)))
                .get();
    }

    public Pizza findMostExpensiveVegetarian() {
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients()
                        .stream()
                        .noneMatch(Ingredient::isMeat))
                .max(Comparator.comparingInt(pizza -> pricePizza(pizza)))
                .get();
    }

    public List iLikeMeat() {
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients()
                        .stream()
                        .anyMatch(Ingredient::isMeat))
                .sorted((o1, o2) ->
                        (int) o2.getIngredients()
                                .stream()
                                .filter( Ingredient::isMeat)
                                .count()
                                - (int) o1.getIngredients()
                                .stream()
                                .filter(Ingredient::isMeat)
                                .count())
                .collect(Collectors.toList());
    }

    public Map groupByPrice() {
        return Arrays.stream(Pizza.values())
                .collect(Collectors.groupingBy(PizzaController::pricePizza));
    }
}
