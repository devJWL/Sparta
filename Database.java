import util.ProductType;

import java.util.HashMap;
import java.util.Map;

public class Database {
    // 데이터베이스
    private final Map<Integer, Product> database;
    // 이름을 통하여 일련번호를 가져오기 위한 맵
    private final Map<String, Integer> getNoMap;
    private static int no = 1;

    Database() {
        database = new HashMap<>();
        getNoMap = new HashMap<>();
        init();
    }

    public Map<Integer, Product> getDatabase() {
        return database;
    }
    public Map<String, Integer> getGetNoMap() {
        return getNoMap;
    }
    public int getNo() {
        return no;
    }

    public void add(Product product) {
        database.put(no, product);
        getNoMap.put(product.getName(), no);
        ++no;
    }

    public void delete(Product product) {
        database.remove(product.getNo());
    }

    public Product find(Product product){
        return find(product.getNo());
    }
    public Product find(int no) {
        return database.get(no);
    }
    public Product find(String name) {
        return find(getNoMap.get(name));
    }

    public void init () {
        // int no, String name, String detail, double sPrice, double dPrice, TypeEnum type
        this.add(new Product(no,"ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9, 10.9, ProductType.BURGER));
        this.add(new Product(no, "SmokeShack", "애플우드 칩으로 훈연한 베이컨, 쉑소스가 토핑된 치즈 버거", 8.9, 12.9, ProductType.BURGER));
        this.add(new Product(no, "Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채우고, 쉑소를 올린 베지테리안 버거", 9.4, 0.0, ProductType.BURGER));
        this.add(new Product(no, "Shack Stack", "슈룸 버거와 쉑버거의 맛을 한번에 즐길 수 있는 메뉴", 12.4, 0.0, ProductType.BURGER));
        this.add(new Product(no, "Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9, 10.9, ProductType.BURGER));
        this.add(new Product(no, "Hamburger", "포테이토 번과 비프패티를 기반, 토핑을 취향에 따라 선택할 수 있는 버거", 5.4, 9.0, ProductType.BURGER));



        this.add(new Product(no, "Shakes", "바닐라, 초콜렛, 솔티드 카라멜", 5.9, 0, ProductType.FROZEN_CUSTARD));
        this.add(new Product(no, "Shake of the Week", "특별한 커스터드 플레이버", 6.5, 0, ProductType.FROZEN_CUSTARD));
        this.add(new Product(no, "Red Bean Shake", "신선한 커스터드와 함께 우유와 레드빈이 블랜딩 된 시즈널 쉐이크", 6.5, 0, ProductType.FROZEN_CUSTARD));
        this.add(new Product(no, "Floats", "루트 비어, 퍼플 카우, 크림시클", 5.9, 0, ProductType.FROZEN_CUSTARD));
        this.add(new Product(no, "Cups & Cones", "바닐라, 초콜렛, Flavor of the Week", 4.9, 5.9, ProductType.FROZEN_CUSTARD));
        this.add(new Product(no, "Concretes", "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합", 5.9, 8.9, ProductType.FROZEN_CUSTARD));


        this.add(new Product(no,"Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드", 3.9, 4.5, ProductType.DRINK));
        this.add(new Product(no,"Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티", 3.4, 3.9, ProductType.DRINK));
        this.add(new Product(no,"Fifty/Fifty", "레몬에이드와 아이스티의 만남", 3.5, 4.4, ProductType.DRINK));
        this.add(new Product(no,"Fountain  Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", 2.7, 3.3, ProductType.DRINK));
        this.add(new Product(no,"Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 탄산음료", 4.4, 0.0, ProductType.DRINK));
        this.add(new Product(no,"Bottled Water", "지리산 암반대수층으로 만든 프리미엄 생수", 1.0, 0.0, ProductType.DRINK));


        this.add(new Product(no,"ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일맥주",
                        9.8, 0, ProductType.BEER));
        this.add(new Product(no,"Magpie Brewing Co.", "상세설명 없음",
                6.8, 0, ProductType.BEER));
    }
}
