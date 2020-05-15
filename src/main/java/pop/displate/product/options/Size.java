package pop.displate.product.options;

public enum Size implements Assertable {
    M("M"),
    L("L"),
    XL("XL");

    private final static String NAME = "size";
    private String optionName;

    public String getOptionName() {
        return optionName;
    }

    public String getName() {
        return NAME;
    }

    Size(String optionName) {
        this.optionName = optionName;
    }
}
