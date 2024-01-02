public class Product extends Menu{
    private double sPrice;
    private double dPrice;
    private boolean hasOption; // ture 사이즈 선택 가능

    public Product(String name, String detail, double sPrice, double dPrice, boolean hasOption) {
        super(name, detail);
        this.sPrice = sPrice;
        this.dPrice = dPrice;
        this.hasOption = hasOption;
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

    public boolean isHasOption() {
        return hasOption;
    }

    public void setHasOption(boolean hasOption) {
        this.hasOption = hasOption;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append("Single : ").append(sPrice);
        sb.append("Double : ").append(dPrice);
        return sb.toString();
    }
}
