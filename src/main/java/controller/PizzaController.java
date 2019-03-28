package controller;

import attachments.Ingredient;
import attachments.Pizza;

import java.util.Arrays;
import java.util.Comparator;

public class PizzaController {

    private Integer pricePizza(Pizza pizza) {
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
}
