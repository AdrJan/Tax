package utils;

/**
 * Utility class for tests
 *
 * @author Adrian Jankowski.
 */

public class Formatter {

    public static double getFormattedPrice(String text) {
        return Double.parseDouble(text.replaceAll("[^\\d.]", "").trim());
    }
}
