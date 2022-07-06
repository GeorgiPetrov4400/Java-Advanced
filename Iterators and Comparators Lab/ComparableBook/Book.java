package IteratorsAndComparatorsLab.ComparableBook;

import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        setTitle(title);
        setYear(year);
        setAuthors();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        this.authors = List.of(authors);
    }

    @Override
    public int compareTo(Book otherBook) {

        int result = this.title.compareTo(otherBook.title);
        if (result == 0) {
            result = Integer.compare(this.year, otherBook.year);
        }
        return result;
    }
    @Override
    public String toString () {
        return this.title + " " + this.year;
    }
}
