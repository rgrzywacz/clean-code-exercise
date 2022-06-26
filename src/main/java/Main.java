import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

            Warehouse warehouse = new Warehouse();

            ShoppingOperations shoppingOperations = new ShoppingOperations();
            ShoppingCart shoppingCart = new ShoppingCart();

            Product paperOfficeOne = shoppingOperations.addItem("Papier biurowy");
            Product paperOfficeTwo = shoppingOperations.addItem("Papier biurowy");

            shoppingCart.setProductList(Arrays.asList(paperOfficeTwo, paperOfficeOne));
            shoppingCart.setSum(shoppingOperations.sumShoppingCart(shoppingCart));

            ShoppingCartPrinter shoppingCartPrinter = new ShoppingCartPrinter();
            shoppingCartPrinter.printShoppingCart(shoppingCart);
            Product paperOfficeThree = shoppingOperations.addItem("Papier biurowy");
    }
}

