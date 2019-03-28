import controller.PizzaController;

public class Main {
    public static void main(String[] args) {
        PizzaController pizzaController = new PizzaController();

        System.out.println(pizzaController.findCheapestSpicy());
    }
}
