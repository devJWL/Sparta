public class Product extends Menu{
    private double sPrice; // normal size or single size
    private double dPrice; // double size
    private String type;  // burger, frozen custard, drink, beer

    public Product(String name, String detail, double sPrice, double dPrice, String type) {
        super(name, detail);
        this.sPrice = sPrice;
        this.dPrice = dPrice;
        this.type = type;
    }

    public double getsPrice() {
        return sPrice;
    }

    public void setsPrice(double sPrice) {
        this.sPrice = sPrice;
    }

    public double getdPrice() {
        return dPrice;
    }

    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append("Single : ").append(sPrice);
        sb.append("Double : ").append(dPrice);
        return sb.toString();
    }
}
