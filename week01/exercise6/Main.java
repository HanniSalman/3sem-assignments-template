package week01.exercise6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("RavioliBook1", "Author1", 2019, 100, 4.5),
                new Book("RavioliBook2", "Author2", 2020, 150, 4.0),
                new Book("RavioliBook3", "Author3", 2021, 200, 3.8),
                new Book("RavioliBook4", "Author4", 2022, 250, 5.0),
                new Book("RavioliBook5", "Author5", 2023, 300, 2.5),
                new Book("RavioliBook6", "Author1", 2023, 322, 2.6)
        );

        // Calculate the average rating of all books

        double averageRatingAllBooks = books.stream()
                .mapToDouble(Book::getRating)
                .average()
                .getAsDouble();
        //.orElse(0.0);
        System.out.println("Average rating of all books: " + averageRatingAllBooks);


        // Filter and display books published after a specific year

        int booksPublishedAfterYear = 2021;
        books.stream()
                .filter(book -> book.getPublicationYear() > 2021)
                .map(book -> book.getTitle())
                .forEach(title -> System.out.println("Books published after " + booksPublishedAfterYear + ": " + title));


        // Sort books by rating in descending order

        books.stream()
                .sorted(Comparator.comparing(Book::getRating).reversed())
                .collect(Collectors.toList())
                .forEach(book -> System.out.println("Books sorted by rating in descending order: " + book.getTitle()));


        // Find and display the title of the highest-rated book

        String highestRatedBook = books.stream()
                .max((b1, b2) -> Double.compare(b1.getRating(), b2.getRating()))
                .map(Book::getTitle)
                .orElse("No Ravioli books found tihi");
        System.out.println("Book with the highest rating: " + highestRatedBook);


        // Group books by author and calculate average rating for each author


        // Calculate the total number of pages for all books
        int totalPages = books.stream()
                .mapToInt(Book::getPages)
                .sum();
        System.out.println("Total number of pages for all books: " + totalPages);
    }
}
