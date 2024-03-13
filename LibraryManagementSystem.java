package assignment1;

import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Class representing the Library Management System GUI
public class LibraryManagementSystem extends JFrame {
    private Library library;

 // Constructor for the Library Management System
    public LibraryManagementSystem() {
    	setBackground(new Color(255, 0, 255));
        library = new Library(); // Initialize the library
        initializeUI();  // Initialize the user interface
    }

    private void initializeUI() {
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1349, 773);
        setLocationRelativeTo(null); // Center the window

        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 128, 255));
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        
        JButton addBookButton = new JButton("Add Book");
        addBookButton.setBounds(476, 137, 386, 39);
        addBookButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        addBookButton.setBackground(new Color(0, 255, 255));
       
            addBookButton.addActionListener(new ActionListener() {
                
            	public void actionPerformed(ActionEvent e) {
            	    // Create a new dialog window
            	    JDialog dialog = new JDialog();
            	    dialog.setTitle("Add Book");
            	    dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

            	    // Create input fields for book information
            	    JTextField titleField = new JTextField(20);
            	    JTextField authorField = new JTextField(20);
            	    JTextField genreField = new JTextField(20);
            	    JTextField bookIDField = new JTextField(20);
            	    JCheckBox availabilityCheckBox = new JCheckBox("Available", true);

            	    // Create labels for input fields
            	    JLabel titleLabel = new JLabel("Title:");
            	    JLabel authorLabel = new JLabel("Author:");
            	    JLabel genreLabel = new JLabel("Genre:");
            	    JLabel bookIDLabel = new JLabel("BookID:");
            	    JLabel availabilityLabel = new JLabel("Availability:");

            	    // Create a button to add the book
            	    JButton addButton = new JButton("Add");
            	    addButton.addActionListener(new ActionListener() {
            	        @Override
            	        public void actionPerformed(ActionEvent e) {
            	            // Get the input values from the text fields
            	            String title = titleField.getText().trim();
            	            String author = authorField.getText().trim();
            	            String genre = genreField.getText().trim();
            	            String bookIDText = bookIDField.getText().trim();
            	            boolean availability = availabilityCheckBox.isSelected();

            	            // Validate input fields
            	            if (bookIDText.isEmpty() || title.isEmpty() || author.isEmpty() || genre.isEmpty()) {
            	                JOptionPane.showMessageDialog(dialog, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            	                return;
            	            }

            	            // Parse book ID to integer
            	            int bookID;
            	            try {
            	                bookID = Integer.parseInt(bookIDText);
            	            } catch (NumberFormatException ex) {
            	                JOptionPane.showMessageDialog(dialog, "Please enter a valid integer for Book ID.", "Error", JOptionPane.ERROR_MESSAGE);
            	                return;
            	            }

            	            // Create a new Book object with the provided information
            	            Book book = new Book(bookID, title, author, genre, availability);

            	            // Add the book to the library
            	            library.addBook(book);

            	            // Show a message indicating that the book was successfully added
            	            JOptionPane.showMessageDialog(null, "Book added successfully:\n" + book);

            	            // Close the dialog window
            	            dialog.dispose();
            	        }
            	    });

                    // Create a panel to hold input components
                    JPanel inputPanel = new JPanel(new GridLayout(5, 2));
                    inputPanel.add(bookIDLabel);
                    inputPanel.add(bookIDField);
                    inputPanel.add(titleLabel);
                    inputPanel.add(titleField);
                    inputPanel.add(authorLabel);
                    inputPanel.add(authorField);
                    inputPanel.add(genreLabel);
                    inputPanel.add(genreField);
                    inputPanel.add(availabilityLabel);
                    inputPanel.add(availabilityCheckBox);

                    // Create a panel to hold the add button
                    JPanel buttonPanel = new JPanel();
                    buttonPanel.add(addButton);

                    // Add input panel and button panel to the dialog
                    dialog.getContentPane().add(inputPanel, BorderLayout.CENTER);
                    dialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

                    // Set the size and visibility of the dialog window
                    dialog.pack();
                    dialog.setLocationRelativeTo(null); // Center the dialog
                    dialog.setVisible(true);
                }
            });
        buttonPanel.setLayout(null);
        buttonPanel.add(addBookButton);

        JButton addUserButton = new JButton("Add User");
        addUserButton.setBounds(476, 186, 386, 39);
        addUserButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        addUserButton.setBackground(new Color(0, 255, 255));
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new dialog window for adding a user
                JDialog dialog = new JDialog();
                dialog.setTitle("Add User");
                dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

                // Create input fields for user information
                JTextField userIDField = new JTextField(20);
                JTextField nameField = new JTextField(20);
                JTextField emailField = new JTextField(20);
                JTextField phonenoField = new JTextField(20);

                // Create labels for input fields
                JLabel nameLabel = new JLabel("Name:");
                JLabel userIDLabel = new JLabel("UserID:");
                JLabel emailLabel = new JLabel("Email:");
                JLabel phonenoLabel = new JLabel("Phone number:");

                // Create a button to add the user
                JButton addButton = new JButton("Add");
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get the input values from the text fields
                        String userIDText = userIDField.getText().trim();
                        String name = nameField.getText().trim();
                        String email = emailField.getText().trim();
                        String phoneno = phonenoField.getText().trim();

                        // Validate input fields
                        if (userIDText.isEmpty() || name.isEmpty() || email.isEmpty() || phoneno.isEmpty()) {
                            JOptionPane.showMessageDialog(dialog, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Parse user ID to integer
                        int userID;
                        try {
                            userID = Integer.parseInt(userIDText);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(dialog, "Please enter a valid integer for User ID.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Create a new User object with the provided information
                        User user = new User(userID, name, email, phoneno);

                        // Add the user to the library
                        library.addUser(user);

                        // Show a message indicating that the user was successfully added
                        JOptionPane.showMessageDialog(null, "User added successfully:\n" + user);

                        // Close the dialog window
                        dialog.dispose();
                    }
                });

                // Create a panel to hold input components
                JPanel inputPanel = new JPanel(new GridLayout(4, 2));
                inputPanel.add(userIDLabel);
                inputPanel.add(userIDField);
                inputPanel.add(nameLabel);
                inputPanel.add(nameField);
                inputPanel.add(emailLabel);
                inputPanel.add(emailField);
                inputPanel.add(phonenoLabel);
                inputPanel.add(phonenoField);
                
               
                
                // Create a panel to hold the add button
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(addButton);

                // Add input panel and button panel to the dialog
                dialog.getContentPane().add(inputPanel, BorderLayout.CENTER);
                dialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

                // Set the size and visibility of the dialog window
                dialog.pack();
                dialog.setLocationRelativeTo(null); // Center the dialog
                dialog.setVisible(true);
            }
        });
        buttonPanel.add(addUserButton);

        JButton displayBooksButton = new JButton("Display Books");
        displayBooksButton.setBounds(476, 235, 386, 39);
        displayBooksButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        displayBooksButton.setBackground(new Color(0, 255, 255));
        displayBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the list of books from the library
                List<Book> books = library.getBooks();

                // Create a StringBuilder to build the message to display
                StringBuilder message = new StringBuilder();
                message.append("Books in the Library:\n");

                // Append details of each book to the message
                for (Book book : books) {
                    message.append("Title: ").append(book.getTitle()).append("\n");
                    message.append("Author: ").append(book.getAuthor()).append("\n");
                    message.append("Genre: ").append(book.getGenre()).append("\n");
                    message.append("Book ID: ").append(book.getBookID()).append("\n");
                    message.append("Availability: ").append(book.isAvailable() ? "Available" : "Not Available").append("\n\n");
                }

                // Display the message in a dialog window
                JOptionPane.showMessageDialog(null, message.toString());
            }
        });
        buttonPanel.add(displayBooksButton);

        JButton borrowBookButton = new JButton("Borrow Book");
        borrowBookButton.setBounds(476, 284, 386, 39);
        borrowBookButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        borrowBookButton.setBackground(new Color(0, 255, 255));
        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new dialog window for borrowing a book
                JDialog dialog = new JDialog();
                dialog.setTitle("Borrow Book");
                dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

                // Create input fields for book ID and user ID
                JTextField bookIDField = new JTextField(20);
                JTextField userIDField = new JTextField(20);

                // Create labels for input fields
                JLabel bookIDLabel = new JLabel("Book ID:");
                JLabel userIDLabel = new JLabel("User ID:");

                // Create a button to borrow the book
                JButton borrowButton = new JButton("Borrow");
                borrowButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get the input values from the text fields
                        String bookIDText = bookIDField.getText().trim();
                        String userIDText = userIDField.getText().trim();

                        // Validate input fields
                        if (bookIDText.isEmpty() || userIDText.isEmpty()) {
                            JOptionPane.showMessageDialog(dialog, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Parse book ID and user ID to integers
                        int bookID, userID;
                        try {
                            bookID = Integer.parseInt(bookIDText);
                            userID = Integer.parseInt(userIDText);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(dialog, "Please enter valid integers for Book ID and User ID.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Check out the book
                        boolean success = library.checkOutBook(bookID, userID);
                        if (success) {
                            JOptionPane.showMessageDialog(null, "Book borrowed successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to borrow book. Please check the book ID and user ID.");
                        }

                        // Close the dialog window
                        dialog.dispose();
                    }
                });

                // Create a panel to hold input components
                JPanel inputPanel = new JPanel(new GridLayout(2, 2));
                inputPanel.add(bookIDLabel);
                inputPanel.add(bookIDField);
                inputPanel.add(userIDLabel);
                inputPanel.add(userIDField);

                // Create a panel to hold the borrow button
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(borrowButton);

                // Add input panel and button panel to the dialog
                dialog.getContentPane().add(inputPanel, BorderLayout.CENTER);
                dialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

                // Set the size and visibility of the dialog window
                dialog.pack();
                dialog.setLocationRelativeTo(null); // Center the dialog
                dialog.setVisible(true);
            }
        });
        buttonPanel.add(borrowBookButton);

        JButton returnBookButton = new JButton("Return Book");
        returnBookButton.setBounds(476, 333, 386, 39);
        returnBookButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        returnBookButton.setBackground(new Color(0, 255, 255));
        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new dialog window for returning a book
                JDialog dialog = new JDialog();
                dialog.setTitle("Return Book");
                dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

                // Create input fields for book ID and user ID
                JTextField bookIDField = new JTextField(20);
                JTextField userIDField = new JTextField(20);

                // Create labels for input fields
                JLabel bookIDLabel = new JLabel("Book ID:");
                JLabel userIDLabel = new JLabel("User ID:");

                // Create a button to return the book
                JButton returnButton = new JButton("Return");
                returnButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get the input values from the text fields
                        String bookIDText = bookIDField.getText().trim();
                        String userIDText = userIDField.getText().trim();

                        // Validate input fields
                        if (bookIDText.isEmpty() || userIDText.isEmpty()) {
                            JOptionPane.showMessageDialog(dialog, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Parse book ID and user ID to integers
                        int bookID, userID;
                        try {
                            bookID = Integer.parseInt(bookIDText);
                            userID = Integer.parseInt(userIDText);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(dialog, "Please enter valid integers for Book ID and User ID.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Check if the book is successfully returned
                        boolean success = library.returnBook(bookID, userID);
                        if (success) {
                            JOptionPane.showMessageDialog(null, "Book returned successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to return book. Please check the book ID and user ID.");
                        }

                        // Close the dialog window
                        dialog.dispose();
                    }
                });

                // Create a panel to hold input components
                JPanel inputPanel = new JPanel(new GridLayout(2, 2));
                inputPanel.add(bookIDLabel);
                inputPanel.add(bookIDField);
                inputPanel.add(userIDLabel);
                inputPanel.add(userIDField);

                // Create a panel to hold the return button
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(returnButton);

                // Add input panel and button panel to the dialog
                dialog.getContentPane().add(inputPanel, BorderLayout.CENTER);
                dialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

                // Set the size and visibility of the dialog window
                dialog.pack();
                dialog.setLocationRelativeTo(null); // Center the dialog
                dialog.setVisible(true);
            }
        });
        buttonPanel.add(returnBookButton);
        
        
        JButton searchBooksButton = new JButton("Search Books by User ID");
        searchBooksButton.setBounds(476, 429, 386, 39);
        searchBooksButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        searchBooksButton.setBackground(new Color(0, 255, 255));

        searchBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new dialog window for searching books by user ID
                JDialog dialog = new JDialog();
                dialog.setTitle("Search Books by User ID");
                dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

                // Create input field for user ID
                JTextField userIDField = new JTextField(20);

                // Create label for input field
                JLabel userIDLabel = new JLabel("User ID:");

                // Create a button to search books by user ID
                JButton searchButton = new JButton("Search");
                searchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get the input value from the text field
                        String userIDText = userIDField.getText().trim();

                        // Validate input field
                        if (userIDText.isEmpty()) {
                            JOptionPane.showMessageDialog(dialog, "Please enter a user ID.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Parse user ID to integer
                        int userID;
                        try {
                            userID = Integer.parseInt(userIDText);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(dialog, "Please enter a valid integer for User ID.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Perform book search by user ID logic
                        List<Book> books = library.searchBooksByUserID(userID);

                        // Display search results
                        if (books.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No books found for the specified user ID.");
                        } else {
                            StringBuilder message = new StringBuilder("Books found for user ID " + userID + ":\n");
                            for (Book book : books) {
                                message.append(book.toString()).append("\n");
                            }
                            JOptionPane.showMessageDialog(null, message.toString());
                        }

                        // Close the dialog window
                        dialog.dispose();
                    }
                });

                // Create a panel to hold input components
                JPanel inputPanel = new JPanel(new GridLayout(1, 2));
                inputPanel.add(userIDLabel);
                inputPanel.add(userIDField);

                // Create a panel to hold the search button
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(searchButton);

                // Add input panel and button panel to the dialog
                dialog.getContentPane().add(inputPanel, BorderLayout.CENTER);
                dialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

                // Set the size and visibility of the dialog window
                dialog.pack();
                dialog.setLocationRelativeTo(null); // Center the dialog
                dialog.setVisible(true);
            }
        });
        buttonPanel.add(searchBooksButton);
        
        JLabel lblNewLabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        lblNewLabel.setBounds(437, 26, 476, 86);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(lblNewLabel);

        setVisible(true);
    
    
    JButton searchButton = new JButton("Search Books by Author/title");
    searchButton.setBounds(476, 382, 386, 39);
    searchButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
    searchButton.setBackground(new Color(0, 255, 255));
    searchButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        // Create a new dialog window for input
        	        JDialog inputDialog = new JDialog();
        	        inputDialog.setTitle("Search Books");
        	        inputDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        	        // Create input field for search text
        	        JTextField searchTextfield = new JTextField(20);

        	        // Create labels for input fields
        	        JLabel searchLabel = new JLabel("Search by Author/Title:");

        	        // Create radio buttons for selecting search type
        	        JRadioButton authorRadioButton = new JRadioButton("Search by Author");
        	        JRadioButton titleRadioButton = new JRadioButton("Search by Title");
        	        authorRadioButton.setSelected(true); // Default selection

        	        // Group the radio buttons
        	        ButtonGroup searchTypeGroup = new ButtonGroup();
        	        searchTypeGroup.add(authorRadioButton);
        	        searchTypeGroup.add(titleRadioButton);

        	        // Create a button to perform the search
        	        JButton searchButton = new JButton("Search");
        	        searchButton.addActionListener(new ActionListener() {
        	            @Override
        	            public void actionPerformed(ActionEvent e) {
        	                // Get the input value from the text field
        	                String searchText = searchTextfield.getText().trim();

        	                // Determine the selected search type
        	                String searchType;
        	                if (authorRadioButton.isSelected()) {
        	                    searchType = "Search by Author";
        	                } else {
        	                    searchType = "Search by Title";
        	                }

        	                // Perform book search by author/title logic
        	                List<Book> books = null;
        	                if (searchType.equals("Search by Author")) {
        	                    books = library.searchBooksByAuthor(searchText);
        	                } else {
        	                    books = library.searchBooksByTitle(searchText);
        	                }

        	                // Display search results
        	                if (books == null || books.isEmpty()) {
        	                    JOptionPane.showMessageDialog(inputDialog, "No books found for the specified search text.");
        	                } else {
        	                    StringBuilder message = new StringBuilder("Books found for search text \"" + searchText + "\" and type \"" + searchType + "\":\n");
        	                    for (Book book : books) {
        	                        message.append(book.toString()).append("\n");
        	                    }
        	                    JOptionPane.showMessageDialog(inputDialog, message.toString());
        	                }
        	            }
        	        });

        	        // Create a panel to hold input components
        	        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        	        inputPanel.add(searchLabel);
        	        inputPanel.add(searchTextfield);
        	        inputPanel.add(authorRadioButton);
        	        inputPanel.add(titleRadioButton);

        	        // Create a panel to hold the search button
        	        JPanel buttonPanel = new JPanel();
        	        buttonPanel.add(searchButton);

        	        // Add input panel and button panel to the dialog
        	        inputDialog.getContentPane().add(inputPanel, BorderLayout.CENTER);
        	        inputDialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        	        // Set the size and visibility of the dialog window
        	        inputDialog.pack();
        	        inputDialog.setLocationRelativeTo(null); // Center the dialog
        	        inputDialog.setVisible(true);
        	    }
        	});
    buttonPanel.add(searchButton);
    }
    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LibraryManagementSystem();
        });
    }
}
