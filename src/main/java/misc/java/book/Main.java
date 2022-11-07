package misc.java.book;

public class Main {
    // compare the difference of interface between java and go
    // https://y-zumi.hatenablog.com/entry/2019/07/28/035632

    private static Book searchBook(BookFetcher fetcher, String bookId) {
        return fetcher.getByID(bookId);
    }

    private static void addBook(BookAdder adder, Book book) {
        adder.add(book);
    }

    public static void main(String[] args) {
        var database = new Database();
        var bookId = "12345";
        var book = searchBook(database, bookId);

        var callerDatabase = new CallerDatabase();
        // addBook(database, book); => error: incompatible types: Database cannot be converted to BookAdder
        addBook(callerDatabase, book);
    }
}
