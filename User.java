package assignment1;

import java.util.ArrayList;
import java.util.List;

// Class representing a User
public class User {
    // Instance variables for user details
    private int userID;
    private String name;
    private String email;
    private String phoneno;
    private List<Book> borrowedBooks;

    // Constructor to initialize a User object
    public User(int userID, String name, String email, String phoneno) {
        this.userID = userID; // Assign provided user ID
        this.name = name; // Assign provided name
        this.email = email; // Assign provided email
        this.phoneno = phoneno; // Assign provided phone number
        this.borrowedBooks = new ArrayList<>(); // Initialize list of borrowed books
    }

    // Getter method for retrieving user ID
    public int getUserID() {
        return userID;
    }

    // Setter method for updating user ID
    public void setUserID(int userID) {
        this.userID = userID;
    }

    // Getter method for retrieving user name
    public String getName() {
        return name;
    }

    // Setter method for updating user name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for retrieving user email
    public String getemail() {
        return email;
    }

    // Setter method for updating user email
    public void setemail(String email) {
        this.email = email;
    }
    
    // Getter method for retrieving user phone number
    public String getphoneno() {
        return phoneno;
    }

    // Setter method for updating user phone number
    public void setphoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    // Getter method for retrieving list of borrowed books
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Method to add a borrowed book to the user's list
    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    // Method to remove a borrowed book from the user's list
    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    // Method to represent User object as a string
    @Override
    public String toString() {
        return "User ID: " + userID + ", Name: " + name + ", Phone number: " + phoneno + ", Email: " + email + ", Borrowed Books: " + borrowedBooks;
    }
}
