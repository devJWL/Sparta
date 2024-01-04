public class Menu {
    private String name;
    private String detail;

    public Menu(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("메뉴명 : ").append(name).append('\n');
        sb.append("상세설명 : ").append(detail).append('\n');
        return sb.toString();
    }
}
