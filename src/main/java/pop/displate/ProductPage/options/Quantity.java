package pop.displate.ProductPage.options;

public class Quantity implements Assertable {

    private final int quantity;

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getOptionName() {
        return String.valueOf(quantity);
    }

    @Override
    public String getName() {
        return "quantity";
    }
}
