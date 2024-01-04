import util.MenuType;
import util.ProductType;

import java.sql.Array;
import java.util.*;

import static util.MenuType.*;


public class Kiosk {
    private final Database database;
    private final Map<Integer, ArrayList<Product>> listMap;
    private final List<Product> productList;
    private final Order order;
    private final Cart cart;
    private Scanner sc;
    private String prevWork = "";


    public Kiosk() {
        database = new Database();
        listMap = new HashMap<>();
        for (int i = ProductType.START.ordinal() + 1; i < ProductType.END.ordinal(); ++i) {
            listMap.put(i, new ArrayList<>());
        }
        productList = new ArrayList<>();
        cart = new Cart();
        order = new Order(cart);
        sc = new Scanner(System.in);
        init();
    }

    public void run() throws InterruptedException {
        while(true) {
            showMenu();
            int sel = sc.nextInt();
            // 메뉴 선택
            if (sel >= BURGERS.ordinal() && sel <= BEER.ordinal()) {
                System.out.println("SHAKESHACK BURGER에 오신걸 환영합니다.");
                System.out.println("아래 상품메뉴판을 보시고 메뉴를 골라 입력해주세요.");
                List<Product> products = listMap.get(sel);
                String type = "";
                if (sel == BURGERS.ordinal()) {
                   type = "Burgers MENU";
                }
                else if (sel == FROZEN_CUSTARD.ordinal()) {
                    type = "ForzenCustard MENU";
                }
                else if (sel == DRINKS.ordinal()) {
                    type = "Drinks MENU";
                }
                else {
                    type = "Beer MENU";
                }
                System.out.println(" [ " + type + " ]");
                prevWork = order.buy(products);
            }
            else if(sel == ORDER.ordinal()) {
                order.order();
            }
            else if (sel == CANCEL.ordinal()) {
                order.cancel();
            }
         }
    }
    private void init (){
        List<Product> products = new ArrayList<>(database.getDatabase().values());
        for (Product product : products) {
            switch (product.getType()) {
                case BURGER -> listMap.get(ProductType.BURGER.ordinal()).add(product);
                case FROZEN_CUSTARD -> listMap.get(ProductType.FROZEN_CUSTARD.ordinal()).add(product);
                case DRINK -> listMap.get(ProductType.DRINK.ordinal()).add(product);
                case BEER -> listMap.get(ProductType.BEER.ordinal()).add(product);
            }
            productList.add(product);
        }
    }
    private void showMenu() {

        if (!prevWork.equals("")) {
            System.out.println(prevWork);
            System.out.println();
            prevWork = "";
        }
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
}
