package wiprotraining;

import java.util.*;

// CD class with Comparable implementation
class CD implements Comparable<CD> {
    private String title;
    private String singer;

    public CD(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Singer: " + singer;
    }

    // Sort by singer name (ascending)
    @Override
    public int compareTo(CD other) {
        return this.singer.compareToIgnoreCase(other.singer);
    }
}

// Main class
public class Forty {
    public static void main(String[] args) {
        List<CD> cds = new ArrayList<>();

        cds.add(new CD("Melody Mix", "Arijit Singh"));
        cds.add(new CD("Pop Beats", "Shreya Ghoshal"));
        cds.add(new CD("Rock On", "KK"));
        cds.add(new CD("Golden Tunes", "Lata Mangeshkar"));

        // Sort the list using Comparable
        Collections.sort(cds);

        // Display sorted CDs
        System.out.println("CDs sorted by Singer Name:");
        for (CD cd : cds) {
            System.out.println(cd);
        }
    }
}
//output:-
//CDs sorted by Singer Name:
//Title: Melody Mix, Singer: Arijit Singh
//Title: Rock On, Singer: KK
//Title: Golden Tunes, Singer: Lata Mangeshkar
//Title: Pop Beats, Singer: Shreya Ghoshal