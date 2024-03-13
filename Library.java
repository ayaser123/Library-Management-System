package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

// Class representing a library with various functionalities
public class Library {
    private List<Book> books; // List to store books
    private List<User> users; // List to store users
    private Scanner input; // Scanner object for input

    // Constructor to initialize a Library object
    public Library() {
        this.books = new ArrayList<>(); // Initialize list of books
        this.users = new ArrayList<>(); // Initialize list of users
        this.input = new Scanner(System.in); // Initialize Scanner object for input
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book); // Add book to the list of books
        JOptionPane.showMessageDialog(null, "Book added successfully."); // Show success message
    }

    // Method to add a user to the library
    public void addUser(User user) {
        users.add(user); // Add user to the list of users
        JOptionPane.showMessageDialog(null, "User added successfully."); // Show success message
    }

    // Method to find a book by its title
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book; // Return the book if found
            }
        }
        return null; // Return null if book not found
    }

    // Method to find a book by its author
    public Book findBookByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return book; // Return the book if found
            }
        }
        return null; // Return null if book not found
    }

    // Method to check out a book by a user
    public boolean checkOutBook(int bookID, int userID) {
        Book book = findBookByID(bookID);
        User user = findUserByID(userID);
        if (book != null && user != null && book.isAvailable()) {
            book.setAvailability(false); // Set book availability to false (checked out)
            user.addBorrowedBook(book); // Add the book to user's borrowed books
            return true; // Return true indicating successful checkout
        }
        return false; // Return false indicating checkout failed
    }

    // Method to return a book by a user
    public boolean returnBook(int bookID, int userID) {
        Book book = findBookByID(bookID);
        User user = findUserByID(userID);
        if (book != null && user != null && !book.isAvailable()) {
            book.setAvailability(true); // Set book availability to true (returned)
            user.removeBorrowedBook(book); // Remove the book from user's borrowed books
            return true; // Return true indicating successful return
        }
        return false; // Return false indicating return failed
    }

    // Method to find a book by its ID
    private Book findBookByID(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                return book; // Return the book if found
            }
        }
        return null; // Return null if book not found
    }

    // Method to find a user by its ID
    private User findUserByID(int userID) {
        for (User user : users) {
            if (user.getUserID() == userID) {
                return user; // Return the user if found
            }
        }
        return null; // Return null if user not found
    }

    // Method to search for books borrowed by a user
    public List<Book> searchBooksByUserID(int userID) {
        List<Book> userBooks = new ArrayList<>();
        for (User user : users) {
            if (user.getUserID() == userID) {
                for (Book book : user.getBorrowedBooks()) {
                    userBooks.add(book); // Add the borrowed books to the list
                }
                break;
            }
        }
        return userBooks; // Return the list of borrowed books
    }
    
    // Method to search for books by author
    public List<Book> searchBooksByAuthor(String searchText) {
        List<Book> foundBooks = new ArrayList<>();
        
        // Convert search text to lowercase for case-insensitive comparison
        searchText = searchText.toLowerCase();

        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(searchText)) {
                foundBooks.add(book); // Add the book to the list if author matches search text
            }
        }

        return foundBooks; // Return the list of found books
    }

    // Method to search for books by title
    public List<Book> searchBooksByTitle(String searchText) {
        List<Book> foundBooks = new ArrayList<>();
        
        // Convert search text to lowercase for case-insensitive comparison
        searchText = searchText.toLowerCase();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchText)) {
                foundBooks.add(book); // Add the book to the list if title matches search text
            }
        }

        return foundBooks; // Return the list of found books
    }
    
    // Getter method to retrieve the list of books
    public List<Book> getBooks() {
        return books;
    }

    // Getter method to retrieve the list of users
    public List<User> getUsers() {
        return users;
    }
}
