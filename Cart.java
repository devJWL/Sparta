import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Cart {
    private final List<Product> menuList;
    private final Map<Integer, Integer> menuHash;
    private static int orderCount = 1;
    public Cart() {
        this.menuList = new ArrayList<>();
        this.menuHash = new HashMap<>();
    }

    public List<Product> getMenuList() {
        return menuList;
    }
    public Map<Integer, Integer> getMenuHash() {
        return menuHash;
    }
    public static int getOrderCount() {
        return orderCount;
    }
    public static void setOrderCount(int orderCount) {
        Cart.orderCount = orderCount;
    }

    // 장바구니에 추가하는 메소드
    public void addOrder(Product product) {
        menuList.add(product);
        menuHash.put(product.getNo(), menuHash.getOrDefault(product.getNo(), 0) + 1);
    }

    // 장바구니를 비우는 메소드
    public void clear() {
        menuList.clear();
        menuHash.clear();
    }

    // 물품의 갯수를 한개씩 빼는 메소드
    public void substractOrder(Product product) {
        int cnt = menuHash.getOrDefault(product, -1);
        // 장바구니에 없는 물건이 input으로 들어온 경우
        if (cnt == -1) return;
        --cnt;
        // 마지막 한 개를 비운 경우
        if (cnt == 0) {
            menuList.remove(product);
            menuHash.remove(product);
        }
        // 한 개 이상 남은 경우
        else {
            menuHash.put(product.getNo(), cnt);
        }
    }
}
