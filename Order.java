import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Order {
    Map<Product, Integer> menuList;
    public Order() {
        this.menuList = new HashMap<>();
    }
    // 장바구니에 추가하는 메소드
    public void addOrder(Product product) {
        menuList.put(product, menuList.getOrDefault(product, 0) + 1);
    }


    // 장바구니를 비우는 메소드
    public void orderCancel() {
        menuList.clear();
    }


    // 물품의 갯수를 한개씩 빼는 메소드
    public void substractOrder(Product product) {
        int cnt = menuList.getOrDefault(product, -1);
        // 장바구니에 없는 물건이 input으로 들어온 경우
        if (cnt == -1) return;
        --cnt;
        // 마지막 한 개를 비운 경우
        if (cnt == 0) {
            menuList.remove(product);
        }
        // 한개 이상 남은 경우
        else {
            menuList.put(product, cnt);
        }
    }
}
