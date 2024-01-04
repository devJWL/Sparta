import util.Type;

public class Product extends Menu{
    private double sPrice; // normal size or single size
    private double dPrice; // double size
    private Type type;  // burger, frozen custard, drink, beer

    public Product(String name, String detail, double sPrice, double dPrice, Type type) {
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


    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        // 가격이 한 가지인 항목
        sb.append("가격\n");
        if (dPrice == 0) {
            sb.append(sPrice).append('\n');
            return sb.toString();
        }
        if (type == Type.DRINK){
            sb.append("Regular : ").append(sPrice).append('\n');
            sb.append("Large : ").append(dPrice).append('\n');
        }
        else {
            sb.append("Single : ").append(sPrice).append('\n');
            sb.append("Double : ").append(dPrice).append('\n');
        }
        return sb.toString();
    }
}
