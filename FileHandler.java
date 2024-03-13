package assignment1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Class for handling file operations related to books and users
public class FileHandler {
    // File paths for books and users data
    private static final String BOOKS_FILE = "books.txt";
    private static final String USERS_FILE = "users.txt";

    // Method to save a list of books to a file
    public static void saveBooks(List<Book> books) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(BOOKS_FILE))) {
            // Iterate over each book and write its details to the file
            for (Book book : books) {
                writer.println(book.getBookID() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "," + book.isAvailable());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load a list of books from a file
    public static List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            // Read each line from the file and parse book details
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int bookID = Integer.parseInt(parts[0]);
                String title = parts[1];
                String author = parts[2];
                String genre = parts[3];
                boolean availability = Boolean.parseBoolean(parts[4]);
                // Create a book object and add it to the list
                Book book = new Book(bookID, title, author, genre, availability);
                book.setBookID(bookID); // Set book ID
                book.setAvailability(availability); // Set availability
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Method to save a list of users to a file
    public void saveUsers(List<User> users) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USERS_FILE))) {
            // Iterate over each user and write its details to the file
            for (User user : users) {
                writer.println(user.getUserID() + "," + user.getName() + "," + user.getemail() + "," + user.getphoneno());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load a list of users from a file
    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            // Read each line from the file and parse user details
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int userID = Integer.parseInt(parts[0]);
                String name = parts[1];
                String email = parts[2];
                String phoneno = parts[3];
                // Create a user object and add it to the list
                User user = new User(userID, name, email, phoneno);
                user.setUserID(userID); // Set user ID
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
