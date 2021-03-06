package pop.automation_practice.navigation;

/**
 * Enum for specific categories in main menu.
 *
 * @author Adrian Jankowski
 */

public enum MainNavItems {
    WOMEN("Women"),
    DRESSES("Dresses"),
    T_SHIRTS("T-shirts");

    private final String label;

    MainNavItems(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
