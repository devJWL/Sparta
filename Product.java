import util.ProductType;
import util.SizeType;


public class Product extends Menu{
    private double sPrice; // Normal or Single or Regular
    private double dPrice; // Double or Large
    private final ProductType type;  //     BURGER, FROZEN_CUSTARD, DRINK, BEER
    private SizeType size = SizeType.NORMAL;  // NORMAL == SINGLE == REGULER,  DOUBLE == LARGE

    public Product(int no, String name, String detail, double sPrice, double dPrice, ProductType type) {
        super(no, name, detail);
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

    public ProductType getType() {
        return type;
    }

    public SizeType getSize() {
        return size;
    }

    public void setSize(SizeType size) {
        this.size = size;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        // 가격이 한 가지인 항목
        sb.append("    가격 -> ");
        if (dPrice == 0) {
            sb.append(sPrice);
            return sb.toString();
        }
        if (type == ProductType.DRINK){
            sb.append("Regular : ").append(sPrice).append("    ");
            sb.append("Large : ").append(dPrice);
        }
        else {
            sb.append("Single : ").append(sPrice).append("    ");
            sb.append("Double : ").append(dPrice);
        }
        return sb.toString();
    }
}
