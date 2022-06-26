public class ShoppingOperations {

    public static Product[] warehouse = Warehouse.initializeWarehouse();

    public Double sumShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCart.getProductList().stream().mapToDouble(Product::getCost).sum();
    }

    private boolean checkIsProductExists(String name) throws NullPointerException {
        for (int i = 0; i < warehouse.length; i++) {
            if (warehouse[i].getName().equals(name)) {
                return true;
            } else {
                throw new NullPointerException("Produkt o nazwie: " + name + " nie jest dostępny.");
            }
        }
        return false;
    }

    private boolean checkProductNameIsCorrect(String name) {
        return name != null && name.length() > 2;
    }

    private boolean checkProductQuantity(Product product) throws IllegalArgumentException {
        if (product.getQuantity() > 1) {
            return true;
        } else {
            throw new IllegalArgumentException("Produkt o nazwie: " + product.getName() + " nie jest dostępny. Stan magazynowy to zero.");
        }
    }

    public Product addItem(final String name) {
        try {
            if (checkProductNameIsCorrect(name) && checkIsProductExists(name)) {
                for (Product product : warehouse) {
                    if (checkProductQuantity(product)) {
                        int quantity = product.getQuantity();
                        product.setQuantity(--quantity);
                        System.out.println("Produkt: " + name + " został dodany do koszyka");
                        return product;
                    }
                }
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Nieoczekiwany błąd");
            e.printStackTrace();
        }
        return null;
    }

}
