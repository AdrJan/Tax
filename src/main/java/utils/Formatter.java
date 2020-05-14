package utils;

/**
 * Utility class for tests
 *
 * @author Adrian Jankowski.
 */

public class Formatter {

    public static double getFormattedPrice(String text) {
        return Double.valueOf(text.replaceAll("[^\\d.]", "").trim()
        );
    }
}
