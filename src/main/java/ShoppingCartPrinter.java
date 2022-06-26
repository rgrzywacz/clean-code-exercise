public class ShoppingCartPrinter {
    public void printShoppingCart(ShoppingCart shoppingCart) {
        System.out.println("Products: ");
        shoppingCart.getProductList().forEach(product -> System.out.println("Product name: " + product.getName() + ", cost: " + product.getCost()));
        System.out.println("Total cost: " + shoppingCart.getSum());
    }
}
