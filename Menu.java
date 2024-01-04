
public class Menu {
    // 데이터베이스 접근을 위한 번호
    private int no;
    // 메뉴 이름
    private String name;
    // 메뉴 상세설명
    private String detail;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Menu(int no, String name, String detail) {
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
        sb.append("메뉴명 -> ").append(name);
        sb.append("    상세설명 -> ").append(detail);
        return sb.toString();
    }
}
