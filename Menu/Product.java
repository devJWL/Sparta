package Menu;

public class Product {
    // 상품의 이름
    private String name;
    // 상품 상세 설명
    private String detail;
    // 상품의 타입
    private String type;  // burger, frozen, drink, beer
    // 상품의 가격
    double price;
    // 상품의 사이즈
    private String size;   // single, double

    public Product(String name, String detail, String type, double price, String size) {
        this.name = name;
        this.detail = detail;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
