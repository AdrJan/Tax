package utils;

/**
 * Utility class for tests
 *
 * @author Adrian Jankowski.
 */

public class Formatter {

    /**
     * Method for formatting text value to double. Used in cases
     * where you want to get numeric value from a text retrieved
     * from WebElement.
     *
     * @param text text you want to format
     * @return double value responding that text
     */
    public static double formatToDouble(String text) {
        return Double.parseDouble(text.replaceAll("[^\\d.]", "").trim()
        );
    }
}
