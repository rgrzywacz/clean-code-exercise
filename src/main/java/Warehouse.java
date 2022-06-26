public class Warehouse {

    public static Product[] initializeWarehouse() {
        int i = 1;
        Product[] items = new Product[2];
        items[0] = new Product(i++, 2, "Papier biurowy", 24.90);
        items[1] = new Product(i++, 10, "Nożyczki", 7.99);

        return items;
    }

}
