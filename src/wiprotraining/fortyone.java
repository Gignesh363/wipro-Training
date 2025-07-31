package wiprotraining;

import java.util.*;

// Main class
public class fortyone {

    // BookStore class
    static class BookStore {
        private int bookId;
        private String bookName;

        public BookStore(int bookId, String bookName) {
            this.bookId = bookId;
            this.bookName = bookName;
        }

        public int getBookId() {
            return bookId;
        }

        public String getBookName() {
            return bookName;
        }

        @Override
        public String toString() {
            return "BookID: " + bookId + ", BookName: " + bookName;
        }
    }

    // Comparator to sort by Book Name
    static class BookNameComparator implements Comparator<BookStore> {
        public int compare(BookStore b1, BookStore b2) {
            return b1.getBookName().compareToIgnoreCase(b2.getBookName());
        }
    }

    // Comparator to sort by Book ID
    static class BookIdComparator implements Comparator<BookStore> {
        public int compare(BookStore b1, BookStore b2) {
            return Integer.compare(b1.getBookId(), b2.getBookId());
        }
    }

    // Main method
    public static void main(String[] args) {
        List<BookStore> books = new ArrayList<>();

        books.add(new BookStore(103, "Java Programming"));
        books.add(new BookStore(101, "Algorithms"));
        books.add(new BookStore(105, "Data Structures"));
        books.add(new BookStore(102, "Computer Networks"));

        // Sort by Book Name
        Collections.sort(books, new BookNameComparator());
        System.out.println("Books sorted by Book Name:");
        for (BookStore b : books) {
            System.out.println(b);
        }

        System.out.println();

        // Sort by Book ID
        Collections.sort(books, new BookIdComparator());
        System.out.println("Books sorted by Book ID:");
        for (BookStore b : books) {
            System.out.println(b);
        }
    }
}
//output:-
//Books sorted by Book Name:
//BookID: 101, BookName: Algorithms
//BookID: 102, BookName: Computer Networks
//BookID: 105, BookName: Data Structures
//BookID: 103, BookName: Java Programming
//
//Books sorted by Book ID:
//BookID: 101, BookName: Algorithms
//BookID: 102, BookName: Computer Networks
//BookID: 103, BookName: Java Programming
//BookID: 105, BookName: Data Structures