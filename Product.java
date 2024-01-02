public class Product extends Menu{
    private double price;
    private boolean hasOption; // ture 사이즈 선택 가능

    public Product(String name, String detail, double price, boolean hasOption) {
        super(name, detail);
        this.price = price;
        this.hasOption = hasOption;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHasOption() {
        return hasOption;
    }

    public void setHasOption(boolean hasOption) {
        this.hasOption = hasOption;
    }
}
