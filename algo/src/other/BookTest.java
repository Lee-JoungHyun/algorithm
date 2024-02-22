package other;

public class BookTest {
    public static void main(String[] args) {
        Book[] books = new Book[2];
        books[0] = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
        books[1] = new Book("35355", "분석 설계", "소나무", "jaen.kr", 30000, "SW 모델링");
        System.out.println("********************도서목록********************");
        for (int i = 0; i < 2; i++) {
            System.out.println(books[i].toString());
        }
    }
}
