package wiprotraining;

class Book {
    String title;
    public Book(String title) {
        this.title = title;
    }
    public String toString() {
        return "Book: " + title;
    }
}

class Video {
    String title;
    public Video(String title) {
        this.title = title;
    }
    public String toString() {
        return "Video: " + title;
    }
}

class Newspaper {
    String name;
    public Newspaper(String name) {
        this.name = name;
    }
    public String toString() {
        return "Newspaper: " + name;
    }
}

// Library class without generics
class MediaLibrary {
    Object[] items = new Object[10];
    int count = 0;

    public void add(Object item) {
        if (count < items.length) {
            items[count++] = item;
        } else {
            System.out.println("Library is full");
        }
    }

    public Object get(int index) {
        if (index >= 0 && index < count) {
            return items[index];
        } else {
            return null;
        }
    }

    public void displayAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}

public class thirtynine {
    public static void main(String[] args) {
        MediaLibrary library = new MediaLibrary();

        Book book = new Book("Java Programming");
        Video video = new Video("Learning JDBC");
        Newspaper newspaper = new Newspaper("The Times of India");

        library.add(book);
        library.add(video);
        library.add(newspaper);

        System.out.println("Library Items:");
        library.displayAll();

        // Retrieve and display a specific item
        Object item = library.get(1); // should get the video
        if (item != null) {
            System.out.println("Retrieved: " + item);
        } else {
            System.out.println("Invalid index.");
        }
    }
}
//output:-
//Library Items:
//Book: Java Programming
//Video: Learning JDBC
//Newspaper: The Times of India
//Retrieved: Video: Learning JDBC
