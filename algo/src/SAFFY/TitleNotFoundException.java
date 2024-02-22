package SAFFY;

public class TitleNotFoundException extends Exception {
    private String title;
    public TitleNotFoundException(String title) {
        super(title+" 에 해당하는 영화가 없습니다");
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}
