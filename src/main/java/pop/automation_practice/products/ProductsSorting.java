package pop.automation_practice.products;

public enum ProductsSorting {
    PRICE_ASC("price:asc"),
    PRICE_DESC("price:desc"),
    NAME_ASC("name:asc"),
    NAME_DESC("name:desc");

    String optionValue;

    ProductsSorting(String optionValue) {
        this.optionValue = optionValue;
    }

    public String getOptionValue() {
        return optionValue;
    }
}
