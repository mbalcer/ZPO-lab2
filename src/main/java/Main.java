import attachments.Pizza;
import controller.PizzaController;

public class Main {
    public static void main(String[] args) {
        PizzaController pizzaController = new PizzaController();

        System.out.println("Najtańsza ostra pizza: ");
        System.out.println(pizzaController.findCheapestSpicy());

        System.out.println("\nNajdroższa pizza wegetariańska: ");
        System.out.println(pizzaController.findMostExpensiveVegetarian());

        System.out.println("\nPizze mięsne: ");
        System.out.println(pizzaController.iLikeMeat());

        System.out.println("\nPizze pogrupowane po cenie: ");
        System.out.println(pizzaController.groupByPrice());

        System.out.println("\nMenu: ");
        System.out.println(pizzaController.formatedMenu());
    }
}
