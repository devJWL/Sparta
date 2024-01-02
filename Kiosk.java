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
        showMenu();
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

    private Product makeProduct(String name, String detail, double sPrice, double dPrice, String type) {
        Product product = null;
        switch (type) {
            case "Burger" :
                product = new Burger(name, detail, sPrice, dPrice, type);
                burgerList.add(product);
            case "FrozenCustard" :
                product = new FrozenCustard(name, detail, sPrice, dPrice, type);
                frozenCustardList.add(product);
            case "Drink" :
                product = new Drink(name, detail, sPrice, dPrice, type);
                drinkList.add(product);
            case "Beer" :
                product = new Beer(name, detail, sPrice, dPrice, type);
                beerList.add(product);
        }
        productList.add(product);
        return product;
    }

    public void init() {
        String names[] = {"ShackBurger", "SmokeShack", "Shroom Burger", "Shack Stack", "Cheeseburger",
                            "Hamburger", "Shakes", "Shake of the Week", "Red Bean Shake", "Floats", "Cup&Cone", "Concrete",
                            "Shack Attack", "Shack-made Lemonade", "Fresh Brewed Iced Tea", "Fifty/Fifty", "Fountain Soda",
                            "Abita Root Beer", "Bottled Water", "ShackMeister Ale", "Magpie Brewing Co."};

        String details[] = {"토마토, 양상추, 쉑소스가 토핑된 치즈버거", "애플 무드 칩으로 훈연한 베이컨, 매콤한 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                            "몬스터 치즈와 체다 치즈로 ~~ 쉑소스를 올린 베지테리안 버거", "슈룸 버거와 쉑버거의 맛을 한번에 즐길수 있는 메뉴",
                            "포테이토 번과 비프패티, 치즈가 토핑도니 치즈버거", "포테이토 번과 비프패티를 기본으로 토핑을 취향에 따라 선택할 수 있는 버거",
                            "바닐라, 초콜렛, 솔티드 카라멜, 블랙&화이트, 스트로베리, 피넛버터, 커피", "특별한 커스터드 플레이버",
                            "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크", "루트 비어, 퍼플 카우, 크림시클",
                            "바닐라, 초콜렛, Flavor of the Week", "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합",
                            "초콜렛 퍼지 소스, 초콜렛 트러플 쿠키, Lumiere 초콜렛 청크와 스프링클이 들어간 진한 초콜렛 커스터드",
                            "매장에서 직접 만드는 상큰한 레몬에이드(오리지날/시즈널)", "직접 유기농 홍차를 우려낸 아이스티",
                            "레몬에이드와 아이스티의 만남", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프",
                            "청량감 있는 독특한 미국식 무알콜 탄산음료", "지리산 암반대수층으로 만든 프리미엄 생수",
                            "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", "pale Ale, Draft"};

        double sPrices[] = {6.9, 8.9, 9.4, 12.4, 6.9, 5.4, 5.9, 6.5, 6.5, 5.9, 4.9, 5.9, 4.9, 3.9, 3.4, 3.5, 2.7, 4.4, 1.0, 9.8, 6.8};

        double dPrices[] = {10.9, 12.9, 0, 0, 10.9, 9.0, 0, 0, 0, 0, 5.9, 7.9, 8.9, 4.5, 3.9, 4.4, 3.3, 0, 0, 0, 0};

        String types[] = {"Burger", "Burger", "Burger", "Burger", "Burger", "Burger", "FrozenCustard", "FrozenCustard", "FrozenCustard",
                          "FrozenCustard", "FrozenCustard", "FrozenCustard", "FrozenCustard", "Drink", "Drink", "Drink", "Drink",
                          "Drink", "Drink", "Beer", "Beer"};


        for (int i = 0; i < names.length; ++i) {
            makeProduct(names[i], details[i], sPrices[i], dPrices[i], types[i]);
        }
    }
}
