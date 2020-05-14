package pop.displate.ProductPage;

import pop.displate.ProductPage.options.Finish;
import pop.displate.ProductPage.options.Frame;
import pop.displate.ProductPage.options.Quantity;
import pop.displate.ProductPage.options.Size;

public class ProductParameters {

    private Finish finish;
    private Frame frame;
    private Size size;
    private Quantity quantity;

    public ProductParameters() {
        finish = Finish.MATTE;
        frame = Frame.GRAPHITE;
        size = Size.L;
        quantity = new Quantity(1);
    }

    public Finish getFinish() {
        return finish;
    }

    public void setFinish(Finish finish) {
        this.finish = finish;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }
}
