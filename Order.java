import util.ProductType;
import util.SizeType;
import java.util.*;


public class Order {
    // 총 판매상품 맵
    private final Map<String, Double> soldMap = new HashMap<>();
    private Cart cart;
    Scanner sc = new Scanner(System.in);
    public Order(Cart cart) {
        this.cart = cart;
    }
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String addCart(List<Product> products){

        for (int i = 0; i < products.size(); ++i) {
            System.out.print(i + 1 + ". ");
            System.out.println(products.get(i));
        }

        int select = sc.nextInt() - 1;

        Product product = new Product(products.get(select));
        StringBuffer sb = new StringBuffer();

        if (product.getdPrice() != 0.0) {
            System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
            if (product.getType() == ProductType.DRINK) {
                System.out.print("1. Regular (₩" + product.getsPrice() + ")   ");
                System.out.println("2. Large (₩" + product.getdPrice() + ")");
                select = sc.nextInt();
                if (select == 1) {
                    sb.append(product.getName()).append(" (Regular) | ₩")
                            .append(String.valueOf(product.getsPrice()))
                            .append(" | ")
                            .append(product.getDetail());
                    product.setName(product.getName() + "(Regular)");
                }
                else {
                    sb.append(product.getName()).append(" (Large)  | ₩")
                            .append(String.valueOf(product.getdPrice()))
                            .append(" | ")
                            .append(product.getDetail());
                    product.setName(product.getName() + "(Large)");
                }
            }
            else {
                System.out.print("1. Single (₩" + product.getsPrice() + ")   ");
                System.out.println("2. Double (₩" + product.getdPrice() + ")");
                select = sc.nextInt();
                if (select == 1) {
                    sb.append(product.getName()).append(" (Single) | ₩")
                            .append(String.valueOf(product.getsPrice()))
                            .append(" | ")
                            .append(product.getDetail());
                    product.setName(product.getName() + "(Single)");
                }
                else {
                    sb.append(product.getName()).append(" (Double) | ₩")
                            .append(String.valueOf(product.getdPrice()))
                            .append(" | ")
                            .append(product.getDetail());
                    product.setSize(SizeType.DOUBLE);
                    product.setName(product.getName() + "(Double)");
                }
            }
        }
        else {
            sb.append(product.getName())
                    .append(" | ₩")
                    .append(String.valueOf(product.getsPrice()))
                    .append(" | ")
                    .append(product.getDetail());
        }
        System.out.println(sb.toString());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
        select = sc.nextInt();
        String message = "";
        if (select == 1) {
            cart.addCart(product);
            message = product.getName() + " 가 장바구니에 추가되었습니다.";
        }
        return message;
    }

    public void buy() throws InterruptedException {
        Set<Product> products = cart.getSet();
        if (products.size() == 0) return;
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[ Orders ]");

        double total = 0;

        for (Product product : products) {
            int cnt = cart.getMenuHash().get(product);
            double price;
            if (product.getSize().getValue() == SizeType.NORMAL.getValue()) {
                price = product.getsPrice();
            }
            else {
                price = product.getdPrice();
            }

            StringBuffer sb = new StringBuffer();
            sb.append(product.getName()).append(" | ₩").append(price).append(" | ").append(cnt).append("개")
                    .append(" | ").append(product.getDetail());
            System.out.println(sb.toString());
            total += price * cart.getMenuHash().get(product);
        }

        System.out.println("[ Total ]");
        System.out.printf("₩%.1f\n", total);
        System.out.println("1. 주문하기    2. 메뉴판으로 돌아가기");
        int sel = sc.nextInt();

        if (sel == 1) {
            // 총 판매상품 목록 현황 구현
            for (Product product : products) {
                int cnt = cart.getMenuHash().get(product);
                double price;
                if (product.getSize().getValue() == SizeType.NORMAL.getValue()) {
                    price = product.getsPrice();
                }
                else {
                    price = product.getdPrice();
                }
                soldMap.put(product.getName(), soldMap.getOrDefault(product.getName(), 0.0) + price * cnt);
            }
            cart.clear();
            System.out.println("주문이 완료되었습니다!\n");
            System.out.println("대기번호는 [ " + Cart.getOrderCount() + " ] 번 입니다.");
            System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
            Thread.sleep(3000);
            Cart.setOrderCount(Cart.getOrderCount() + 1);
        }
    }
    public String cancel() {
        String message = "";
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        int select = sc.nextInt();
        if (select == 1){
            cart.clear();
            message = "진행하던 주문이 취소되었습니다.";
        }
        return message;
    }

    public void totalList() {
        if (soldMap.size() == 0) return;
        System.out.println(" [ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.\n");

        for (Map.Entry<String, Double> entry : soldMap.entrySet()) {
            System.out.println(entry.getKey() + " | ₩" + entry.getValue());
        }

        System.out.println();
        System.out.println("1. 돌아가기");

        int sel = 0;
        while(true) {
            sel = sc.nextInt();
            if (sel == 1) {
                break;
            }
        }
    }
}
