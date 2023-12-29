import Menu.*;
import java.util.ArrayList;
import java.util.List;


// 메뉴의 리스트를 가지고 있는 클래스
public class MenuBoard{

    List<Burger> burgerList;
    List<FrozenCustard> frozenCustardList;
    List<Drink> drinkList;
    List<Beer> beerList;

    public MenuBoard() {
        burgerList = new ArrayList<>();
        frozenCustardList = new ArrayList<>();
        drinkList = new ArrayList<>();
        beerList = new ArrayList<>();
    }
    // String name, String detail, String type, double price, String size

    public void showBurgers() { }
    public void showFrozens() { }
    public void showDrinks () {}
    public void showBeers() {}

}
