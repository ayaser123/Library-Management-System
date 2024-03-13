package assignment1;

// Class representing a Book
public class Book {
    // Static variable to keep track of the next book ID
    private static int nextBookID = 1;
    // Instance variables for book details
    private int bookID;
    private String title;
    private String author;
    private String genre;
    private boolean availability;

    // Constructor to initialize a Book object
    public Book(int bookID, String title, String author, String genre, boolean availability) {
        this.bookID = bookID; // Assign provided book ID
        this.title = title; // Assign provided title
        this.author = author; // Assign provided author
        this.genre = genre; // Assign provided genre
        this.availability = true; // Default availability is set to true
    }

    // Getter method for retrieving book ID
    public int getBookID() {
        return bookID;
    }

    // Setter method for updating book ID
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    // Getter method for retrieving book title
    public String getTitle() {
        return title;
    }

    // Setter method for updating book title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter method for retrieving book author
    public String getAuthor() {
        return author;
    }

    // Setter method for updating book author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter method for retrieving book genre
    public String getGenre() {
        return genre;
    }

    // Setter method for updating book genre
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Getter method for checking availability of the book
    public boolean isAvailable() {
        return availability;
    }

    // Setter method for updating availability of the book
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    // Method to represent Book object as a string
    @Override
    public String toString() {
        return "Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Availability: " + availability;
    }
}