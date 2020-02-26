package utils;

/**
 * Utility class for test.
 */

public class Formatter {

    public static double getFormattedPrice(String text) {
        return Double.valueOf(text.trim().replace('$', ' '));
    }
}
