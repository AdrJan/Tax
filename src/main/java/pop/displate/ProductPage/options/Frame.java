package pop.displate.ProductPage.options;

public enum Frame implements Assertable {
    NO_FRAME("No frame"),
    NATURAL_WOOD_PATTERN("Natural wood pattern"),
    GRAPHITE("Graphite"),
    WHITE_WOOD_PATTERN("White wood pattern"),
    BLACK_WOOD_PATTERN("Black wood pattern");

    private final static String NAME = "frames";
    String optionName;

    public String getOptionName() {
        return optionName;
    }

    public String getName() {
        return NAME;
    }

    Frame(String optionName) {
        this.optionName = optionName;
    }
}
