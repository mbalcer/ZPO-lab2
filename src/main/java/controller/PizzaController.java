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
                .sorted(Comparator.comparing(pizza ->
                        pizza.getIngredients()
                             .stream()
                             .filter(Ingredient::isMeat)
                             .count(), Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    public Map groupByPrice() {
        return Arrays.stream(Pizza.values())
                .collect(Collectors.groupingBy(PizzaController::pricePizza));
    }

    public String formatedMenu() {
        return Arrays.stream(Pizza.values())
                .map(pizza -> {
                    return String.format("%s: %s - %d",
                            pizza.getName(),
                            pizza.getIngredients()
                                    .stream()
                                    .map(Ingredient::getName)
                                    .collect(Collectors.joining(",")),
                            pricePizza(pizza));
                })
                .collect(Collectors.joining("\n"));
    }
}
