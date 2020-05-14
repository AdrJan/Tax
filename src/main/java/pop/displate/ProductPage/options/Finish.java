package pop.displate.ProductPage.options;

public enum Finish implements Assertable {
    MATTE("Matte"),
    GLOSS("Gloss");

    private String optionName;
    private final static String NAME = "finish";

    public String getOptionName() {
        return optionName;
    }

    public String getName() {
        return NAME;
    }

    Finish(String optionName) {
        this.optionName = optionName;
    }
}
