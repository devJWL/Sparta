import util.Type;
import java.util.ArrayList;
import java.util.List;

public class Kiosk {

    Order order;
    List<Product> burgerList;
    List<Product> frozenCustardList;
    List<Product> drinkList;
    List<Product> beerList;
    List<Product> productList;

    public Kiosk() {
        order = new Order();
        burgerList = new ArrayList<>();
        frozenCustardList = new ArrayList<>();
        drinkList = new ArrayList<>();
        beerList = new ArrayList<>();
        productList = new ArrayList<>();
        init();


    }

    public void run() {

    }


    public void showMenu() {
        System.out.println("SHAKESHACK BURGER에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");

        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. Burgers          |   앵거스 비프 통살을 다져만든 버거" );
        System.out.println("2. Frozen Custard   |   매장에서 신선하게 만드는 아이스크림" );
        System.out.println("3. Drinks           |   매장에서 직접 만드는 음료" );
        System.out.println("4. Beer             |   뉴욕 브루클린 브루어리에서 양조한 맥주" );

        System.out.println("[ ORDER MENU ]");
        System.out.println("5. Order            |   장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel           |   진행중인 주문을 취소합니다.");
    }

    private Product makeProduct(String name, String detail, double sPrice, double dPrice, Type type) {
        Product product = new Product(name, detail, sPrice, dPrice, type);
        switch (type) {
            case BURGER -> burgerList.add(product);
            case FROZEN_CUSTARD -> frozenCustardList.add(product);
            case DRINK -> drinkList.add(product);
            case BEER -> beerList.add(product);
        }
        productList.add(product);
        return product;
    }

    public void init() {

    }
}
