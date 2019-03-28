package controller;

import attachments.Ingredient;
import attachments.Pizza;

import java.util.Arrays;
import java.util.Comparator;

public class PizzaController {

    public Pizza findCheapestSpicy() {
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients()
                        .stream()
                        .anyMatch(Ingredient::isSpicy))
                .min(Comparator.comparingInt(pizza ->
                        pizza.getIngredients()
                                .stream()
                                .mapToInt(Ingredient::getPrice)
                                .sum()))
                .get();
    }
}
