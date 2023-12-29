import Menu.*;
import java.util.ArrayList;
import java.util.List;


// 메뉴의 리스트를 가지고 있는 클래스
public class MenuBoard{

    List<Product> allList;
    List<Burger> burgerList;
    List<FrozenCustard> frozenCustardList;
    List<Drink> drinkList;
    List<Beer> beerList;

    public MenuBoard() {
        allList = new ArrayList<> ();
        burgerList = new ArrayList<>();
        frozenCustardList = new ArrayList<>();
        drinkList = new ArrayList<>();
        beerList = new ArrayList<>();
    }
    // String name, String detail, String type, double price, String size
    public Product makeProduct(String type, String name, String detail, double price, String size) {
        if (type.equals("Burger")) {
            Burger product = new Burger(name, detail, price, size);
            allList.add(product);
            burgerList.add(product);
            return product;
        }
        else if (type.equals("FrozenCustard")) {
            FrozenCustard product = new FrozenCustard(name, detail, price, size);
            allList.add(product);
            frozenCustardList.add(product);
            return product;
        }
        else if (type.equals("Drink")) {
            Drink product = new Drink(name, detail, price, size);
            allList.add(product);
            drinkList.add(product);
            return product;
        }
        else if (type.equals("Beer")) {
            Beer product = new Beer(name, detail, price, size);
            allList.add(product);
            beerList.add(product);
            return product;
        }
        else {
            System.out.println("만들 수 없는 상품입니다.");
            return null;
        }
    }
    public void showBurgers() {
        for (Burger burger : burgerList) {
            System.out.println(burger.toString());
        }
    }

    public void showFrozens() {
        for (FrozenCustard frozenCustard : frozenCustardList) {
            System.out.println(frozenCustard.toString());
        }
    }

    public void showDrinks () {
        for (Drink drink : drinkList){
            System.out.println(drink.toString());
        }
    }

    public void showBeers() {
        for (Beer beer : beerList){
            System.out.println(beer.toString());
        }
    }
}
