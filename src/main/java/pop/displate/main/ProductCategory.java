package pop.displate.main;

/**
 * Enum representing all product categories on main page of www.displate.com.
 *
 * @author Adrian Jankowski
 */

public enum ProductCategory {
    BESTELLING("bestselling"),
    DISPLATE_EXCLUSIVE("displate exclusive");

    private String name;

    public String getName() {
        return name;
    }

    ProductCategory(String name) {
        this.name = name;
    }
}
