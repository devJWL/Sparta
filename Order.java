import util.ProductType;
import util.SizeType;

import java.util.List;
import java.util.Scanner;

public class Order {
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

    public String buy(List<Product> products){

        for (int i = 0; i < products.size(); ++i) {
            System.out.print(i + 1 + ". ");
            System.out.println(products.get(i));
        }

        // 인덱스는 0부터 시
        int select = sc.nextInt() - 1;
//        int first = 0;
//        int last = products.size();
//        while(true) {
//            select = sc.nextInt();
//            // 올바른 선택
//            if (select > first && select < last) {
//                break;
//            }
//        }
        Product product = products.get(select);
        StringBuffer sb = new StringBuffer();
        if (product.getdPrice() != 0) {
            System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
            if (product.getType() == ProductType.DRINK) {
                System.out.print("1. Regular (" + product.getsPrice() + ")   ");
                System.out.println("2. Large (" + product.getdPrice() + ")");
                select = sc.nextInt();
                if (select == 1) {
                    sb.append(product.getName()).append(" (Regular)  ")
                            .append(String.valueOf(product.getsPrice()))
                            .append("  ")
                            .append(product.getDetail());
                }
                else {
                    sb.append(product.getName()).append(" (Large)  ")
                            .append(String.valueOf(product.getdPrice()))
                            .append("  ")
                            .append(product.getDetail());
                    product.setSize(SizeType.LARGE);
                }
            }
            else {
                System.out.print("1. Single (" + product.getsPrice() + ")   ");
                System.out.println("2. Double (" + product.getdPrice() + ")");
                select = sc.nextInt();
                if (select == 1) {
                    sb.append(product.getName()).append(" (Single)  ")
                            .append(String.valueOf(product.getsPrice()))
                            .append("  ")
                            .append(product.getDetail());
                }
                else {
                    sb.append(product.getName()).append(" (Double)  ")
                            .append(String.valueOf(product.getdPrice()))
                            .append("  ")
                            .append(product.getDetail());

                    product.setSize(SizeType.DOUBLE);
                }
            }
        }
        else {
            sb.append(product.toString());
        }
        System.out.println(sb.toString());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
        select = sc.nextInt();
        if (select == 1) {
            cart.addOrder(product);
            return product.getName() + " 가 장바구니에 추가되었습니다.";
        }
        return "";
    }

    public void order() throws InterruptedException {
        List<Product> products = cart.getMenuList();
        if (products.size() == 0) return;
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[ Orders ]");

        double total = 0;
        for (Product product : products) {
            int cnt = cart.getMenuHash().get(product.getNo());
            double price;
            if (product.getSize().getValue() == SizeType.NORMAL.getValue()) {
                price = product.getsPrice();
            }
            else {
                price = product.getdPrice();
            }
            StringBuffer sb = new StringBuffer();
            sb.append(product.getName()).append(" | ").append(price).append(" | ").append(cnt).append("개")
                    .append(" | ").append(product.getDetail());
            System.out.println(sb.toString());
            total += price;
        }
        System.out.println("[ Total ]");
        System.out.println(total);
        System.out.println("1. 주문    2. 메뉴판");
        int sel = sc.nextInt();

        if (sel == 1) {
            cart.clear();
            System.out.println("주문이 완료되었습니다!\n");
            System.out.println("대기번호는 [ " + Cart.getOrderCount() + " ] 번 입니다.");
            System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
            Thread.sleep(3000);
            Cart.setOrderCount(Cart.getOrderCount() + 1);
        }
    }
    public void cancel() {
        cart.clear();
    }
}
