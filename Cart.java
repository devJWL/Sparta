import util.SizeType;

import java.util.*;


public class Cart {

    // 장바구니에 담긴 상품의 숫자를 가지고 있는 HashMap
    private final Map<Product, Integer> menuHash;
    // 장바구니에 담긴 상품 (순서를 유지)을 가지고있는 LinkedHashSet
    private final Set<Product> linkedSet;
    private static int orderCount = 1;

    public Cart() {
        this.menuHash = new HashMap<>();
        this.linkedSet = new LinkedHashSet<>();
    }

    public Map<Product, Integer> getMenuHash() {
        return menuHash;
    }

    public Set<Product> getSet() {
        return linkedSet;
    }

    public static int getOrderCount() {
        return orderCount;
    }
    public static void setOrderCount(int orderCount) {
        Cart.orderCount = orderCount;
    }

    // 장바구니에 추가하는 메소드
    public void addCart (Product product) {
        linkedSet.add(product);
        menuHash.put(product, menuHash.getOrDefault(product, 0) + 1);
    }

    // 장바구니를 비우는 메소드
    public void clear() {
        linkedSet.clear();
        menuHash.clear();
    }
}
