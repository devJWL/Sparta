import util.ProductType;
import util.SizeType;

import java.util.Objects;


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

    public Product(Product product) {
        super(product.getNo(), product.getName(), product.getDetail());
        this.sPrice = product.sPrice;
        this.dPrice = product.dPrice;
        this.type = product.type;
        this.size = product.getSize();
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
            sb.append("Regular : ₩").append(sPrice).append("    ");
            sb.append("Large : ₩").append(dPrice);
        }
        else {
            sb.append("Single : ₩").append(sPrice).append("    ");
            sb.append("Double : ₩").append(dPrice);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Double.compare(product.sPrice, sPrice) == 0
                && Double.compare(product.dPrice, dPrice) == 0
                && type == product.type && size == product.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sPrice, dPrice, type, size);
    }
}
