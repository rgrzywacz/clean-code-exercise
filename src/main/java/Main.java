import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static Product[] x = initializeWarehouse();

    public static void main(String[] args) {

            ShoppingCart shoppingCart = new ShoppingCart();
            Product papier_biurowy = AddItem("Papier biurowy");
            Product papier_biurowy1 = AddItem("Papier biurowy");

            shoppingCart.setProductList(Arrays.asList(papier_biurowy1, papier_biurowy));
            shoppingCart.setSum(SumBasket(shoppingCart));
            printhoopingcart(shoppingCart);

            Product spinacze = AddItem("Spinacze biurowe");
            Product papier_biurowy2= AddItem("Papier biurowy");

    }

    private static void printhoopingcart(ShoppingCart shoppingCart) {
        System.out.println("Products: ");
        shoppingCart.getProductList().forEach(p -> {
            System.out.println("Product name: " + p.GetName()+ ", cost: "+ p.getCost());
        });
        System.out.println("Total cost: " + shoppingCart.getSum());
    }

    private static Double SumBasket(ShoppingCart shoppingCart) {
        return shoppingCart.getProductList().stream().map(p -> p.getCost()).collect(Collectors.summingDouble(Double::doubleValue));
    }

    private static String AddItems(String[] names) throws Exception {
        String items = "";
        for (String name : names) {
            if (name != null) {
                if (name.length() > 2) {
                    int tablesize = x.length;
                    for(int i = 0; i < tablesize; i++)
                    {
                        if (x[i].GetName().equals(name)) {
                            if (x[i].getQuantity() > 0 ) {
                                Product scissors = x[i];
                                int quantity = scissors.getQuantity();
                                int quantity2 = quantity - 1;
                                scissors.setQuantity(quantity2);
                                items = items + " "+scissors;
                            } else
                            {
                                System.exit(1);
                            }
                        }
                        else {
                            throw new NullPointerException("Product called: " + name +" is nov available.");
                        }
                    }
                }
            }
        }
        return items;
    }
    private static Product AddItem(final String name)
    {
        try {
            if (name != null) {
                if (name.length() > 2) {
                    int tablesize = x.length;
                    for (int i = 0; i < tablesize; i++) {
                        if (x[i].GetName().equals(name)) {
                            if (x[i].getQuantity() > 0) {
                                Product scissors = x[i];
                                int quantity = scissors.getQuantity();
                                int quantity2 = quantity - 1;
                                scissors.setQuantity(quantity2);
                                System.out.println(name + " został dodany do koszyka");
                                return scissors;
                            } else {
                                System.exit(2);
                            }
                        } else {
                            throw new NullPointerException("Product called: " + name + " is nov available.");
                        }
                    }
                }
            }
        }
        catch (RuntimeException e ) {
            System.err.println("Product called: " + name +" is nov available.");
        }
        return null;
    }

    private static Product[] initializeWarehouse() {
        int i = 1;
        Product[] ItemArray = new Product[2];
        if (ItemArray != null ) {
            ItemArray[0] = new Product(i++, 2, "Papier biurowy", 24.90);
            ItemArray[1] = new Product(i++, 10, "Nożyczki", 7.99);
        }

        return ItemArray;
    }
}


/**
 * Bugi
 * 1. Raz posługujemy się Product, raz ItemArray a raz x - trzeba to uspójnić (złe zmienne)
 * 2. Niepotrzebny kod - sprawdzanie czy ItemArray jest różny od null (nigdy nie będzie nullem)
 * 3. Do poprawy System.exit(1) - nie powinno tego być, powinien być wyrzucony wyjątek
 * 4. Do poprawienia logika metody  AddItem - jest zawiła i można ją uprościć
 * 5. Do poprawy nazwy metod, które są dużymy literami
 */
