package Menu;

public class Product {
    // 상품의 이름
    private String name;
    // 상품 상세 설명
    private String detail;
    // 상품의 타입
    // 상품의 가격
    double price;
    // 상품의 사이즈
    private String size;   // single, double

    public Product(String name, String detail, double price, String size) {
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String toString () {
        StringBuilder output = new StringBuilder();
        output.append(name); output.append('\n');
        output.append(detail); output.append('\n');
        output.append(price); output.append('\n');
        if (size != null) {
            output.append(size); output.append('\n');
        }
        return output.toString();
    }
}
