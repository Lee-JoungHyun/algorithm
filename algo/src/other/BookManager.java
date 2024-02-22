package other;

public class BookManager {
    private final int MAX_SIZE = 100;
    private Book[] books = new Book[MAX_SIZE];
    int size = 0;

    public void add(Book book) {
        books[size++] = book;
    }
    public void remove(String isbn) {
        for (int i=0; i<size; i++) {
            if ((books[i].getIsbn()).equals(isbn)) {
                System.out.println("********************도서삭제:" + isbn + "********************");
                for (int j = i+1; j < size; j++) {
                    books[j-1] = books[j];
                }
                size--;
                return;
            }
        }
    }
    public Book[] getList() {
        return books;
    }
//    public other.Book searchByIsbn (String isbn) {
//        return ";
//    }

}
